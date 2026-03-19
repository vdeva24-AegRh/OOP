package Seminars;

public enum RomanToken {
    M("M", 1000),
    CM("CM", 900),
    D("D", 500),
    CD("CD", 400),
    C("C", 100),
    XC("XC", 90),
    L("L", 50),
    XL("XL", 40),
    X("X", 10),
    IX("IX", 9),
    V("V", 5),
    IV("IV", 4),
    I("I", 1);

    private final String token;
    private final int value;

    RomanToken(String token , int value) {
        this.token = token;
        this.value = value;
    }
    public static int getValue(String token) {
        for(RomanToken currToken: RomanToken.values()) {
            if(currToken.token.equals(token)) {
                return currToken.value;
            }
        }
        return -1;
    }
}
