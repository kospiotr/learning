package pl.pkosmowski.learning.stringcalculatorcata;

import java.util.ArrayList;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;

/**
 *
 * @author pkosmowski
 */
public class Calculator {

	public int add(String arguments) {

		List<String> argumentList = extractArguments(arguments);
		System.out.println("argumentList = " + argumentList);

		List<Integer> numbers = extractNumbers(argumentList);
		System.out.println("numbers = " + numbers);

		int result = sumNumbers(numbers);
		System.out.println("result = " + result);

		return result;

	}

	StringDelimitator stringDelimitator = new StringDelimitator();
	
	private List<String> extractArguments(String command) {
		CommandParser commandParser = new CommandParser(command);
		return stringDelimitator.splitByDelimiter(commandParser.getNumbers(), commandParser.getDelimiter());
	}

	private Integer sumNumbers(List<Integer> numbers) {
		int result = 0;
		for (Integer number : numbers) {
			if(number < 0) throw new RuntimeException("negatives not allowed");
			if(number > 1000) continue;
			result += number;
		}
		return result;
	}

	private List<Integer> extractNumbers(List<String> argumentList) {
		List<Integer> numbers = new ArrayList<>();
		for (String numberAsString : argumentList) {
			try {
				numbers.add(Integer.parseInt(numberAsString));
			} catch (NumberFormatException numberFormatException) {
			}
		}
		return numbers;
	}

}
