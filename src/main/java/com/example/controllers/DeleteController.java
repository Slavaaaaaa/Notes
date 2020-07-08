package com.example.controllers;

import com.example.da.ListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.da.ListRepository;

import javax.rmi.CORBA.Util;

@Controller
public class DeleteController {
    @Autowired
    private ListRepository listRep;
}
