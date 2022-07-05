package com.uday.mbs.services.impl;

import com.uday.mbs.dao.UserDao;
import com.uday.mbs.entities.User;
import com.uday.mbs.exceptions.UserDetailsNotFoundException;
import com.uday.mbs.exceptions.UserNameAlreadyExistsException;
import com.uday.mbs.exceptions.UserTypeDetailsNotFoundException;
import com.uday.mbs.services.UserService;
import com.uday.mbs.services.UserTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserTypeService userTypeService;

    @Override
    public User acceptUserDetails(User user) throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException {
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }
        return userDao.save(user);
    }

    @Override
    public User getUserDetails(int id) throws UserDetailsNotFoundException {
        return userDao.findById(id)
                .orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException {
        return userDao.findByUsername(username)
                .orElseThrow(() -> new UserDetailsNotFoundException("Customer not found with username: " + username));
    }

    @Override
    public User updateUserDetails(int id, User user)
            throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException {
        User savedUser = getUserDetails(id);
        if (userDao.findByUsername(user.getUsername()).isPresent()) {
            throw new UserNameAlreadyExistsException("This username is already taken.");
        }

        if (isNotNullOrZero(user.getFirstName())) {
            savedUser.setFirstName(user.getFirstName());
        }

        if (isNotNullOrZero(user.getLastName())) {
            savedUser.setLastName(user.getLastName());
        }

        if (isNotNullOrZero(user.getUsername())) {
            savedUser.setUsername(user.getUsername());
        }

        if (isNotNullOrZero(user.getPassword())) {
            savedUser.setPassword(user.getPassword());
        }


        if (isNotNullOrZero(user.getLanguage())) {
            savedUser.setLanguage(user.getLanguage());
        }

        return userDao.save(savedUser);
    }

    private boolean isNotNullOrZero(Object obj) {
        return obj != null;
    }
}
