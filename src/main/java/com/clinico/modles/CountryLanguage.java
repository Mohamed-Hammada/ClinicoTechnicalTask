package com.clinico.modles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
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
    private Float percentage;

    @ManyToOne
    @JoinColumn(name="country_code", nullable=false, insertable=false, updatable=false)
    private Country country;

}