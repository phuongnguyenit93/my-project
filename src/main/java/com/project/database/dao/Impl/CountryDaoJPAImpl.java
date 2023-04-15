package com.project.database.dao.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.project.database.dao.CRUDMethod;
import com.project.database.dao.CountryDaoJPA;
import com.project.database.entity.OneToManyExample.Country;

@Repository
@Transactional("transactionManager")
public class CountryDaoJPAImpl implements CRUDMethod<Country>{
    @Autowired
    @Lazy
    CountryDaoJPA countryDaoJPA;

    @Override
    public void add(Country instance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Country instance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Country getById(int id) {
        if (countryDaoJPA.findById(id).isPresent()) 
        return countryDaoJPA.findById(id).get();
    else return null;
    }

    @Override
    public List<Country> getList() {
        return countryDaoJPA.findAll();
    }


}
