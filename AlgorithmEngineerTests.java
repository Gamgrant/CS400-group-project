// --== CS400 Project One File Header ==--
// Name: Nathin Williams
// CSL Username: nathin
// Email: nwilliams32@wisc.edu
// Lecture #: 004 @4:00pm

import java.util.List;
import java.util.NoSuchElementException;

/**
 * Test program for HashTableSortedSets
 * 
 * @author nathi
 *
 */
public class AlgorithmEngineerTests {

  /**
   * Tests the add() and size() methods
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test1() {
    try {
      HashTableSortedSets<String, String> testTable = new HashTableSortedSets<String, String>();
      testTable.add("Larry", "Tiger");
      testTable.add("Johnny", "Lion");
      testTable.add("Bobby", "Dog");

      if (testTable.size() == 3) {
        return true;
      } else {
        return false;
      }
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  /**
   * Tests the get() method
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test2() {
    try {
      HashTableSortedSets<String, String> testTable = new HashTableSortedSets<String, String>();
      testTable.add("Larry", "Tiger");
      testTable.add("Johnny", "Lion");
      testTable.add("Bobby", "Dog");
      List<String> testValue = testTable.get("Larry");
      if (testValue.get(0).equals("Tiger")) {
        testValue = testTable.get("Johnny");
        if (testValue.get(0).equals("Lion")) {
          testValue = testTable.get("Bobby");
          if (testValue.get(0).equals("Dog")) {
            return true;
          }
        }
      }
      return false;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Tests the containsKey(), remove() and clear() methods
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test3() {
    try {
      HashTableSortedSets<String, String> testTable = new HashTableSortedSets<String, String>();
      testTable.add("Larry", "Tiger");
      testTable.add("Johnny", "Lion");
      testTable.add("Bobby", "Dog");

      if (testTable.containsKey("Larry") && testTable.containsKey("Johnny")
          && testTable.containsKey("Bobby")) {
        testTable.remove("Larry");
        if (!testTable.containsKey("Larry")) {
          testTable.clear();
          if (testTable.size() == 0 && !(testTable.containsKey("Bobby"))) {
            return true;
          }
        }
      }
      return false;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  /**
   * Tests adding keys already in table w different values and makes sure they're sorted
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test4() {
    try {
      HashTableSortedSets<String, String> testTable = new HashTableSortedSets<String, String>();
      testTable.add("Larry", "Tiger");
      testTable.add("Johnny", "Lion");
      testTable.add("Bobby", "Bear");
      
      testTable.add("Larry", "Cheetah");
      testTable.add("Johnny", "Fish");
      testTable.add("Bobby", "Dog");
      testTable.add("Bobby", "Zebra");
      
      List<String> testValue = testTable.get("Larry");
      if (testValue.get(0).equals("Cheetah") && testValue.get(1).equals("Tiger")) {
        testValue = testTable.get("Johnny");
        if (testValue.get(0).equals("Fish") && testValue.get(1).equals("Lion")) {
          testValue = testTable.get("Bobby");
          if (testValue.get(0).equals("Bear") && testValue.get(1).equals("Dog") && testValue.get(2).equals("Zebra")) {
            return true;
          }
        }
      }
      return false;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  /**
   * Tests an invalid get()
   * 
   * @return true if all tests pass, false otherwise
   */
  public static boolean test5() {
    try {
      HashTableSortedSets<String, String> testTable = new HashTableSortedSets<String, String>();
      testTable.add("Larry", "Tiger");
      try {
        testTable.get("Jerry");
      }
      catch (NoSuchElementException e1) {
        return true;
      }
      return false;
    } catch (Exception e) {
      System.out.println(e);
      return false;
    }
  }

  /**
   * Runs the main program
   * 
   * @param args
   */
  public static void main(String[] args) {
    System.out.println( test1() && test2() && test3() && test4() && test5());
  }
}
