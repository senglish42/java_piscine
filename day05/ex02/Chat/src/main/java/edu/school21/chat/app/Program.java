
package edu.school21.chat.app;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Chatroom;
import edu.school21.chat.models.Message;
import edu.school21.chat.models.User;
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
            User creator = new User(2, "user", "user", new ArrayList(), new ArrayList());
            User author = creator;
            Chatroom room = new Chatroom(3, "room", creator, new ArrayList());
            Message message = new Message(null, author, room, "Hello!", LocalDateTime.now());
            MessagesRepository messagesRepository = new MessagesRepositoryJdbcImpl(dataSource);
            messagesRepository.save(message);
            System.out.println(message.getId());
            dataSource.close();
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