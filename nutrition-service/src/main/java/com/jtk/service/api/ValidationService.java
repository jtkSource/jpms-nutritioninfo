package com.jtk.service.api;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public interface ValidationService<T> {
    boolean validate(T t);

    boolean isSupportedType(Object t);

    public static List<ValidationService> getValidators(Object item) {
        List<ValidationService> validationServiceList = new ArrayList<>();
        Iterable<ValidationService> validationServices = ServiceLoader.load(ValidationService.class);
        for (ValidationService s : validationServices) {
            if (s.isSupportedType(item))
                validationServiceList.add(s);
        }
        return validationServiceList;
    }
}
