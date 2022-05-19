package com.sliitreg_33.hotelreservationsystem.service.impl;

import com.sliitreg_33.hotelreservationsystem.exception.ResourceNotFoundException;
import com.sliitreg_33.hotelreservationsystem.model.Users;
import com.sliitreg_33.hotelreservationsystem.repository.UsersRepository;
import com.sliitreg_33.hotelreservationsystem.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserImpl implements UserService {

    private UsersRepository _usersRepository;
    public UserImpl(UsersRepository usersRepository) {
        _usersRepository = usersRepository;
    }


    @Override
    public Users createUser(Users users) {
        return _usersRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return _usersRepository.findAll();
    }

    @Override
    public Users getUsersById(int id) {
        return _usersRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User not found"));
    }

    @Override
    public Users updateUsers(Users user, int id) {
        Users updateUser = _usersRepository.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("User not found"));

        updateUser.setFirstName(user.getFirstName());
        updateUser.setLastName(user.getLastName());
        updateUser.setEmail(user.getEmail());
        updateUser.setRole(user.getRole());
        updateUser.setPassword(user.getPassword());

        return updateUser;
    }

    @Override
    public void deleteUser(Integer id) {
        _usersRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("User not found"));
        _usersRepository.deleteById(id);
    }
}
