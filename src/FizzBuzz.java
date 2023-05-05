public class FizzBuzz {
        private final int n;
        private int actual_n;

        public FizzBuzz(int n) {
            this.n = n;
            this.actual_n = 1;
        }

        public synchronized void a() throws InterruptedException {
            while (actual_n <= n) {
                if (actual_n % 3 == 0 && actual_n % 5 != 0) {
                    System.out.println("fizz");
                    actual_n++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            notifyAll();
        }

        public synchronized void b() throws InterruptedException {
            while (actual_n <= n) {
                if (actual_n % 3 != 0 && actual_n % 5 == 0) {
                    System.out.println("buzz");
                    actual_n++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            notifyAll();
        }

        public synchronized void c() throws InterruptedException {
            while (actual_n <= n) {
                if (actual_n % 3 == 0 && actual_n % 5 == 0) {
                    System.out.println("fizzbuzz");
                    actual_n++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            notifyAll();
        }

        public synchronized void d() throws InterruptedException {
            while (actual_n <= n) {
                if (actual_n % 3 != 0 && actual_n % 5 != 0) {
                    System.out.println(actual_n);
                    actual_n++;
                    notifyAll();
                } else {
                    wait();
                }
            }
            notifyAll();
        }

        public static void main(String[] args) {
            FizzBuzz fizzBuzz = new FizzBuzz(35);
            
            Thread thread_A = new Thread(() -> {
                try {
                    fizzBuzz.a();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread thread_B = new Thread(() -> {
                try {
                    fizzBuzz.b();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread thread_C = new Thread(() -> {
                try {
                    fizzBuzz.c();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            Thread thread_D = new Thread(() -> {
                try {
                    fizzBuzz.d();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

            thread_A.start();
            thread_B.start();
            thread_C.start();
            thread_D.start();
        }
}
