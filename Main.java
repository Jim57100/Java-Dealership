import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        
        //Database
        Car[] cars = new Car[] {
            new Car("Nissan", 5000, 2020, "red", new String[] {"tires", "keys"}),
            new Car("Dodge", 8500, 2019, "blue", new String[] {"tires", "keys"}),
            new Car("Nissan", 5000, 2017, "yellow", new String[] {"tires", "filter"}),
            new Car("Honda", 7000, 2019, "orange", new String[] {"tires", "filter"}),
            new Car("Mercedes", 12000, 2015, "jet black", new String[] {"tires", "filter", "transmission"})
        };
        
        Dealership dealership = new Dealership(cars);
        
        /**
         * Add user input.
         */
        System.out.println("\n ****** JAVA DEALERSHIP! ****** \n");
        System.out.print("Welcome! Enter the type of car you're looking for: ");
        String wantedMake = scan.nextLine();
        System.out.print("Enter your budget: ");
        if(scan.hasNextInt()) {
            int budget = scan.nextInt(); scan.nextLine();
            int index = dealership.search(wantedMake, budget);
            
            // Call the search action.
            switch(index) {
                /* case 404 */ 
                case 404: 
                    System.out.println("Feel free to browse through our collection of cars.\n");
                    System.out.println(dealership); 
                    System.out.println("Wich car are you interested in ?");
                    index = scan.nextInt(); scan.nextLine();
                    dealership.sell(index);
                    break;
                    /* Sell the car */
                    default: 
                    String interest = scan.nextLine();
                    if(interest.equalsIgnoreCase("Y")) {
                        dealership.sell(index);
                    }
                    break;              
            }
        }
        
        scan.close();

    }
}

