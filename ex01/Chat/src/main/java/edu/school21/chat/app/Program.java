
package edu.school21.chat.app;

import java.sql.SQLException;
import java.util.Optional;
import java.util.Scanner;
import com.zaxxer.hikari.HikariDataSource;
import edu.school21.chat.models.Message;
import edu.school21.chat.repositories.MessagesRepository;
import edu.school21.chat.repositories.MessagesRepositoryJdbcImpl;

public class Program {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setJdbcUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUsername("post");
        dataSource.setPassword("12345");
        System.out.print("Enter a message ID: ");
        try
        {
            Long id = null;
            if (in.hasNextLong()) {
                id = in.nextLong();
            } else {
                System.err.println("You should input a number of long format.");
                System.exit(-1);
            }
            MessagesRepository repositoryJdbc = new MessagesRepositoryJdbcImpl(dataSource);
            Optional <Message> msg = repositoryJdbc.findById(id);
            if (msg.isPresent()) {
                System.out.println(msg.get());
            } else {
                System.err.println("Optional Message container is not set.");
            }
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