package swt;

import Model.Book;
import Service.BookRestService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.*;

import java.util.List;

public class PrintBooks
{ public PrintBooks(Display d){

    final Display display=d;
    final Shell shell = new Shell(display);


    Table table = BookTable.bookTable(shell);


    table.addListener(SWT.SetData, new Listener() {
        public void handleEvent(Event event) {

            BookRestService bookRestService=new BookRestService();
            List<Book> bookList=bookRestService.getAllBook("http://localhost:8089/book/byAuthorName", display);
            for (Book book:bookList) {
                TableItem item=new TableItem(table,SWT.NONE);
                item.setText(new String[]{String.valueOf(book.getIsbn()),book.getAuthorName(),
                       book.getBookTitle() ,String.valueOf(book.isAcademic()),String.valueOf(book.getStock())});

            }
        }
    });

    shell.open();
    shell.layout();
    shell.addListener(SWT.CLOSE, new Listener() {
        @Override
        public void handleEvent(Event event) {
            shell.dispose();
        }
    });
}


}




