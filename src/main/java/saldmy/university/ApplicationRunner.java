package saldmy.university;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import saldmy.university.command.Command;
import saldmy.university.exception.InvalidInputException;
import saldmy.university.service.InputParserService;

import java.util.Scanner;

/**
 * @author Dmytro Salo
 */
@Component
public class ApplicationRunner implements CommandLineRunner {

    private final InputParserService inputParserService;

    public ApplicationRunner(InputParserService inputParserService) {
        this.inputParserService = inputParserService;
    }

    @Override
    public void run(String... args) {
        try (Scanner scanner = new Scanner(System.in)) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();

                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                try {
                    Command command = inputParserService.parseInput(input);
                    System.out.println(command.execute());
                } catch (InvalidInputException e) {
                    if (e.getMessage() != null) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }

}
