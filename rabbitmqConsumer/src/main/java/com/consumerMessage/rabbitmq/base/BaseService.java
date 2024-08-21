package com.consumerMessage.rabbitmq.base;

import java.beans.PropertyDescriptor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public abstract class BaseService {

    public String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        final PropertyDescriptor[] pds = src.getPropertyDescriptors();

        final Set<String> emptyNames = new HashSet<>();
        emptyNames.add("id");
        for (final PropertyDescriptor pd : pds) {
            // check if value of this property is null then add it to the collection
            final Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null || (srcValue instanceof List<?> && ((List<?>) srcValue).size() == 0)) {
                emptyNames.add(pd.getName());
            }
        }
        final String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }
}