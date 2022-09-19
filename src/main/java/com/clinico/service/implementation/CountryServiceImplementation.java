package com.clinico.service.implementation;

import com.clinico.dto.CountryInformation;
import com.clinico.modles.Country;
import com.clinico.modles.CountryLanguage;
import com.clinico.repositories.CountryRepository;
import com.clinico.service.CountryService;
import com.clinico.util.GeneralUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CountryServiceImplementation implements CountryService {
    private final CountryRepository countryRepository;
    private final GeneralUtils generalUtils;

    @Override
    public CountryInformation getCountryInformation(String code) {
        Optional<Country> country=countryRepository.findByCode(code);
        if (country.isPresent())
            return CountryInformation.builder()
                    .population(country.get().getPopulation())
                    .continent(country.get().getContinent())
                    .lifeExpectancy(generalUtils.getNumber(country.get().getLifeExpectancy()))
                    .name(country.get().getName())
                    .countryLanguage(getCountryOfficialLanguage(country.get()))
                    .build();
        throw new RuntimeException();
    }

    private String getCountryOfficialLanguage(Country country) {
        Optional<CountryLanguage> first=country.getCountryLanguages().stream().filter(e->e.getIsOfficial()).findFirst();
        if (first.isEmpty())
            return null;
        return first.get().getId().getLanguage();
    }
}
