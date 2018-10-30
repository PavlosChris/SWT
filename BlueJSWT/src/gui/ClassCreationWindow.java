package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import codewritten.BlueJSWTMyCode;
import codewritten.NewClassWindowVisibility;

import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;

public class ClassCreationWindow {

	protected Shell shlCreateNewClass;
	NewClassWindowVisibility newClassVisibility;
	
	/**
	 * Open the window.
	 */
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open(BlueJSWTMyCode newReference, Composite composite) {
		Display display = Display.getDefault();
		createContents(newReference, composite);
		shlCreateNewClass.open();
		shlCreateNewClass.layout();
		while (!shlCreateNewClass.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(BlueJSWTMyCode newReference, Composite composite) {
		shlCreateNewClass = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE));
		shlCreateNewClass.setSize(281, 400);
		shlCreateNewClass.setText("Create New Class");
		
		Label lblClassName = new Label(shlCreateNewClass, SWT.NONE);
		lblClassName.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.BOLD));
		lblClassName.setBounds(10, 25, 92, 15);
		lblClassName.setText("Class Name:");
		
		Text text = new Text(shlCreateNewClass, SWT.BORDER);
		text.setBounds(117, 25, 131, 21);
		
		Label lblClassLanguage = new Label(shlCreateNewClass, SWT.NONE);
		lblClassLanguage.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.BOLD));
		lblClassLanguage.setBounds(10, 67, 126, 21);
		lblClassLanguage.setText("Class Language:");
		
		Button btnJava = new Button(shlCreateNewClass, SWT.TOGGLE);
		btnJava.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityBtnJava();
			}
		});
		btnJava.setSelection(true);
		btnJava.setBounds(142, 63, 57, 25);
		btnJava.setText("Java");
		
		Button btnStride = new Button(shlCreateNewClass, SWT.TOGGLE);
		btnStride.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityBtnStride();
			}
		});
		btnStride.setBounds(200, 63, 61, 25);
		btnStride.setText("Stride");
		
		Label lblClassType = new Label(shlCreateNewClass, SWT.NONE);
		lblClassType.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.BOLD));
		lblClassType.setBounds(10, 123, 92, 25);
		lblClassType.setText("Class Type");
		
		Button btnClass = new Button(shlCreateNewClass, SWT.RADIO);
		btnClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityBtnClass();
			}
		});
		btnClass.setSelection(true);
		btnClass.setBounds(56, 164, 90, 16);
		btnClass.setText("Class");
		
		Button btnAbstractClass = new Button(shlCreateNewClass, SWT.RADIO);
		btnAbstractClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityBtnAbstractClass();
			}
		});
		btnAbstractClass.setBounds(56, 186, 90, 16);
		btnAbstractClass.setText("Abstract Class");
		
		Button btnInterface = new Button(shlCreateNewClass, SWT.RADIO);
		btnInterface.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityBtnInterface();
			}
		});
		btnInterface.setBounds(56, 208, 90, 16);
		btnInterface.setText("Interface");
		
		Button btnUnitTest = new Button(shlCreateNewClass, SWT.RADIO);
		btnUnitTest.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityBtnUnitTest();
			}
		});
		btnUnitTest.setBounds(56, 230, 90, 16);
		btnUnitTest.setText("Unit Test");
		
		Button btnEnum = new Button(shlCreateNewClass, SWT.RADIO);
		btnEnum.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityBtnEnum();
			}
		});
		btnEnum.setBounds(56, 252, 90, 16);
		btnEnum.setText("Enum");
		
		Button btnJavafxClass = new Button(shlCreateNewClass, SWT.RADIO);
		btnJavafxClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newClassVisibility.setVisibilityJavaFXClass();
			}
		});
		btnJavafxClass.setBounds(56, 274, 90, 16);
		btnJavafxClass.setText("JavaFX Class");
		
		Button btnOk = new Button(shlCreateNewClass, SWT.NONE);
		btnOk.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newReference.createClassIcon(text.getText(), shlCreateNewClass);
			}
		});
		btnOk.setEnabled(false);
		btnOk.setBounds(104, 326, 75, 25);
		btnOk.setText("OK");
		
		Button btnCancel = new Button(shlCreateNewClass, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    shlCreateNewClass.close();
			}
		});
		btnCancel.setBounds(180, 326, 75, 25);
		btnCancel.setText("Cancel");
		
		text.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
                    newReference.addKeyReleasedLisener(text, btnOk);
			}
		});
		
    newClassVisibility = new NewClassWindowVisibility(btnClass,  
        btnAbstractClass,  btnInterface,
        btnUnitTest,  btnEnum,  btnJavafxClass, btnJava, btnStride);
	}

}
