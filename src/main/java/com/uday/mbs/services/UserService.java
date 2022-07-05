package com.uday.mbs.services;

import com.uday.mbs.entities.User;
import com.uday.mbs.exceptions.UserDetailsNotFoundException;
import com.uday.mbs.exceptions.UserNameAlreadyExistsException;
import com.uday.mbs.exceptions.UserTypeDetailsNotFoundException;

public interface UserService {
    public User acceptUserDetails(User user)
            throws UserNameAlreadyExistsException, UserTypeDetailsNotFoundException;

    public User getUserDetails(int id) throws UserDetailsNotFoundException;

    public User getUserDetailsByUsername(String username) throws UserDetailsNotFoundException;

    public User updateUserDetails(int id, User user)
            throws UserNameAlreadyExistsException, UserDetailsNotFoundException, UserTypeDetailsNotFoundException;
}
