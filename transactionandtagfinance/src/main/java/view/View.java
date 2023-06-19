package view;


import model.TagFinance;
import model.Transaction;
import controller.TagfinanceController;
import controller.TransactionController;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class View {
    private static List<TagFinance> tagFinanceList = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();
    private static List<Transaction> transactionList = new ArrayList<>();
    static TagfinanceController tagfinancecontroller = new TagfinanceController();
    static TransactionController transactioncontroller = new TransactionController();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {


        int choice = 0;
        do {
            showMenu();

            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    TagFinance tagFinance = createTagfinance();
                    tagfinancecontroller.insert(tagFinance);
                    break;
                }
                case 2: {
                    System.out.println("enter id tagFinance you want to update");
                    int idUpdate = scanner.nextInt();
                    TagFinance tagFinance = createTagfinance();
                    tagfinancecontroller.update(tagFinance, idUpdate);
                    break;
                }
                case 3: {
                    System.out.println("enter id tagFinance");
                    int idDelete = scanner.nextInt();
                    tagfinancecontroller.delete(idDelete);
                    break;
                }
                case 4: {
                    tagFinanceList = tagfinancecontroller.getAll();
                    showAllTag(tagFinanceList);
                    break;
                }
                case 5: {
                    tagFinanceList = tagfinancecontroller.getAll();
                    showAllTag(tagFinanceList);
                    Transaction transaction = createTransaction(tagFinanceList);
                    transactioncontroller.insert(tagFinanceList, transaction);
                    break;
                }
                case 6: {
                    transactionList = transactioncontroller.getAll();
                    showAllTransaction(transactionList);
                    break;
                }
                case 7: {
                    System.out.println("enter id Transaction you want to delete");
                    int idDeleteTransaction = scanner.nextInt();
                    transactioncontroller.delete(idDeleteTransaction);
                    break;
                }
                case 8: {
                    System.out.println("enter id Transaction you want to update");
                    int idUpdate = scanner.nextInt();
                    Transaction transaction = createTransaction(tagFinanceList);
                    transactioncontroller.update(transaction, idUpdate);
                    break;
                }
                case 9: {
                    System.out.println("enter id Transaction");
                    int idSearch = scanner.nextInt();
                    transactions = transactioncontroller.searchByTagfinal(idSearch);
                    showAllTransaction(transactions);
                    break;
                }
                case 10: {
                    scanner.nextLine();
                    System.out.println("enter name Transaction");
                    String name = scanner.nextLine();
                    transactions = transactioncontroller.searchByName(name);
                    showAllTransaction(transactions);

                    break;
                }
            }
        } while (choice != 0);


    }

    private static void showMenu() {
        System.out.println("1.Insert tag finance");
        System.out.println("2.update tag finance");
        System.out.println("3.delete tag finance");
        System.out.println("4.show tag finance");
        System.out.println("5.Insert transaction");
        System.out.println("6.show transaction");
        System.out.println("7.Delete transaction");
        System.out.println("8.Update transaction");
        System.out.println("9.Search by Id");
        System.out.println("10.Search by name");
    }

    private static void showAllTag(List<TagFinance> tagFinanceList) {
        for (TagFinance tagFinance : tagFinanceList) {
            System.out.println(tagFinance);
        }
    }

    private static void showAllTransaction(List<Transaction> transactionList) {
        for (Transaction transaction : transactionList) {
            System.out.println(transaction);
        }
    }

    public static Transaction createTransaction(List<TagFinance> tagFinanceList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id tagFinance you want to add transaction");
        int idTag = scanner.nextInt();
        scanner.nextLine();
        TagFinance tagFinance = new TagFinance();

        boolean check = false;
        for (int i = 0; i < tagFinanceList.size(); i++) {
            if (tagFinanceList.get(i).getId() == idTag) {
                tagFinance = tagFinanceList.get(i);
                check = true;
            }
        }
        if (check == false) {
            System.out.println("Not found");
            return null;
        }
        int id = 0;
        System.out.println("create At");
        String createdAt = scanner.nextLine();
        System.out.println("title");
        String title = scanner.next();
        System.out.println("description");
        String description = scanner.next();
        scanner.nextLine();
        System.out.println("amount");
        double amount = scanner.nextInt();


        Transaction transaction = new Transaction(createdAt, title, description, amount, idTag, tagFinance);
        return transaction;
    }

    public static TagFinance createTagfinance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter id tagFinance");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.println("enter new name tagfinance");
        String name = scanner.nextLine();
        System.out.println("ennter new description tagfinance");
        String description = scanner.nextLine();
        TagFinance tagFinance = new TagFinance(id, name, description);
        return tagFinance;
    }
}