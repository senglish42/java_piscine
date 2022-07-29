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

    private final JdbcTemplate jdbcTemplateObject;
    final String UPDATE_QUERY = "UPDATE users SET email = ? WHERE id = ?";
    final String FIND_ID_QUERY = "SELECT * FROM users WHERE id = ";
    final String FIND_ALL_QUERY = "SELECT * FROM users";
    final String FIND_EMAIL_QUERY = "SELECT * FROM users WHERE email = ?";
    final String SAVE_QUERY = "INSERT INTO users (email) VALUES (?)";
    final String DELETE_QUERY = "DELETE FROM users WHERE id = ?";

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplateObject = new JdbcTemplate(dataSource);
    }

    private static final class UserMapper implements RowMapper<User> {
        public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
            return (new User(resultSet.getLong("id"),
                    resultSet.getString("email")));
        }
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try {
            user = jdbcTemplateObject.queryForObject(FIND_ID_QUERY + id.intValue(), new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplateObject.query(FIND_ALL_QUERY, new UserMapper());
    }

    @Override
    public void save(User entity) {
        if (findByEmail(entity.getEmail()).isPresent())
            return;
        jdbcTemplateObject.update(SAVE_QUERY, entity.getEmail());
        Optional<User> user = findByEmail(entity.getEmail());
        user.ifPresent(value -> entity.setId(value.getId()));
    }

    @Override
    public void update(User entity) {
        int result = jdbcTemplateObject.update(UPDATE_QUERY,
                entity.getEmail(),
                entity.getId());
        if (result == 0)
            save(entity);
    }

    @Override
    public void delete(Long id) {
        jdbcTemplateObject.update(DELETE_QUERY, id.intValue());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = null;
        try {
            user = jdbcTemplateObject.queryForObject(FIND_EMAIL_QUERY, new UserMapper(), email);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
        return Optional.of(user);
    }
}
