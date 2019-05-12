package com.javainuse.kafkaproducer;

import com.javainuse.Entity.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class MessageService {
    private final MessageRepo messageRepo;


    public List<User> findAll() {
        return messageRepo.findAll();
    }

    public Optional<User> findById(Long id) {
        return messageRepo.findById(id);
    }


    public void addUser(List<String> userData) {
        User newUser = new User(userData.get(1), userData.get(2), userData.get(3));

        User userFromDB = messageRepo.findByName(newUser.getName());
        if (userFromDB != null) {
            log.info("User exist");
        } else {
            messageRepo.save(newUser);
        }
    }
}
