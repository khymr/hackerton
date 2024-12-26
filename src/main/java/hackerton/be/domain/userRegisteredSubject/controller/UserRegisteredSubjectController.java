package hackerton.be.domain.userRegisteredSubject.controller;

import hackerton.be.domain.userRegisteredSubject.service.UserRegisteredSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/{userId}/subjects")
@RequiredArgsConstructor
public class UserRegisteredSubjectController {
    private final UserRegisteredSubjectService userRegisteredSubjectService;
    @PostMapping
    public ResponseEntity<?> registerSubjects(
            @PathVariable Long userId,
            @RequestBody List<Long> subjectIds) {
        userRegisteredSubjectService.registerSubjects(userId, subjectIds);
        return ResponseEntity.ok("Subjects registered successfully.");
    }

}
