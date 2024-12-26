package hackerton.be.domain.recommend.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RecommendationRequest {
    @NotBlank(message = "과목명은 필수 입력값입니다.")
    private String subjectName; // 추천 과목명
    @NotBlank(message = "학과명은 필수 입력값입니다.")
    private String department;  // 학과명
    @NotNull(message = "학년은 필수 입력값입니다.")
    @Min(value = 1, message = "학년은 1 이상이어야 합니다.")
    private Integer grade;      // 학년
    @NotBlank(message = "교수명은 필수 입력값입니다.")
    private String professor;   // 교수명
}