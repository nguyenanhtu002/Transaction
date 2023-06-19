package dao;

import model.TagFinance;

import java.util.List;

public interface TagFinanceDAO {
    void insert(TagFinance tagFinance);

    List<TagFinance> getAll();

    void delete(int id);

    void update(TagFinance tagFinance, int id);
}
