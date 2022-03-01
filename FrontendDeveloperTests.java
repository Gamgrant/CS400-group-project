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

    private ShowSearcherBackend OBJECT;

    /**
     * Will test title search and its effectiveness
     *
     * @returns true if it works properly, else it will return false
     */
    public static boolean test1() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();
            IShowHelper SHOW1 = new IShowHelper("The Cat", 1952, 89, "", false, true, true, true);
            IShowHelper SHOW2 = new IShowHelper("The Dog", 1952, 89, "", true, false, true, false);
            IShowHelper SHOW3 = new IShowHelper("The Zebra", 1952, 89, "", false, false, true, true);
            IShowHelper SHOW4 = new IShowHelper("The IDK", 1952, 89, "", true, false, true, false);
            IShowHelper SHOW5 = new IShowHelper("The Rascal", 1952, 89, "", true, false, true, false);
            IShowHelper SHOW6 = new IShowHelper("The BoI", 1952, 89, "", false, false, true, true);
            IShowHelper SHOW7 = new IShowHelper("The Sheesh", 1952, 89, "", true, false, true, false);

            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);
            OBJECT.addShow(SHOW5);
            OBJECT.addShow(SHOW6);
            OBJECT.addShow(SHOW7);

            ShowSearcherFrontend test = new ShowSearcherFrontend("3\n1\n2\n3\n4\n5\n6\n7\n1\nShow\nq\n", (IShow) OBJECT);
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
            IShowHelper SHOW1 = new IShowHelper("The Cat", 1952, 84, "", false, true, true, true);
            IShowHelper SHOW2 = new IShowHelper("The Dog", 2002, 95, "", true, false, true, false);
            IShowHelper SHOW3 = new IShowHelper("The Zebra", 2011, 78, "", false, false, true, true);
            IShowHelper SHOW4 = new IShowHelper("The IDK", 2005, 80, "", true, false, true, false);
            IShowHelper SHOW5 = new IShowHelper("The Rascal", 2019, 98, "", true, false, true, false);
            IShowHelper SHOW6 = new IShowHelper("The BoI", 2020, 47, "", false, false, true, true);
            IShowHelper SHOW7 = new IShowHelper("The Sheesh", 2022, 89, "", true, false, true, false);

            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);
            OBJECT.addShow(SHOW5);
            OBJECT.addShow(SHOW6);
            OBJECT.addShow(SHOW7);

            ShowSearcherFrontend test = new ShowSearcherFrontend("3\n1\nShow\nq\n", (IShow) OBJECT);
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!")) {
            } else {
                System.out.println("The test has failed");
                OUTPUT.contains("Found 1/5 matches.");

                return false;
            }

        } catch (Exception e) {
            return false;
        }

        return true;
    }


    /**
     * Tests different shows
     * @return
     */
    public static boolean test2() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();
            IShowHelper SHOW1 = new IShowHelper("The Cat", 1952, 84, "", false, true, true, true);
            IShowHelper SHOW2 = new IShowHelper("The Dog", 2002, 95, "", true, false, true, false);
            IShowHelper SHOW3 = new IShowHelper("The Zebra", 2011, 78, "", false, false, true, true);
            IShowHelper SHOW4 = new IShowHelper("The IDK", 2005, 80, "", true, false, true, false);
            IShowHelper SHOW5 = new IShowHelper("The Rascal", 2019, 98, "", true, false, true, false);
            IShowHelper SHOW6 = new IShowHelper("The BoI", 2020, 47, "", false, false, true, true);
            IShowHelper SHOW7 = new IShowHelper("The Sheesh", 2022, 89, "", true, false, true, false);

            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);
            OBJECT.addShow(SHOW5);
            OBJECT.addShow(SHOW6);
            OBJECT.addShow(SHOW7);

            ShowSearcherFrontend test = new ShowSearcherFrontend("nShow\nq\n", (IShow) OBJECT);
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
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();
            IShowHelper SHOW1 = new IShowHelper("The Cat", 1952, 84, "", false, true, true, true);
            IShowHelper SHOW2 = new IShowHelper("The Dog", 2002, 95, "", true, false, true, false);
            IShowHelper SHOW3 = new IShowHelper("The Zebra", 2011, 78, "", false, false, true, true);
            IShowHelper SHOW4 = new IShowHelper("The IDK", 2005, 80, "", true, false, true, false);
            IShowHelper SHOW5 = new IShowHelper("The Rascal", 2019, 98, "", true, false, true, false);
            IShowHelper SHOW6 = new IShowHelper("The BoI", 2020, 47, "", false, false, true, true);
            IShowHelper SHOW7 = new IShowHelper("The Sheesh", 2022, 89, "", true, false, true, false);

            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);
            OBJECT.addShow(SHOW5);
            OBJECT.addShow(SHOW6);
            OBJECT.addShow(SHOW7);

            ShowSearcherFrontend test = new ShowSearcherFrontend("3\n1\n2\n3\nShow\nq\n", (IShow) OBJECT);
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

        return true;
    }

    /**
     * Tests command menu
     * @return
     */
    public static boolean test3() {
        try{
        ShowSearcherBackend OBJECT = new ShowSearcherBackend();
            IShowHelper SHOW1 = new IShowHelper("The Cat", 1952, 84, "", false, true, true, true);
            IShowHelper SHOW2 = new IShowHelper("The Dog", 2002, 95, "", true, false, true, false);
            IShowHelper SHOW3 = new IShowHelper("The Zebra", 2011, 78, "", false, false, true, true);
            IShowHelper SHOW4 = new IShowHelper("The IDK", 2005, 80, "", true, false, true, false);
            IShowHelper SHOW5 = new IShowHelper("The Rascal", 2019, 98, "", true, false, true, false);
            IShowHelper SHOW6 = new IShowHelper("The BoI", 2020, 47, "", false, false, true, true);
            IShowHelper SHOW7 = new IShowHelper("The Sheesh", 2022, 89, "", true, false, true, false);


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);
            OBJECT.addShow(SHOW5);
            OBJECT.addShow(SHOW6);
            OBJECT.addShow(SHOW7);

        ShowSearcherFrontend test = new ShowSearcherFrontend("", (IShow) OBJECT);
        String OUTPUT = test.outputHelper();

        if (OUTPUT.startsWith("Welcome to the Show Searcher App!")
                && OUTPUT.contains("=================================\n\n")
                && OUTPUT.contains("Command Menu:")
                && OUTPUT.contains("\t\t1) Search by [T]itle Word")
                && OUTPUT.contains("\t\t2) Search by [Y]ear First Produced")
                && OUTPUT.contains("\t\t3) [F]ilter by Streaming Provider")
                && OUTPUT.contains("\t\t4) [Q]uit\n")
                && OUTPUT.contains("Choose a command from the menu above: "))

    {
      }else

    {
        System.out.println("The Test has failed");
        return false;
    }
} catch (Exception e){
    return false;
        }

        return true;}

    /**
     * Tests filters
     * @return
     */
    public static boolean test4() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();
            IShowHelper SHOW1 = new IShowHelper("The Cat", 1952, 84, "", false, true, true, true);
            IShowHelper SHOW2 = new IShowHelper("The Dog", 2002, 95, "", true, false, true, false);
            IShowHelper SHOW3 = new IShowHelper("The Zebra", 2011, 78, "", false, false, true, true);
            IShowHelper SHOW4 = new IShowHelper("The IDK", 2005, 80, "", true, false, true, false);
            IShowHelper SHOW5 = new IShowHelper("The Rascal", 2019, 98, "", true, false, true, false);
            IShowHelper SHOW6 = new IShowHelper("The BoI", 2020, 47, "", false, false, true, true);
            IShowHelper SHOW7 = new IShowHelper("The Sheesh", 2022, 89, "", true, false, true, false);


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);
            OBJECT.addShow(SHOW5);
            OBJECT.addShow(SHOW6);
            OBJECT.addShow(SHOW7);

            ShowSearcherFrontend test = new ShowSearcherFrontend("", (IShow) OBJECT);
            String OUTPUT = test.outputHelper();

            if (OUTPUT.startsWith("Welcome to the Show Searcher App!")
                    && OUTPUT.contains("=================================\n\n")
                    && OUTPUT.contains("Command Menu:")
                    && OUTPUT.contains("\t\t1) _ [N]etflix")
                    && OUTPUT.contains("\t\t2) _ [H]ulu")
                    && OUTPUT.contains("\t\t3) _ [P]rime Video")
                    && OUTPUT.contains("\t\t3) _ [D]isney +")
                    && OUTPUT.contains("\t\t4) [Q]uit\n")
                    && OUTPUT.contains("Found 0 matches.")){


        }else{
            System.out.println("The test has failed");
            return false;
        }
    }catch (Exception e){
        return false;
    }
                return false;}

    /**
     * Tests filters, years and ratings.
     * @return
     */
    public static boolean test5() {
        try {
            ShowSearcherBackend OBJECT = new ShowSearcherBackend();
            IShowHelper SHOW1 = new IShowHelper("The Cat", 1952, 84, "", false, true, true, true);
            IShowHelper SHOW2 = new IShowHelper("The Dog", 2002, 95, "", true, false, true, false);
            IShowHelper SHOW3 = new IShowHelper("The Zebra", 2011, 78, "", false, false, true, true);
            IShowHelper SHOW4 = new IShowHelper("The IDK", 2005, 80, "", true, false, true, false);
            IShowHelper SHOW5 = new IShowHelper("The Rascal", 2019, 98, "", true, false, true, false);
            IShowHelper SHOW6 = new IShowHelper("The BoI", 2020, 47, "", false, false, true, true);
            IShowHelper SHOW7 = new IShowHelper("The Sheesh", 2022, 89, "", true, false, true, false);


            OBJECT.addShow(SHOW1);
            OBJECT.addShow(SHOW2);
            OBJECT.addShow(SHOW3);
            OBJECT.addShow(SHOW4);
            OBJECT.addShow(SHOW5);
            OBJECT.addShow(SHOW6);
            OBJECT.addShow(SHOW7);

            ShowSearcherFrontend test = new ShowSearcherFrontend("", (IShow) OBJECT);
            String OUTPUT = test.outputHelper();
            if (OUTPUT.startsWith("Welcome to the Show Searcher App!")
                    && OUTPUT.contains("=================================\n\n")
                    && OUTPUT.contains("5. The Rascal")
                    && OUTPUT.contains("89/100 (2022) on Netflix, Prime Vide"))
            {

            } else {
                System.out.println("The test has failed");
                return false;
            }

        } catch (Exception e){
        }
        return true;
    }

    public static void main(String args[]){
        System.out.println("Test1: " + test1());
        System.out.println("Test2: " + test2());
        System.out.println("Test3: " + test3());
        System.out.println("Test4: " + test4());
        System.out.println("Test5: " + test5());

    }

}
