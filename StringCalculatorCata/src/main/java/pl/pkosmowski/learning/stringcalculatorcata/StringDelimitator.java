package pl.pkosmowski.learning.stringcalculatorcata;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pkosmowski
 */
class StringDelimitator {

	public List<String> splitByDelimiter(String arguments, String delimiter) {
		List<String> out = new ArrayList<>();

		int begin = 0;
		int current = 0;
		int length = arguments.length();

		while (current < length) {
			if (arguments.startsWith(delimiter, current)) {
				out.add(arguments.substring(begin, current));
				current += delimiter.length();
				begin = current;
			} else {
				current++;
			}
		}
		out.add(arguments.substring(begin));
		return out;
	}

}
