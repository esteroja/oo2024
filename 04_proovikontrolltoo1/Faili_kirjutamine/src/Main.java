import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("valjund.txt"));
        //fail tekib ise kui käima panna (vähemalt siis kui print käsud olemas + close())
        pw.print("Elas");
        pw.print(" ");
        pw.print("metsas");
        pw.print(" ");
        pw.print("mutionu");
        pw.println();
        pw.println("Keset kuuski noori vanu");
        pw.println("Eluruum tal sügaval");
        pw.close();
    }
}
