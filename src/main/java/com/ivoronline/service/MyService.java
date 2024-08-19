package com.ivoronline.service;

import com.ivoronline.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private DataSource dataSource;

  //=========================================================================================================
  // SELECT RECORD
  //=========================================================================================================
  public PersonDTO selectRecord(Integer id, Integer age) throws SQLException {

    //GET DB CONNECTION
    Connection connection = dataSource.getConnection();

    //INSERT RECORDS (Use single quotes for Strings)
    String    sql       = " SELECT * FROM PERSON WHERE ID = "+id+" AND AGE = "+age;
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    //GET RECORD
    resultSet.next();
    PersonDTO personDTO = new PersonDTO(
      resultSet.getInt   ("id"  ),
      resultSet.getString("name"),
      resultSet.getInt   ("age" )
    );

    //RETURN RECORD
    return personDTO;

  }

  //=========================================================================================================
  // SELECT RECORDS
  //=========================================================================================================
  public List<PersonDTO> selectRecords(Integer id, Integer age) throws SQLException {

    //GET DB CONNECTION
    Connection connection = dataSource.getConnection();

    //INSERT RECORDS (Use single quotes for Strings)
    String    sql       = " SELECT * FROM PERSON WHERE ID > "+id+" AND AGE > "+age;
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    //RETURN RECORDS
    List<PersonDTO> dtoList = new ArrayList<>();
    while(resultSet.next()) {
      PersonDTO personDTO = new PersonDTO(
        resultSet.getInt   ("id"  ),
        resultSet.getString("name"),
        resultSet.getInt   ("age" )
      );
      dtoList.add(personDTO);
    }

    //RETURN SUCCESS
    return dtoList;

  }

  //=========================================================================================================
  // SELECT WITHOUT PARAMETERS
  //=========================================================================================================
  public List<PersonDTO> selectWithoutParameters() throws SQLException {

    //GET DB CONNECTION
    Connection connection = dataSource.getConnection();

    //INSERT RECORDS (Use single quotes for Strings)
    String    sql       = " SELECT * FROM PERSON WHERE ID > 1 AND AGE > 10";
    Statement statement = connection.createStatement();
    ResultSet resultSet = statement.executeQuery(sql);

    //RETURN RECORDS
    List<PersonDTO> dtoList = new ArrayList<>();
    while(resultSet.next()) {
      PersonDTO personDTO = new PersonDTO(
        resultSet.getInt   ("id"  ),
        resultSet.getString("name"),
        resultSet.getInt   ("age" )
      );
      dtoList.add(personDTO);
    }

    //RETURN SUCCESS
    return dtoList;

  }

}
