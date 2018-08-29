package pl.coderslab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@ToString(exclude = {"budgets"})    // przerwanie aby się nie zapętlało przez sąsiednie tabele
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    @Size(max = 25)
    @Column(length = 25, unique = true)
    private String name;

    @NotBlank
    @Pattern(regexp = "\\d{4}")
    @Column(precision = 4)
    private String pin;

    @Digits(integer=15, fraction=2)
    @Column(precision = 15, scale = 2)
    private double salary;

    @ManyToMany(mappedBy = "users")
    private List<Budget> budgets = new ArrayList<>();

}