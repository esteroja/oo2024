public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Kevade", 1912, "Oskar Luts");
        Book book2 = new Book ("Suvi", 1918, "Oskar Luts");

        Library library1 = new Library(book1);
        Library library2 = new Library(book2);

        book1.sameAuthor("Sügis", 1938);

        library1.outOfStock();
        library2.outOfStock();

    }
}