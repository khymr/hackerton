package hackerton.be.domain.userRegisteredSubject.service;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.user.User;
import hackerton.be.domain.userRegisteredSubject.UserRegisteredSubject;
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



    public void registerSubject(Long userId, Long subjectId) {
        UserRegisteredSubject userRegisteredSubject = UserRegisteredSubject.builder()
                .user(User.builder().id(userId).build())
                .subject(Subject.builder().id(subjectId).build())
                .build();
        userRegisteredSubjectRepository.save(userRegisteredSubject);
    }
}
