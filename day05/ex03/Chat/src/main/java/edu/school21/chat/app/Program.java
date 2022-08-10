
package edu.school21.chat.app;

import java.sql.SQLException;
import java.util.Optional;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

public class Program {

    public static void main(String[] args) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("post");
        dataSource.setPassword("12345");
        try
        {
            MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
            Optional<Message> messageOptional = messagesRepository.findById(4L);
            if (messageOptional.isPresent()) {
                Message message = messageOptional.get();
                message.setText("Bye");
                message.setDate(null);
                messagesRepository.update(message);
            } else {
                System.err.println("Index of the given message is not valid.");
                System.exit(-1);
            }
        }
        catch (SQLException e)
        {
            System.err.println(e.getSQLState());
            System.exit(-1);
        }
        catch (RuntimeException e)
        {
            System.err.println(e.getMessage());
            System.exit(-1);
        }
    }
}