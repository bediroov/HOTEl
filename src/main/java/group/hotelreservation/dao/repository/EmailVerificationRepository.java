package group.hotelreservation.dao.repository;

import group.hotelreservation.dao.entity.EmailVerificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailVerificationRepository extends JpaRepository<EmailVerificationEntity,String> {



}
