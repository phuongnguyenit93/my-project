package com.project.database.dao;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.database.entity.User;

public interface UserDaoJPA extends JpaRepository<User,Integer> {
    User findByName(String name);
    User findByPhone(String phone);

    @Query(value = "FROM #{#entityName} WHERE name like ?1")
	List<User> findUserByUserNameLike(String name, Pageable pageable);
	
	@Query(value = "SELECT * FROM user WHERE phone like :phone ORDER BY phone DESC", nativeQuery = true)
	List<User> findUserByPhoneDesc(@Param("phone") String phone);
}
