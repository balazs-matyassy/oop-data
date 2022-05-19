package hu.progmatic.oop_09_quartals;

import java.io.*;

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

            reader.close(); // ez nem teljesen szép
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
