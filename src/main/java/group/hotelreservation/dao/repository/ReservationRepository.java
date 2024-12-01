package group.hotelreservation.dao.repository;

import group.hotelreservation.dao.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    @Query("select r from ReservationEntity r where r.checkInDate between :start and :end and r.status=false")
    List<ReservationEntity>
    findReservationsTwodaysBefore(@Param("start") LocalDateTime start,
                                  @Param("end") LocalDateTime end);


}
