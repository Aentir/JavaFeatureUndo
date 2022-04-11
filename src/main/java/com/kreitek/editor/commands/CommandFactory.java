package com.kreitek.editor.commands;

import com.kreitek.editor.BadCommandException;
import com.kreitek.editor.Command;
import com.kreitek.editor.ExitException;
import com.kreitek.editor.memento.CareTaker;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();
    CareTaker careTaker = new CareTaker();

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1], careTaker);
            case "u" -> createUpdateCommand(args[1], args[2], careTaker);
            case "d" -> createDeleteCommand(args[1], careTaker);
            case "undo" -> createUndoCommand(careTaker);
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand(CareTaker careTaker) {
        return new UndoCommand(careTaker);
    }

    private Command createDeleteCommand(String lineNumber, CareTaker careTaker) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number, careTaker);
    }

    private Command createUpdateCommand(String lineNumber, String text, CareTaker careTaker) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number, careTaker);
    }

    private Command createAppendCommand(String text, CareTaker careTaker) {
        return new AppendCommand(text, careTaker);
    }

}
