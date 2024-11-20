package group.hotelreservation.mapper;
import group.hotelreservation.dao.entity.CustomerEntity;
import group.hotelreservation.dto.customer.request.CustomerRequest;
import group.hotelreservation.dto.customer.response.CustomerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring",uses = ReservationMapper.class)
public abstract class CustomerMapper {

    // CustomerRequest obyektini CustomerEntity obyektinə çevirmək üçün metod
    @Mapping(source = "reservations",target = "reservations")
    public abstract CustomerEntity mapToEntity(CustomerRequest customerRequest);


    @Mapping(source = "reservations",target = "reservations")
    public abstract CustomerResponse mapToResponse(CustomerEntity customerEntity);


}
