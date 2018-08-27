package pl.coderslab.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
    private String name;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private Category category;


}
