package hackerton.be.domain.subject.service;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.subject.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class SubjectService {
    private final SubjectRepository subjectRepository;

    // 모든 학과 조회
    public List<String> getDepartments() {
        return subjectRepository.findAllDepartments();
    }

    // 특정 학과의 과목 조회
    public List<Subject> getSubjectsByDepartment(String department) {
        return subjectRepository.findByDepartment(department);
    }


}
