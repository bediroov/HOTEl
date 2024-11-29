package group.hotelreservation.dao.repository;

import group.hotelreservation.dao.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity,Long> {

    List<ReservationEntity> findByStatus(Boolean status);
}
