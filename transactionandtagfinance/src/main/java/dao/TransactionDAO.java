package dao;

import model.Transaction;

import java.util.List;

public interface TransactionDAO {
    List<Transaction> getAll();

    void insert(Transaction transaction);

    void update(Transaction transaction, int id);

    void delete(int id);

    List<Transaction> searchByTagfinal(int id);

    List<Transaction> searchByName(String name);
}
