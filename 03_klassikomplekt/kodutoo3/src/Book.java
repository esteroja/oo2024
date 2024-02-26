public class Book {

    String title;
    int year;
    String author;

    public Book(String title, int year, String author) {
        this.title = title;
        this.year = year;
        this.author = author;
    }

    public void sameAuthor(String newTitle, int newYear) {
        title = newTitle;
        year = newYear;
        System.out.println(title + ", " + year + ", " + author);
    }

}
