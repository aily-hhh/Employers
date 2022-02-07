package com.company;

public class ThreadForUser implements Runnable
{

    @Override
    public void run()
    {
        View.start();
    }
}
