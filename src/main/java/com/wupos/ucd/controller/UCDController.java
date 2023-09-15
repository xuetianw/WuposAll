package com.wupos.ucd.controller;

import com.wupos.ucd.entity.Compliance;
import com.wupos.ucd.entity.Customer;
import com.wupos.ucd.service.ComplianceServiceImpl;
import com.wupos.ucd.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UCDController {
    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private ComplianceServiceImpl complianceService;

    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello, World!";
    }

    @RequestMapping(value = "/addOrUpdateUser", method = { RequestMethod.POST, RequestMethod.PUT })
    public ResponseEntity<?> addUser(@RequestBody Customer customer) {
        try {
            long pcp = userService.addOrUpdateUser(customer);
            if (pcp == 0) {
                return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
            } else {
                return new ResponseEntity<>(new CustomResponse.UserResponse(pcp, "Successfully created"),
                        HttpStatus.CREATED);
            }

        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>("Failure: " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/getUser/{pcp}")
    public ResponseEntity<?> getUser(@PathVariable String pcp) {
        try {
            Customer user = userService.getUser(pcp);
            if (user != null) {
                return new ResponseEntity<>(user, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>("Error retrieving user", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getCompliance/{pcp}")
    public ResponseEntity<?> getCompliance(@PathVariable String pcp) {
        try {
            Compliance compliance = complianceService.getCompliance(pcp);
            if (compliance != null) {
                return new ResponseEntity<>(compliance, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("User compliance not found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            System.err.println(e);
            return new ResponseEntity<>("Error retrieving compliance details", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
