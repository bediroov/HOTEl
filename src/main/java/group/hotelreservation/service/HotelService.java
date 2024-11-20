package group.hotelreservation.service;

import group.hotelreservation.dao.repository.HotelRepository;
import group.hotelreservation.dto.hotel.request.HotelRequest;
import group.hotelreservation.dto.hotel.response.HotelResponse;
import group.hotelreservation.mapper.HotelMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class HotelService {

    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;


    public HotelResponse addHotelwithRooms(HotelRequest hotelRequest) {

        var hotelEntity = hotelMapper.mapToHotelEntity(hotelRequest);

        // her bir otagin hotel sahesini teyin etmeliyik!!!

        if (hotelEntity.getRooms() != null) {
            hotelEntity.getRooms().forEach(room -> room.setHotel(hotelEntity));
        }

        hotelRepository.save(hotelEntity);
        var response = hotelMapper.mapToHotelResponse(hotelEntity);
        System.out.println("responsehotel:" + response);
        return response;
    }


    public HotelResponse getHotelbyId(Long hotelId) {
        var hotelEntity = hotelRepository.findById(hotelId)
                .orElseThrow(() -> new RuntimeException("Hotel not found"));
        return hotelMapper.mapToHotelResponse(hotelEntity);
    }


    public HotelResponse updateHotel(HotelRequest hotelRequest, Long hotelId) {
        var existHotel = hotelRepository.findById(hotelId).orElseThrow(() ->
                new RuntimeException("Hotel not found!!!"));

        existHotel.setName(hotelRequest.getName());
        existHotel.setAddress(hotelRequest.getAddress());
        existHotel.setStars(hotelRequest.getStars());

        hotelRepository.save(existHotel);
        return hotelMapper.mapToHotelResponse(existHotel);

    }

    public void deleteCustomer(Long hotelId) {
        hotelRepository.deleteById(hotelId);

    }
}
