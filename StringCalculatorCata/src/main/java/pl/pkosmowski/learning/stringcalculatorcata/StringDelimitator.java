package pl.pkosmowski.learning.stringcalculatorcata;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pkosmowski
 */
class StringDelimitator {

	private static final Logger logger = Logger.getLogger(StringDelimitator.class.getName());

	public List<String> splitByDelimiter(String arguments, String... delimiters) {
		List<String> out = new ArrayList<>();

		int begin = 0;
		int current = 0;
		int length = arguments.length();

		System.out.println("Arguments: " + arguments);

		while (current < length) {
			for (String delimiter : delimiters) {
				System.out.println("\tCurrent: " + current + " Delimiter: " + delimiter);
				if (arguments.startsWith(delimiter, current)) {
					String part = arguments.substring(begin, current);
					System.out.println("\t\t\tFound part: " + part);
					out.add(part);
					current += delimiter.length();
					begin = current;
					break;
				}
			}
			current++;
		}
		out.add(arguments.substring(begin));
		return out;
	}

}
