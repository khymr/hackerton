package hackerton.be.domain.recommend.controller;

import hackerton.be.domain.recommend.Recommend;
import hackerton.be.domain.recommend.dto.RecommendationRequest;
import hackerton.be.domain.recommend.service.RecommendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{userId}/recommendations")
@RequiredArgsConstructor
public class RecommendController {
    private final RecommendService recommendService;

    @PostMapping
    public ResponseEntity<?> saveRecommendations(
            @PathVariable Long userId,
            @RequestBody List<RecommendationRequest> recommendations) {
        recommendService.saveRecommendations(userId, recommendations);
        return ResponseEntity.ok("Recommendations saved successfully.");
    }

    @GetMapping
    public List<Recommend> getRecommendations(@PathVariable Long userId) {
        return recommendService.getRecommendations(userId);
    }
}
