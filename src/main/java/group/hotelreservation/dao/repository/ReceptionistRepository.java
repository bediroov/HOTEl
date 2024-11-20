package group.hotelreservation.dao.repository;

import group.hotelreservation.dao.entity.ReceptionistEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionistRepository extends JpaRepository<ReceptionistEntity,Long> {
}
