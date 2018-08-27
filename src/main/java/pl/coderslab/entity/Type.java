package pl.coderslab.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Data
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @Size(max = 25)
    @Column(unique = true, nullable = false, length = 25)
    private String name;

}
