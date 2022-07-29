package edu.school21.application;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import edu.school21.models.User;
import edu.school21.repositories.UsersRepository;

public class Program {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        UsersRepository usersRepository = context.getBean("usersRepositoryJdbc", UsersRepository.class);
        System.out.println(usersRepository.findAll());

        System.out.println(usersRepository.findByEmail("awoods@student.21-school.ru") );
        System.out.println(usersRepository.findByEmail("senglish@student.21-school.ru") );
        System.out.println(usersRepository.findById(3L));
        System.out.println();

        usersRepository = context.getBean("usersRepositoryJdbcTemplate", UsersRepository.class);
        System.out.println(usersRepository.findAll() );

        System.out.println(usersRepository.findByEmail("awoods@student.21-school.ru") );
        System.out.println(usersRepository.findByEmail("senglish@student.21-school.ru") );
        System.out.println(usersRepository.findById(3L));
        System.out.println();

        User user = new User(999L, "new_email.ru");
        usersRepository.save(user);
        System.out.println(usersRepository.findByEmail(user.getEmail()));
    }
}