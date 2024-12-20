package group.hotelreservation.controller;
import group.hotelreservation.dto.hotel.request.HotelRequest;
import group.hotelreservation.dto.hotel.response.HotelResponse;
import group.hotelreservation.service.HotelService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/hotel")
@RequiredArgsConstructor


public class HotelController {

    private final HotelService hotelService;
    @PostMapping
    public HotelResponse saveHotel(@RequestBody @Valid HotelRequest hotelRequest) {
        System.out.println("stars:" + hotelRequest.getStars());
        return hotelService.createHotel(hotelRequest);
    }

//     bu get pathvariable ucun
    @GetMapping("/{hotelId}")
    public HotelResponse getHotel(@PathVariable String hotelId) {
        return hotelService.getHotelbyId(hotelId);
    }

    @PutMapping("/{hotelId}")
    public HotelResponse putHotel(@RequestBody HotelRequest hotelRequest, @PathVariable String hotelId) {
        return hotelService.updateHotel(hotelRequest, hotelId);
    }

    @DeleteMapping("/{hotelId}")
    public void deleteHotel(@PathVariable String hotelId) {
        hotelService.deleteCustomer(hotelId);
    }



}
