package saldmy.university.service;

import org.springframework.stereotype.Service;
import saldmy.university.command.Command;
import saldmy.university.exception.InvalidInputException;

@Service
public interface InputParserService {

    Command parseInput(String input) throws InvalidInputException;

}
