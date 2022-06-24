package org.brightly.springbootapp.repositories;

import org.brightly.springbootapp.entities.Company;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@ConditionalOnProperty(prefix = "db", name = "isEnabled", havingValue = "true")
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select c from Company c where c.id = ?1")
    public Company getCompanyById(Long id);
}