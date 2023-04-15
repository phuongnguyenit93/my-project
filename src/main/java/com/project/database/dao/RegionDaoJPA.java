package com.project.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.database.entity.OneToManyExample.Region;

public interface RegionDaoJPA extends JpaRepository<Region,Integer> {
    
}
