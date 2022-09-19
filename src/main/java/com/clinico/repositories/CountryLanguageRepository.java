package com.clinico.repositories;

import com.clinico.modles.CountryLanguage;
import com.clinico.modles.CountryLanguagePK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryLanguageRepository extends JpaRepository<CountryLanguage, CountryLanguagePK> {
}
