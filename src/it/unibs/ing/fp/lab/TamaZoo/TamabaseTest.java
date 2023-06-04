package it.unibs.ing.fp.lab.TamaZoo;

import org.junit.Assert;
import org.junit.Test;

public class TamabaseTest {
	
	@Test
	public void petShouldDieWhenSatisfactionIsZero() throws Exception {
		final Tamagotchi tama = new Tamagotchi("Nome 1", 0, 50);
		Assert.assertTrue(tama.sonoMorto());
	}
	
	@Test
	public void petShouldDieWhenRepletionIsZero() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 50, 0);
		Assert.assertTrue(tama.sonoMorto());
	}
	
	@Test
	public void petShouldLiveWhenRepletionAndSatisfactionAreInTheMiddleOfTheRange() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 50, 50);
		Assert.assertTrue(!tama.sonoMorto());
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeSatisfaction() throws Exception {
		new Tamagotchi("nome", -10, 50);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void cantInstantiatePetWithNegativeRepletion() throws Exception {
		new Tamagotchi("nome", 50, -10);
	}
	
	@Test
	public void petCanReceiveCaresses() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome",50, 50);
		tama.riceviCarezze(10);
		Assert.assertFalse(tama.sonoTriste());
	}
	
	@Test
	public void petCanReceiveCookies() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 50, 50);
		tama.riceviCarezze(10);
		Assert.assertFalse(tama.sonoTriste());
	}
	
	@Test
	public void petIsUnhappyDueToHunger() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 50, 10);
		Assert.assertTrue(tama.sonoTriste());
	}
	
	@Test
	public void petIsUnhappyDueToExtremeRepletion() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 50, 95);
		Assert.assertTrue(tama.sonoTriste());
	}
	
	@Test
	public void petIsHappyInTheMidlleOfTheRange() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 50, 50);
		Assert.assertFalse(tama.sonoTriste());
	}
	
	@Test
	public void petAugmentsItsRepletionAndDiesDueToCookies() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 50, 99);
		tama.riceviBiscotti(10);
		Assert.assertTrue(tama.sonoMorto());
	}
	
	@Test
	public void petAugmentsItsSatisfactionDueToCaresses() throws Exception {
		final Tamagotchi tama = new Tamagotchi("nome", 29, 50);
		tama.riceviCarezze(10);
		Assert.assertTrue(!tama.sonoTriste());
	}
}
