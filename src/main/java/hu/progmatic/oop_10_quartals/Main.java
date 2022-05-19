package hu.progmatic.oop_10_quartals;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        try {
            copyFileToNetwork();
            notifyCEO();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copyFileToNetwork() throws IOException {
        try {
            openFile();
            uploadFile(); // itt keletkezhet hálózati hiba
        } finally {
            closeFile(); // a fájl akkor is kerüljön bezárásra, ha hálózati hiba történik
        }

        // azért nem szabad ide catch blokkot írni,
        // mert elnyelnénk a hibát, és a külső blokkban lefutna tévesen az értesítés
        // a sikeres feltöltésről
    }

    private static void openFile() {
        // DO NOTHING
    }

    private static void closeFile() {
        // DO NOTHING
    }

    private static void uploadFile() throws IOException {
        // DO NOTHING
    }

    private static void notifyCEO() {
        // DO NOTHING
    }
}
