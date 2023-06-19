package dao.implement;

import dao.DataSource;
import dao.TagFinanceDAO;
import model.TagFinance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TagFinanceDAOImpl implements TagFinanceDAO {
    public static final String ADD_TAG = "INSERT INTO TagFinance VALUES (?, ?,?)";
    public static final String SELECT_ALL = "SELECT * FROM TagFinance";
    public static final String DELETE_TRAN = "DELETE FROM TagFinance WHERE id =?";
    public static String UPDATE_TAG = "UPDATE TagFinance SET name =?, description =? WHERE id =?";

    @Override
    public void insert(TagFinance tagFinance) {

        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(ADD_TAG);
            pstmt.setInt(1, tagFinance.getId());
            pstmt.setString(2, tagFinance.getName());
            pstmt.setString(3, tagFinance.getDescription());
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public List<TagFinance> getAll() {
        List<TagFinance> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TagFinance getTagFinance = new TagFinance(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("description"));
                list.add(getTagFinance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return list;
    }

    @Override
    public void delete(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(DELETE_TRAN);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException("Failed to delete");

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public void update(TagFinance tagFinance, int idUpdate) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TAG);
            pstmt.setString(1, tagFinance.getName());
            pstmt.setString(2, tagFinance.getDescription());
            pstmt.setInt(3, idUpdate);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }
}
