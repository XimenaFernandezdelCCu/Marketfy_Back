package com.Marketfy.Server_Marketfy.repos;

import com.Marketfy.Server_Marketfy.entities.UsersExtra;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersExtraRepository extends CrudRepository<UsersExtra, Integer> {
    Optional<UsersExtra> findById(Integer id);
}
