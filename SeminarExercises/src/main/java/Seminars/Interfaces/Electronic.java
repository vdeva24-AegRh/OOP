package Seminars.Interfaces;

public interface Electronic extends Device{
    public void plugin();

    @Override
    public void on();

    @Override
    public void off();


    }

