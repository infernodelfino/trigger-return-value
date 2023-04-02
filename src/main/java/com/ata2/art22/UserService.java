package com.ata2.art22;

import com.ata2.art22.entity.User;
import com.ata2.art22.entity.UserDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    private final EntityManager entityManager;

    private final EntityManagerFactory entityManagerFactory;

    public UserService(UserRepository userRepository, UserMapper userMapper, EntityManager entityManager, EntityManagerFactory entityManagerFactory) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.entityManager = entityManager;
        this.entityManagerFactory = entityManagerFactory;
    }

    @Transactional
    public void getAll() {
//        entityManager.createNativeQuery("SET NOCOUNT OFF");
        List<User> x = userRepository.findAll();
        x.get(0).setName("QQQQQQQQQQQ");
    }

    @Transactional
    public void updateUsingJPQL(Long id) {
        userRepository.updateUser(id, "QQQQQQ");
    }

    //    @Transactional
    @Transactional
    public UserDTO saveRepo(UserDTO userDTO) {
//        userRepository.saveAll(List.of(userMapper.toEntity(userDTO)));
        userRepository.save(userMapper.toEntity(userDTO));
        return userDTO;
    }

    //    @Transactional
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public UserDTO saveEmPersist(UserDTO userDTO) {
//        EntityManager em = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//        entityManager.createNativeQuery("SET NOCOUNT OFF").executeUpdate();
        User entity = userMapper.toEntity(userDTO);
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
//        entityManager.getTransaction().commit();
//        entityManager.close();
        return userDTO;
    }

    //    @Transactional
    public UserDTO saveEmNative(UserDTO userDTO) {
        entityManager.createNativeQuery("INSERT INTO jhi_user(name) VALUES (?)")
                .setParameter(1, userDTO.getName())
                .getSingleResult();
        return userDTO;
    }
}
