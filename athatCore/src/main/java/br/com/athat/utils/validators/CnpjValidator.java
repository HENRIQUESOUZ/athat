package br.com.athat.utils.validators;


public class CnpjValidator {

    private static int[] multiplicadoresPrimeiroDigito = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
    private static int[] multiplicadoresSegundoDigito = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public static boolean isValid(Object value) {

        String s = null;
        if (value == null) {
            return false;
        } else if (value instanceof Number) {
            long longValue = ((Number) value).longValue();
            s = String.format("%014d", longValue);
        } else {
            s = ValidatorUtils.getDigitsOnly(value.toString());
        }
        if (s.matches("\\d{14}")) {
            char[] numbers = s.toCharArray();
            int soma = 0;

            for (int i = 0; i < multiplicadoresPrimeiroDigito.length; i++) {
                soma += Character.digit(numbers[i], 10) * multiplicadoresPrimeiroDigito[i];
            }

            int resto = soma % 11;
            if (resto < 2) {
                if (Character.digit(numbers[12], 10) != 0) {
                    return false;
                }
            } else {
                if (Character.digit(numbers[12], 10) != 11 - resto) {
                    return false;
                }
            }

            soma = 0;
            for (int i = 0; i < multiplicadoresSegundoDigito.length; i++) {
                soma += Character.digit(numbers[i], 10) * multiplicadoresSegundoDigito[i];
            }

            resto = soma % 11;
            if (resto < 2) {
                if (Character.digit(numbers[13], 10) != 0) {
                    return false;
                }
            } else {
                if (Character.digit(numbers[13], 10) != 11 - resto) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
