package com.mikko.jdbcrest;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mikko.jdbcrest.jdbc.DegreeRepository;

@RestController
public class RestApplication {

    private static final Logger log = Logger.getLogger(RestApplication.class);

    @Autowired
    DataSource dataSource;
    
    @Autowired
    DegreeRepository repository;
    
    @RequestMapping("/addDegree")
    public void addDegree(@RequestParam(value = "degree") double value) {
    	
    	System.out.println("value: " + value);
    	repository.addDegree(value);
    	
    }
}
