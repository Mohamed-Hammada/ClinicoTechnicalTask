package com.clinico.controller;

import com.clinico.dto.CountryInformation;
import com.clinico.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class CountryController {
    private final CountryService countryService;

    @GetMapping("/{code}")
    public CountryInformation getCountryInformation(@PathVariable("code") String code) {
        return countryService.getCountryInformation(code);
    }
}
