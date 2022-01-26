import java.util.InputMismatchException;
import java.util.Scanner;

public class Project1 {
    public static void main ( String[] args ) {
        //follow the instructions in the comments exactly
        //do not delete the comments

        //1. WHEN DID YOU FIRST START WORKING ON THIS ASSIGNMENT (date and time):
        //ANSWER: 1/26/22 at 2:27pm

        //2. print greeting
        System.out.println("Hello");


        //3. create a scanner object - change the null to the proper call to the Scanner constructor
        Scanner keyboard = new Scanner (System.in);

        //4. ask the user where they are buying a ticket to today
        System.out.println("What is your destination?: ");

        //5. read the input in the destination variable
        String destination = keyboard.next();

        //6. remove all white space from destination
        destination = destination.replaceAll(" ", "");

        //7. make destination all lower case letters
        destination = destination.toLowerCase();

        //this is logic that checks if your destination that the Ankh-Morpork Railway travels to
        //if the destination is not valid (one of the four), it terminates the program with an error code of -1
        //do NOT change this code fragment!
        if ( !destination.equals( "stolat" ) && !destination.equals( "quirm" ) &&
                !destination.equals( "pseudopolis" ) && !destination.equals( "ueberwald" ) &&
                !destination.equals( "lancre" ) ){
            System.out.println( "Sorry, AMR doesn't travel to " + destination + " yet. Goodbye." );
            System.exit( -1 );
        }

        //8. ask the traveller which train they want to be on
        System.out.println("Which train would you like to take? enter night or day: ");

        //9. read the input in the whichTrain variable
        String whichTrain = keyboard.next();

        //10. trim the whichTrain value of leading and trailing spaces
        whichTrain = whichTrain.trim();

        //11. make whichTrain all lower case letters
        whichTrain = whichTrain.toLowerCase();

        //this is logic that checks if the traveller is using the day or night train
        //if it's neither, it terminates the program with an error code of -2
        //do NOT change this code fragment!
        if ( !whichTrain.equals( "night") && !whichTrain.equals( "day" ) ){
            System.out.println( "Sorry, AMR doesn't have that type of train (" + whichTrain + "). Goodbye." );
            System.exit( -2 );
        }

        //12. ask the traveller if they want to buy meals
        // the number of meals entered will be read in the meals variable
        System.out.println("Do you want to buy meals? Enter amount: ");
        int meals = 0;

        //this code fragment reads the number of meals the traveller wants to purchase in the meals variable
        //if the user enters a negative number of meals, it terminates the program with an error code of -4
        //if the user enters more than 30 meals, it terminates the program with an error code of -5
        //if the user enters a non-integer, it terminates the program with an error code of -6
        //do NOT change this code fragment!
        try {
            meals = keyboard.nextInt();

            if ( meals < 0 ) {
                System.out.println( "Can't purchase negative meals!" );
                System.exit( -4 );
            }
            if ( meals > 30 ) {
                System.out.println( "Goodness, how hungry are you?! Pick a reasonable number." );
                System.exit( -5 );
            }
        } catch ( InputMismatchException e ) {
            System.out.println( "I asked for integer input!" );
            System.exit( -6 );
        }

        //13. create a Ticket object with the standard constructor
        Ticket projectTicket = new Ticket();

        //14. set trainType instance variable in the Ticket object, use whichTrain
        projectTicket.setTrainType(whichTrain);

        //15. capitalize the first letter of the destination variable
        destination = destination.substring(0, 1).toUpperCase() + destination.substring(1);

        //16. set the destination instance variable in the Ticket object
        projectTicket.setDestination(destination);

        //this code invokes a method, which calculates the ticket price given the destination
        //when the line executes, the price variable will hold the price of a train ticket to the destination
        //the price doesn't include tax
        //do NOT change this code fragment!
        double price = calculateRegularTicket( destination );

        //17. set the ticketPrice instance variable in the Train object
        projectTicket.setTicketPrice(price);

        //18. set the numberOfMeals instance variable in the Train object
        projectTicket.setNumberOfMeals(meals);

        //19. print formatted train ticket
        projectTicket.printTicket();
    }


    /* do not change this method!
     *
     * calculateRegularTicket - this method calculates the train ticket price given the detination
     *
     * @param String dest - the destination
     * @return double - the price of ticket (before tax)
     */
    private static double calculateRegularTicket( String dest ) {
        if ( dest.trim().equalsIgnoreCase( "Stolat" ) )             return 26.50;
        else if ( dest.trim().equalsIgnoreCase( "Quirm" ) )         return 35.85;
        else if ( dest.trim().equalsIgnoreCase( "Pseudopolis" ) )   return 44.10;
        else if ( dest.trim().equalsIgnoreCase( "Ueberwald" ) )     return 90.99;
        else if ( dest.trim().equalsIgnoreCase( "Lancre" ) )        return 122.30;
        else{
            System.out.println( "Something went wrong. Panic!" );
            System.exit( -3 );
        }
        return -1;
    }
}
