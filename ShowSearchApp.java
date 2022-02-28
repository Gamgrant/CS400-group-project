import java.util.*;
import java.util.HashMap;
public class ShowSearcherApp implements IShowSearcherBackend {

  
  IHashTableSortedSets<Integer,IShow> HashTableForYear = new HashTableSortedSets<Integer, IShow>();
  IHashTableSortedSets<String,IShow> HashTableForTitle = new HashTableSortedSets<String,IShow>();
  
  private HashMap<String, Boolean> HashMapForFilter = new HashMap<String, Boolean>();
  
  private static int numberOfShows = 0;
  
  //i have word and year and two sorted hashmaps. now dolast two methods. 
  //whatever  you return must be a list 
  //boolean isAvailableOn(String provider);
//  This is a property of IShow.java
//  Use this with HashMapForFilter
//  For all providers in filtterMap
//  Check if show.isAvailable on that. Provider returns true and only then add the show. To the list that you will return 
//  

  
  
  @Override
  public void addShow(IShow show) {
    // TODO Auto-generated method stub
    numberOfShows++;
    String title = show.getTitle();
    String[] words = title.split(" ");
    for(int i = 0; i < words.length; i++) {
      HashTableForTitle.add(words[i].trim(), show);
    }
    int year = show.getYear();
    HashTableForYear.add(year, show);
  }

  @Override
  public int getNumberOfShows() {
    // TODO Auto-generated method stub
    return numberOfShows;
  }



  @Override
  public List<IShow> searchByTitleWord(String word) {
    List<IShow> shows = HashTableForTitle.get(word.toLowerCase());//type error list saying it can't add an
    
    return filterShows(shows);
  }

  @Override
  public List<IShow> searchByYear(int year) {
    List<IShow> shows = HashTableForYear.get(year);

    return filterShows(shows);
  }
  
  private List<IShow> filterShows(List<IShow> shows) {
    // Iterate through shows and return the ones for which provider filter is set to true
    List<IShow> filteredList = new LinkedList<IShow>();
    List<String> ProvidersAvailable = new LinkedList<String>();

    for(String provider: HashMapForFilter.keySet()) {
      if (HashMapForFilter.getOrDefault(provider, false)) {
        ProvidersAvailable.add(provider);
      }
    }

    for (IShow show: shows) {
      for (String provider : ProvidersAvailable) {
        if (show.isAvailableOn(provider)) {
          filteredList.add(show);
          break;
        }
      }
    }

    return filteredList;
  }
  
  
  @Override
  public void setProviderFilter(String provider, boolean filter) {
    HashMapForFilter.put(provider, filter);
  }

  @Override
  public boolean getProviderFilter(String provider) {
    return this.HashMapForFilter.getOrDefault(provider, false);
  
    
  }

  @Override
  public void toggleProviderFilter(String provider) {
    HashMapForFilter.put(provider, !HashMapForFilter.get(provider));
  }

}