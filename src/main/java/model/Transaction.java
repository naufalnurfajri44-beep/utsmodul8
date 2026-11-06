/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Dimas
 */

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {

    private int id;
    private LocalDate transactionDate;
    private String transactionType;
    private String category;
    private String description;
    private BigDecimal amount;
    private String paymentMethod;

    public Transaction() {
    }

    public Transaction(int id, LocalDate transactionDate,
            String transactionType, String category,
            String description, BigDecimal amount,
            String paymentMethod) {
        this.id = id;
        this.transactionDate = transactionDate;
        this.transactionType = transactionType;
        this.category = category;
        this.description = description;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}