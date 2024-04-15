package com.Marketfy.Server_Marketfy.repos;

import com.Marketfy.Server_Marketfy.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository <User, Integer> {
    List<User> findByEmail(String email);
    Optional<User> findById(Integer id);

    @Query(value = "SELECT\n" +
            " u.email, u.first, u.last, ue.preferred, ue.bio FROM users u\n" +
            "JOIN users_extra ue ON u.user_id = ue.user_id\n" +
            "WHERE u.user_id = :userId LIMIT 1", nativeQuery = true)
//    @Query(value = "SELECT\n" +
//            " u.email, u.first, u.last, ue.preferred, ue.bio, ue.tags FROM users u\n" +
//            "JOIN users_extra ue ON u.user_id = ue.user_id\n" +
//            "WHERE u.user_id = :userId", nativeQuery = true)
    List<String> getAllUserDetails(@Param("userId") Integer userId);
}
