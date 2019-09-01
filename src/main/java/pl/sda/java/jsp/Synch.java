package pl.sda.java.jsp;

public class Synch {

    public synchronized void methoda(){
        System.out.println("Wykonam sie tylko w jednym watku w danym momencie");
    }

    public void notSynchronized(){
        synchronized (this){
            System.out.println("Wykonam sie tylko w jednym watku w danym momencie");
        }
    }

    public static void main(String[] args) {
        Synch synch = new Synch();
        Thread t1 = new Thread(synch::methoda);
        Thread t2 = new Thread(synch::methoda);
        t2.start();
        t1.start();
    }
}
