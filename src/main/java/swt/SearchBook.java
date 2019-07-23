package swt;

import Model.Book;
import Service.BookRestService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import java.util.List;

public class SearchBook
{
    SearchBook()
    {
        Display display = Display.getDefault();
        Shell shell = new Shell(display);
        shell.setSize(1500,800);
        shell.setText("searching book details");

        Label label1 = new Label(shell, SWT.BORDER);
        label1.setText("author name");
        label1.setSize(150,25);
        label1.setLocation(10,25);

       /* Label label2 = new Label(shell, SWT.BORDER);
        label2.setText("BookTitle");
        label2.setSize(150,25);
        label2.setLocation(10,55);

        Label label3 = new Label(shell, SWT.BORDER);
        label3.setText("isbn");
        label3.setSize(150,30);
        label3.setLocation(10,85);
*/

        Text text1 = new Text(shell,SWT.BORDER);
        text1.setText("");
        text1.setBounds(180,30,180,20);
        text1.setTextLimit(10);

       /* Text text2 = new Text(shell,SWT.BORDER);
        text2.setText("");
        text2.setBounds(180,60,180,20);
        text2.setTextLimit(10);

        Text text3 = new Text(shell,SWT.BORDER);
        text3.setText("");
        text3.setBounds(180,90,180,20);
        text3.setTextLimit(10);*/

        Button button = new Button(shell,SWT.CENTER);
        button.setText("Search");
        button.setSize(60,30);
        button.setLocation(250,250);

        button.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent e) {
                System.out.println(e.getSource());
                try {
                    String authorName = text1.getText();
                    System.out.println("authorName");

                    if (!(authorName.equals(""))) {
                        List<Book> bookList = null;
                        BookRestService restTemplateService = new BookRestService();
                        restTemplateService.getByAuthor("http://localhost:8089/bookRental/byAuthor" + authorName, display);
                    } else {
                        MessageBox msgBox = new MessageBox(shell, SWT.CANCEL | SWT.OK);
                        msgBox.setMessage("please enter valid isbn number");
                        msgBox.open();

                    }
                } catch (Exception a) {a.printStackTrace(); }
            }
        });
        shell.open();
        shell.addListener(SWT.CLOSE, new Listener() {
            @Override
            public void handleEvent(Event event) {
                shell.dispose();
            }
        });

    }

}
