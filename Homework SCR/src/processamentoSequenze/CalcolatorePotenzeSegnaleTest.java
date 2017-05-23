package processamentoSequenze;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalcolatorePotenzeSegnaleTest {

	@Test
	public void testCalcolaPotenza() {
		CalcolatorePotenzeSegnali csp = new CalcolatorePotenzeSegnali();
		double[] parteReale = new double[1000];
		double[] parteImmaginaria = new double[1000];
		for(int i = 0; i < 1000; i++) {
			parteReale[i] = 1;
			parteImmaginaria[i] = 1;
		}
		assertNotEquals(0, csp.calcolaPotenzaSegnale(parteReale, parteImmaginaria));
	}

}
