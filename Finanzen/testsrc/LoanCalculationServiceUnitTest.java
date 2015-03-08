import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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

	}

	@Test
	public void testPayToTheEnd() {
		loan = new Loan(DARLEHEN, ZINS, 0, RATE);
		service = new LoanCalculationService(loan);
		service.payDept();
		assertEquals(loan.getActualRuntime(), 89);
		assertFalse(loan.getRestDept() > 0);
		assertTrue(loan.getPayedInterest() == 3441.122789569876);
	}

	@Test
	public void testWithLimitedRuntime() {
		loan = new Loan(DARLEHEN, ZINS, 60, RATE);
		service = new LoanCalculationService(loan);
		service.payDept();

		assertTrue(loan.getPayedInterest() == 2831.693801914482);
	}
}
