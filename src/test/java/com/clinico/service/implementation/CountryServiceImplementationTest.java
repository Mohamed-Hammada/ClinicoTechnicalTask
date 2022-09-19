package com.clinico.service.implementation;

import com.clinico.dto.CountryInformation;
import com.clinico.exception.InvalidValue;
import com.clinico.modles.Country;
import com.clinico.modles.CountryLanguage;
import com.clinico.modles.CountryLanguagePK;
import com.clinico.repositories.CountryRepository;
import com.clinico.util.GeneralUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;


@SpringBootTest
class CountryServiceImplementationTest {
    @Autowired
    private CountryServiceImplementation countryServiceImplementation;
    @MockBean
    private CountryRepository countryRepository;
    @Autowired
    private GeneralUtils generalUtils;


    private final String countryName="Bahrain";
    private final String continent="Asia";
    private final int population=617000;
    private final Float lifeExpectancy=73f;
    private final String ARABIC="Arabic";
    private final String countryCode_BHR="BHR";
    private final String countryCode_InvalidValue="123";
    private final String english="English";

    @Test
    void getCountryInformation_success() {

        CountryInformation expected=buildCountryInformationResponse();

        when(countryRepository.findByCode(countryCode_BHR)).thenReturn(Optional.of(getCountry()));

        CountryInformation actual=countryServiceImplementation.getCountryInformation(countryCode_BHR);

        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);

    }

    @Test
    void getCountryInformation_InvalidValue() {
        // given
        when(countryRepository.findByCode(countryCode_InvalidValue)).thenReturn(Optional.empty());
        // when
        assertThrows(InvalidValue.class,
                ()->{
                    countryServiceImplementation.getCountryInformation(countryCode_InvalidValue);
                });
    }

    private Country getCountry() {
        CountryLanguagePK countryLanguagePK_Arabic=buildCountryLanguagePK(ARABIC);
        CountryLanguagePK countryLanguagePK_English=buildCountryLanguagePK(english);
        List<CountryLanguage> countryLanguageList=getCountryLanguageList(countryLanguagePK_Arabic, countryLanguagePK_English);
        return Country.builder().name(countryName).continent(continent).population(population).lifeExpectancy(lifeExpectancy).countryLanguages(countryLanguageList).build();
    }

    private List<CountryLanguage> getCountryLanguageList(CountryLanguagePK countryLanguagePK_Arabic, CountryLanguagePK countryLanguagePK_English) {
        return List.of(CountryLanguage.builder().id(countryLanguagePK_Arabic).isOfficial(true).build(), CountryLanguage.builder().id(countryLanguagePK_English).isOfficial(false).build());
    }

    private CountryLanguagePK buildCountryLanguagePK(String ARABIC) {
        return CountryLanguagePK.builder().countryCode(countryCode_BHR).language(ARABIC).build();
    }

    private CountryInformation buildCountryInformationResponse() {
        return CountryInformation.builder().name(countryName).continent(continent).population(population).lifeExpectancy(generalUtils.getNumber(lifeExpectancy)).countryLanguage(ARABIC).build();
    }
}