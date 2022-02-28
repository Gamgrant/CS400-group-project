import java.util.List;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

/**
 *Class loads show data from a .csv file into a list Show objects
 */
public class ShowLoader {
        /**
         *Loads file date into a List of Shows
         *@param String filepath the file being read and loaded
         *@return List of Show objects
         */
        public static List<Show> loadShows(String filepath) throws FileNotFoundException {
                List<Show> showList = new ArrayList<Show>();
                Scanner scan = new Scanner(new File(filepath));
                scan.useDelimiter(",");
                
                // Move past header
                scan.nextLine();
                
                // Loop runs until it reaches the end of the list of shows
                while (scan.hasNextLine()) {
                        String providers = "";
                        String[] values;
                        //Converts line of data in the file to a String value   
                        String line = scan.nextLine();
                        int count = 0;
                        
                        // Splits the data seperated by commas into an array
                        values = line.split(",");
                        
                        // Runs only if there is a quotation present in the line
                        if (line.contains("\"")){
                        
                                // Rejoins title seperated due to commas
                                int quoteIndex = line.indexOf("\"");
                                String quotes = line.substring(quoteIndex, line.indexOf("\"", quoteIndex + 1) + 1);
 
                                values[2] = quotes;
                                
                                // Counts number of commas in the quoted String
                                for (int i = 0; i < quotes.length(); i++){
                                        if (quotes.charAt(i) == ','){
                                                count ++;
                                        }
                                }
                                
                                // Uses number of commas to return all data values to proper indices
                                
                                for (int i = 3 + count; i < values.length; i++){
                                        values[i - count] = values[i];
                                }
                        }
                        
                        // Converts binary provider values into a String representation
                        if (values[7].equals("1")){
                                providers = "Netflix, ";
                        }
                        
                        if (values[8].equals("1")){
                                providers = providers + "Hulu, ";
                        }
                        
                        if (values[9].equals("1")){
                                providers = providers + "Amazon Prime, ";
                        }
                        
                        if (values[10].equals("1")){
                                providers = providers + "Disney +, ";
                        }
                        
                        // Adds new Show value with provided parameters to the list
                        showList.add(new Show(values[2], Integer.valueOf(values[3]), Integer.valueOf(values[6].subs
tring(0, values[6].length() - 4)), providers));
                }
                return showList;
        }
}
                        
                        
