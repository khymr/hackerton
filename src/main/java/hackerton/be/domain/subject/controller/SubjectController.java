package hackerton.be.domain.subject.controller;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
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
    public List<Subject> getSubjectsByDepartment(@PathVariable String department) {
        return subjectService.getSubjectsByDepartment(department);
    }
}
