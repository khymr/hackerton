package hackerton.be.domain.subject.repository;

import hackerton.be.domain.subject.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("SELECT DISTINCT s.department FROM Subject s")
    List<String> findAllDepartments();

    List<Subject> findByDepartment(String department);

}
