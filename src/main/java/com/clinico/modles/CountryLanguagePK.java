package com.clinico.modles;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class CountryLanguagePK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID=1L;

    @Column(name="country_code", insertable=false, updatable=false, unique=true, nullable=false, length=3)
    private String countryCode;

    @Column(unique=true, nullable=false)
    private String language;


    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CountryLanguagePK)) {
            return false;
        }
        CountryLanguagePK castOther=(CountryLanguagePK) other;
        return
                this.countryCode.equals(castOther.countryCode)
                        && this.language.equals(castOther.language);
    }

    public int hashCode() {
        final int prime=31;
        int hash=17;
        hash=hash * prime + this.countryCode.hashCode();
        hash=hash * prime + this.language.hashCode();

        return hash;
    }
}