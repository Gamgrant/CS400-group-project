import java.util.HashMap; 
import java.util.LinkedList;
import java.util.List;

public class ShowSearcherBackendTester {
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

  // by default all of the providers are set to true;
  
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



  public static boolean test3() {

    ShowSearcherBackend Empty_Backend = new ShowSearcherBackend();
    ShowSearcherBackend Empty_Backend2 = new ShowSearcherBackend();

    Empty_Backend.setProviderFilter("Netflix", true);
    Empty_Backend2.setProviderFilter("Amazon", true);

    if (Empty_Backend.getProviderFilter("Netflix") != true) {
      return false;
    }

    if (Empty_Backend2.getProviderFilter("Netflix") == true) {
      return false;
    }

    return true;
  }
  /*

  public static boolean test4() {
    ShowSearcherBackend Empty_Backend = new ShowSearcherBackend();
    ShowSearcherBackend Empty_Backend2 = new ShowSearcherBackend();
    return true;
  }

  public static boolean test5() {

    IHashTableSortedSetsImpl<Integer, IShow> HashMapForYears =
        new IHashTableSortedSetsImpl<Integer, IShow>();
    IHashTableSortedSetsImpl<String, IShow> HashMapForTitle =
        new IHashTableSortedSetsImpl<String, IShow>();

    IShowImpl show4 = new IShowImpl("How I have met your mom", 2022, 870, "Prime Video");
    IShowImpl show5 = new IShowImpl("Title1", 2030, 87, "Disney+");

    HashMapForYears.put(show4.getYear(), show4);
    HashMapForTitle.put(show4.getTitle(), show4);


    if (!HashMapForYears.containsKey(2022)) {
      return false;
    }

    if (!HashMapForTitle.containsKey("How I have met your mom")) {
      return false;
    }
    return true;
    }
    */
  


  public static void main(String[] args) {
    System.out.println(test1());
    System.out.println(test2());
    //System.out.println(test3());
    //System.out.println(test4());
    //System.out.println(test5());
  }
}
