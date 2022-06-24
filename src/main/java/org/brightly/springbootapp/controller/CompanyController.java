package org.brightly.springbootapp.controller;

import org.brightly.springbootapp.dtos.CompanyDto;
import org.brightly.springbootapp.services.CompanyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company")
@ConditionalOnProperty(prefix = "db", name = "isEnabled", havingValue = "true")
public class CompanyController {

    Logger logger = LoggerFactory.getLogger(CompanyController.class);

    @Autowired
    CompanyService companyService;

    @PostMapping("/create")
    public ResponseEntity<Long> create(@RequestBody final CompanyDto companyDto) {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.createCompany(companyDto));
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<CompanyDto> getCompanyById(@PathVariable Long id) {
        logger.info("CompanyController getCompanyById: {}", id);
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findCompany(id));
    }

    @GetMapping("/all")
    public ResponseEntity<List<CompanyDto>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(companyService.findAll());
    }
}

