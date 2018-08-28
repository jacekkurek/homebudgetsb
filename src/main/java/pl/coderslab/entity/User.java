package pl.coderslab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Size(max = 25)
    @Column(length = 25, unique = true)
    private String name;
    @Digits(integer=4, fraction=0)
    @Column(precision = 4)
    private int pin;
    @Digits(integer=15, fraction=2)
    @Column(precision = 15, scale = 2)
    private double salary;

    @ManyToMany
    private List<Budget> budgets = new ArrayList<>();
}