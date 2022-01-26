import java.util.Date;

public class Ticket {
        private String trainType;
        private String destination;
        private double ticketPrice;
        private int numberOfMeals;

    public Ticket() {
    }

    Date now = new Date();

    public void setTrainType ( String train ) {
            trainType = train;
        }
        public void setDestination ( String dest ) {

        destination = dest;
        }
        public void setTicketPrice ( double ticket) {

        ticketPrice = ticket;
        }
        public void setNumberOfMeals ( int meals) {

        numberOfMeals = meals;
        }
        public String getTrainType() {
            return this.trainType;
        }
        public String getDestination() {
            return this.destination;
        }
        public double getTicketPrice() {
            return this.ticketPrice;
        }
        public int getNumberOfMeals() {
            return this.numberOfMeals;
        }
        public void printTicket() {
        ticketPrice = ticketPrice * 1.06 + (numberOfMeals * 10) * 1.06;

        System.out.print( "------------------------------------------------------------\n" );
        System.out.println("|  Date: " + now + "                      |");
        System.out.println("|                                                          |");
        System.out.println("|  TRAIN  DESTINATION     MEALS   TOTAL PRICE WITH TAX     |");
        System.out.printf("|  %-5s  %-11s     %5d   $%7.2f                 |\n", trainType, destination, numberOfMeals, ticketPrice);
        System.out.println("|                                                          |");
        System.out.println("|  Thank you for travelling with the Ankh-Morpork Railway! |");
        System.out.print( "------------------------------------------------------------" );
        }
}

