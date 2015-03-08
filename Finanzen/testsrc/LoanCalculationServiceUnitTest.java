import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class LoanCalculationServiceUnitTest {

	private LoanCalculationService service;
	private Loan loan;
	DecimalFormat decimalFormatter;
	private static final double DARLEHEN = 50000;
	private static final double ZINS = 0.0175d;
	private static final double RATE = 406.25;
	private static final int LAUFZEIT = 0;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);

		decimalFormatter = new DecimalFormat("##,##");
		loan = new Loan(DARLEHEN, ZINS, LAUFZEIT, RATE);
		service = new LoanCalculationService(loan);
	}

	@Test
	public void testStuff() {

		service.payDept(LAUFZEIT, DARLEHEN);
		assertEquals(loan.getActualRuntime(), 89);
		assertTrue(loan.getRestDept() == -215.127210430128);
		assertTrue(loan.getPayedInterest() == 3441.122789569876);
	}
}
