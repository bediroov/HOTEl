package group.hotelreservation.service;
import group.hotelreservation.dao.entity.HotelEntity;
import group.hotelreservation.dao.entity.ReceptionistEntity;
import group.hotelreservation.dao.repository.HotelRepository;
import group.hotelreservation.dao.repository.ReceptionistRepository;
import group.hotelreservation.dto.receptionist.request.ReceptionistRequest;
import group.hotelreservation.dto.receptionist.response.ReceptionistResponse;
import group.hotelreservation.mapper.ReceptionistMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;




@Service
@RequiredArgsConstructor

public class ReceptionistService {

    private final ReceptionistRepository receptionistRepository;

    private final ReceptionistMapper receptionistMapper;

    private final HotelRepository hotelRepository;



        public ReceptionistResponse addReceptionists(ReceptionistRequest receptionistRequest) {

        HotelEntity hotel = hotelRepository.findById(receptionistRequest.getHotelId())
                .orElseThrow(() -> new RuntimeException("Hotel not found"));

        ReceptionistEntity receptionist = receptionistMapper.mapToReceptionistEntity(receptionistRequest);

        receptionist.setHotel(hotel);
        receptionistRepository.save(receptionist);
        return receptionistMapper.mapToReceptionistResponse(receptionist);


    }

    public List<ReceptionistResponse> getAllReceptionists() {
        var receptionEntityList = receptionistRepository.findAll();
        return receptionEntityList.stream().map(receptionistMapper::mapToReceptionistResponse).collect(Collectors.toList());
    }


    public ReceptionistResponse getReceptionistById(Long receptionistId) {
        var receptionistEntity = receptionistRepository.findById(receptionistId)
                .orElseThrow(() -> new RuntimeException("RECEPTIONIST not found"));
        return receptionistMapper.mapToReceptionistResponse(receptionistEntity);
    }


    public ReceptionistResponse updateReceptionist(ReceptionistRequest receptionistRequest, Long receptionistId) {

        var existReceptionist = receptionistRepository.findById(receptionistId)
                .orElseThrow(() -> new RuntimeException("RECEPTIONIST not Found"));

        existReceptionist.setName(receptionistRequest.getName());
        existReceptionist.setSurname(receptionistRequest.getSurname());
        existReceptionist.setEmail(receptionistRequest.getEmail());
        existReceptionist.setPassword(receptionistRequest.getPassword());


        receptionistRepository.save(existReceptionist);
        return receptionistMapper.mapToReceptionistResponse(existReceptionist);

    }

    public void deleteReceptionist(Long receptionistId) {
        receptionistRepository.deleteById(receptionistId);
    }


}
