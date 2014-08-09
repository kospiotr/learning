package pl.pkosmowski.learning.stringcalculatorcata;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;

/**
 *
 * @author pkosmowski
 */
public class StringDelimitatorTest {

	StringDelimitator stringDelimitator = new StringDelimitator();
	
	@Test
	public void shouldDelimiteByComma() throws Exception {
		assertThat(stringDelimitator.splitByDelimiter("1,2,3", ",")).contains("1","2","3");
	}
	
	@Test
	public void shouldDelimiteByDot() throws Exception {
		assertThat(stringDelimitator.splitByDelimiter("1.2.3", ".")).contains("1","2","3");
	}
	
	@Test
	public void shouldDelimiteByNewLine() throws Exception {
		assertThat(stringDelimitator.splitByDelimiter("1\n2\n3", "\n")).contains("1","2","3");
	}
	
}
