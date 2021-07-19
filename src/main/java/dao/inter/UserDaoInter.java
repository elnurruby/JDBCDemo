package dao.inter;

import com.company.bean.User;

import java.util.List;

public interface UserDaoInter {
    List<User> getAll();

    User getByID(int id);

    boolean updateUser(User u);

    boolean removeUser(int id);
}
