import java.util.*;
import java.util.HashMap;

public class ShowSearcherBackend implements IShowSearcherBackend {

  private IHashTableSortedSets<Integer, IShow> hashYear;
  private IHashTableSortedSets<String, IShow> hashTitle;
  private static int numberOfShows = 0;
  // need 4 boolean vars for toggle shows
  private boolean prime;
  private boolean netflix;
  private boolean disney;
  private boolean hulu;


  public ShowSearcherBackend() {
    // create 2 hash tables: one with year of the show as a key
    // and the other with the show title as a key
    this.hashYear = new HashTableSortedSets<Integer, IShow>();
    this.hashTitle = new HashTableSortedSets<String, IShow>();

    // by default, set the filter includes all the providers
    this.prime = true;
    this.netflix = true;
    this.disney = true;
    this.hulu = true;
  }



  @Override
  public void addShow(Show show) {
    // add show to hashYear hash table
    int year = show.getYear();
    hashYear.add(year, show);

    // add show to hashTitle hash table
    String showTitle = show.getTitle();
    String[] wordsInTitle = showTitle.split(" ");
    for (int i = 0; i < wordsInTitle.length; i++) {
      hashTitle.add(wordsInTitle[i].trim(), show);
    }
    numberOfShows++;
  }

  @Override
  public int getNumberOfShows() {
    return numberOfShows;
  }



  @Override
  public List<IShow> searchByTitleWord(String word) {
    try {
      List<IShow> unfilteredShowsByTitle = hashTitle.get(word);
      return Filter(unfilteredShowsByTitle);
    } catch (NoSuchElementException e) {
      // just return an empty list if the provided word is not in any of the titles 
      return (new ArrayList<>());
    }
  }

  @Override
  public List<IShow> searchByYear(int year) {
    try {
      List<IShow> unfilteredShowsByYear = hashYear.get(year);
      return Filter(unfilteredShowsByYear);
    } catch (NoSuchElementException e) {
      // just return an empty list if the provided year does not present in the hashYear hash table
      return (new ArrayList<>());
    }
  }

  private List<IShow> Filter (List<IShow> shows) {
    // put the providers in the list
    List<String> ProvidersAvailable = new LinkedList<String>();

    // create a list of filtered shows by provider, which will be returned
    List<IShow> filteredShows = new LinkedList<IShow>();

    // check the status of each provider: if the toggle is set to true, then add that provider
    // to the list of the ProvidersAvailable
    if (this.prime == true) {
      ProvidersAvailable.add("Prime Video");
    }
    if (this.netflix == true) {
      ProvidersAvailable.add("Netflix");
    }
    if (this.disney == true) {
      ProvidersAvailable.add("Disney+");
    }
    if (this.hulu == true) {
      ProvidersAvailable.add("Hulu");
    }

    // filter the shows by checking the providers
    // iterate through the list of shows
    for (IShow show : shows) {
      // iterate through the list of providers
      for (String provider : ProvidersAvailable) {
        if (show.isAvailableOn(provider)) {
          filteredShows.add(show);
          // must exit from the inner loop if the show is added to the list
          // to avoid the duplicate values
          break;
        }
      }
    }
    return filteredShows;
  }



  @Override
  public void setProviderFilter(String provider, boolean filter) {
    if (provider.equals("Prime Video")) {
      this.prime = filter;
    }

    if (provider.equals("Netflix")) {
      this.netflix = filter;
    }

    if (provider.equals("Disney+")) {
      this.disney = filter;
    }

    if (provider.equals("Hulu")) {
      this.hulu = filter;
    }
  }

  @Override
  public boolean getProviderFilter(String provider) {
    if ((provider.equals("Prime Video")) && (this.prime == true)) {
      return true;
    }
    if ((provider.equals("Netflix")) && (this.netflix == true)) {
      return true;
    }
    if ((provider.equals("Disney+")) && (this.disney == true)) {
      return true;
    }
    if ((provider.equals("Hulu")) && (this.hulu == true)) {
      return true;
    }
    return false;
  }


  // change the boolean of the provider
  @Override
  public void toggleProviderFilter(String provider) {

    if (provider.equals("Prime Video")) {
      this.prime = !this.prime;
    }

    if (provider.equals("Netflix")) {
      this.netflix = !this.netflix;
    }

    if (provider.equals("Disney+")) {
      this.disney = !this.disney;
    }

    if (provider.equals("Hulu")) {
      this.hulu = !this.hulu;
    }
  }
}
