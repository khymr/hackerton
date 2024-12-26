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
                        .hasTakenBefore(subject.isHasTakenBefore())
                        .build())
                .toList();
    }

    // 사용자가 선택한 과목의 상태 업데이트
    public List<SubjectResponse> markSubjectsAsTaken(List<Long> subjectIds) {
        List<Subject> subjects = subjectRepository.findAllById(subjectIds);

        if (subjects.isEmpty()) {
            throw new SubjectException(SubjectExceptionType.NO_SUBJECTS_FOUND);
        }

        // 선택된 과목들의 상태를 업데이트
        subjects.forEach(Subject::markAsTaken);
        subjectRepository.saveAll(subjects);

        // 업데이트된 과목 리스트 반환
        return subjects.stream()
                .map(subject -> SubjectResponse.builder()
                        .id(subject.getId())
                        .name(subject.getName())
                        .type(subject.getType())
                        .credit(subject.getCredit())
                        .grade(subject.getGrade())
                        .department(subject.getDepartment())
                        .professor(subject.getProfessor())
                        .hasTakenBefore(subject.isHasTakenBefore())
                        .build())
                .toList();
    }



}
