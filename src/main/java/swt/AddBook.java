package swt;

import Model.Book;
import Service.BookRestService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.*;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AddBook
{
    public  AddBook(final Display display)

    {
        // Display display = Display.getDefault();
        final Shell shell = new Shell(display);
        shell.setSize(1500,800);
        shell.setText("Adding Book Details");

        Label label1 = new Label(shell, SWT.BORDER);
        label1.setText("author name");
        label1.setSize(150,25);
        label1.setLocation(10,25);

        Label label2 = new Label(shell, SWT.BORDER);
        label2.setText("BookTitle");
        label2.setSize(150,25);
        label2.setLocation(10,60);

        Label label3 = new Label(shell, SWT.BORDER);
        label3.setText("isbn");
        label3.setSize(150,25);
        label3.setLocation(10,95);

        Label label4 = new Label(shell, SWT.BORDER);
        label4.setText("is academic");
        label4.setSize(150,25);
        label4.setLocation(10,125);

        Label label5 = new Label(shell, SWT.BORDER);
        label5.setText("stock");
        label5.setSize(150,25);
        label5.setLocation(10,160);

        final Text text1 = new Text(shell,SWT.BORDER);
        text1.setText("");
        text1.setBounds(180,25,180,20);
        text1.setTextLimit(10);

        final Text text2 = new Text(shell,SWT.BORDER);
        text2.setText("");
        text2.setBounds(180,60,180,20);
        text2.setTextLimit(10);

        final Text text3 = new Text(shell,SWT.BORDER);
        text3.setText("");
        text3.setBounds(180,95,180,20);
        text3.setTextLimit(10);

        final Text text4= new Text(shell,SWT.BORDER);
        text4.setText("");
        text4.setBounds(180,125,180,20);
        text4.setTextLimit(10);

        final Text text5 = new Text(shell,SWT.BORDER);
        text5.setText("");
        text5.setBounds(180,160,180,20);
        text5.setTextLimit(10);

        Button button = new Button(shell,SWT.CENTER);
        button.setSize(40,40);
        button.setLocation(300,300);
        button.setText("Add");


        button.addSelectionListener (new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                 Book book=new Book(Integer.parseInt(text3.getText()), text1.getText(),text2.getText(),Boolean.parseBoolean(text4.getText()),Integer.parseInt(text5.getText()));
                BookRestService bookRestService=new BookRestService();
                bookRestService.createBook(book);
                shell.dispose();



          /* try {
                Class.forName("com.mysql.jdbc.Driver");
               Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookrental","root","root");
               PreparedStatement ps=connection.prepareStatement("insert into book values (!,!,!,!,!)");
               ps.setString(1,text1.getText());
               ps.setString(2,text2.getText());
               ps.setInt(3, Integer.parseInt(text3.getText()));
               ps.setString(4,text4.getText());
               ps.setInt(5, Integer.parseInt(text5.getText()));
               ps.executeUpdate();
           } catch (Exception ex) {
               ex.printStackTrace();
           }  */


            }  });

        shell.open();
        shell.addListener(SWT.CLOSE, new Listener() {
            @Override
            public void handleEvent(Event event) {
                shell.dispose();
            }
        });



    }

}
