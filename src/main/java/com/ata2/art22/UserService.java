package com.ata2.art22;

import com.ata2.art22.entity.User;
import com.ata2.art22.entity.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final EntityManager entityManager;

    public UserService(UserRepository userRepository, UserMapper userMapper, EntityManager entityManager) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.entityManager = entityManager;
    }

    @Transactional
    public UserDTO preSave(UserDTO userDTO) {
        User savedUser = userRepository.save(userMapper.toEntity(userDTO));
        UserDTO savedUserDTO = userMapper.toDto(savedUser);
        entityManager.flush();
        return savedUserDTO;
    }
}
