package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.data.jdbc.core.convert.JdbcCustomConversions;
import org.springframework.data.jdbc.repository.config.JdbcConfiguration;

import java.sql.Clob;
import java.sql.SQLException;
import java.util.Collections;

@Configuration
public class MyJdbcConfiguration extends JdbcConfiguration {

  @Override
  protected JdbcCustomConversions jdbcCustomConversions() {
    return new JdbcCustomConversions(Collections.singletonList(new Converter<Clob, String>() {
      @Override
      public String convert(Clob clob) {
        try {
          return clob == null ? null : clob.getSubString(1L, (int) clob.length());
        } catch (SQLException e) {
          throw new IllegalStateException(e);
        }
      }
    }));
  }

}
