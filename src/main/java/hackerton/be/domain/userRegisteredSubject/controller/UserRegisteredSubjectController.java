package hackerton.be.domain.userRegisteredSubject.controller;

import hackerton.be.domain.userRegisteredSubject.dto.UserSubjectRequest;
import hackerton.be.domain.userRegisteredSubject.service.UserRegisteredSubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/subjects")
@RequiredArgsConstructor
public class UserRegisteredSubjectController {
    private final UserRegisteredSubjectService userRegisteredSubjectService;

    @PostMapping
    public ResponseEntity<?> registerSubject(@RequestBody UserSubjectRequest request) {
        userRegisteredSubjectService.registerSubject(request.getUserId(), request.getSubjectId());
        return ResponseEntity.ok("Subject registered successfully.");
    }

}
