package hackerton.be.domain.recommend.controller;

import hackerton.be.domain.recommend.Recommend;
import hackerton.be.domain.recommend.dto.GetRecommendationResponse;
import hackerton.be.domain.recommend.dto.RecommendationRequest;
import hackerton.be.domain.recommend.service.RecommendService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users/{userId}/recommendations")
public class RecommendController {
    private final RecommendService recommendService;


    @PostMapping
    public ResponseEntity<String> saveRecommendations(
            @PathVariable Long userId,
            @Valid @RequestBody List<RecommendationRequest> recommendations) {
        recommendService.saveRecommendations(userId, recommendations);
        return ResponseEntity.ok("Recommendations saved successfully.");
    }

    @GetMapping
    public ResponseEntity<List<GetRecommendationResponse>> getRecommendations(@PathVariable Long userId) {
        List<GetRecommendationResponse> recommendations = recommendService.getRecommendations(userId);
        return ResponseEntity.ok(recommendations);
    }
}
