package Controllers;

public class ConverterController {
    public static String errorMessage;

    public static boolean isInteger(String value) {
        return !value.contains(".");
    }

    public static String integerConversionToTargetBase(String UserValue, int UserSourceBase, int UserTargetBase) {
        int convertedBase10Value = 0;
        String convertedTargetBaseValue;

        try {
            convertedBase10Value = Integer.parseInt(UserValue, UserSourceBase);
        } catch (NumberFormatException nfe) {
            errorMessage = String.format("Error - Please Give a Valid Value for the given Base\n %s", nfe.getMessage());
        }
        convertedTargetBaseValue = Integer.toString(convertedBase10Value, UserTargetBase);
        return errorMessage == null ? convertedTargetBaseValue : errorMessage;
    }

    public static String decimalConversionHelper(String UserValue, int UserSourceBase, int UserTargetBase) {
        // source base -> base 10
        double resultBase10Converted = 0.0;
        for (int i = 0; i < UserValue.length(); i++) {
            char c = UserValue.charAt(i);
            int digit = Character.digit(c, UserSourceBase);
            resultBase10Converted = resultBase10Converted + digit / Math.pow(UserSourceBase, i + 1);
        }

        // base 10 -> target base ( binary )
        int precision = 5;
        double frac = resultBase10Converted;
        String resultTargetBaseConverted = new String();
        while (frac != 0.0 && precision != 0) {
            frac = frac * UserTargetBase;
            int digit = (int) frac;
            resultTargetBaseConverted = resultTargetBaseConverted + Character.forDigit(digit, UserTargetBase);
            frac = frac - digit;
            precision--;
        }
        return resultTargetBaseConverted;
    }

    public static String decimalConversionToTargetBase(String UserValue, int UserSourceBase, int UserTargetBase) {
        String ValueParts[] = UserValue.split("\\.");
        String integerPart = integerConversionToTargetBase(ValueParts[0], UserSourceBase, UserTargetBase);
        String fracPart = decimalConversionHelper(ValueParts[1], UserSourceBase, UserTargetBase);
        return String.format("%s.%s", integerPart, fracPart);
    }

    public static String convert(String UserValue, int UserSourceBase, int UserTargetBase) {
        if (ConverterController.isInteger(UserValue)) {
            return ConverterController.integerConversionToTargetBase(UserValue, UserSourceBase, UserTargetBase);
        } else {
            return ConverterController.decimalConversionToTargetBase(UserValue, UserSourceBase, UserTargetBase);
        }
    }
}