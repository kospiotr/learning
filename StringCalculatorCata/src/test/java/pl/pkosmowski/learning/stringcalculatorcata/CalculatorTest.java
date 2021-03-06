package pl.pkosmowski.learning.stringcalculatorcata;

import static org.fest.assertions.Assertions.assertThat;
import org.junit.Test;
import org.junit.Before;

/**
 *
 * @author pkosmowski
 */
public class CalculatorTest {

	Calculator calculator;

	@Before
	public void init() {
		calculator = new Calculator();
	}

	@Test
	public void shouldReturnZeroIfNoArguments() throws Exception {
		assertThat(calculator.add("")).isEqualTo(0);
	}

	@Test
	public void shouldAddTwoNumbers() throws Exception {
		assertThat(calculator.add("1,2")).isEqualTo(3);
	}

	@Test
	public void shouldAddThreeNumbers() throws Exception {
		assertThat(calculator.add("1,2,3")).isEqualTo(6);
	}

	@Test
	public void shouldAddNumbersWithCustomDelimiter() throws Exception {
		assertThat(calculator.add("//[;]\n1;2")).isEqualTo(3);
	}

	@Test(expected = RuntimeException.class)
	public void shouldNotAllowToAddNegativeNumber() throws Exception {
		assertThat(calculator.add("1,-2,3"));
	}

	@Test
	public void shouldIgnoreNumberGreaterThan1000() throws Exception {
		assertThat(calculator.add("2,1001")).isEqualTo(2);
	}

	@Test
	public void shouldSupportMultipleCustomDelimiters() throws Exception {
		assertThat(calculator.add("//[*][%]\n1*2%3")).isEqualTo(6);
	}

	@Test
	public void shouldSupportMultipleLongCustomDelimiters() throws Exception {
		assertThat(calculator.add("//[***][%%%]\n1***2%%%3")).isEqualTo(6);
	}

}
