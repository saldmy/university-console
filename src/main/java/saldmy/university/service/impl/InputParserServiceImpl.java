package saldmy.university.service.impl;

import org.springframework.stereotype.Service;
import saldmy.university.command.Command;
import saldmy.university.command.impl.*;
import saldmy.university.exception.InvalidInputException;
import saldmy.university.service.DepartmentService;
import saldmy.university.service.InputParserService;
import saldmy.university.service.LectorService;

@Service
public class InputParserServiceImpl implements InputParserService {
    
    private final DepartmentService departmentService;
    private final LectorService lectorService;

    public InputParserServiceImpl(DepartmentService departmentService, LectorService lectorService) {
        this.departmentService = departmentService;
        this.lectorService = lectorService;
    }

    @Override
    public Command parseInput(String input) throws InvalidInputException {
        input = prepareInput(input);

        String[] tokens = input.split(" ");

        if (tokens.length >= 8
                && "Show".equalsIgnoreCase(tokens[0])
                && "the".equalsIgnoreCase(tokens[1])
                && "average".equalsIgnoreCase(tokens[2])
                && "salary".equalsIgnoreCase(tokens[3])
                && "for".equalsIgnoreCase(tokens[4])
                && "the".equalsIgnoreCase(tokens[5])
                && "department".equalsIgnoreCase(tokens[6])) {
            return new AverageSalaryCommand(departmentService, parseName(tokens, 7));
        } else if (tokens.length >= 6
                && "Who".equalsIgnoreCase(tokens[0])
                && "is".equalsIgnoreCase(tokens[1])
                && "head".equalsIgnoreCase(tokens[2])
                && "of".equalsIgnoreCase(tokens[3])
                && "department".equalsIgnoreCase(tokens[4])) {
            return new HeadOfDepartmentCommand(departmentService, parseName(tokens, 5));
        } else if (tokens.length >= 6
                && "Show".equalsIgnoreCase(tokens[0])
                && "count".equalsIgnoreCase(tokens[1])
                && "of".equalsIgnoreCase(tokens[2])
                && "employee".equalsIgnoreCase(tokens[3])
                && "for".equalsIgnoreCase(tokens[4])) {
            return new EmployeeCountCommand(departmentService, parseName(tokens, 5));
        } else if (tokens.length >= 4
                && "Global".equalsIgnoreCase(tokens[0])
                && "search".equalsIgnoreCase(tokens[1])
                && "by".equalsIgnoreCase(tokens[2])) {
            return new GlobalSearchCommand(lectorService, departmentService, parseName(tokens, 3));
        } else if (tokens.length >= 3
                && "Show".equalsIgnoreCase(tokens[0])
                && "statistics".equalsIgnoreCase(tokens[tokens.length - 1])) {
            return new DepartmentStatisticsCommand(departmentService, parseName(tokens, 1, 1));
        } else {
            throw new InvalidInputException("cannot recognize command " + input);
        }
    }

    private String prepareInput(String input) throws InvalidInputException {
        input = input.strip();

        if (input.isEmpty()) {
            throw new InvalidInputException();
        }

        if (input.endsWith(".")) {
            input = input.substring(0, input.length() - 1);
        }
        return input;
    }

    private String parseName(String[] tokens, int wordsBefore) {
        return parseName(tokens, wordsBefore, 0);
    }

    private String parseName(String[] tokens, int wordsBefore, int wordsAfter) {
        StringBuilder sb = new StringBuilder();

        for (int i = wordsBefore; i < tokens.length - wordsAfter; i++) {
            sb.append(tokens[i]);
            sb.append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        return sb.toString();
    }

}
