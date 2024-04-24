package com.example.RegisterLogin.Service;
import com.example.RegisterLogin.Model.User;
import com.example.RegisterLogin.UserDao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
 @Autowired
 private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();// gives us list of users
    }
    public List<User> getUserbyRole(String role){
        return userRepository.findByRole(role);
    }

    public String addUser(User user){
        userRepository.save(user);
        return "User added successfully";
    }

    public String updateUser(int id, User newUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(newUser.getName());
            existingUser.setLastname(newUser.getLastname());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setPhone(newUser.getPhone());
            existingUser.setRole(newUser.getRole());
            userRepository.save(existingUser);
            return "User updated successfully";
        }
        return "User not found";
    }


    public String deleteUser(int id){
        if(userRepository.existsById(id)){
            userRepository.deleteById(id);
            return "User deleted successfully";
        }
        return "User not found";
    }
}
