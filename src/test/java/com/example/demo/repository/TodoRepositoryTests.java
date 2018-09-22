package com.example.demo.repository;

import com.example.demo.config.MyJdbcConfiguration;
import com.example.demo.domain.Todo;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJdbcTest
@Import({MyJdbcConfiguration.class})
public class TodoRepositoryTests {

  @Autowired
  private TodoRepository todoRepository;

  @Test
  public void saveAndFindById() {
    Todo newTodo = new Todo();
    newTodo.setTitle("飲み会");
    newTodo.setDetails("銀座 19:00");
    todoRepository.save(newTodo);

    Optional<Todo> todo = todoRepository.findById(newTodo.getId());
    Assertions.assertThat(todo.isPresent()).isTrue();
    Assertions.assertThat(todo.get().getId()).isEqualTo(newTodo.getId());
    Assertions.assertThat(todo.get().getTitle()).isEqualTo(newTodo.getTitle());
    Assertions.assertThat(todo.get().getDetails()).isEqualTo(newTodo.getDetails());
    Assertions.assertThat(todo.get().isFinished()).isFalse();
  }

}
