
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите два Арабских или Римских числа: ");
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }
    public static String calc(String input) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRoman;
        String[] operands = input.split("[+\\-*/]");
        if (operands.length != 2) throw new Exception("Два операнда");
        oper = operation(input);
        //if (oper == null) throw new Exception("Некорректная оперция");
        if (Roman.isRoman(operands[0]) && Roman.isRoman(operands[1])) {
        // конвертируем оба числа в арабские
            num1 = Roman.convertToArabian(operands[0]);
            num2 = Roman.convertToArabian(operands[1]);
            isRoman = true;
        }
        // если оба числа арабские
        else if (!Roman.isRoman(operands[0]) && !Roman.isRoman(operands[1])) {
            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[1]);
            isRoman = false;
        }
        // если одно число римское, а второе арабское
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 || num2 > 1000) {
            throw new Exception("Числа от 1 до 10");
        }
        int arabian = calculator(num1, num2, oper);
        if (isRoman) {
            if (arabian <= 0) {
                throw new Exception("...должно быть больше нуля");
            }
            result = Roman.convertToRoman(arabian);
        } else {
            result = String.valueOf(arabian);
        }
        return result;
    }
    static String operation(String input)  {
        if (input.contains("+")) return "+";
        else if (input.contains("-")) return "-";
        else if (input.contains("*")) return "*";
        else if (input.contains("/")) return "/";
        else return null;
    }

    static int calculator(int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

        }
class Roman {
            static String[] arrayRoman = new String[]{"0", "I", "II","III", "IV", "V", "VI", "VII",
            "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI","XVII", "XVIII", "XIX",
            "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX",
             "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
            "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LII",
            "LII", "LIV", "LV", "LVI", "LVII", "LVII", "LIX", "LX", "LXI", "LXII", "LXII", "LXIV", "LXV",
            "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
            "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
            "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

            static boolean isRoman(String val) {
                for (int i = 0; i < arrayRoman.length; i++) {
                    if (val.equals(arrayRoman[i])) {
                        return true;
                    }
                }
                return false;
            }

            static int convertToArabian(String roman) {
                for (int i = 0; i < arrayRoman.length; i++){
                    if (roman.equals(arrayRoman[i])) {
                        return i;
                    }
                }return -1;
            }
            static String convertToRoman(int arabian) {
                return arrayRoman[arabian];

            }
}































