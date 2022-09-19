package com.clinico.modles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;


@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="country")
public class Country implements Serializable {
    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(unique=true, nullable=false, length=3)
    private String code;

    @Column(nullable=false, length=2)
    private String code2;

    @Column(nullable=false)
    private String continent;

    @Column(precision=10, scale=2)
    private BigDecimal gnp;

    @Column(name="gnp_old", precision=10, scale=2)
    private BigDecimal gnpOld;

    @Column(name="government_form", nullable=false)
    private String governmentForm;

    @Column(name="head_of_state")
    private String headOfState;

    @Column(name="indep_year")
    private Integer indepYear;

    @Column(name="life_expectancy")
    private Float lifeExpectancy;

    @Column(name="local_name", nullable=false)
    private String localName;

    @Column(nullable=false)
    private String name;

    @Column(nullable=false)
    private Integer population;

    @Column(nullable=false)
    private String region;

    @Column(name="surface_area", nullable=false)
    private Float surfaceArea;

    @OneToMany(mappedBy="country")
    private List<City> cities;

    @ManyToOne
    @JoinColumn(name="capital")
    private City city;

    @OneToMany(mappedBy="country")
    private List<CountryLanguage> countryLanguages;

    public City addCity(City city) {
        getCities().add(city);
        city.setCountry(this);

        return city;
    }

    public City removeCity(City city) {
        getCities().remove(city);
        city.setCountry(null);

        return city;
    }

    public CountryLanguage addCountryLanguage(CountryLanguage countryLanguage) {
        getCountryLanguages().add(countryLanguage);
        countryLanguage.setCountry(this);

        return countryLanguage;
    }

    public CountryLanguage removeCountryLanguage(CountryLanguage countryLanguage) {
        getCountryLanguages().remove(countryLanguage);
        countryLanguage.setCountry(null);

        return countryLanguage;
    }

}