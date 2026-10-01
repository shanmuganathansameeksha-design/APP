class OrderProcessing extends Thread {

    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Activity: Processing customer orders");
    }
}

class DeliveryTracking extends Thread {

    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Activity: Tracking delivery location");
    }
}

class Notification extends Thread {

    public void run() {
        System.out.println("Thread Name: " + getName());
        System.out.println("Priority: " + getPriority());
        System.out.println("Activity: Sending order-status notifications");
    }
}

public class FoodDelivery {
    public static void main(String[] args) {

        OrderProcessing t1 = new OrderProcessing();
        DeliveryTracking t2 = new DeliveryTracking();
        Notification t3 = new Notification();

        t1.setName("OrderProcessing");
        t2.setName("DeliveryTracking");
        t3.setName("Notification");

        t1.setPriority(10);
        t2.setPriority(5);
        t3.setPriority(1);

        t1.start();
        t2.start();
        t3.start();
    }
}