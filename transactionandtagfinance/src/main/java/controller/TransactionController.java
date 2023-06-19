package controller;

import dao.TransactionDAO;
import dao.implement.TransactionDAOImpl;
import model.TagFinance;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TransactionController {
    private TransactionDAO transactionDAO = new TransactionDAOImpl();

    public List<Transaction> getAll() {
        List<Transaction> list = new ArrayList<>();
        return transactionDAO.getAll();
    }

    public void insert(List<TagFinance> tagFinanceList, Transaction transaction) {
        transactionDAO.insert(transaction);
    }

    public void update(Transaction transaction, int idUpdate) {
        transactionDAO.update(transaction, idUpdate);
    }

    public void delete(int idDelete) {
        transactionDAO.delete(idDelete);
    }

    public List<Transaction> searchByTagfinal(int idSearch) {

        List<Transaction> list = new ArrayList<>();
        list = transactionDAO.searchByTagfinal(idSearch);
        return list;

    }

    public List<Transaction> searchByName(String name) {
        List<Transaction> list = new ArrayList<>();
        return transactionDAO.searchByName(name);
    }


}
