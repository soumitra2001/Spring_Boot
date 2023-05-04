package com.supriya.Mapping.repositories;

import com.supriya.Mapping.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepo extends CrudRepository<User,Long> {

}
