package Model;

 public class Book
 {
    private  int isbn;
    private  String authorName;
    private  String bookTitle;
    private  boolean isAcademic;
    private  int stock;

     public Book() {
     }

     public Book(int isbn, String authorName, String bookTitle, boolean isAcademic, int stock) {
         this.isbn = isbn;
         this.authorName = authorName;
         this.bookTitle = bookTitle;
         this.isAcademic = isAcademic;
         this.stock = stock;
     }

     public int getIsbn() {
         return isbn;
     }

     public void setIsbn(int isbn) {
         this.isbn = isbn;
     }

     public String getAuthorName() {
         return authorName;
     }

     public void setAuthorName(String authorName) {
         this.authorName = authorName;
     }

     public String getBookTitle() {
         return bookTitle;
     }

     public void setBookTitle(String bookTitle) {
         this.bookTitle = bookTitle;
     }

     public boolean isAcademic() {
         return isAcademic;
     }

     public void setAcademic(boolean academic) {
         isAcademic = academic;
     }

     public int getStock() {
         return stock;
     }

     public void setStock(int stock) {
         this.stock = stock;
     }

     @Deprecated
     @Override
     public String toString() {
         return "Book{" +
                 "isbn=" + isbn +
                 ", authorName='" + authorName + '\'' +
                 ", bookTitle='" + bookTitle + '\'' +
                 ", isAcademic=" + isAcademic +
                 ", stock=" + stock +
                 '}';
     }
 }
