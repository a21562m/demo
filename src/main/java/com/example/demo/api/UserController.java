package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.AppUser;
import com.example.demo.exception.NotFoundException;
import com.example.demo.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
    @Autowired
    private UserService userService;

    @ApiOperation(value="getUserList", notes="Get user list.")
    @GetMapping(value = "/users")
    @ResponseStatus(HttpStatus.OK)
    public List<AppUser> getUserList()
    {
        return userService.getUserList();
    }

    @ApiOperation(value="addUser", notes="Add user.")
    @PostMapping(value = "/users")
    @ResponseStatus(HttpStatus.CREATED)
    public Object addUser(@RequestBody AppUser user){
        return userService.addUser(user);
    }

    @ApiOperation(value="getUser", notes="Get user by id.")
    @GetMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Object getUser(@PathVariable("id") String id) throws NotFoundException
    {
        return userService.getUser(id);
    }

    @ApiOperation(value="deleteUser", notes="Detele user by id")
    @DeleteMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("id") String id)
    {
        userService.deleteUser(id);
    }

    @ApiOperation(value="updateUser", notes="Update user.")
    @PatchMapping(value = "/users/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public AppUser updateUser(@PathVariable("id") String id, @RequestBody AppUser user)
    {
        return userService.update(id, user);
    }


    @ApiOperation(value="test")
    @GetMapping(value = "/test")
    @ResponseStatus(HttpStatus.OK)
    public String test()
    {
        return "test ok!";
    }

}
