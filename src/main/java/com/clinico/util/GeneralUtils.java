package com.clinico.util;

import org.springframework.stereotype.Service;

@Service
public class GeneralUtils {

    public Object getNumber(Float f) {
        if (f == null)
            return null;
        if (f % 1 == 0)
            return Math.round(f);
        return f;
    }
}
