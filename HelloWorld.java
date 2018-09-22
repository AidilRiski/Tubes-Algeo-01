import java.util.*;

class HelloWorld{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Nama : ");
        String nama = input.nextLine();
        System.out.print("Hello " + nama);
    }
}