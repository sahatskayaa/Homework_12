public class Timer {
    public static void main(String[] args) throws InterruptedException {
        Timer_1 timer_1 = new Timer_1();
        Timer_2 timer_2 = new Timer_2();
        timer_1.start();
        timer_2.sleep(5000);
        timer_2.start();
    }
}

class Timer_1 extends Thread{
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (true) {
            long elapsedTime = System.currentTimeMillis() - startTime;
            System.out.println(elapsedTime / 1000 + " сек.");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Timer_2 extends Thread{
    @Override
    public void run() {
        while (true) {
            System.out.println("Минуло 5 секунд");
            try{
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

