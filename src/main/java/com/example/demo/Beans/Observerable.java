package com.example.demo.Beans;

import java.util.Observer;

/**
 * Created by 1 on 2018/10/23.
 */
public interface Observerable {
    public void registerObserver(Obser o);
    public void removeObserver(Obser o);
    public void notifyObserver();
}
