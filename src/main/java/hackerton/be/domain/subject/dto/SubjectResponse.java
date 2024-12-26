package hackerton.be.domain.subject.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SubjectResponse {
    private Long id;          // 과목 ID
    private String name;      // 교과목명
    private String type;      // 이수구분
    private String credit;    // 학점/이론/실습
    private Integer grade;    // 학년
    private String department;// 주관학과
    private String professor; // 교수명
}
