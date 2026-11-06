/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author Dimas
 */

import model.Transaction;
import repository.TransactionRepository;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService() {
        this.repository = new TransactionRepository();
    }

    public void addTransaction(Transaction transaction) throws SQLException {
        validateTransaction(transaction);
        repository.save(transaction);
    }

    public List<Transaction> getAllTransactions() throws SQLException {
        return repository.findAll();
    }

    private void validateTransaction(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("Transaksi tidak boleh kosong.");
        }

        if (transaction.getTransactionDate() == null) {
            throw new IllegalArgumentException("Tanggal transaksi wajib diisi.");
        }

        if (transaction.getTransactionType() == null
                || (!transaction.getTransactionType().equals("INCOME")
                && !transaction.getTransactionType().equals("EXPENSE"))) {
            throw new IllegalArgumentException(
                    "Jenis transaksi harus INCOME atau EXPENSE.");
        }

        if (transaction.getCategory() == null
                || transaction.getCategory().isBlank()) {
            throw new IllegalArgumentException("Kategori wajib diisi.");
        }

        BigDecimal amount = transaction.getAmount();

        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException(
                    "Nominal harus lebih besar dari nol.");
        }
    }
}