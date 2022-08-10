package edu.school21.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import edu.school21.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private final JdbcTemplate jdbcTemplateObj;
    final String FIND = "SELECT * FROM users WHERE id = ";
    final String FIND_ALL = "SELECT * FROM users";
    final String FIND_EMAIL = "SELECT * FROM users WHERE email = ?";
    final String SAVE = "INSERT INTO users (email) VALUES (?)";
    final String UPDATE = "UPDATE users SET email = ? WHERE id = ?";

    final String DELETE = "DELETE FROM users WHERE id = ?";

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplateObj = new JdbcTemplate(dataSource);
    }

    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return (new User(resultSet.getLong("id"),
                    resultSet.getString("email")));
        }
    }

    @Override
    public User findById(Long id) {
        User user;
        try {
            user = jdbcTemplateObj.queryForObject(FIND + id.intValue(), new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplateObj.query(FIND_ALL, new UserMapper());
    }

    @Override
    public void save(User entity) {
        if (findByEmail(entity.getEmail()).isPresent())
            return;
        jdbcTemplateObj.update(SAVE, entity.getEmail());
        Optional<User> user = findByEmail(entity.getEmail());
        user.ifPresent(value -> entity.setId(value.getId()));
    }

    @Override
    public void update(User entity) {
        int result = jdbcTemplateObj.update(UPDATE,
                entity.getEmail(),
                entity.getId());
        if (result == 0)
            save(entity);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplateObj.update(DELETE, id.intValue());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user;
        try {
            user = jdbcTemplateObj.queryForObject(FIND_EMAIL, new UserMapper(), email);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
        assert user != null;
        return Optional.of(user);
    }
}
