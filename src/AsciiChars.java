public class AsciiChars {

    public static void printNumbers() {
        System.out.println("These are numbers!");
        for (int i = 48; i < 58; i++) {
            System.out.println((char) i);
        }
    }

    public static void printLowerCaseLetters() {
        System.out.println("These are lowercase letters!");
        for (int i = 97; i < 123; i++) {
            System.out.println((char) i);
        }

    }

    public static void printUpperCaseLetters() {
        System.out.println("These are uppercase letters!");
        for (int i = 65; i < 91; i++) {
            System.out.println((char) i);
        }
    }

    public static void main(String[] args) {
        AsciiChars.printNumbers();        
        AsciiChars.printLowerCaseLetters();
        AsciiChars.printUpperCaseLetters();

    }

}