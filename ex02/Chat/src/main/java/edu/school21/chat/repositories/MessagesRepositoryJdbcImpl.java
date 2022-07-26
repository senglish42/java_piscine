package edu.school21.chat.repositories;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.app.NotSavedSubEntityException;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;

import java.sql.*;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository
{
    private final java.sql.Connection connection;
    public MessagesRepositoryJdbcImpl(HikariDataSource data) throws SQLException
    {
        this.connection = data.getConnection();
    }
    public java.sql.Connection getConnection()
    {
        return this.connection;
    }
    @Override
    public Optional<Message> findById(Long id)
    {
        long a_id;
        long r_id;
        User usr;
        Chatroom croom;
        String txt;
        Timestamp time;

        try (Statement statement = connection.createStatement()){
            try(ResultSet resultSet = statement.executeQuery("SELECT * FROM messages WHERE id=" + id)) {
                if (!resultSet.next()) {
                    return Optional.empty();
                }
                a_id = resultSet.getLong("author_id");
                r_id = resultSet.getLong("room_id");
                txt = resultSet.getString("text");
                time = resultSet.getTimestamp("time");
            }

            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM users WHERE id=" + a_id)) {
                resultSet.next();

                usr = new User(a_id, resultSet.getString("login"), resultSet.getString("password"), null, null);
            }
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM rooms WHERE id=" + r_id)){
                resultSet.next();

                croom = new Chatroom(r_id, resultSet.getString("name"), null, null);
                if (time == null) {
                    return Optional.of(new Message(id, usr, croom, txt, null));
                }
                return Optional.of(new Message(id, usr, croom, txt, time.toLocalDateTime()));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public void save(Message message) throws NotSavedSubEntityException {
        String sql = "INSERT INTO messages (author_id, room_id, text) VALUES (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setLong(1, message.getAuthor().getId());
            statement.setLong(2, message.getRoom().getId());
            statement.setString(3, message.getText());
            statement.executeUpdate();
            try (ResultSet key = statement.getGeneratedKeys()) {
                key.next();
                message.setId(key.getLong(1));
            }

        } catch (SQLException e) {
            throw new NotSavedSubEntityException();
        }
    }
}
