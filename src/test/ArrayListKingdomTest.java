package test;

import kingdom.ArrayListKingdom;
import kingdom.ListADT;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListKingdomTest
{
  private ListADT<String> listKingdom;

  @BeforeEach
  void setup()
  {
    listKingdom = new ArrayListKingdom<>();
  }

  @Test
  public void testIsEmptyReturnsFalseWhenListIsNotEmpty()
  {
    listKingdom.add("TEST");
    assertFalse(listKingdom.isEmpty());
  }

  @Test
  public void testAddElementAtIndex0()
  {
    //List size =0 and legal values are 0 to list size
    assertDoesNotThrow(()-> listKingdom.add(0, "TEST"));
  }


  @Test
  public void testAddElementsAddsToRear()
  {
    listKingdom.add("TEST1");
    listKingdom.add("TEST2");

    assertEquals(1, listKingdom.indexOf("TEST2"));
  }

  @Test
  public void testSetElementSet()
  {
    //Adds an element such that list size = 1
    //legal values = 0 to list size -1
    listKingdom.add("TEST1");
    listKingdom.set(0,"TEST2");
    assertEquals("TEST2",listKingdom.get(0));
  }


  @Test
  public void testContainsFalse()
  {
    listKingdom.add("Test1");
    assertFalse(listKingdom.contains("Test2"));
  }

  @Test
  public void testIsFull()
  {
    //List is unbounded and will always return true
    for (int i = 0; i < 10000; i++)
    {
      listKingdom.add( "Test" + i);
    }
    // the ListADT in the kingdom project has the isFull set to be true
    //thus the tested class does not follow the documentation.
    assertFalse(listKingdom.isFull());
  }

}