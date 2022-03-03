public class Show implements IShow {///////////////////////////////////
  private String title;
  private int year;
  private int rating;
  private String providers;
  
  /**
   *Constructor for instances of the Show class
   *@param String title represents the title of the show
   *@param int year represents the year the show was released
   *@param int rating represents the Rotten Tomatoes rating of the show /100
   *@param String providers is a list of all streaming services that provide the show
   */
  public Show (String title, int year, int rating, String providers){
          this.title = title;
          this.year = year;
          this.rating = rating;
          this.providers = providers;
  }
  
  /**
   *Accessor for the title field of Show objects
   *@return String title
   */
  public String getTitle(){
          return title;
  }
  
  /**
   *Accessor for the year field of Show objects
   *@return int year
   */
  public int getYear(){
          return year;
  }
  
  /**
   *Accessor for the rating field of Show objects
   *@return int rating
   */
  public int getRating(){
          return rating;
  }
  
  /**
   *Finds if Show is carred by given provider
   *@param String provider representing the streaming service
   *@return true if the provider carries the show, false otherwise
   */
  public boolean isAvailableOn(String provider){
          if (providers.contains(provider)){
                  return true;
          }
          return false;
  }
  
  /**
   *Compares two Show objects by rating
   *@param Show s show being compared to
   *@return positive value if higher rated, negative if lower, 0 if equal
   */
  public int compareTo(IShow s){/////////////////////////////////////////
          if (rating > s.getRating()){
                  return 1;
          }
          if (rating < s.getRating()){
                  return -1;
          }
          return 0;
  }

}
  