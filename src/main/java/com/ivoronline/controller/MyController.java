package com.ivoronline.controller;

import com.ivoronline.dto.PersonDTO;
import com.ivoronline.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.sql.SQLException;
import java.util.List;

@RestController
public class MyController {

  //PROPERTIES
  @Autowired
  private MyService myService;

  //=========================================================================================================
  // SELECT RECORD
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/selectRecord")
  public PersonDTO selectRecord(@RequestParam Integer id, @RequestParam Integer age) throws SQLException {
    PersonDTO personDTO = myService.selectRecord(id, age);
    return personDTO ;
  }

  //=========================================================================================================
  // SELECT RECORDS
  //=========================================================================================================
  @ResponseBody
  @GetMapping("/selectRecords")
  public List<PersonDTO> select(@RequestParam Integer id, @RequestParam Integer age) throws SQLException {
    List<PersonDTO> personDTOList = myService.selectRecords(id, age);
    return personDTOList;
  }

  //=========================================================================================================
  // SELECT WITHOUT PARAMETERS
  //=========================================================================================================
  // Request without Parameters => http://localhost:8080/selectWithoutParameters
  // Returns JSON Array         => [ {"id":2, "name":"Bill", "age":20 }, { "id":3, "name":"Susan", "age":30 } ]
  @ResponseBody
  @GetMapping("/selectWithoutParameters")
  public List<PersonDTO> selectWithoutParameters() throws SQLException {
    List<PersonDTO> personDTOList = myService.selectWithoutParameters();
    return personDTOList;
  }

}
