package pl.sda.java.jsp;

public class Tree {

    public static void main(String[] args) {
        int n = 7;
        String zmienna = "O";
        for(int i = 0; i< n; i ++){
            for(int j = 0; j<=i; j ++){
                System.out.print(zmienna);
                if(zmienna.equals("O")){
                    zmienna = "X";
                }else{
                    zmienna = "O";
                }
            }
            System.out.println("");
        }
    }
}
