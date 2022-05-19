package hu.progmatic.oop_09_quartals;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // A System.in egy InputStream
            // InputStream: valamilyen adatforrást enged byteonként kiolvasni
            // FileInputStream, ByteArrayInputStream (konstans tömböt ad vissza -> lsd. StringReader)

            BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Kérek egy sort!");
            String inLine = inReader.readLine();
            System.out.println("A megadott sor: " + inLine);


            // Reader: valamilyen adatforrást enged karakterenként kiolvasni
            //  - FileReader: szöveges fájlokat enged karakterenként kiolvasni
            //  - StringReader: fix szöveget ad vissza karakterenként
            //  - InputStreamReader: Egy InputStream-ből olvas ki egy byteot,
            //  a kiolvasott értéket karakterré alakítva adja vissza
            // BufferedReader: olyan Reader, akinek van egy beépített puffere
            //      képes összegyűjteni több karaktert
            //      pl. Képesek vagyunk egy teljes sort kiolvasni.
            //          readLine() !!!
            //      Nem önállóan működik, hanem egy másik Readert "csomagol be".
            // BufferedReader reader = new BufferedReader(new FileReader("c:\\quartals.txt"));
            BufferedReader reader = new BufferedReader(new FileReader("data\\quartals.txt"));
            // BufferedReader reader = new BufferedReader(new StringReader("Hello\nWorld"));

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

            // ha előbb kivétel keletkezik, akkor nem kerül lezárásra az erőforrás
            // igaziból a finally blokkban lenne a helye
            reader.close(); // ez nem teljesen szép
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("==============================");
        System.out.println();

        // Try-with resources
        // Nincs szükség csak az erőforrások garantált lezárása miatt finally blokkra
        // automatikusan meghívja a close metódust (kezeli a close közben keletkező hibákat is)
        try (BufferedReader reader = new BufferedReader(new FileReader("data\\quartals.txt"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println();
        System.out.println("==============================");
        System.out.println();

        try {
            Scanner scanner = new Scanner(new File("quartals.txt"));

            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }

            scanner.close(); // nem teljesen szép
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
