package controller;

import dao.TagFinanceDAO;
import dao.implement.TagFinanceDAOImpl;
import model.TagFinance;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TagfinanceController {
    private TagFinanceDAO tagFinanceDAO = new TagFinanceDAOImpl();


    public void insert(TagFinance tagFinance) {
        tagFinanceDAO.insert(tagFinance);
    }

    public void update(TagFinance tagFinance,int idUpdate) {
        tagFinanceDAO.update(tagFinance, idUpdate);
    }

    public void delete(int idDelete) {
        tagFinanceDAO.delete(idDelete);
    }

    public List<TagFinance> getAll() {
        List<TagFinance> list = new ArrayList<>();
        list= tagFinanceDAO.getAll();
        return list;
    }

}
