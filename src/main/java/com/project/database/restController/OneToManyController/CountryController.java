package com.project.database.restController.OneToManyController;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.database.entity.OneToManyExample.Country;
import com.project.database.entity.OneToManyExample.Region;
import com.project.database.service.impl.OneToMany.CountryServiceImpl;

@RestController
@RequestMapping("/one-to-many")
public class CountryController {

    @Autowired
    CountryServiceImpl countryServiceImpl;

    @GetMapping("/country")
    public ResponseEntity<List<Country>> getAllCountry() {
        return new ResponseEntity<List<Country>>(countryServiceImpl.getList(), HttpStatus.OK);
    }

    @GetMapping("/country/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable Integer id) {
        Country country = countryServiceImpl.getById(id);
        return new ResponseEntity<Country>(country, HttpStatus.OK);
    }

    @GetMapping("/country/{id}/region")
    public ResponseEntity<Set<Region>> getRegionByCountryId(@PathVariable Integer id) {
        Country country = countryServiceImpl.getById(id);
        Set<Region> regions = null;
        if (country != null) {
            regions = country.getRegions();
        }

        return new ResponseEntity<Set<Region>>(regions, HttpStatus.OK);
    }
}
