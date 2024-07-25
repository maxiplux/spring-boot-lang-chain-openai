package app.quantun.langchanin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "students")
public class Student {
    @Id
    @Column(name = "id")
    private Integer id;

    @Size(max = 64)
    @Column(name = "name", length = 64)
    private String name;

    @Column(name = "score")
    private Integer score;

    @Size(max = 256)
    @Column(name = "teacher_note", length = 256)
    private String teacherNote;

}
