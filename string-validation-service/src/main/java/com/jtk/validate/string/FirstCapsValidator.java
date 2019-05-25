package com.jtk.validate.string;

import com.jtk.service.api.ValidationService;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class FirstCapsValidator implements ValidationService<String> {
    Pattern p = Pattern.compile("[A-Z]");
    @Override
    public boolean validate(String s) {
        if(s != null ){
            Matcher m = p.matcher(s.substring(0, 1));
            if(m.find()){
                return TRUE;
            }
        }
        return FALSE;
    }

    @Override
    public boolean isSupportedType(Object s) {
        if (s instanceof String)
            return TRUE;
        return FALSE;
    }
}
