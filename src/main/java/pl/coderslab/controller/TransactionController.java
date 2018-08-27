package pl.coderslab.controller;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.entity.Transaction;
import pl.coderslab.entity.User;
import pl.coderslab.repository.TransactionRepository;

import javax.validation.Valid;
import javax.validation.Validator;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.sql.*;

@Controller
@RequestMapping("/transaction")
@Log
public class TransactionController {

    private final TransactionRepository transactionRepository;

    public TransactionController(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Autowired
    Validator validator;

    @GetMapping("/add")
    public String addNew(Model model) {
        model.addAttribute("transaction", new Transaction());
        return "transaction/add";
    }

    @PostMapping("/add")
    public String performNew(@Valid Transaction transaction, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors) {
                System.out.println(error.getObjectName() + " - " + error.getDefaultMessage());
            }
            return "transaction/add";
        } else {

        }

//        java.util.Date data1 = new java.util.Date();
//        java.sql.Date time_transaction = new java.sql.Date(data1.getTime());
//
//
//        try {
//            data1 =  new SimpleDateFormat("yyyy-MM-dd").parse(transaction.getTime_transaction());
//            time_transaction = new java.sql.Date(data1.getTime());
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }

        transaction.setTime_added(LocalDateTime.now());
//        transaction.setTime_transaction(time_transaction);
        transactionRepository.save(transaction);
        System.out.println(transaction.getTime_transaction());
        return "redirect:/transaction/all";
    }

    @GetMapping("/all")
    public String list(Model model) {
        model.addAttribute("transactions", transactionRepository.findAll());
        return "transaction/all";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable long id) {
        transactionRepository.delete(id);
        return "redirect:/transaction/all";
    }

    @GetMapping("/edit/{id}")
    public String edit(Model model, @PathVariable long id) {
        model.addAttribute("transaction", transactionRepository.findOne(id));
        return "transaction/edit";
    }

    @PostMapping("/edit/*")
    public String editPerform(Model model, @Valid Transaction transaction, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println("EEEEEEEEE");

            return "transaction/edit";
        }
        transactionRepository.save(transaction);
        return "redirect:/transaction/all";
    }
}
