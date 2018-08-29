package pl.coderslab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "transaction")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDateTime timeAdded;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate timeTransaction;

    @Size(max = 50)
    @Column(length = 50)
    private String name;

    @NotNull
    @Digits(integer = 15, fraction = 2)
    @Column(precision = 15, scale = 2, nullable = false)
    private Double value;   //

    @ManyToOne
    private User user;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Subcategory subcategory;

}
