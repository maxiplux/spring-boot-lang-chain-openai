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
@Table(name = "parents")
public class Parent {
    @Id
    @Column(name = "id")
    private Integer id;

    @Size(max = 64)
    @Column(name = "student_name", length = 64)
    private String studentName;

    @Size(max = 64)
    @Column(name = "parent_name", length = 64)
    private String parentName;

    @Size(max = 16)
    @Column(name = "parent_mobile", length = 16)
    private String parentMobile;

}
