/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

/**
 *
 * @author Dimas
 */

import main.DatabaseConnection;
import model.Transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionRepository {

    public void save(Transaction transaction) throws SQLException {
        String sql = """
            INSERT INTO transactions
            (transaction_date, transaction_type, category,
             description, amount, payment_method)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setDate(1, java.sql.Date.valueOf(
                    transaction.getTransactionDate()));
            statement.setString(2, transaction.getTransactionType());
            statement.setString(3, transaction.getCategory());
            statement.setString(4, transaction.getDescription());
            statement.setBigDecimal(5, transaction.getAmount());
            statement.setString(6, transaction.getPaymentMethod());

            statement.executeUpdate();
        }
    }

    public List<Transaction> findAll() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();

        String sql = "SELECT * FROM transactions ORDER BY transaction_date DESC";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Transaction transaction = new Transaction();

                transaction.setId(resultSet.getInt("id"));
                transaction.setTransactionDate(
                        resultSet.getDate("transaction_date").toLocalDate());
                transaction.setTransactionType(
                        resultSet.getString("transaction_type"));
                transaction.setCategory(resultSet.getString("category"));
                transaction.setDescription(
                        resultSet.getString("description"));
                transaction.setAmount(resultSet.getBigDecimal("amount"));
                transaction.setPaymentMethod(
                        resultSet.getString("payment_method"));

                transactions.add(transaction);
            }
        }

        return transactions;
    }
}