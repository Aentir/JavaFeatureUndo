package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.CareTaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class UpdateCommand implements Command {
    private final String text;
    private final int lineNumber;
    private CareTaker careTaker;

    public UpdateCommand(String text, int lineNumber, CareTaker careTaker) {
        this.text = text;
        this.lineNumber = lineNumber;
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        if (documentLines.size() > lineNumber) {
            documentLines.set(lineNumber, text);
        } else {
            documentLines.add(text);
        }
        careTaker.push(saveMemento(documentLines));
    }

    private Memento saveMemento(ArrayList<String> documentLines) {
        return new Memento(documentLines);
    }
}
