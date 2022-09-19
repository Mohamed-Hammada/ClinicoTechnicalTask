package com.clinico.repositories;

import com.clinico.modles.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {
    Optional <Country> findByCode(String code);
}
