import java.util.Scanner;

public class Main {

    private static boolean breakflag = false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (!breakflag)
        {
            System.out.println("1) Stwórz kategorie produktów");
            System.out.println("2) Stwórz produkt");
            System.out.println("3) Wyświetl wszystkie kategorie");
            System.out.println("4) Wyświetl wszystkie produkty");
            System.out.println("5) Prosty zapis - kodowanie");
            System.out.println("6) Zapis - serializacja");
            System.out.println("7) Proste wczytywanie - dekodowanie");
            System.out.println("8) Wczytywanie - deserializacja");
            System.out.println("0) Zakończ");

        int option = scanner.nextInt();

            switch (option){
                case 1:

                    break;
            }
        }
    }
}
