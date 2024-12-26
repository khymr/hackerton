package hackerton.be.domain.userRegisteredSubject.repository;

import hackerton.be.domain.userRegisteredSubject.UserRegisteredSubject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRegisteredSubjectRepository extends JpaRepository<UserRegisteredSubject, Long> {
    List<UserRegisteredSubject> findByUserId(Long userId);
}