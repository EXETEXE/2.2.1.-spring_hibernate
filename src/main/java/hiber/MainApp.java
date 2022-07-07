package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

//      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
//      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
//      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
//      userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

//      --- Добавление пользователей с машинами ---

      User carUser1 = new User("Vasya", "Pupkin", "vpupkin@mail.ru");
      User carUser2 = new User("Loopich", "Poopievich", "vpupich@mail.ru");
      User carUser3 = new User("John", "Smith", "jsmith@mail.ru");
      User carUser4 = new User("Dart", "Vader", "dvader@mail.ru");

      Car car1 = new Car("Toyota", 4, carUser1);
      Car car2 = new Car("Mersedes", 15,carUser2);
      Car car3 = new Car("Lada", 2,carUser3);
      Car car4 = new Car("BMW", 40,carUser4);


      userService.add(carUser1);
      userService.add(carUser2);
      userService.add(carUser3);
      userService.add(carUser4);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar().toString());
         System.out.println();
      }


      System.out.println(userService.getUserByCarData("Toyota", 4));


      context.close();
   }
}
