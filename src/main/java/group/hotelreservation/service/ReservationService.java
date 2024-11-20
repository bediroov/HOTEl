package group.hotelreservation.service;
import group.hotelreservation.dao.repository.ReservationRepository;
import group.hotelreservation.dto.reservation.request.ReservationRequest;
import group.hotelreservation.dto.reservation.response.ReservationResponse;
import group.hotelreservation.mapper.ReservationMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;


    public ReservationResponse addReservation(ReservationRequest reservationRequest) {

        var reservationentity = reservationMapper.mapToReservationEntity(reservationRequest);
        reservationRepository.save(reservationentity);
        var response = reservationMapper.mapToReservationResponse(reservationentity);
        System.out.println("response:" + response);
        return response;
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
        existReservation.setTotal_price(reservationRequest.getTotal_price());
        existReservation.setPaymentMethod(reservationRequest.getPaymentMethod());

        reservationRepository.save(existReservation);
        return reservationMapper.mapToReservationResponse(existReservation);
    }

    public void deleteReservation(Long reservationId) {
        reservationRepository.deleteById(reservationId);

    }
}
