package hackerton.be.domain.subject;

import hackerton.be.global.util.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "subject")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@AllArgsConstructor
@Builder
public class Subject extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;// 교과목명
    private String type;// 이수구분
    private String credit;// 학점/이론/실습
    private Integer grade;// 학년
    private String department;// 주관학과
    private String professor;// 교수명

    @Builder.Default
    private boolean hasTakenBefore = false; // 기본값 False

    public void markAsTaken() {
        this.hasTakenBefore = true;
    }


    public void updateName(String name) {
        this.name = name;
    }

    public void updateType(String type) {
        this.type = type;
    }

    public void updateCredit(String credit) {
        this.credit = credit;
    }

    public void updateGrade(Integer grade) {
        this.grade = grade;
    }

    public void updateDepartment(String department) {
        this.department = department;
    }

    public void updateProfessor(String professor) {
        this.professor = professor;
    }

}
