package com.sliitreg_33.hotelreservationsystem.service;

import com.sliitreg_33.hotelreservationsystem.model.Users;

import java.util.List;

public interface UserService {

    //Users
    Users createUser(Users users);

    //get all Users
    List<Users> getAllUsers();

    //get Users by id
    Users getUsersById(int id);

    //update Users
    Users updateUsers(Users user, int id);

    //delete Users
    void deleteUser(Integer id);
}
