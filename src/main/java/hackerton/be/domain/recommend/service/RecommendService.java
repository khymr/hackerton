package hackerton.be.domain.recommend.service;

import hackerton.be.domain.recommend.Recommend;
import hackerton.be.domain.recommend.dto.RecommendationRequest;
import hackerton.be.domain.recommend.repository.RecommendRepository;
import hackerton.be.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RecommendService {
    private final RecommendRepository recommendRepository;
    // 추천 데이터를 저장
    public void saveRecommendations(Long userId, List<RecommendationRequest> recommendations) {
        for (RecommendationRequest request : recommendations) {
            Recommend recommend = Recommend.builder()
                    .user(User.builder().id(userId).build()) // User와 연결
                    .subjectName(request.getSubjectName())
                    .department(request.getDepartment())
                    .grade(request.getGrade())
                    .professor(request.getProfessor())
                    .isSelected(false) // 초기값은 선택되지 않은 상태
                    .build();
            recommendRepository.save(recommend);
        }
    }

    // 사용자별 추천 데이터 조회
    public List<Recommend> getRecommendations(Long userId) {
        return recommendRepository.findByUserId(userId);
    }
}
