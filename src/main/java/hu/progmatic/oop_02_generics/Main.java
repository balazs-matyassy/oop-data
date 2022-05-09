package hu.progmatic.oop_02_generics;

public class Main {
    public static void main(String[] args) {
        Document document = new Document(1, "Gyűrűk Ura");
        Document document2 = new Document(2, "Harry Potter");
        // típusparaméter
        // <> diamond operator jelentése: az új objektum típusa legyen egyenlő a referencia típusával
        // ChangeTracker sablonból "generál" egy ChangeTrackerDocument verziót, ahol már a helyes típusok szerepelnek
        // Ez amúgy nem teljesen igaz (-> Type Erasure: eléggé haladó téma).
        ChangeTracker<Document> favoriteBook = new ChangeTracker<>();
        favoriteBook.addVersion(document);
        favoriteBook.addVersion(document);
        favoriteBook.addVersion(document2);
        favoriteBook.addVersion(document);

        System.out.println(favoriteBook.getChanges());
        System.out.println(favoriteBook.getLastVersion());

        OperatingSystem os1 = new OperatingSystem(1,"Windows");
        OperatingSystem os2 = new OperatingSystem(2, "Linux");
        ChangeTracker<OperatingSystem> favoriteOS = new ChangeTracker<>();
        favoriteOS.addVersion(os1);
        favoriteOS.addVersion(os1);
        favoriteOS.addVersion(os2);
        favoriteOS.addVersion(os2);

        // helyesen szűri
        // favoriteOS.addVersion(document);

        System.out.println(favoriteOS.getChanges());
        System.out.println(favoriteOS.getLastVersion());

        OperatingSystem lastFavorite = favoriteOS.getLastVersion();
        lastFavorite.setName(lastFavorite.getName() + " 2.0");
        System.out.println(lastFavorite);
    }
}
