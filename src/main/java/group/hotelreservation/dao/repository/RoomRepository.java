package group.hotelreservation.dao.repository;
import group.hotelreservation.dao.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<RoomEntity, String> {


}
