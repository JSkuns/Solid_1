public class IsInteger {

    // TODO: правило DRY
    // Правило DRY (Don’t Repeat Yourself): не повторяй свой код
    // метод isInteger был использован в классе Main (строки 32, 59) и в классе Product (строка 34)
    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

}
