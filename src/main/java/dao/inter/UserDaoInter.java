package dao.inter;

import com.company.bean.User;

import java.util.List;

public interface UserDaoInter {
    List<User> getAll(String name, String surname, Integer nationalityID);

    User getByID(int id);
    boolean addUser(User u);
    boolean updateUser(User u);

    boolean removeUser(int id);
}
