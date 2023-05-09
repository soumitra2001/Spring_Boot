package com.geekster.H2dataBase.repository;

import com.geekster.H2dataBase.models.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserRepository extends CrudRepository<Users,Integer> {

}
