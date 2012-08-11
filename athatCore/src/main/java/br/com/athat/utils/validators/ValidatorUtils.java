package br.com.athat.utils.validators;

public class ValidatorUtils {

    public static String getDigitsOnly(Object value) {
        return value == null ? "" : value.toString().replaceAll("[^0-9]", "");
    }
    
    public static boolean isNotEmptyAndNotNull(String value){
    	return  value != null && !value.trim().isEmpty() ? true : false;
    }
}
