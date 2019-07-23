package swt;


import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.widgets.*;

public class BookRental
{

    public static void main(String[] args)
    {
        final Display display = new Display();
        final Shell shell = new Shell(display,SWT.CLOSE);
        shell.setModified(true);
        shell.setSize(1500,800);
        Label label1 = new Label(shell, SWT.CENTER);;
        label1.setText("Welcome to Book System");
        label1.setBounds(400,50,440,50);
        label1.setLocation(550,25);
        label1.setFont(new Font(display, "arial",16,SWT.BOLD));

        label1.setBackground(new Color(display,250,121,60));


        final Button addBook= new Button(shell,SWT.PUSH);
        addBook.setText("AddBook");
        addBook.setLocation(90,100);
        addBook.setSize(100,30);

        final Button printbook= new Button(shell,SWT.PUSH);
        printbook.setText("PrintBook");
        printbook.setLocation(90,180);
        printbook.setSize(100,30);


        final Button delBook = new Button(shell,SWT.PUSH);
        delBook.setText("DeleteBook");
        delBook.setLocation(90,280);
        delBook.setSize(100,30);

        final Button serBook = new Button(shell,SWT.PUSH);
        serBook.setText("SearchBook");
        serBook.setLocation(90,380);
        serBook.setSize(100,30);

        final Button rentBook = new Button(shell,SWT.PUSH);
        rentBook.setText("RentBook");
        rentBook.setLocation(90,480);
        rentBook.setSize(100,30);

        final Button returnBook = new Button(shell,SWT.PUSH);
        returnBook.setText("ReturnBook");
        returnBook.setLocation(90,580);
        returnBook.setSize(100,30);

        final Button logout = new Button(shell,SWT.PUSH);
        logout.setText("Logout");
        logout.setLocation(170,680);
        logout.setSize(100,30);



        addBook.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {

                try {
                    new AddBook(display);
                }
                  catch (Exception ex) {
                    ex.printStackTrace();
                }

            }  });

        printbook.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent selectionEvent) {

                try {

                    new PrintBooks(display);
                    System.out.println("printed books sucessfully");
                }
                catch (Exception e){
                    e.printStackTrace();
                }


                Table table = new Table( shell, SWT.CHECK | SWT.BORDER | SWT.V_SCROLL
                        | SWT.H_SCROLL);
                table.setHeaderVisible(true);
                String[] titles = { "author name", "book title", "isbn", "isAcademic","stock" };

            }

        });

        delBook.addSelectionListener(new SelectionAdapter()
        {

            public void widgetSelected(SelectionEvent e)
            {

                new DeleteBook(display);


            }  });


        serBook.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {
                try {
                    new SearchBook();
                }
                catch (Exception ex) {
                    ex.printStackTrace();
                }

            }  });

       /* rentBook.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {

                new RentBook(display);

            }  });

        returnBook.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {

                new ReturnBook(display);

            }  });*/

        logout.addSelectionListener(new SelectionAdapter()
        {
            public void widgetSelected(SelectionEvent e)
            {

                shell.close();

            }  });





        shell.open();
        while(!shell.isDisposed())
            if (!display.readAndDispatch())
            {
                display.sleep();
            }
        display.dispose();

    }

}
