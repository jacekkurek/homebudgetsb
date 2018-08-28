package pl.coderslab.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Digits;
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
    private LocalDateTime time_added;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate time_transaction;
    @Size(max = 50)
    private String name;
    @Digits(integer = 15, fraction = 2)
    private Double value;

    @ManyToOne
    private User user;

    @ManyToOne
    private Budget budget;

    @ManyToOne
    private Type type;

    @ManyToOne
    private Category category;
}
