package swt;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;

public class BookTable
{
    public static Table bookTable(Shell s) {
        Shell shell=s;
        shell.setLayout(new GridLayout(1, false));
        shell.setSize(700, 700);
        shell.setText("Your Book Details Are..");
        Table table = new Table(shell, SWT.VIRTUAL|SWT.FULL_SELECTION);
        table.setHeaderVisible(true);
        table.setLinesVisible(true);
        table.setItemCount(1);


        table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

        TableColumn column1= new TableColumn(table, SWT.NONE);
        column1.setWidth(100);
        column1.setText("authorName");


        TableColumn column2 = new TableColumn(table, SWT.NONE);
        column2.setWidth(100);
        column2.setText("bookTitle");


        TableColumn column3 = new TableColumn(table, SWT.NONE);
        column3.setWidth(100);
        column3.setText("ISBN");


        TableColumn column4 = new TableColumn(table, SWT.NONE);
        column4.setWidth(100);
        column4.setText("IsAcademic");


        TableColumn column5= new TableColumn(table, SWT.NONE);
        column5.setWidth(100);
        column5 .setText("Stock");

        return table;

    }
}
