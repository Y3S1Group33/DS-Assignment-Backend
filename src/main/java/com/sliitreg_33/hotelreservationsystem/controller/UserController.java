package com.sliitreg_33.hotelreservationsystem.controller;

import com.sliitreg_33.hotelreservationsystem.model.Users;
import com.sliitreg_33.hotelreservationsystem.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {

    private UserService _userService;

    public UserController(UserService userService){
        _userService=userService;
    }

    @GetMapping
    public List<Users> getAll(){
        return _userService.getAllUsers();
    }

    @GetMapping("/getByUserName")
    public ResponseEntity<Users> getById(@RequestParam(name="id") int id){
        return new ResponseEntity<Users>(_userService.getUsersById(id), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Users> createReservationsRecord(@RequestBody Users users){
        return new ResponseEntity<Users>(_userService.createUser(users), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<Users> updateReservationsRecord(@RequestParam(name="id") int id,@RequestBody Users users){
        return new ResponseEntity<Users>(_userService.updateUsers(users,id), HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<String> deleteReservationsRecord(@RequestParam(name="id") int id){
        _userService.deleteUser(id);
        return new ResponseEntity<>("Record deleted with id: "+id, HttpStatus.OK);
    }
}
