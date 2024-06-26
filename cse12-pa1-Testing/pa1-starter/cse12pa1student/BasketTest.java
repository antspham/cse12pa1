package cse12pa1student;

import java.util.Collection;
import java.util.Arrays;

import static org.junit.Assert.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BasketTest {

	public static Collection<Object[]> BAGNUMS =
			Arrays.asList(new Object[][] { {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}, {8}, {9}, {10}, {11}, {12} });
	private int bagType;

	public BasketTest(int bagType) {
		super();
		this.bagType = bagType;
	}

	@Parameterized.Parameters(name = "Basket{index}")
	public static Collection<Object[]> bags() {
		return BAGNUMS;
	}
	
	private Basket makeBasket() {
		switch(this.bagType) {
			case 0: return new Basket0();
			case 1: return new Basket1();
			case 2: return new Basket2();
			case 3: return new Basket3();
			case 4: return new Basket4();
			case 5: return new Basket5();
			case 6: return new Basket6();
			case 7: return new Basket7();
			case 8: return new Basket8();
			case 9: return new Basket9();
			case 10: return new Basket10();
			case 11: return new Basket11();
			case 12: return new Basket12();
		}
		return null;
	}
	
	@Test 
	public void addedHasCount1() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(1, basketToTest.count());
	}

	@Test 
	public void countTest() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		i = new Item("Soap", 3);
		basketToTest.addToBasket(i);
		assertEquals(2, basketToTest.count());
	}

	@Test 
	public void countItemTest() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		assertEquals(2, basketToTest.countItem(i));
	}

	@Test
	public void totalCostTest() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		assertEquals(5, basketToTest.totalCost());
	}

	@Test
	public void removeFromBasketTest() {
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Soap", 3);
		basketToTest.addToBasket(i);
		i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.removeFromBasket(i);
		assertEquals(1, basketToTest.count());
	}

	@Test
	public void removeAllFromBasketTest() {
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Soap", 3);
		basketToTest.addToBasket(i);
		i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.removeAllFromBasket(i);
		assertEquals(1, basketToTest.count());
	}

	@Test 
	public void emptyTest() {
		Basket basketToTest = makeBasket();
		
		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		basketToTest.addToBasket(i);
		basketToTest.empty();
		assertEquals(0, basketToTest.count());
	}

	@Test // Removes item not in basket, edge case
	public void removeItemNotInBasket() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		basketToTest.addToBasket(i);
		Item a = new Item("Soap", 3);
		assertEquals(false, basketToTest.removeFromBasket(a));
	}

	@Test // Checks overflow, edge case
	public void largeBasket() {
		Basket basketToTest = makeBasket();

		Item i = new Item("Shampoo", 5);
		for (int x = 0; x < 99; x++) {
			basketToTest.addToBasket(i);
		}
		assertEquals(99, basketToTest.count());
	}
}
