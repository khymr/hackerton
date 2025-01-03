package hackerton.be.domain.userRegisteredSubject.service;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.subject.exception.SubjectException;
import hackerton.be.domain.subject.exception.SubjectExceptionType;
import hackerton.be.domain.subject.repository.SubjectRepository;
import hackerton.be.domain.user.User;
import hackerton.be.domain.user.exception.UserException;
import hackerton.be.domain.user.exception.UserExceptionType;
import hackerton.be.domain.user.repository.UserRepository;
import hackerton.be.domain.userRegisteredSubject.UserRegisteredSubject;
import hackerton.be.domain.userRegisteredSubject.dto.UserRegisteredSubjectResponse;
import hackerton.be.domain.userRegisteredSubject.repository.UserRegisteredSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRegisteredSubjectService {
    private final UserRegisteredSubjectRepository userRegisteredSubjectRepository;
    private final UserRepository userRepository; // 추가
    private final SubjectRepository subjectRepository; // 추가



    public void registerSubject(Long userId, Long subjectId) {
        // userId 검증
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserExceptionType.USER_NOT_FOUND));

        // subjectId 검증
        Subject subject = subjectRepository.findById(subjectId)
                .orElseThrow(() -> new SubjectException(SubjectExceptionType.SUBJECT_NOT_FOUND));

        // 등록 로직 수행
        UserRegisteredSubject userRegisteredSubject = UserRegisteredSubject.builder()
                .user(user)
                .subject(subject)
                .build();
        userRegisteredSubjectRepository.save(userRegisteredSubject);
    }

    // 사용자 등록 과목 조회
    public List<UserRegisteredSubjectResponse> getUserSubjects(Long userId) {
        List<UserRegisteredSubject> registeredSubjects = userRegisteredSubjectRepository.findByUserId(userId);

        return registeredSubjects.stream()
                .map(registered -> UserRegisteredSubjectResponse.builder()
                        .id(registered.getId())
                        .userId(registered.getUser().getId())
                        .subjectId(registered.getSubject().getId())
                        .subjectName(registered.getSubject().getName())
                        .department(registered.getSubject().getDepartment())
                        .build())
                .toList();
    }

    public List<String> getAllDepartments() {
        List<String> departments = subjectRepository.findAllDepartments();
        if (departments.isEmpty()) {
            throw new IllegalArgumentException("No departments found.");
        }
        return departments;
    }
}
