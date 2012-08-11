package br.com.athat.utils.validators;

import java.util.HashSet;
import java.util.Set;

public class CpfValidator {

    private static Set<String> invalidValues = new HashSet<String>();

    static {
        invalidValues.add("00000000000");
        invalidValues.add("11111111111");
        invalidValues.add("22222222222");
        invalidValues.add("33333333333");
        invalidValues.add("44444444444");
        invalidValues.add("55555555555");
        invalidValues.add("66666666666");
        invalidValues.add("77777777777");
        invalidValues.add("88888888888");
        invalidValues.add("99999999999");
    }

    public static boolean isValid(Object value) {
        String s = null;
        if (value == null) {
            return false;
        } else if (value instanceof Number) {
            long longValue = ((Number) value).longValue();
            s = String.format("%011d", longValue);
        } else {
            s = ValidatorUtils.getDigitsOnly(value.toString());
        }

        if (s.matches("\\d{11}") && !invalidValues.contains(s)) {
            char[] numbers = s.toCharArray();
            int soma = 0;

            for (int i = 0; i < 9; i++) {
                soma += Character.digit(numbers[i], 10) * (10 - i);
            }

            int resto = soma % 11;
            if (resto < 2) {
                if (Character.digit(numbers[9], 10) != 0) {
                    return false;
                }
            } else {
                if (Character.digit(numbers[9], 10) != 11 - resto) {
                    return false;
                }
            }

            soma = 0;
            for (int i = 0; i < 10; i++) {
                soma += Character.digit(numbers[i], 10) * (11 - i);
            }

            resto = soma % 11;
            if (resto < 2) {
                if (Character.digit(numbers[10], 10) != 0) {
                    return false;
                }
            } else {
                if (Character.digit(numbers[10], 10) != 11 - resto) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}