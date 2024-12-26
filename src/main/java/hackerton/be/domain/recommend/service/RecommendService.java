package hackerton.be.domain.recommend.service;

import hackerton.be.domain.recommend.Recommend;
import hackerton.be.domain.recommend.dto.GetRecommendationResponse;
import hackerton.be.domain.recommend.dto.RecommendationRequest;
import hackerton.be.domain.recommend.exception.RecommendException;
import hackerton.be.domain.recommend.exception.RecommendExceptionType;
import hackerton.be.domain.recommend.repository.RecommendRepository;
import hackerton.be.domain.user.User;
import hackerton.be.domain.user.exception.UserException;
import hackerton.be.domain.user.exception.UserExceptionType;
import hackerton.be.domain.user.repository.UserRepository;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RecommendService {
    private final RecommendRepository recommendRepository;
    private final UserRepository userRepository;

    // 추천 데이터 저장
    public void saveRecommendations(Long userId, List<RecommendationRequest> recommendations) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserExceptionType.USER_NOT_FOUND));
        if (recommendations.isEmpty()) {
            throw new RecommendException(RecommendExceptionType.EMPTY_RECOMMENDATION_LIST);
        }
        for (RecommendationRequest request : recommendations) {
            Recommend recommend = Recommend.builder()
                    .user(User.builder().id(userId).build()) // 사용자와 연결
                    .subjectName(request.getSubjectName())
                    .department(request.getDepartment())
                    .grade(request.getGrade())
                    .professor(request.getProfessor())
                    .build();
            recommendRepository.save(recommend);
        }
    }

    // 추천 데이터 조회
    public List<GetRecommendationResponse> getRecommendations(Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new UserException(UserExceptionType.USER_NOT_FOUND));
        List<Recommend> recommendations = recommendRepository.findByUserId(userId);
        if (recommendations.isEmpty()) {
            return List.of(); // 빈 리스트 반환
        }
        return recommendations.stream()
                .map(recommend -> GetRecommendationResponse.builder()
                        .id(recommend.getId())
                        .subjectName(recommend.getSubjectName())
                        .department(recommend.getDepartment())
                        .grade(recommend.getGrade())
                        .professor(recommend.getProfessor())
                        .build())
                .toList();
    }

}
