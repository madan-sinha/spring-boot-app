package org.brightly.springbootapp.services;

import org.brightly.springbootapp.dtos.CompanyDto;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

import java.util.List;

//@ConditionalOnProperty(prefix = "db", name = "isEnabled", havingValue = "true")
public interface CompanyService {

    public Long createCompany(CompanyDto companyDto);

    public CompanyDto findCompany(Long id);

    public List<CompanyDto> findAll();
}
