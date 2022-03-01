// --== CS400 Project One File Header ==--
// Name: <Jake Christensen>
// CSL Username: <Jakec>
// Email: <Jrchristens2@wisc.edu>
// Lecture #: <001 @11:00am, 002 @1:00pm, 004 @4:00pm>
// Notes to Grader: <any optional extra notes to your grader>

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.sql.SQLOutput;
import java.util.*;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

/**
 * This class makes use of an implementation of an IShowSearcherBackend
 * placeholder object.
 *
 * Additionally, this class serves as a main purpose
 * for providing a console-based textual user interface for the Show Searcher App.
 */
public class ShowSearcherFrontend implements IShowSearcherFrontend {



    private ShowSearcherBackend INFO;
    private Integer YEARINPUT;
    private String TITLEINPUT;
    private String FILTERINPUT;
    private String DETAIl;
    private String OUT;
    private Scanner scan = new Scanner(System.in); //scanner

    ByteArrayOutputStream OUTPUT;
    InputStream systemIn;
    PrintStream systemOut;
    PrintStream systemErr;


    protected String selection;
    protected List listOfShows;


    /**
     * Constructor that passes IShowSearcherBackend as well as reads the user input.
     * @param IShow
     */
    public ShowSearcherFrontend(IShowSearcherBackend IShow){

        this.INFO = INFO;
        runCommandLoop(); //loop for specified commands

    }


    /**
     * Reads input from String.
     * @param testShow
     * @param IShowSearcherBackend
     */
    public ShowSearcherFrontend(String testShow, IShow IShowSearcherBackend){

        this.INFO = INFO; //backend object

        systemIn = System.in; //Takes the systems input
        systemOut = System.out; //Displays the systems output
        systemErr = System.err; //Will display the error output




        System.setIn(new ByteArrayInputStream(testShow.getBytes())); //assigns the standard input stream in byte format
        System.setOut(new PrintStream(OUTPUT = new ByteArrayOutputStream())); // output stream
        runCommandLoop(); //runs the command loop

    }





    @Override
    /**
     * This method drives the entire read, eval, print loop (repl) for the
     * Show Search App.
     *
     * This loop will continue to run until the user
     * explicitly enters the quit command.
     */
    public void runCommandLoop() {


        //Displays the interface
        System.out.println("Welcome to the Show Searcher App!");
        System.out.print("=================================\n\n");
        displayCommandMenu(); //displays the command menu

        //uses a while loop that takes in the users input and sees if the input matches one of the commands on the
        //command prompt
        while (scan.hasNext()) {

            selection = "" + scan.nextLine(); //takes in the users input

            //If the users input == 1 or t then it will provide the user a prompt to
            //choose a word that they would like to search for
            if (selection.equals("1") || selection.equals("t") || selection.equals("T") ||
                    selection.equals("title") || selection.equals("Title")) {
                System.out.println("Choose a word that you would like to search for: ");

                //takes in the users input for the title they would like to search
                TITLEINPUT = scan.nextLine();
                try {
                    titleSearch();
                } catch (Exception e) {
                    System.out.println("Found " + 0 + "/" + INFO.getNumberOfShows() + " matches");
                }
                displayCommandMenu();
            }


            //If the selection == 3 or F than it will provide the user with a list of providers
            //It will also then display the filter helper and go through the list of options for shows
            if (selection.equals("3") || selection.equals("f") || selection.equals("F") ||
                    selection.equals("filter") || selection.equals("Filter")) {
                System.out.println("Providers that shows are being searched for: ");
                filterHELPER(); //calls filter helper to display providers more conveniently

                //takes in the users next input and see's what selection they'll make
                while (scan.hasNext()) {

                    FILTERINPUT = "" + scan.nextLine().toLowerCase();

                    if (FILTERINPUT.equals("n") || FILTERINPUT.equals("1")) {
                        INFO.toggleProviderFilter("Netflix"); //backend method to toggle through methods
                        filterHELPER();
                    } else if (FILTERINPUT.equals("h") || FILTERINPUT.equals("2")) {
                        INFO.toggleProviderFilter("Hulu");
                        filterHELPER();
                    } else if (FILTERINPUT.equals("p") || FILTERINPUT.equals("3")) {
                        INFO.toggleProviderFilter("Prime Video");
                        filterHELPER();
                    } else if (FILTERINPUT.equals("d") || FILTERINPUT.equals("4")) {
                        INFO.toggleProviderFilter("Disney Plus");
                        filterHELPER();
                    }
                }

            }


            //if the users input == 2 or Y then it will search the year and ask them to search for which year they're
            //looking for
            if (selection.equals("2") || selection.equals("y") || selection.equals("Y") ||
                    selection.equals("year") || selection.equals("Year")) {
                System.out.println("Choose a year that you would like to search for: ");

            try {
                YEARINPUT = scan.nextInt();
                yearSearch();
                if (INFO.searchByYear(YEARINPUT).size() == 0) {
                    System.out.println("Found " + 0 + "/ " + INFO.getNumberOfShows() + " matches");
                }

            } catch (NoSuchElementException e) {
                System.out.println("Found " + 0 + "/" + INFO.getNumberOfShows() + " matches");
            }
            displayCommandMenu();
        }


            //If the selection is 4 or quit then the interface will close
            if (selection.equals("4") || selection.equals("q") || selection.equals("Q") ||
                    selection.equals("quit") || selection.equals("Quit")) {

                System.out.println("Are you sure you would like to quit? (Y/N)");


                String newSelection = scan.nextLine();

                if (newSelection.equals("Y") || newSelection.equals("y")) {
                    System.exit(0); //exits the program
                } else if (newSelection.equals("N") || newSelection.equals("n")) {
                    displayCommandMenu();
                }
            }

        }
    }




    @Override
    /**
     * Uses print statements to display the command menu to the users output.
     */
    public void displayCommandMenu() {


        System.out.println("Command Menu: ");
        System.out.println("\t\t1) Search by [T]itle Word");
        System.out.println("\t\t2) Search by [Y]ear First Produced");
        System.out.println("\t\t3) [F]ilter by Streaming Provider");
        System.out.println("\t\t4) [Q]uit\n");
        System.out.print("Choose a command from the menu above: ");

    }

    @Override
    /**
     * This method will display a list of shows
     */
    public void displayShows(List<IShow> shows) {
        int i = 1;
        System.out.println("Found " + shows.size() + "/" + INFO.getNumberOfShows() + "matches.");
        for(IShow show: shows) {

            DETAIl = "";
            DETAIl += (i + ". " + show.getTitle() + "\n");
            DETAIl += ("\t\t" + show.getRating() + "/100 (" + show.getYear() + ") on:");

            if (show.isAvailableOn("Netflix")){
                DETAIl += "Netflix, ";}
            else if (show.isAvailableOn("Hulu")){
                DETAIl += "Hulu, ";}
            else if (show.isAvailableOn("Prime Video")){
                DETAIl += "Prime Video, ";}
            else if (show.isAvailableOn("Disney Plus")) {
                DETAIl += "Disney+, ";
            }

            DETAIl = DETAIl.substring(0, DETAIl.length() - 2);
            DETAIl += "\n";
            System.out.println(DETAIl);
            i++;
    }
        

    }

    /**
     * Filter helper method that will aid the process of displaying viable options when letting the user
     * select a provider.
     */
    public void filterHELPER(){

        String NETFLIX;
        String HULU;
        String PRIMEVIDEO;
        String DISNEY;


        if(INFO.getProviderFilter("Netflix")){
            NETFLIX = "X";
        } else {
            NETFLIX = "_";
        }

        if(INFO.getProviderFilter("Hulu")){
            HULU = "X";
        } else {
            HULU = "_";
        }

        if(INFO.getProviderFilter("Prime Video")){
            PRIMEVIDEO = "X";
        } else {
            PRIMEVIDEO = "_";
        }
        if(INFO.getProviderFilter("Disney Plus")){
            DISNEY = "X";
        } else {
            DISNEY = "_";
        }

        System.out.println("\t\t1) _" + NETFLIX + "_ [N]etflix");
        System.out.println("\t\t2) _" + HULU + "_ [H]ulu");
        System.out.println("\t\t3) _" + PRIMEVIDEO + "_ [P]rime Video");
        System.out.println("\t\t4) _" + DISNEY + "_ [D]isney");
        System.out.println("\t\t5) [Q]uit toggling provider filters");
        System.out.println("\t\t6) Choose a command from the following above: ");
    }

    /**
     * Helper method to aid the process of displaying proper output from the frontend interface
     * @return
     */
    public String outputHelper(){

        try {
            OUT = systemErr.toString() + systemOut.toString();
            return OUT;
        } finally {

            System.err.close();
            System.setIn(systemIn);
            System.setOut(systemOut);

        }


    }

    @Override
    /**
     * Reads word from System.in, displays results
     */
    public void titleSearch() {

        this.TITLEINPUT = TITLEINPUT;
        displayShows(INFO.searchByTitleWord(TITLEINPUT));

    }

    @Override
    /**
     * Reads year from System.in, displays results
     */
    public void yearSearch() {

        this.YEARINPUT = YEARINPUT;
        displayShows(INFO.searchByYear(YEARINPUT));

    }



    public static void main(String args[]){

        ShowSearcherFrontend show = new ShowSearcherFrontend((IShowSearcherBackend) null);



    }
}
