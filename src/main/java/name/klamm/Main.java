package name.klamm;

public class Main {
    public static void main(String[] args) {
        int value = 0x017E;

        System.out.println(" H E X ");
        System.out.print("UseStringFormat:\t\t");
        System.out.println(UseStringFormat.convertToHex(value));

        System.out.print("IntegerToHex:\t\t\t");
        System.out.println(IntegerToHex.convert(value));

        System.out.print("UseIntegerToString:\t\t");
        System.out.println(UseIntegerToString.convertToHex(value));

        System.out.print("UseIntegerToXString:\t");
        System.out.println(UseIntegerToXString.convertToHex(value));

        System.out.println(" B I N ");
        System.out.print("UseStringFormat:\t\t");
        System.out.println(UseStringFormat.convertToBin(value));

        System.out.print("IntegerToBin:\t\t\t");
        System.out.println(IntegerToBin.convert(value));

        System.out.print("UseIntegerToString:\t\t");
        System.out.println(UseIntegerToString.convertToBin(value));

        System.out.print("UseIntegerToXString:\t");
        System.out.println(UseIntegerToXString.convertToBin(value));
    }

    static class UseStringFormat {
        public static String convertToBin(int value) {
            return String.format("%16s", Integer.toBinaryString(value)).replace(' ', '0');
        }

        public static String convertToHex(int value) {
            return String.format("%04x", value);
        }
    }

    // TODO: can generify by radix
    static class IntegerToHex {
        private static final String DIGITS = "0123456789abcdef";
        public static String convert(int value) {
            if (value <= 0) {
                return "0";
            }

            StringBuilder result = new StringBuilder();
            while (value > 0) {
                int digit = value % 16;
                result.insert(0, DIGITS.charAt(digit));
                value /= 16;
            }

            return result.toString();
        }
    }

    static class UseIntegerToString {
        public static String convertToBin(int value) {
            return Integer.toString(value, 2);
        }

        public static String convertToHex(int value) {
            return Integer.toString(value, 16);
        }
    }

    static class UseIntegerToXString {
        public static String convertToBin(int value) {
            return Integer.toBinaryString(value);
        }

        public static String convertToHex(int value) {
            return Integer.toHexString(value);
        }
    }

    static class IntegerToBin {
        private static final String DIGITS = "01";

        public static String convert(int value) {
            if (value <= 0) {
                return "0";
            }

            StringBuilder result = new StringBuilder();
            while (value > 0) {
                int digit = value % 2;
                result.insert(0, DIGITS.charAt(digit));
                value /= 2;
            }

            return result.toString();
        }
    }
}