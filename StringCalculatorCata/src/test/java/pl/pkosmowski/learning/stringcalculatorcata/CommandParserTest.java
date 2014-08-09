package pl.pkosmowski.learning.stringcalculatorcata;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author pkosmowski
 */
public class CommandParserTest {

	@Test
	public void shouldParseNumbersOnly() throws Exception {
		assertThat(new CommandParser("1,2,3").getNumbers()).isEqualTo("1,2,3");
	}

	@Test
	public void shouldParseDelimiterAndNumbers() throws Exception {
		CommandParser commandParser = new CommandParser("//[,]\n1,2,3");
		assertThat(commandParser.getDelimiters()).containsOnly(",");
		assertThat(commandParser.getNumbers()).isEqualTo("1,2,3");
	}
	
	@Test
	public void shouldParseMultipleDelimitersAndNumbers() throws Exception {
		CommandParser commandParser = new CommandParser("//[*][%]\n1*2%3");
		assertThat(commandParser.getDelimiters()).containsOnly("*","%");
		assertThat(commandParser.getNumbers()).isEqualTo("1*2%3");
	}

}
