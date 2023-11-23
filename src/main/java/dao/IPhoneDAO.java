package dao;

import model.Phone;

import java.sql.SQLException;
import java.util.List;

public interface IPhoneDAO {
    public void insertPhone(Phone phone) throws SQLException;
    Phone selectPhone(int id) throws SQLException;
    List<Phone> selectALlPhone() throws SQLException;
    boolean deletePhone(int id) throws SQLException;
    boolean updatePhone(Phone phone) throws SQLException;
}
