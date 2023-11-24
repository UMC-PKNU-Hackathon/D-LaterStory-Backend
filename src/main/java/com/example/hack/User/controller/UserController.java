package com.example.hack.User.controller;

import com.example.hack.User.UserServcie;
import com.example.hack.User.dto.UserRequestDto;
import com.example.hack.User.dto.UserResponseDto;
import com.example.hack.User.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Validated
@AllArgsConstructor
public class UserController {

    private final UserServcie userServcie;


    @PostMapping
    public ResponseEntity postUsers(@RequestBody UserRequestDto.Post user){
        User response= userServcie.createUser(user);
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @PatchMapping("/{user-Id}")
    public ResponseEntity PatchUser(@PathVariable("user-Id") String userId,
                                    @RequestBody UserRequestDto.Patch patch){

        User response = userServcie.patchUser(patch,userId);
        return new ResponseEntity<>(response, HttpStatus.OK);


    }

    @GetMapping("/login")
    public ResponseEntity login(@RequestBody UserRequestDto.login user){

        boolean a = userServcie.logincheck(user);
        return new ResponseEntity<>(a, HttpStatus.OK);
    }


   @GetMapping("/get/{user-Id}")
    public ResponseEntity getuser(@PathVariable("user-Id") String userId){
        UserResponseDto.userResponse user = userServcie.getUser(userId);
       return new ResponseEntity<>(user, HttpStatus.OK);

   }








}
