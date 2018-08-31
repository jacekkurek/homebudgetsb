package pl.coderslab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "subcategories")
public class Subcategory {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 25)
    @Column(length = 25, nullable = false)
    private String name;

    @ManyToOne
    private Budget budget;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Category category;

    @OneToMany(mappedBy = "subcategory", cascade = CascadeType.REMOVE)
    private List<Transaction> transactions;

}
