package hackerton.be.domain.recommend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SaveRecommendationResponse {
    private Long id;            // 추천 ID
    private String subjectName; // 추천 과목명
    private String department;  // 학과명
    private Integer grade;      // 학년
    private String professor;   // 교수명

}