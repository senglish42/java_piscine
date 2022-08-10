package edu.school21.repositories;

import edu.school21.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private final Connection connect;
    final String FIND = "SELECT * FROM users WHERE id = ";
    final String FIND_ALL = "SELECT * FROM users";
    final String FIND_EMAIL = "SELECT * FROM users WHERE email = ?";
    final String SAVE = "INSERT INTO users (email) VALUES (?)";
    final String UPDATE = "UPDATE users SET email = ? WHERE id = ?";
    final String DELETE = "DELETE FROM users WHERE id = ?";



    public UsersRepositoryJdbcImpl(DataSource dataSource) throws SQLException {
        this.connect = dataSource.getConnection();
    }

    @Override
    public User findById(Long id) {
        User user = null;
        try (Statement statement = connect.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND + id);
            if (!resultSet.next())
                return null;
            user = new User(id, resultSet.getString("email"));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> list = new ArrayList<>();
        try (Statement statement = connect.createStatement())
        {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while(resultSet.next())
                list.add(new User(resultSet.getLong("id"), resultSet.getString("email")));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void save(User entity) {
        try (PreparedStatement statement = connect.prepareStatement(SAVE)) {
            statement.setLong(1, entity.getId());
            statement.setString(2, entity.getEmail());
            statement.execute();
            Optional<User> user = findByEmail(entity.getEmail());
            user.ifPresent(value -> entity.setId(value.getId()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        try (PreparedStatement statement = connect.prepareStatement(UPDATE)) {
            statement.setString(1, entity.getEmail());
            statement.setLong(2, entity.getId());
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = connect.prepareStatement(DELETE)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<User> findByEmail(String email) {
        User user = null;
        try (PreparedStatement preparedStatement = connect.prepareStatement(FIND_EMAIL)) {
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (!resultSet.next())
                return Optional.empty();
            user = new User(resultSet.getLong(1), resultSet.getString(2));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (user == null)
            return Optional.empty();
        return Optional.of(user);
    }
}
