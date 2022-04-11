package com.kreitek.editor.memento;

import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    List<Memento> mementos = new ArrayList<>();

    public void push(Memento memento) {
        mementos.add(memento);
    }

    public Memento pop() {
        if (mementos.size() > 0) {
            mementos.remove(mementos.size() - 1);
            if (mementos.size() != 0) {
                return mementos.get(mementos.size() - 1);
            } else {
                return null;
            }
        }
        return null;
    }


}
