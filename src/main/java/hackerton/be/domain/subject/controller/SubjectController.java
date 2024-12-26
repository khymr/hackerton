package hackerton.be.domain.subject.controller;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.subject.dto.SubjectResponse;
import hackerton.be.domain.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subject")
public class SubjectController {
    private final SubjectService subjectService;
    @GetMapping
    public List<String> getDepartments() {
        return subjectService.getDepartments();
    }
    @GetMapping("/{department}")
    public ResponseEntity<List<SubjectResponse>> getSubjectsByDepartment(@PathVariable String department) {
        List<SubjectResponse> subjects = subjectService.getSubjectsByDepartment(department);
        return ResponseEntity.ok(subjects);
    }
}
