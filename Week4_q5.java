class Ride {
    int rideNumber;
    String rideName;

    Ride(int rideNumber, String rideName) {
        this.rideNumber = rideNumber;
        this.rideName = rideName;
    }

    void displayPattern() {
        System.out.print(rideName + " : ");

        for (int i = 1; i <= rideNumber; i++) {
            System.out.print("*");
        }

        System.out.println();
    }
}

public class AmusementPark {
    public static void main(String[] args) {

        Ride[] rides = new Ride[5];

        rides[0] = new Ride(1, "Roller Coaster");
        rides[1] = new Ride(2, "Ferris Wheel");
        rides[2] = new Ride(3, "Bumper Cars");
        rides[3] = new Ride(4, "Water Ride");
        rides[4] = new Ride(5, "Haunted House");

        System.out.println("===== RIDE ACTIVITY LEVEL =====");

        for (int i = 0; i < 5; i++) {
            rides[i].displayPattern();
        }
    }
}