package hackerton.be.domain.recommend.dto;

import lombok.Data;

@Data
public class RecommendationRequest {
    private String subjectName; // 추천 과목명
    private String department;  // 학과명
    private Integer grade;      // 학년
    private String professor;   // 교수명
}