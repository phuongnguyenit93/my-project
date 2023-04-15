package com.project.database.entity.OneToManyExample;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Formula;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Có 3 phương thức để tránh vòng lặp vô hạn khi render JSON
// 1. Sử dụng @JsonManagedReference và @JsonBackReference : Trong đó class cần render chính (Class OneToMany) sẽ để Managed , class còn lại để Back
// 2. Sử dụng @JsonIdentityInfo . Lần định dang thứ 2 thay vì lấy cả instance thì sẽ chỉ lấy 1 thuộc tính chính làm đại diện : Thông thường là id
// 3. Sử dụng @JsonIgnore : Thay vì render ra, ta bỏ nó luôn
@Entity
@Table(name = "country")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "country_id")
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private int country_id;
	
	@Column(name = "country_code", unique = true)
	private String countryCode;
	
	@Column(name = "country_name")
	private String countryName;
	
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "country", cascade = CascadeType.ALL)
    @JsonManagedReference
	private Set<Region> regions;

    @Formula("country_code")
    private String anotherCode;

    @Transient
    private String anotherName;

    public String getAnotherName() {
        return this.countryName;
    }
}
