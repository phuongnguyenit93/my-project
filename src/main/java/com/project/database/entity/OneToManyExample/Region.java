package com.project.database.entity.OneToManyExample;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "region")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "region_id")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int region_id;
    
    @Column(name = "region_code", unique = true)
    private String regionCode;
    
    @Column(name = "region_name")
    private String regionName;
    
    @ManyToOne
    @JoinColumn(name="country_id")
    @JsonBackReference
    private Country country;
}
