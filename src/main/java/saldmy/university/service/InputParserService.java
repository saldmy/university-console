package saldmy.university.service;

import org.springframework.stereotype.Service;
import saldmy.university.command.Command;

@Service
public interface InputParserService {

    Command parseInput(String input);

}
