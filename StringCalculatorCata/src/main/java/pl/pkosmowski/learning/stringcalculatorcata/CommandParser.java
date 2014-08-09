package pl.pkosmowski.learning.stringcalculatorcata;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 *
 * @author pkosmowski
 */
class CommandParser {

	private static final String DELIMITER_PREFIX = "//[";
	private static final String DELIMITER_SPLITTER = "\\]\\[";
	private static final String DELIMITER_SUFFIX = "]\n";

	private final String[] delimiters;
	private final String numbers;

	CommandParser(String command) {
		System.out.println("command = " + command);
		boolean hasCustomDelimiter = hasCustomDelimiter(command);
		this.delimiters = extractDelimiter(command, hasCustomDelimiter);
		System.out.println("delimiters = " + Arrays.toString(delimiters));
		this.numbers = extractNumbers(command, hasCustomDelimiter);
		System.out.println("numbers = " + numbers);
	}

	public String[] getDelimiters() {
		return delimiters;
	}

	public String getNumbers() {
		return numbers;
	}

	private boolean hasCustomDelimiter(String command) {
		return command.startsWith(DELIMITER_PREFIX);
	}

	private String[] extractDelimiter(String command, boolean hasCustomDelimiter) {
		return hasCustomDelimiter
						? extractDelimitersFromDelimiterSection(command)
						: new String[]{","};
	}

	private String[] extractDelimitersFromDelimiterSection(String command) {
		String delimiterSection = command.substring(
						DELIMITER_PREFIX.length(),
						command.indexOf(DELIMITER_SUFFIX));
		return delimiterSection.split(DELIMITER_SPLITTER);
	}

	private String extractNumbers(String command, boolean hasCustomDelimiter) {
		return hasCustomDelimiter
						? command.substring(command.indexOf(DELIMITER_SUFFIX) + DELIMITER_SUFFIX.length())
						: command;
	}

}
