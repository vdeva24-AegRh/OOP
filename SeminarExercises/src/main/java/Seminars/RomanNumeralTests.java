package Seminars;

public class RomanNumeralTests {
    public static void main(String[] args) {
        for(String arg: args) {
            try {
                RomanNumeral entry = new RomanNumeral(arg);
                System.out.println("Roman: " + entry);
                System.out.println("Arabic: " + entry.toInt());
            } catch(RuntimeException ex) {
                RomanNumeral entry = new RomanNumeral(Integer.parseInt(arg));
                System.out.println("Roman: " + entry);
                System.out.println("Arabic: " + entry.toInt());
            }
        }
    }
}
