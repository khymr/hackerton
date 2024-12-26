package hackerton.be.domain.recommend;

import hackerton.be.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "recommend")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Recommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 추천을 받은 사용자

    private String subjectName; // 추천된 과목명
    private String department;  // 학과명
    private Integer grade;      // 학년
    private String professor;   // 교수명

    private boolean isSelected = false; // 사용자가 실제로 선택했는지 여부

    private LocalDateTime recommendedAt = LocalDateTime.now(); // 추천된 시간
}