package ro.unibuc.hello.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.unibuc.hello.data.UserEntity;
import ro.unibuc.hello.data.UserRepository;
import ro.unibuc.hello.dto.User;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public UserService(){}

    public UserEntity saveUser(User user) {

        UserEntity userEntity = new UserEntity();

        userEntity.setUsername(user.getUsername());
        userEntity.setEmail(user.getUsername());
        userEntity.setPassword(user.getPassword());
        return userRepository.save(userEntity);
    }
    public UserEntity getUserByEmail(String userEmail) {
        return userRepository.findByEmail(userEmail);
    }

}
