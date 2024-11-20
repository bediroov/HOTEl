package group.hotelreservation.dao.repository;

import group.hotelreservation.dao.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {
}
