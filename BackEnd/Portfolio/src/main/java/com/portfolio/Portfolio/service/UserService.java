/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfolio.Portfolio.service;


import com.portfolio.Portfolio.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.portfolio.Portfolio.Repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author eemoran
 */
@Service
public class UserService implements IUserService{
    
    @Autowired
    public UserRepository userRepo;

    @Override
    public User buscarUser(Long id) {
          return userRepo.findById(id).orElse(null);
    }
    
   
}
