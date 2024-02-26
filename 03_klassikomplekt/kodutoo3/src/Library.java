public class Library {

    Book book;

    public Library(Book book) {
        this.book = book;
    }

    public void outOfStock() {
        if (book.title.equals("Suvi")) {
            System.out.println("Raamatut pole ");
        } else {
            System.out.println("Raamat olemas ");
        }
    }

}
