package com.example.RegisterLogin.service;
import com.example.RegisterLogin.model.User;
import com.example.RegisterLogin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
 @Autowired
 private UserRepository userRepository;

 @Autowired
 private PasswordEncoder passwordEncoder;

    public List<User> getAllUsers() {
        return userRepository.findAll();// gives us list of users
    }
    public List<User> getUserbyRole(String roles){
        return userRepository.findByRoles(roles);
    }

    public String addUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return "User added to system successfully";
    }

    public String updateUser(int id, User newUser) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(newUser.getName());
            existingUser.setEmail(newUser.getEmail());
            existingUser.setPassword(newUser.getPassword());
            existingUser.setPhone(newUser.getPhone());
            existingUser.setRoles(newUser.getRoles());
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
