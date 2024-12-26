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

    public List<Subject>getAllSubjects(){
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(Long id) {
        return subjectRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 과목이 존재하지 않습니다" ));
    }


}
