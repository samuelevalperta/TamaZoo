package it.unibs.ing.fp.lab.TamaZoo;

import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TamagordoTest {
	@Test
	public void tamagordoShouldNotDieDueToTooManyCookies() throws Exception {
		Tamagotchi tama = new TamaGordo("gordo", 90);
		tama.riceviBiscotti(100);
		tama.riceviBiscotti(100);
		Assert.assertTrue(!tama.sonoTriste());
		Assert.assertTrue(!tama.sonoTriste());
	}

	@Test
	public void tamagordoDiesDueToHunger() throws Exception {
		Tamagotchi tama = new TamaGordo("gordo", 0);
		Assert.assertTrue(tama.sonoMorto());
	}
}
