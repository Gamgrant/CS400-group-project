// --== CS400 Project One File Header ==--
// Name: <Jake Christensen>
// CSL Username: <Jakec>
// Email: <Jrchristens2@wisc.edu>
// Lecture #: <001 @11:00am, 002 @1:00pm, 004 @4:00pm>
// Notes to Grader: <any optional extra notes to your grader>
/**
 * This class serves as a tester that uses 5 test methods
 * evaluates the effectiveness of the ShowSearcherFrontend class
 * and will return true if the code being tested behaves correctly
 * in regard to the hard-coded placeholder classes, else false when a bug
 * has occurred.
 *
 */
public class FrontEndDeveloperTests {


    /**
     * Will test title search and its effectiveness
     *
     * @returns true if it works properly, else it will return false.
     */
    public static boolean test1() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();//create a backend obj to test

            Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
            Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
            Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
            Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);


            ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT); //creating a frontend object (with all its
            //methods to test the implementation of the backend)
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!")) {
            } else {
                System.out.println("The test has failed");
                return false;
            }

        } catch (Exception e) {
            return false;
        }
        try {

            ShowSearcherBackend OBJECT = new ShowSearcherBackend();
            Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
            Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
            Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
            Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);


            ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT); //creating a frontend object (with all its
            //methods to test the implementation of the backend)
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("The Cat") || OUTPUT.startsWith("The Dog") || OUTPUT.startsWith("The Zebra") ||
                    OUTPUT.startsWith("The IDK")) {
            } else {
                System.out.println("The test has passed");
                OUTPUT.contains("Found 1/5 matches.");

                return true;
            }

        } catch (Exception e) {
            return false;
        }

        System.out.println("The test passed!");
        return true;
    }


    /**
     * Tests different shows
     *
     * @return true if method works as expected; Else return false.
     */
    public static boolean test2() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend(); //create a backend obj to test
            Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
            Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
            Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
            Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);


            ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT); //creating a frontend object (with all its
            //methods to test the implementation of the backend)
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!") && OUTPUT.contains("Found 0/5 matches.")) {
            } else {
                System.out.println("The test has failed");
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend(); //create a backend obj to test
            Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
            Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
            Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
            Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);


            ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT);
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!") && OUTPUT.contains("Found 3/5 matches.")
                    && OUTPUT.contains("1. The BoI") && OUTPUT.contains("2. The Zebra") && OUTPUT.contains("The Dog")) {
            } else {
                System.out.println("The test has failed");
                return false;
            }

        } catch (Exception e) {
            return false;
        }

        System.out.println("The test passed!");
        return true;
    }

    /**
     * Tests command menu and it's properties.
     *
     * @return true if method works as expected; Else return false.
     */
    public static boolean test3() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend(); //create a backend obj to test
            Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
            Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
            Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
            Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);


            ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT);
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!")
                    && OUTPUT.contains("=================================\n\n")
                    && OUTPUT.contains("Command Menu:")
                    && OUTPUT.contains("\t\t1) Search by [T]itle Word")
                    && OUTPUT.contains("\t\t2) Search by [Y]ear First Produced")
                    && OUTPUT.contains("\t\t3) [F]ilter by Streaming Provider")
                    && OUTPUT.contains("\t\t4) [Q]uit\n")
                    && OUTPUT.contains("Choose a command from the menu above: ")) {
            } else {
                System.out.println("The Test has failed");
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        System.out.println("The test passed!");
        return true;
    }

    /**
     * Tests filters and it's properties.
     *
     * @return true if method works as expected; Else return false.
     */
    public static boolean test4() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();//create a backend obj to test

            Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
            Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
            Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
            Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);


            ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT);
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!")
                    && OUTPUT.contains("=================================\n\n")
                    && OUTPUT.contains("Command Menu:")
                    && OUTPUT.contains("\t\t1) _ [N]etflix")
                    && OUTPUT.contains("\t\t2) _ [H]ulu")
                    && OUTPUT.contains("\t\t3) _ [P]rime Video")
                    && OUTPUT.contains("\t\t3) _ [D]isney +")
                    && OUTPUT.contains("\t\t4) [Q]uit\n")
                    && OUTPUT.contains("Found 0 matches.")) {


            } else {
                System.out.println("The test has failed");
                return false;
            }
        } catch (Exception e) {
            return false;
        }

        System.out.println("The test passed!");
        return true;
    }

    /**
     * Tests filters, years and ratings.
     *
     * @return true if method works as expected; Else return false.
     */
    public static boolean test5() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();//create a backend obj to test


            //create 4 new shows to test by using the show class
            Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
            Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
            Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
            Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");

            //use the backend object to add the 4 shows
            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);


            ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT); //creating a frontend object (with all its
            //methods to test the implementation of the backend)

            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!")
                    && OUTPUT.contains("=================================\n\n")
                    && OUTPUT.contains("5. The Rascal")
                    && OUTPUT.contains("89/100 (2022) on Netflix, Prime Vide")) {

            } else {
                System.out.println("The test has failed");
                return false;
            }

        } catch (Exception e) {
        }

        System.out.println("The test passed!");
        return true;
    }

    /**
     * Testing frontend command prompt and run command along with Backend implementations and Data Wrangler.
     * Test looks to see that when the user enters a specific show or year they will be prompted with the correct
     * show and if not will return false.
     *
     * @return true if method works as expected; Else return false.
     */
    public static boolean integrationTest1() {

        ShowSearcherBackend BACKOBJECT = new ShowSearcherBackend(); //create a backend obj to test
        //ShowSearcherFrontend userInput = null;

        Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
        Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
        Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
        Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");

        BACKOBJECT.addShow(SHOW1);
        BACKOBJECT.addShow(SHOW2);
        BACKOBJECT.addShow(SHOW3);
        BACKOBJECT.addShow(SHOW4);

        ShowSearcherFrontend test = new ShowSearcherFrontend(BACKOBJECT);//creating a frontend object (with all its
        //methods to test the implementation of the backend)
        String OUTPUT = test.outputHelper();


        if (OUTPUT.startsWith("Breaking Bad") || OUTPUT.startsWith("Stranger Things")
                || OUTPUT.startsWith("Black Mirror") || OUTPUT.contains("2008")
                || OUTPUT.contains("2016") || OUTPUT.contains("2011")
                || OUTPUT.contains("2001") || OUTPUT.contains("2000")) {
        } else {
            System.out.println("The test has failed");
            return false;
        }

        System.out.println("The test passed!");
        return true;
    }



        /**
         * Testing frontend code along with backend and IShow/IShowHelper by creating new shows and seeing if the methods
         * implemented by the backend role work properly when a user searches a specific show name and if the method works
         * improperly this test will then return false.
         *
         * @return true ~ if methods from IShow/IShowHelper/Backend work properly
         * @return false ~ iff methods fail
         */
        public static boolean integrationTest2() {
            try {
                ShowSearcherBackend OBJECT = new ShowSearcherBackend(); //create a backend obj to test
                Show SHOW1 = new Show("The Cat", 2001, 45, "Disney+");
                Show SHOW2 = new Show("The Dog", 2010, 90, "Hulu");
                Show SHOW3 = new Show("The Zebra", 2016, 88, "Netflix");
                Show SHOW4 = new Show("The IDK", 2000, 99, "Netflix");


                OBJECT.addShow(SHOW1);
                OBJECT.addShow(SHOW2);
                OBJECT.addShow(SHOW3);
                OBJECT.addShow(SHOW4);


                ShowSearcherFrontend test = new ShowSearcherFrontend(OBJECT); //creating a frontend object (with all its
                //methods to test the implementation of the backend)
                String OUTPUT = test.outputHelper();


                if (OUTPUT.equals("2001") || OUTPUT.equals("2010") ||
                        OUTPUT.equals("2016") || OUTPUT.equals("2000")) {
                    return true;

                } else if (!OUTPUT.equals("2001") || OUTPUT.equals("2010") ||
                        OUTPUT.equals("2016") || OUTPUT.equals("2000")){
                    System.out.println("The test has failed");
                    return false;


                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            System.out.println("The test passed!");
            return false;
        }

    /**
     * (Teams of 2 Test) ~ Frontend testing the effectiveness of Backend
     *
     * Review code for the backend developer and testing its effectiveness to see that the methods from the backend
     * properly function
     *
     * @return true if method works as expected; Else return false.
     */
    public static boolean integrationTest3() {

            ShowSearcherBackend BACKENDOBJ = new ShowSearcherBackend(); //create a backend obj to test

         Show show1 = new Show("The Cat", 2020, 99, "Disney+");
         Show show2 = new Show("The Dog", 2015, 45, "Hulu");
         Show show3 = new Show("The Zebra", 2013, 78, "Netflix");

         BACKENDOBJ.addShow(show1);
         BACKENDOBJ.addShow(show2);
         BACKENDOBJ.addShow(show3);

         if (BACKENDOBJ.searchByTitleWord("Cat").size() != 1) {
             return false;
         }

         if (!BACKENDOBJ.searchByTitleWord("Dog").get(0).equals(show3)) {
             return false;
         }

        System.out.println("The test passed!");
         return true;
     }

    /**
     * (Teams of 2 Test) ~ Frontend testing the effectiveness of Backend
     *
     * Review code for the backend developer and testing its effectiveness to see that the methods from the backend
     * properly function
     *
     * @return true if method works as expected; Else return false.
     */
    public static boolean integrationTest4() {
        ShowSearcherBackend BACKENDOBJ = new ShowSearcherBackend(); //create a backend obj to test

        Show show1 = new Show("The Cat", 2020, 99, "Disney+");
        Show show2 = new Show("The Dog", 2015, 45, "Hulu");
        Show show3 = new Show("The Zebra", 2013, 78, "Netflix");

        BACKENDOBJ.addShow(show1);
        BACKENDOBJ.addShow(show2);
        BACKENDOBJ.addShow(show3);

        if (BACKENDOBJ.searchByYear(2020).size() != 2) {
            return false;
        }
        // now set Netflix as the only provider
        BACKENDOBJ.setProviderFilter("Disney+", false);
        BACKENDOBJ.setProviderFilter("Hulu", false);
        BACKENDOBJ.setProviderFilter("Prime Video", false);
        BACKENDOBJ.setProviderFilter("Netflix", true);


        if (BACKENDOBJ.searchByYear(2020).size() != 1) {
            return false;
        }

        System.out.println("The test passed!");
        return true;
    }




    public static void main(String args[]){
        System.out.println("Test1: " + test1());
        //System.out.println("Test2: " + test2());
        //System.out.println("Test3: " + test3());
        //System.out.println("Test4: " + test4());
        //System.out.println("Test5: " + test5());
        //System.out.println("Integration Test 1: " + integrationTest1());
        //System.out.println("Integration Test 2: " + integrationTest2());

    }
}
