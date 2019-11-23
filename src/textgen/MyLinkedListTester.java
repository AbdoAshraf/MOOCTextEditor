/**
 * 
 */
package textgen;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

/**
 * @author UC San Diego MOOC team
 *
 */
public class MyLinkedListTester {

	private static final int LONG_LIST_LENGTH = 100;

	MyLinkedList<String> shortList;
	MyLinkedList<Integer> emptyList;
	MyLinkedList<Integer> longerList;
	MyLinkedList<Integer> list1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		// Feel free to use these lists, or add your own
		shortList = new MyLinkedList<String>();
		shortList.add("A");
		shortList.add("B");
		emptyList = new MyLinkedList<Integer>();
		longerList = new MyLinkedList<Integer>();
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			longerList.add(i);
		}
		list1 = new MyLinkedList<Integer>();
		list1.add(65);
		list1.add(21);
		list1.add(42);

	}

	/**
	 * Test if the get method is working correctly.
	 */
	/*
	 * You should not need to add much to this method. We provide it as an example
	 * of a thorough test.
	 */
	@Test
	public void testGet() {
		// test empty list, get should throw an exception
		try {
			emptyList.get(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}

		// test short list, first contents, then out of bounds
		assertEquals("Check first", "A", shortList.get(0));
		assertEquals("Check second", "B", shortList.get(1));

		try {
			shortList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.get(2);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		// test longer list contents
		for (int i = 0; i < LONG_LIST_LENGTH; i++) {
			assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
		}

		// test off the end of the longer array
		try {
			longerList.get(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.get(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

	}

	/**
	 * Test removing an element from the list. We've included the example from the
	 * concept challenge. You will want to add more tests.
	 */
	@Test
	public void testRemove() {
		int a = list1.remove(0);
		assertEquals("Remove: check a is correct ", 65, a);
		assertEquals("Remove: check element 0 is correct ", (Integer) 21, list1.get(0));
		assertEquals("Remove: check size is correct ", 2, list1.size());
		try {
			emptyList.remove(0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.remove(-1);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.remove(LONG_LIST_LENGTH);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		int b = longerList.remove(50);
		assertEquals("Remove: check a is correct ", (Integer) 51, longerList.get(50));
		// TODO: Add more tests here
		for (int i = 0; i < 50; i++) {
			assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
		}

		for (int i = 50; i < 99; i++) {
			assertEquals("Check " + i + " element", (Integer) (i + 1), longerList.get(i));
		}
	}

	/**
	 * Test adding an element into the end of the list, specifically public boolean
	 * add(E element)
	 */
	@Test
	public void testAddEnd() {
		// TODO: implement this test
		try {
			shortList.add(null);
			fail("Check out of bounds");
		} catch (NullPointerException e) {
		}
		longerList.add(10000);
		assertEquals("Remove: check a is correct ", (Integer) 10000, longerList.get(100));
	}

	/** Test the size of the list */
	@Test
	public void testSize() {
		// TODO: implement this test
		longerList.add(0);
		assertEquals("Remove: check size is correct ", 101, longerList.size());
		longerList.remove(9);
		assertEquals("Remove: check size is correct ", 100, longerList.size());
	}

	/**
	 * Test adding an element into the list at a specified index, specifically:
	 * public void add(int index, E element)
	 */
	@Test
	public void testAddAtIndex() {
		// TODO: implement this test
		try {
			list1.add(list1.size() + 1, 100);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			longerList.add(-1, 10);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {

		}
		try {
			shortList.add(0, null);
			fail("Check out of bounds");
		} catch (NullPointerException e) {
		}

		longerList.add(50, 555);
		assertEquals("Remove: check a is correct ", (Integer) 555, longerList.get(50));
		// TODO: Add more tests here
		for (int i = 0; i < 50; i++) {
			assertEquals("Check " + i + " element", (Integer) i, longerList.get(i));
		}

		for (int i = 51; i < 99; i++) {
			assertEquals("Check " + i + " element", (Integer) (i - 1), longerList.get(i));
		}

	}

	/** Test setting an element in the list */
	@Test
	public void testSet() {
		// TODO: implement this test
		try {
			emptyList.set(0, 0);
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}

		try {
			shortList.set(-1, "9");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.set(2, "9");
			fail("Check out of bounds");
		} catch (IndexOutOfBoundsException e) {
		}
		try {
			shortList.set(0, null);
			fail("Check out of bounds");
		} catch (NullPointerException e) {
		}

		longerList.set(2, 55);
		assertEquals("check", (Integer) 55, longerList.get(2));

		// TODO: Optionally add more test methods.
	}

}
