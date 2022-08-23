package test.xpath.selectors;

public class Debugging {
    static int x = 10;
    static int z;
    
    public static int summe(){
        int y=20;
        z = y + x;
        return z;

    }



    public static void main(String[] args) {
        summe();
        System.out.println(z);
    }
}
