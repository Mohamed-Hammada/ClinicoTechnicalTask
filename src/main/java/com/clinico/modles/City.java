package com.clinico.modles;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Data
@Entity
@Table(name="city")
public class City implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true, nullable=false)
    private Integer id;

    @Column(nullable=false)
    private String district;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Integer population;

    @ManyToOne
    @JoinColumn(name="country_code", nullable=false)
    private Country country;

    @OneToMany(mappedBy="city")
    private List<Country> countries;

    public Country addCountry(Country country) {
        getCountries().add(country);
        country.setCity(this);

        return country;
    }

    public Country removeCountry(Country country) {
        getCountries().remove(country);
        country.setCity(null);

        return country;
    }

}