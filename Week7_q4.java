class Transaction implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Processing transaction - Count: " + i);

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class Balance implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Updating balance - Count: " + i);

            try {
                Thread.sleep(1500);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

class SMSNotification implements Runnable {

    public void run() {
        for (int i = 1; i <= 3; i++) {
            System.out.println(Thread.currentThread().getName()
                    + " - Sending SMS notification - Count: " + i);

            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        Thread t1 = new Thread(new Transaction());
        Thread t2 = new Thread(new Balance());
        Thread t3 = new Thread(new SMSNotification());

        t1.setName("Transaction Thread");
        t2.setName("Balance Thread");
        t3.setName("SMS Thread");

        t1.start();
        t2.start();
        t3.start();
    }
}