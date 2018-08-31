package pl.coderslab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @Size(max = 25)
    @Column(unique = true, nullable = false, length = 25)
    private String name;

    @OneToMany(mappedBy = "type", cascade = CascadeType.REMOVE)
    private List<Transaction> transactions;

}
