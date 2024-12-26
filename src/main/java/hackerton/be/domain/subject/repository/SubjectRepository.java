package hackerton.be.domain.subject.repository;

import hackerton.be.domain.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {

}
