package com.project.database.dao.Impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.database.dao.UserDao;
import com.project.database.model.UserDTO;

@Repository
// Do đang vừa liên kết JDBC và Hibernate cùng 1 lúc . Spring sẽ có 2 bean là 
// hibernateTransactionManager và dataSourceTransactionManager
// Nên phải ghi value tại transactional để biết Spring xài bean nào
@Transactional("dataSourceTransactionManager")
public class UserDaoJDBCImpl implements UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void addUser(UserDTO user) {
        String sql = "INSERT INTO USER(name,phone) VALUE (?,?)";
        jdbcTemplate.update(sql, user.getName(),user.getPhone());
    }

    @Override
    public void updateUser(UserDTO user) {
        String sql = "UPDATE USER SET name = ?, phone = ? WHERE ID = ?";
        jdbcTemplate.update(sql, user.getName(),user.getPhone(),user.getId());
    }

    @Override
    public void deleteUser(int id) {
        String sql = "DELETE FROM USER WHERE ID = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public UserDTO getUserById(int id) {
        String sql = "SELECT * FROM user WHERE ID = ?";
        return jdbcTemplate.queryForObject(sql,new Object[]{id},new int[] {Types.INTEGER}, new BeanPropertyRowMapper<>(UserDTO.class));
    }

    @Override
    public List<UserDTO> getListUser() {
        String sql = "SELECT * FROM user";
        return jdbcTemplate.query(sql,new RowMapper<UserDTO>() {
            public UserDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                UserDTO user = new UserDTO();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPhone(rs.getString("phone"));
                return user;
            }
        });
    }
    
}
