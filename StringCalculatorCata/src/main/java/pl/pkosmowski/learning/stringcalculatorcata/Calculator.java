package pl.pkosmowski.learning.stringcalculatorcata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pkosmowski
 */
public class Calculator {

	public int add(String arguments) {
		Integer result = 0;

		List<String> argumentList = new ArrayList<>();
		for (String argument : arguments.split(",")) {
			argumentList.add(argument);
		}
		System.out.println("argumentList = " + argumentList);

		List<Integer> numbers = new ArrayList<>();
		for (String numberAsString : argumentList) {
			try {
				numbers.add(Integer.parseInt(numberAsString));
			} catch (NumberFormatException numberFormatException) {
			}
		}
		System.out.println("numbers = " + numbers);

		for (Integer number : numbers) {
			result += number;
		}
		System.out.println("result = " + result);

		return result;

	}

}
