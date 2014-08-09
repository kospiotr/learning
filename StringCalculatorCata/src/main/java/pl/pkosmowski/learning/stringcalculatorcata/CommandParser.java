package pl.pkosmowski.learning.stringcalculatorcata;

import java.math.BigDecimal;

/**
 *
 * @author pkosmowski
 */
class CommandParser {

	private static final String DELIMITER_PREFIX = "//";
	private static final String DELIMITER_SUFFIX = "\n";

	private final String delimiter;
	private final String numbers;

	CommandParser(String command) {
		boolean hasCustomDelimiter = hasCustomDelimiter(command);
		this.delimiter = extractDelimiter(command, hasCustomDelimiter);
		this.numbers = extractNumbers(command, hasCustomDelimiter);
	}

	public String getDelimiter() {
		return delimiter;
	}

	public String getNumbers() {
		return numbers;
	}

	private boolean hasCustomDelimiter(String command) {
		return command.startsWith(DELIMITER_PREFIX);
	}

	private String extractDelimiter(String command, boolean hasCustomDelimiter) {
		return hasCustomDelimiter
						? command.substring(DELIMITER_PREFIX.length(), command.indexOf(DELIMITER_SUFFIX))
						: ",";
	}

	private String extractNumbers(String command, boolean hasCustomDelimiter) {
		return hasCustomDelimiter
						? command.substring(command.indexOf(DELIMITER_SUFFIX) + 1)
						: command;
	}

}
