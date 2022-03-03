// --== CS400 P1W4. Team App Integration ==--
// Name: Grant Ovsepyan
// CSL Username: ovsepyan
// Email: govsepyan@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: <any optional extra notes to your grader>

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ShowSearcherBackendTester {
  /*
   * This tester checks if the size of the back end object correctly increments as the shows are
   * added to a back end object returns true if method is passed, false otherwise
   */
  public static boolean test1() {

    ShowSearcherBackend backend = new ShowSearcherBackend();
    Show show1 = new Show("Title1", 2030, 87, "Disney+");
    Show show2 = new Show("Title2", 1999, 19, "Hulu");
    Show show3 = new Show("Title3", 1459, 21, "Netflix");

    backend.addShow(show1);
    backend.addShow(show2);
    backend.addShow(show3);

    if (backend.getNumberOfShows() != 3) {
      return false;
    }
    return true;
  }

  /*
   * This tester checks if the get provider correctly works. returns true if method is passed, false
   * otherwise
   */
  public static boolean test2() {
    ShowSearcherBackend backend = new ShowSearcherBackend();
    Show show1 = new Show("Title1", 2030, 87, "Disney+");
    Show show2 = new Show("Title2", 1999, 19, "Hulu");
    Show show3 = new Show("Title3", 1459, 21, "Netflix");

    backend.addShow(show1);
    backend.addShow(show2);
    backend.addShow(show3);

    if (!backend.getProviderFilter("Netflix")) {
      return false;
    }

    if (!backend.getProviderFilter("Hulu")) {
      return false;
    }
    if (!backend.getProviderFilter("Disney+")) {
      return false;
    }

    return true;
  }


  /*
   * This method checks if the setProvider can set the correct boolean value of the toggle variables
   * returns true if method is passed, false otherwise
   */
  public static boolean test3() {

    ShowSearcherBackend Empty_Backend = new ShowSearcherBackend();
    ShowSearcherBackend Empty_Backend2 = new ShowSearcherBackend();
    ShowSearcherBackend Empty_Backend4 = new ShowSearcherBackend();

    Empty_Backend.setProviderFilter("Netflix", true);
    Empty_Backend2.setProviderFilter("Prime Video", true);
    // expected to work
    if (Empty_Backend.getProviderFilter("Netflix") != true) {
      System.out.println("1");
      return false;
    }
    // expected to work
    if (Empty_Backend2.getProviderFilter("Prime Video") != true) {
      System.out.println("2");
      return false;
    }
    // not expected to work because Amazon is not in the list of the providers
    if (Empty_Backend4.getProviderFilter("Amazon") == true) {
      return false;
    }
    return true;
  }



  /*
   * This method tests if none of the shows are filtered ou tby default returns true if method is
   * passed, false otherwise
   */
  public static boolean test4() {
    ShowSearcherBackend backend = new ShowSearcherBackend();
    // by default, all the providers are set to 'true' value
    if (!backend.getProviderFilter("Netflix")) {
      return false;
    }
    if (!backend.getProviderFilter("Prime Video")) {
      return false;
    }
    if (!backend.getProviderFilter("Disney+")) {
      return false;
    }
    if (!backend.getProviderFilter("Hulu")) {
      return false;
    }

    return true;
  }

  /*
   * This method toggles all the providers, and sets all of their status variable to false returns
   * true if method is passed, false otherwise
   */
  public static boolean test5() {
    ShowSearcherBackend backend = new ShowSearcherBackend();

    backend.toggleProviderFilter("Netflix");
    backend.toggleProviderFilter("Prime Video");
    backend.toggleProviderFilter("Disney+");
    backend.toggleProviderFilter("Hulu");



    // by default, all the providers are set to 'true' value
    if (backend.getProviderFilter("Netflix")) {
      return false;
    }
    if (backend.getProviderFilter("Prime Video")) {
      return false;
    }
    if (backend.getProviderFilter("Disney+")) {
      return false;
    }
    if (backend.getProviderFilter("Hulu")) {
      return false;
    }

    return true;
  }

  /*
   * This method test the search method by year. it checks the size of the returned sorted list and
   * checks if the value inside the list actually equals to the show object. returns true if method
   * is passed, false otherwise
   */
  public static boolean test6() {
    ShowSearcherBackend backend = new ShowSearcherBackend();
    Show show1 = new Show("Title1", 2030, 87, "Disney+");
    Show show2 = new Show("Title2", 1999, 19, "Hulu");
    Show show3 = new Show("Title3", 1459, 21, "Netflix");

    backend.addShow(show1);
    backend.addShow(show2);
    backend.addShow(show3);


    if (backend.searchByYear(2030).size() != 1) {
      return false;
    }

    if (!backend.searchByYear(2030).get(0).equals(show1)) {
      return false;
    }

    return true;
  }


  /*
   * This method test the search method by Title. it checks the size of the returned sorted list and
   * checks if the value inside the list actually equals to the show object. returns true if method
   * is passed, false otherwise
   */
  public static boolean test7() {
    ShowSearcherBackend backend = new ShowSearcherBackend();
    Show show1 = new Show("Title Joe", 2030, 87, "Disney+");
    Show show2 = new Show("Title Max", 1999, 19, "Hulu");
    Show show3 = new Show("Title My Mom", 1459, 21, "Netflix");

    backend.addShow(show1);
    backend.addShow(show2);
    backend.addShow(show3);


    if (backend.searchByTitleWord("Max").size() != 1) {
      return false;
    }

    if (!backend.searchByTitleWord("Mom").get(0).equals(show3)) {
      return false;
    }

    return true;
  }


  /*
   * This method test the search method by year. it checks the size of the returned sorted list and
   * checks if the value inside the list actually equals to the show object. Then it sets the filter
   * on all the providers except for Netflix, and checks that only one show is returned after the
   * search by year with the filter on the provider is applied returns true if method is passed,
   * false otherwise
   */
  public static boolean test8() {

    ShowSearcherBackend backend = new ShowSearcherBackend();
    Show show1 = new Show("Title1", 2030, 87, "Disney+");
    Show show2 = new Show("Title2", 1192, 19, "Hulu");
    Show show3 = new Show("Title3", 2030, 21, "Netflix");

    backend.addShow(show1);
    backend.addShow(show2);
    backend.addShow(show3);


    if (backend.searchByYear(2030).size() != 2) {
      return false;
    }
    // now set Netflix as the only provider
    backend.setProviderFilter("Disney+", false);
    backend.setProviderFilter("Hulu", false);
    backend.setProviderFilter("Prime Video", false);
    backend.setProviderFilter("Netflix", true);


    if (backend.searchByYear(2030).size() != 1) {
      return false;
    }

    return true;
  }

  /*
   * This method test the search method by Title. it checks the size of the returned sorted list and
   * checks if the value inside the list actually equals to the show object. Then it apples filter
   * on the provider (enabling only Netflix) and checks the number of the listed filtered shows.
   * returns true if method is passed, false otherwise
   */
  public static boolean test9() {
    ShowSearcherBackend backend = new ShowSearcherBackend();
    Show show1 = new Show("Get rich or die trying", 2019, 87, "Hulu");
    Show show2 = new Show("Stinky Badger", 1192, 19, "Netflix");
    Show show3 = new Show("Get rich or die trying", 2030, 21, "Netflix");

    backend.addShow(show1);
    backend.addShow(show2);
    backend.addShow(show3);


    if (backend.searchByTitleWord("trying").size() != 2) {
      return false;
    }
    // now set Netflix as the only provider
    backend.setProviderFilter("Disney+", false);
    backend.setProviderFilter("Hulu", false);
    backend.setProviderFilter("Prime Video", false);
    backend.setProviderFilter("Netflix", true);


    if (backend.searchByTitleWord("trying").size() != 1) {
      return false;
    }

    return true;
  }

  /*
   * test#1. testing Front end developer's code. checks that the correct greenings are displayed on
   * the screen.
   * 
   */
  public static boolean test10() {   
    return false;
  }
  /*
   * test#2. testing Front end developer's code
   */
  public static boolean test11() {
    return false;
  }



  /*
   * This main method runs all the tests and prints the outcome of each test
   */
  public static void main(String[] args) {
    System.out.println("Test 1 passed: " + test1());
    System.out.println("Test 2 passed: " + test2());
    System.out.println("Test 3 passed: " + test3());
    System.out.println("Test 4 passed: " + test4());
    System.out.println("Test 5 passed: " + test5());
    System.out.println("Test 6 passed: " + test6());
    System.out.println("Test 7 passed: " + test7());
    System.out.println("Test 8 passed: " + test8());
    System.out.println("Test 9 passed: " + test9());
   

  }
}
