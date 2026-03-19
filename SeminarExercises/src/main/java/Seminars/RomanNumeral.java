package Seminars;

public class RomanNumeral {
    private static final int MIN = 1;
    private static final int MAX = 3999;
    private static final String REGEX_PATTERN = "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
    private int arabicNumber;


   /* @param arabicNumber;
    @throws IllegalArgumentException
    */
    RomanNumeral(int arabicNumber) {
        if(arabicNumber < MIN || arabicNumber > MAX) {
            throw new IllegalArgumentException("Arabic Number should be in : [ " +MIN + " " + MAX + " ]");
        }
        this.arabicNumber = arabicNumber;
    }

    RomanNumeral(String romanNumber) {
        this.arabicNumber = parseRoman(romanNumber);

    }
    private static int parseRoman(String romanNumber) {
        if(!romanNumber.matches(REGEX_PATTERN)) throw new IllegalArgumentException("Illegal Format For Roman Number!");
        int result = 0;
        for(int i = 0 ; i < romanNumber.length() ; i ++) {
            int current = RomanToken.getValue(""+ romanNumber.charAt(i));
            int next = i + 1 < romanNumber.length() ? RomanToken.getValue("" + romanNumber.charAt(i + 1)) : 0;
            if(current < next) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        int current = arabicNumber;
        for(RomanToken curr: RomanToken.values()) {
            while(RomanToken.getValue(curr.name()) <= current) {
                result.append(curr.name());
                current -= RomanToken.getValue(curr.name());
            }
        }
        return result.toString();
    }
    public int toInt() {
        return arabicNumber;
    }
}


