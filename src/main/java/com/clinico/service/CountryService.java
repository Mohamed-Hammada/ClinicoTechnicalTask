package com.clinico.service;

import com.clinico.dto.CountryInformation;

public interface CountryService {
    CountryInformation getCountryInformation(String code);
}
