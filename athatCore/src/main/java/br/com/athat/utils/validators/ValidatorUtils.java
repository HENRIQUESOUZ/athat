package br.com.athat.utils.validators;

import java.util.List;

public class ValidatorUtils {

    public static String getDigitsOnly(Object value) {
        return value == null ? "" : value.toString().replaceAll("[^0-9]", "");
    }
    
    public static boolean isNotEmptyAndNotNull(String value){
    	return  value != null && !value.trim().isEmpty() ? true : false;
    }
    
    public static boolean isNotEmptyAndNotNull(List value){
    	return  value != null && !value.isEmpty() ? true : false;
    }
    
    public static Long convertStringToLong(String value){
    	return value != null && !value.isEmpty() ? Long.valueOf(value) : null;
    }
}
