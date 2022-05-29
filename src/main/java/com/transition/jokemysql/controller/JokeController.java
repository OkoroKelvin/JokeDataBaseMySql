package com.transition.jokemysql.controller;


import com.transition.jokemysql.data.inputDto.JokeInputDto;
import com.transition.jokemysql.data.model.Joke;
import com.transition.jokemysql.data.outputDto.JokeCompositeResponseDto;
import com.transition.jokemysql.data.outputDto.JokeResponseDto;
import com.transition.jokemysql.data.repository.JokeRepository;
import com.transition.jokemysql.service.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3001/")
@RestController
@RequestMapping("/api/v1/")
public class JokeController {
    @Autowired
    private JokeRepository jokeRepository;

    @Autowired
    private JokeService jokeService;


    @GetMapping("/jokes")
    public JokeCompositeResponseDto getAllJokes(){
        return jokeService.findAllJokesWithItsComment();
    }

    @GetMapping("/joke")
    public List<Joke> getAllJoke(){
        return jokeRepository.findAll();
    }

    @PostMapping("/jokes")
    public JokeResponseDto createJoke(@RequestBody JokeInputDto jokeInputDto)  {
        return jokeService.saveJoke(jokeInputDto);
    }

//    @GetMapping("/jokes/{id}")
//    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//        return ResponseEntity.ok(employee);
//    }

//    @PutMapping("/employees/{id}")
//    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails){
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//        employee.setFirstName(employeeDetails.getFirstName());
//        employee.setLastName(employeeDetails.getLastName());
//        employee.setEmailId(employeeDetails.getEmailId());
//
//        Employee updatedEmployee = employeeRepository.save(employee);
//        return ResponseEntity.ok(updatedEmployee);
//    }

//    @DeleteMapping("/employees/{id}")
//    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long id){
//        Employee employee = employeeRepository.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
//
//        employeeRepository.delete(employee);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return ResponseEntity.ok(response);
//    }
}
