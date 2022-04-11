package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.CareTaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class DeleteCommand implements Command {
    private final int lineNumber;
    private CareTaker careTaker;

    public DeleteCommand(int lineNumber, CareTaker careTaker) {
        this.lineNumber = lineNumber;
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.remove(lineNumber);
        careTaker.push(saveMemento(documentLines));
    }

    private Memento saveMemento(ArrayList<String> documentLines) {
        return new Memento(documentLines);
    }
}
