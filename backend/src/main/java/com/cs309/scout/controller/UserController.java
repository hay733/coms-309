package com.cs309.scout.controller;

import com.cs309.scout.entity.Location;
import com.cs309.scout.entity.User;
import com.cs309.scout.repository.UserRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;

import java.util.List;

/**
 * The User Controller class for User Entity
 */
@Api(value = "UserController", description = "REST APIs related to the User Entity")
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    /**
     * Returns only one User based on User ID
     * @param id The ID of the User wanted
     * @return User Object with ID id
     */
    @ApiOperation(value = "Gets a User Object", response = User.class)
    @GetMapping("/user/{id}")
    User GetOneUser(@PathVariable("id") int id){ return userRepository.findById(id); }


    /**
     * Returns all User Objects in a list
     * @return All User Objects
     */
    @ApiOperation(value = "Get List of Users", response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 401, message = "Not Authorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found") })
    @GetMapping("/user/all")
    List<User> GetAllUsers(){ return userRepository.findAll(); }


    /**
     * Creates a new User Object in the system
     * @param user The details of new User
     * @return A string that says if creation of User Object was successful or not
     */
    @ApiOperation(value = "Creates a User Object", response = User.class)
    @PostMapping("/user/create")
    User createUser(@RequestBody User user){ //might need to individually add the params
        if (user == null || findByEmail(user.getEmail()) != null)
            return null;

        user.setFirst_name(user.getFirst_name());
        user.setLast_name(user.getLast_name());
        user.setEmail(user.getEmail());
        user.setPassword(passwordEncryption(user.getPassword()));

        userRepository.save(user);
        return user;
    }


    /**
     * Updates an individual User Object based on its attributes
     * @param id Requested User ID that user wants to update
     * @param request The new details of updated User
     * @return Returns the newly updated User Object
     */
    @ApiOperation(value = "Updates a User Object", response = User.class)
    @PutMapping("/user/update/{id}")
    User updateUser(@PathVariable int id, @RequestBody User request){
        User user = userRepository.findById(id);
        if(user == null)
            return null;

        userRepository.save(request);
        return userRepository.findById(id);
    }


    /**
     * Deletes a specific User Object from the system
     * @param id User ID of User Object wanting to delete
     * @return A string that says whether or not deletion of User is successful
     */
    @ApiOperation(value = "Deletes a User Object", response = User.class)
    @DeleteMapping("/user/delete/{id}")
    String deleteUser(@PathVariable int id){
        userRepository.deleteById(id);
        return "Deleted successfully.";
    }


    /**
     * Returns a User corresponding to the email given
     * @param email Email of the User
     * @return User if email exists or null if not
     */
    @ApiOperation(value = "Finds User based off Email", response = User.class)
    @GetMapping("/user/email")
    User findByEmail(@RequestParam String email) {
        User user = userRepository.findByEmail(email);
        if (user == null)
            return null;

        return userRepository.findByEmail(email);
    }


    /**
     * Encrypts the User's plain_text password into a hash
     * @param plain_text User's password
     * @return Hashed password if successful, plain_text password if not
     */
    String passwordEncryption(String plain_text) {
        try {
            MessageDigest m = MessageDigest.getInstance("MD5");
            m.update(plain_text.getBytes());

            //convert hash value into bytes
            byte[] bytes = m.digest();
            StringBuilder s = new StringBuilder();

            //Converting into hexadecimal
            for(int i = 0; i < bytes.length; i++) {
                s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }

            //hashed password
            return s.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return plain_text;
    }


    /**
     * Checks Login Credentials
     * @param email Email Input
     * @param password Password Input
     * @return True if login credentials are correct, otherwise false
     */
    @ApiOperation(value = "Checks Login credentials", response = User.class)
    @GetMapping("/user/login")
    User checkLoginCredentials(String email, String password) {
        User user = findByEmail(email);
        if (passwordEncryption(password).equals(user.getPassword()))
            return user;

        return null;
    }
}
