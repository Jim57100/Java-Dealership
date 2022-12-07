public class Dealership {
    private Car[] cars;

    public Dealership(Car[] cars) {
        //Avoid mutability. Set new cars array from the Car object with same length
        this.cars = new Car[cars.length];
        //Make a deep copy with same data but different reference
        for (int i = 0; i < cars.length; i++) {
            this.cars[i] = new Car(cars[i]); //Call the copy constructor from Car.
        }
    }

    public void setCar(Car car, int index) {
        this.cars[index] = new Car(car);
    }

    /**
     * Function name: getCar
     * @param index
     * @return (object)
     */
    public Car getCar(int index) {
        return new Car(this.cars[index]);
    }

    /**
     * Function name: sell
     * Sell a car and exit car
     * @param index
     * @return (void)
     */
    public void sell(int index) {
        System.out.println("Congrulations for this beautiful " + this.cars[index].getMake() + " !");
        this.cars[index].drive();
        this.cars[index] = null;
    }

    /**
     * Function name: search
     * Search a car and return 404 error if not found
     * @param make (String)
     * @param budget (int)
     * @return (int)
     */
    public int search(String make, int budget) {
        for (int i = 0; i < this.cars.length; i++) {
            if (this.cars[i] == null) {
                continue;
            } else if (this.cars[i].getMake().equals(make) && this.cars[i].getPrice() <= budget) {
                System.out.println("\nWe found one in spot " + i + "\n" + this.cars[i].toString() + "\nAre you interested (Y/N) ?");
                return i;
            }
        }
        System.out.println("\nYour search didn't match any results.");
        return 404;
    }

    /**
     * Function name: toString
     * @return (String)
     */
    public String toString() {
        String temp = "";
        for (int i = 0; i < this.cars.length; i++) {
            temp += "Parking Spot: " + i + "\n";
            if (this.cars[i] == null) {
                temp += "Empty\n";
            } else {
                temp += this.cars[i].toString() + "\n";
            }
        }
        return temp;
    }


}
