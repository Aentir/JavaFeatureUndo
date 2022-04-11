package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.CareTaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class UndoCommand implements Command {
    private CareTaker careTaker;

    public UndoCommand(CareTaker careTaker) {
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        ArrayList<String> cacheDocumentLines = restore(careTaker.pop());
        documentLines.clear();
        if (cacheDocumentLines != null) {
            documentLines.addAll(cacheDocumentLines);
        }
    }

    private ArrayList<String> restore(Memento memento) {
        if (memento != null) {
            return new ArrayList<>(memento.getState());
        } else {
            return null;
        }
    }

}
