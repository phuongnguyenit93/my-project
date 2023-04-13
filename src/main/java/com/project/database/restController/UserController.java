package com.project.database.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.entity.User;
import com.project.database.model.UserDTO;
import com.project.database.service.impl.UserHibernateServiceImpl;
import com.project.database.service.impl.UserJPAServiceImpl;
import com.project.database.service.impl.UserServiceImpl;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    UserServiceImpl userServiceImpl;

    @Autowired
    UserHibernateServiceImpl userHibernateServiceImpl;

    @Autowired
    UserJPAServiceImpl userJPAServiceImpl;

    @RequestMapping(value = "/user-jdbc",method = RequestMethod.GET)
    public ResponseEntity<List<UserDTO>> getUserListJDBC () {
        return new ResponseEntity<>(userServiceImpl.getListUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user-jdbc/{id}",method = RequestMethod.GET)
    public ResponseEntity <UserDTO> getUserListJDBCByID (@PathVariable int id) {
        return new ResponseEntity<>(userServiceImpl.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user-jdbc")
    public ResponseEntity<UserDTO> addUserJDBC (@RequestBody @Valid UserDTO user) {
        try {
            userServiceImpl.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value = "/user-hibernate",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserListHibernate () {
        return new ResponseEntity<>(userHibernateServiceImpl.getListUser(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user-hibernate/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> getUserListHibernate (@PathVariable int id) {
        return new ResponseEntity<>(userHibernateServiceImpl.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/user-hibernate")
    public ResponseEntity<User> addUserHibernate (@RequestBody @Valid User user) {
        try {
            userHibernateServiceImpl.addUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.badRequest().body(null);
        }
    }

    @RequestMapping(value = "/user-jpa",method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUserListJPA () {
        return new ResponseEntity<>(userJPAServiceImpl.getListUser(), HttpStatus.OK);
    }

}
