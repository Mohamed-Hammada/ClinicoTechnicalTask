package com.clinico.dto;

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
    private Object lifeExpectancy;
    private String countryLanguage;
}
