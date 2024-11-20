package group.hotelreservation.dao.repository;

import group.hotelreservation.dao.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {



}
