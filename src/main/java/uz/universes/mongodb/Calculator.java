package uz.universes.mongodb;

import java.util.concurrent.TimeUnit;

public class Calculator {
    public int sum(int a, int b) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return a+b;
    }
    public int div(int a,int b){
        if (b<0){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        return a/b;
    }
}
