package br.com.athat.utils.validators;

public class CpfCnpjValidator {

    public static boolean isValid(String value) {
        return CpfValidator.isValid(value) || CnpjValidator.isValid(value);
    }

}
