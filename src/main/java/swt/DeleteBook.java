package swt;

import Service.BookRestService;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.widgets.*;

public class DeleteBook
{

    public DeleteBook(Display display) {
        display = Display.getDefault();

        final Shell shell = new Shell(display);
        Label nameLabel = new Label(shell, SWT.NONE);
        nameLabel.setText("Enter book isbn number:");
        nameLabel.setBounds(30, 40, 250, 30);

        final Text text1 = new Text(shell, SWT.NONE);
        text1.setBounds(30, 70, 200, 30);
        text1.setTextLimit(40);
        text1.setFocus();
        final MessageBox messageBox= new MessageBox(shell, SWT.CANCEL | SWT.OK);


        Button del = new Button(shell, SWT.NONE);
        del.setBounds(50, 220, 90, 30);
        del.setText("Delete");


        shell.open();

        text1.addVerifyListener(new VerifyListener() {
            @Override
            public void verifyText(VerifyEvent verifyEvent) {
                if (verifyEvent.text.isEmpty()) {
                    verifyEvent.doit = true;
                }
                else if (verifyEvent.keyCode == SWT.SHIFT || verifyEvent.keyCode == SWT.SPACE || verifyEvent.keyCode == SWT.DEL || verifyEvent.keyCode == SWT.CTRL || verifyEvent.keyCode == SWT.BS || verifyEvent.keyCode == SWT.ARROW_UP || verifyEvent.keyCode == SWT.ARROW_DOWN || verifyEvent.keyCode == SWT.ARROW_RIGHT || verifyEvent.keyCode == SWT.ARROW_LEFT) {
                    verifyEvent.doit = true;
                }
                else {
                    boolean allow = false;
                    for (int i = 0; i < verifyEvent.text.length(); i++)
                    {
                        int i1 = verifyEvent.text.charAt(i);
                        allow = Character.isDigit(i1) || Character.isWhitespace(i1);

                        //allow = Character.isAlphabetic(ch) || Character.isWhitespace(ch);
                        if (!allow) {
                            break;
                        }
                    }
                    verifyEvent.doit = allow;
                }
            }
        });

            del.addSelectionListener(new SelectionAdapter() {
            @Override
            public void widgetSelected(SelectionEvent selectionEvent) {
                System.out.println(selectionEvent.getSource() );
                if(!(text1.getText().equals(""))) {
                    int isbn = Integer.parseInt(text1.getText());
                    try {
                        BookRestService restTemplateService = new BookRestService();
                        String verify = restTemplateService.deleteById();
                        messageBox.setMessage("Book Deleted Successfully");
                        messageBox.open();
                    }
                    catch (Exception exp){
                        exp.printStackTrace();
                    }
                }
                    else {
                    MessageBox messageBox=new MessageBox(shell,SWT.OK|SWT.ICON_WARNING);
                    messageBox.setMessage("please provide valid isbn");
                    messageBox.open();
                }
            }
        });
    }

}
