package com.clinico.modles;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name="country_language")
public class CountryLanguage implements Serializable {
    private static final long serialVersionUID=1L;

    @EmbeddedId
    private CountryLanguagePK id;

    @Column(name="is_official", nullable=false)
    private Boolean isOfficial;

    @Column(nullable=false)
    private float percentage;

    @ManyToOne
    @JoinColumn(name="country_code", nullable=false, insertable=false, updatable=false)
    private Country country;

}