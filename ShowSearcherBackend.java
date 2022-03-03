// --== CS400 P1W4. Team App Integration ==--
// Name: Grant Ovsepyan
// CSL Username: ovsepyan
// Email: govsepyan@wisc.edu
// Lecture #: 004 @4:00pm
// Notes to Grader: <any optional extra notes to your grader>

import java.util.*;
import java.util.HashMap;

/*
 * This class sets the blueprint for the ShowSearcherBackend class. It sets the numberOfShows that
 * were added to the class; creates the hash table for the year and the title, and set up the toggle
 * variables for each provider
 */
public class ShowSearcherBackend implements IShowSearcherBackend {

  private IHashTableSortedSets<Integer, IShow> hashYear;
  private IHashTableSortedSets<String, IShow> hashTitle;
  private static int numberOfShows = 0;
  // need 4 boolean vars for toggle shows
  private boolean prime;
  private boolean netflix;
  private boolean disney;
  private boolean hulu;

  /*
   * this COnstructor creates 2 hash tables and sets all the status providers to true ( no filters
   * on the providers have been applied yet
   */
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


  /*
   * This method adds a show to each hash table. Year hash table receives only entry per movie. The
   * title is split up by a "space" delimiter, and separate entries are made for each word in the
   * title Returns nothing
   */
  @Override
  public void addShow(IShow show1) {
    // add show to hashYear hash table
    int year = show1.getYear();
    hashYear.add(year, show1);

    // add show to hashTitle hash table
    String showTitle = show1.getTitle();
    String[] wordsInTitle = showTitle.split(" ");
    for (int i = 0; i < wordsInTitle.length; i++) {
      hashTitle.add(wordsInTitle[i].trim(), show1);
    }
    numberOfShows++;
  }

  /*
   * THis method returns the number of shows that have been added to a back end object
   */
  @Override
  public int getNumberOfShows() {
    return numberOfShows;
  }


  /*
   * This method is searching the word in the title of the movies that were added to a back end
   * object. the list of the shows is returned. If no matches were found, this method will return an
   * empty array
   */
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

  /*
   * This method is searching the movies by year that were added to a back end. object. the list of
   * the shows is returned. If no matches were found, this method will return an empty array
   */
  @Override
  public List<IShow> searchByYear(int year) {
    try {
      List<IShow> unfilteredShowsByYear = hashYear.get(year);
      return Filter(unfilteredShowsByYear);
    } catch (NoSuchElementException e) {
      System.out.println(e.getMessage());
      // just return an empty list if the provided year does not present in the hashYear hash table
      return (new ArrayList<>());
    }
  }

  /*
   * This method filters the shows by the provider. It checks which providers were filtered out, and
   * adds the desired providers to a linked list. Then it checks each show, piped into the method,
   * and creates a new list of shows that has a matching provider. that list is returned at the end
   * of the method
   */
  private List<IShow> Filter(List<IShow> shows) {
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


  /*
   * THis method sets the status of the provider t either true or false
   */
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


  /*
   * This method returns true if the specified provider is not filtered out by the user returns true
   * if the specified provider is on, false otherwise
   */
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


  /*
   * This method changes the status of the provider to the opposite boolean value
   */

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
