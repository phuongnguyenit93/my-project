package com.project.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.database.entity.OneToManyExample.Country;

public interface CountryDaoJPA extends JpaRepository<Country,Integer> {
    
}
