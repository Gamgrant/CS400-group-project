import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
/**
 * This class tests the Show and ShowLoader classes
*/
public class DataWranglerTests{
        public static void main(String[] args) {
                System.out.println(testConstructor());
                System.out.println(testAccessors());
                System.out.println(testCompareTo());
                System.out.println(testIsAvailableOn());
                System.out.println(testShowLoader());
        }
        /**
         *Tests the constructor for instances of the Show class
         *@return true if all tests pass
         */
        public static boolean testConstructor(){
                try{
                        Show theShow = new Show ("theShow", 2022, 95, "Netflix, Hulu");
                }catch(Exception e){
                        e.printStackTrace();
                        return false;
                }
                return true;
        }
        
        /**
         *Tests accessor methods of the Show class
         *@return true if all tests pass
         */
        public static boolean testAccessors(){
                try{
                        Show theShow = new Show ("theShow", 2022, 95, "Netflix, Hulu");
                        // Testing getTitle method
                        if (!theShow.getTitle().equals("theShow")){
                                return false;
                        }
                        // Testing getYear method
                        if (theShow.getYear() != 2022){
                                return false;
                        }
                        // Testing getRating method
                        if (theShow.getRating() != 95){
                                return false;
                        }
                }catch(Exception e){
                        e.printStackTrace();
                        return false;
                }
                return true;
        }
        
        /**
         *Tests the compareTo method of the Show class
         *@return true if all tests pass
         */
        public static boolean testCompareTo(){
                try{
                        Show theShow = new Show ("theShow", 2022, 95, "Netflix, Hulu");
                        Show theOtherShow = new Show ("theOtherShow", 2021, 54, "Amazon Prime");
                        Show theShow2 = theShow;
                        Show theBestShow = new Show ("theBest", 2016, 100, "Netflix");
                        // Testing compared to a lower rated show
                        if (theShow.compareTo(theOtherShow) != 1){
                                return false;
                        }
                        // Testing compared to an equally rated show
                        if (theShow.compareTo(theShow2) != 0){
                                return false;
                        }
                        // Testing compared to a higher rated show
                        if (theShow.compareTo(theBestShow) != -1){
                                return false;
                        }
                }catch(Exception e){
                        e.printStackTrace();
                        return false;
                }
                return true;
        }
        
        /**
         *Tests the isAvailableOn method of the Show class
         **return true if all tests pass
         */
        public static boolean testIsAvailableOn(){
                try{
                        Show theShow = new Show ("theShow", 2022, 95, "Netflix, Hulu");
                        Show theOtherShow = new Show ("theOtherShow", 2021, 54, "Amazon Prime");
                        // Testing when the show is available on the provider
                        if(!theOtherShow.isAvailableOn("Amazon Prime")){
                                return false;
                        }
                        // Testing with a show that has multiple providers
                        if (!theShow.isAvailableOn("Netflix")){
                                return false;
                        }
                        if (!theShow.isAvailableOn("Hulu")){
                                return false;
                        }
                        // Testing when the show is not available on the provider
                        if (theOtherShow.isAvailableOn("Netflix")){
                                return false;
                        }
                }catch(Exception e){
                        e.printStackTrace();
                        return false;
                }
                return true;
        }
        
        /**
         *Tests the ShowLoader class
         *@return true if all tests pass
         */
        public static boolean testShowLoader(){
                // Tests if correct error is thrown for a nonexistent file
                try{
                        List<Show> showList = ShowLoader.loadShows("nonexistent.csv");
                        return false;
                }catch (FileNotFoundException e){
                }
                try{
                        List<Show> showList = ShowLoader.loadShows("tv_shows.csv");
                        // Test if correct title is passed to Show object constructor
                        if (!showList.get(2).getTitle().equals("Attack on Titan")){
                                return false;
                        }
                        // Testing if correct year is passed to Show object constructor
                        if (showList.get(2).getYear() != 2013){
                                return false;
                        }
                        // Testing if correct rating is passed to Show object constructor
                        if(showList.get(2).getRating() != 95){
                                return false;
                        }
                        // Testing if correct providers were passed to Show object constructor
                        if (!showList.get(2).isAvailableOn("Netflix")){
                                return false;
                        }
                // This test should not throw a FileNotFoundException
                }catch (FileNotFoundException e){
                        e.printStackTrace();
                        return false;
                }catch (Exception ex){
                        ex.printStackTrace();
                        return false;
                }
                return true;
        }
}
        
        
         
        
        
        
        
        
