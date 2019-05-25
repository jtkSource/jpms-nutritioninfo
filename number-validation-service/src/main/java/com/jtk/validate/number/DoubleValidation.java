package com.jtk.validate.number;

import com.jtk.service.api.ValidationService;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class DoubleValidation implements ValidationService<Number> {
    @Override
    public boolean validate(Number value) {
        if(value instanceof Double){
            return TRUE;
        }
        return FALSE;
    }

    @Override
    public boolean isSupportedType(Object t) {
        if(t instanceof Number)
            return TRUE;
        return FALSE;
    }
}
