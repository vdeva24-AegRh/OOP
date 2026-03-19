package Seminars.Interfaces;

public abstract class Phone implements Electronic {
    public abstract void makeCall(String NUmber);
    public void testCall(String Number) {
        System.out.println("Calling: " + Number);
    }

}
