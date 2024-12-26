package hackerton.be.domain.subject.service;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.subject.dto.SubjectResponse;
import hackerton.be.domain.subject.exception.SubjectException;
import hackerton.be.domain.subject.exception.SubjectExceptionType;
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
        List<String> departments = subjectRepository.findAllDepartments();
        if (departments.isEmpty()) {
            throw new SubjectException(SubjectExceptionType.NO_DEPARTMENTS_FOUND);
        }
        return departments;
    }

    // 특정 학과의 과목 조회
    public List<SubjectResponse> getSubjectsByDepartment(String department) {
        List<Subject> subjects = subjectRepository.findByDepartment(department);
        if (subjects.isEmpty()) {
            throw new SubjectException(SubjectExceptionType.NO_SUBJECTS_FOUND);
        }
        return subjects.stream()
                .map(subject -> SubjectResponse.builder()
                        .id(subject.getId())
                        .name(subject.getName())
                        .type(subject.getType())
                        .credit(subject.getCredit())
                        .grade(subject.getGrade())
                        .department(subject.getDepartment())
                        .professor(subject.getProfessor())
                        .build())
                .toList();
    }



}
