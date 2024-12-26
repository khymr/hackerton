package hackerton.be.domain.userRegisteredSubject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRegisteredSubjectResponse {
    private Long id;            // 등록된 데이터 ID
    private Long userId;        // 사용자 ID
    private Long subjectId;     // 과목 ID
    private String subjectName; // 과목명
    private String department;  // 학과명
}
