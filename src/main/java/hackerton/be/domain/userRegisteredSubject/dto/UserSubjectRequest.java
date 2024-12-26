package hackerton.be.domain.userRegisteredSubject.dto;

import lombok.Data;

@Data
public class UserSubjectRequest {
    private Long userId;    // 사용자 ID
    private Long subjectId; // 과목 ID
}
