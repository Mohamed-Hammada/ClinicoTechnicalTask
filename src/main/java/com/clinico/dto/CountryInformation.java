package com.clinico.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CountryInformation {

    private String name;
    private String continent;
    private Integer population;
    @JsonProperty("life_expectancy")
    private Object lifeExpectancy;
    @JsonProperty("country_language")
    private String countryLanguage;
}
