package com.project.database.service.impl.OneToMany;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.database.dao.Impl.CountryDaoJPAImpl;
import com.project.database.entity.OneToManyExample.Country;
import com.project.database.service.CRUDService;

@Service
@Transactional ("transactionManager")
public class CountryServiceImpl implements CRUDService<Country> {

    @Autowired
    CountryDaoJPAImpl countryDaoJPAImpl;

    @Override
    public void add(Country instance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    @Override
    public void update(Country instance) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateUser'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteUser'");
    }

    @Override
    public Country getById(int id) {
        return countryDaoJPAImpl.getById(id);
    }

    @Override
    public List<Country> getList() {
        return countryDaoJPAImpl.getList();
    }

    
}
