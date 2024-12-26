package hackerton.be.domain.subject.controller;

import hackerton.be.domain.subject.Subject;
import hackerton.be.domain.subject.dto.SubjectResponse;
import hackerton.be.domain.subject.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;

    // 학과별 과목 조회 API
    @GetMapping("/department/{department}")
    public ResponseEntity<List<SubjectResponse>> getSubjectsByDepartment(@PathVariable String department) {
        List<SubjectResponse> subjects = subjectService.getSubjectsByDepartment(department);
        return ResponseEntity.ok(subjects);
    }

    // 사용자가 선택한 과목을 수강 처리하는 API
    @PostMapping("/mark-as-taken")
    public ResponseEntity<List<SubjectResponse>> markSubjectsAsTaken(@RequestBody List<Long> subjectIds) {
        List<SubjectResponse> updatedSubjects = subjectService.markSubjectsAsTaken(subjectIds);
        return ResponseEntity.ok(updatedSubjects);
    }
}