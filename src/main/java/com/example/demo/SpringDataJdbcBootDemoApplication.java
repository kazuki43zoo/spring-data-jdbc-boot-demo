package com.example.demo;

import com.example.demo.domain.Todo;
import com.example.demo.repository.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Optional;

@SpringBootApplication
public class SpringDataJdbcBootDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringDataJdbcBootDemoApplication.class, args);
  }

  @Bean
  CommandLineRunner demo(TodoRepository todoRepository) {
    return args -> {
      Todo newTodo = new Todo();
      newTodo.setTitle("飲み会");
      newTodo.setDetails("銀座 19:00");
      todoRepository.save(newTodo);

      Optional<Todo> todo = todoRepository.findById(newTodo.getId());
      System.out.println("ID       : " + todo.get().getId());
      System.out.println("TITLE    : " + todo.get().getTitle());
      System.out.println("DETAILS  : " + todo.get().getDetails());
      System.out.println("FINISHED : " + todo.get().isFinished());
    };

  }

}
