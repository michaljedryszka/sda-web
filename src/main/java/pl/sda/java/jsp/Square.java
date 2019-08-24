package pl.sda.java.jsp;

public class Square {

    public static void main(String[] args) {
        int rozmiar = 6;
        String znak = "X";
        for (int x = 0; x < rozmiar; x++) {
            for (int y = 0; y < rozmiar; y++) {
                System.out.print(znak);
                if (znak.equals("X")) znak = "O";
                else znak = "X";
            }
            System.out.println("\n");
        }
    }
}
