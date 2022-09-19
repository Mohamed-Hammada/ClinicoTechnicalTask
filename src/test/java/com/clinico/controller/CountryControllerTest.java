package com.clinico.controller;

import com.clinico.dto.CountryInformation;
import com.clinico.dto.EmptyJsonBody;
import com.clinico.modles.Country;
import com.clinico.modles.CountryLanguage;
import com.clinico.modles.CountryLanguagePK;
import com.clinico.repositories.CountryRepository;
import com.clinico.util.AbstractTest;
import com.clinico.util.GeneralUtils;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class CountryControllerTest extends AbstractTest {
    private final String countryCode_BHR="BHR";
    private final String countryCode_InvalidValue="123";

    @Override
    @BeforeAll
    public void setUp() {
        super.setUp();
    }

    @Test
    void getCountryInformationApi_Success() throws Exception {
        String uri = "/" + countryCode_BHR;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.OK.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        CountryInformation actual = super.mapFromJson(content, CountryInformation.class);
        assertTrue(actual != null);
    }

    @Test
    void getCountryInformationApi_InvalidValue() throws Exception {
        String uri = "/" + countryCode_InvalidValue;
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(HttpStatus.NOT_FOUND.value(), status);
        String content = mvcResult.getResponse().getContentAsString();
        EmptyJsonBody actual = super.mapFromJson(content, EmptyJsonBody.class);
        assertTrue(actual != null);
    }

}