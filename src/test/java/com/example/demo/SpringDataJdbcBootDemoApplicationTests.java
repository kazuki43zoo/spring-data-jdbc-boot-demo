package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataJdbcBootDemoApplicationTests {

  @ClassRule
  public static OutputCapture capture = new OutputCapture();

  @Test
  public void contextLoads() {
    Assertions.assertThat(capture.toString()).containsSubsequence(
        "ID       : 1",
        "TITLE    : 飲み会",
        "DETAILS  : 銀座 19:00",
        "FINISHED : false"
    );
  }

}
