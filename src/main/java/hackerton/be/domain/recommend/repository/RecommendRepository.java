package hackerton.be.domain.recommend.repository;

import hackerton.be.domain.recommend.Recommend;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecommendRepository extends JpaRepository<Recommend, Long> {
    List<Recommend> findByUserId(Long userId);
}
