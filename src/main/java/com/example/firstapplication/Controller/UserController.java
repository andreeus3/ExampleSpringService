package com.example.firstapplication.Controller;

import com.example.firstapplication.dto.CreateUserDTO;
import com.example.firstapplication.dto.UserDTO;
import com.example.firstapplication.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController( UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findByID(@PathVariable("id") Long ID){
        Optional<UserDTO> user = userService.findByID(ID);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<UserDTO> createUserDTO (@RequestBody CreateUserDTO createUserDTO){
        UserDTO userDTO = userService.saveUser(createUserDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(userDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteByID(@PathVariable("id") Long ID){
        userService.deleteByID(ID);
        return ResponseEntity.noContent().build();
    }
}
