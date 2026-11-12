public class Book {
    private String title;
    private String author;
    private Student borrowedBy;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.borrowedBy = null;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Student getBorrowedBy() {
        return borrowedBy;
    }

    public void borrowBy(Student s) {
        this.borrowedBy = s;
    }

    public String toString() {
        return title + " (" + author + ")";
    }
}