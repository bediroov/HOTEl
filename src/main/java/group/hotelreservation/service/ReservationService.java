package group.hotelreservation.service;

import group.hotelreservation.dao.entity.CustomerEntity;
import group.hotelreservation.dao.entity.ReservationEntity;
import group.hotelreservation.dao.entity.RoomEntity;
import group.hotelreservation.dao.repository.CustomerRepository;
import group.hotelreservation.dao.repository.ReservationRepository;
import group.hotelreservation.dao.repository.RoomRepository;
import group.hotelreservation.dto.reservation.request.ReservationRequest;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import group.hotelreservation.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    private final RoomRepository roomRepository;
    private final CustomerRepository customerRepository;


    public ReservationResponse createReservation(ReservationRequest reservationRequest) {
        RoomEntity room = roomRepository.findById(reservationRequest.getRoomId()).orElseThrow(() -> {
            throw new RuntimeException("ROOM_NOT_FOUND");
        });

        CustomerEntity customer = customerRepository.findById(reservationRequest.getCustomerId()).orElseThrow(() -> {
            throw new RuntimeException("Customer not found");
        });

        ReservationEntity reservation = reservationMapper.mapToReservationEntity(reservationRequest);
        reservation.setRoom(room);
        reservation.setCustomer(customer);
        reservationRepository.save(reservation);
        return reservationMapper.mapToReservationResponse(reservation);
    }

    public List<ReservationResponse> getAllReservations() {
        var reservationEntityList = reservationRepository.findAll();
        return reservationEntityList.stream().map(reservationMapper::mapToReservationResponse).collect(Collectors.toList());
    }


    public ReservationResponse getReservationById(Long reservationId) {

        var reservationEntity = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
        return reservationMapper.mapToReservationResponse(reservationEntity);
    }

    public ReservationResponse updateReservation(ReservationRequest reservationRequest, Long reservationId) {

        var existReservation = reservationRepository.findById(reservationId).orElseThrow(() ->
                new RuntimeException("Reservation not found!!!"));

        existReservation.setCheckInDate(reservationRequest.getCheckInDate());
        existReservation.setCheckOutDate(reservationRequest.getCheckOutDate());

        reservationRepository.save(existReservation);
        return reservationMapper.mapToReservationResponse(existReservation);
    }

    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }


}
