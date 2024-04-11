package com.example.RegisterLogin.Service;
import com.example.RegisterLogin.Model.User;
import com.example.RegisterLogin.UserDao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RegistrationService {
 @Autowired
    UserDao userDao;
    public RegistrationService(UserDao userDao) {
        this.userDao=userDao;
    }

    public List<User> getAllUsers() {
        return userDao.findAll();// gives us list of users
    }
    public List<User> getUserbyRole(String role){
        return userDao.findByRole(role);
    }

    public String addUser(User user){
        userDao.save(user);
        return "User added successfully";
    }

    public String updateUser(int id, User user){
        if(userDao.existsById(id)){
            userDao.save(user);
            return "User updated successfully";
        }
        return "User not found";
    }

    public String deleteUser(int id){
        if(userDao.existsById(id)){
            userDao.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }
}
