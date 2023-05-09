package saldmy.university.service.impl;

import saldmy.university.command.Command;
import saldmy.university.exception.InvalidInputException;
import saldmy.university.service.InputParserService;

public class InputParserServiceImpl implements InputParserService {

    @Override
    public Command parseInput(String input) {
        if (input.isBlank()) {
            throw new InvalidInputException("input is empty");
        }

        String[] tokens = input.split(" ");

        Command command = null;

        if (tokens[2].equals("head")) {

        }

        return command;
    }

}
