package com.rbms.rest.controller;

import com.rbms.rest.service.RBMSService;
import com.rbms.rest.model.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class RBMSController {

	//Creating Service Reference
	@Autowired
	private RBMSService rbms_service;
	
	private String DEFAULT_FILE_NAME = "";

	@Autowired
    private ServletContext servletContext;
     
	
	@RequestMapping(value="/createRule", method=RequestMethod.POST)
	public boolean createRule(@RequestBody Rules rule) {
		
		if(rbms_service.marshallList(rule)) {
			return true;
		} else {
			return false;
		}
	}
	
	/*
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public boolean createUser(@RequestBody User user) {
		
		if(rbms_service.createUser(user)) {
			return true;
		} else {
			return false;
		}
	}
	
	*/
}
