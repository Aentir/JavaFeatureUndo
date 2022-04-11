package com.kreitek.editor.commands;

import com.kreitek.editor.Command;
import com.kreitek.editor.memento.CareTaker;
import com.kreitek.editor.memento.Memento;

import java.util.ArrayList;

public class AppendCommand implements Command {
    private final String text;
    private CareTaker careTaker;

    public AppendCommand(String text, CareTaker careTaker) {
        this.text = text;
        this.careTaker = careTaker;
    }

    @Override
    public void execute(ArrayList<String> documentLines) {
        documentLines.add(text);
        careTaker.push(saveMemento(documentLines));
    }

    private Memento saveMemento(ArrayList<String> documentLines) {
        ArrayList<String> cloneDocumentLines = (ArrayList<String>) documentLines.clone();
        return new Memento(cloneDocumentLines);
    }
}
