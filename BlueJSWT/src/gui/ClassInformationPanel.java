package gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.wb.swt.SWTResourceManager;

import codewritten.BlueJSWTMyCode;

import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class ClassInformationPanel extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ClassInformationPanel(Composite parent, int style, BlueJSWTMyCode newReference, String className) {
		super(parent, style);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(128, 128, 128));
		composite.setBounds(0, 0, 816, 45);
		
		CCombo combo = new CCombo(composite, SWT.BORDER | SWT.READ_ONLY);
		combo.setItems(new String[] {"Source Code", "Documentation"});
		combo.setText("Source Code");
		combo.setBounds(541, 10, 149, 25);
		
		Button btnCompile = new Button(composite, SWT.NONE);
		btnCompile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCompile.setBounds(10, 10, 63, 25);
		btnCompile.setText("Compile");
		
		Button btnUndo = new Button(composite, SWT.NONE);
		btnUndo.setEnabled(false);
		btnUndo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnUndo.setBounds(79, 10, 63, 25);
		btnUndo.setText("Undo");
		
		Button btnCut = new Button(composite, SWT.NONE);
		btnCut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCut.setBounds(148, 10, 63, 25);
		btnCut.setText("Cut");
		
		Button btnCopy = new Button(composite, SWT.NONE);
		btnCopy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCopy.setBounds(217, 10, 63, 25);
		btnCopy.setText("Copy");
		
		Button btnPaste = new Button(composite, SWT.NONE);
		btnPaste.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPaste.setBounds(286, 10, 63, 25);
		btnPaste.setText("Paste");
		
		Button btnFind = new Button(composite, SWT.NONE);
		btnFind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFind.setBounds(355, 10, 63, 25);
		btnFind.setText("Find...");
		
		Button btnClose = new Button(composite, SWT.NONE);
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newReference.removeTab(newReference.getTabIndex());
			}
		});
		btnClose.setBounds(424, 10, 63, 25);
		btnClose.setText("Close");
		
		Composite composite_3 = new Composite(this, SWT.NONE);
		composite_3.setBackground(SWTResourceManager.getColor(211, 211, 211));
		composite_3.setBounds(0, 43, 56, 569);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(this, SWT.V_SCROLL);
		scrolledComposite.setAlwaysShowScrollBars(true);
		scrolledComposite.setBounds(57, 44, 759, 568);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite_1 = new Composite(scrolledComposite, SWT.NONE);
		composite_1.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Composite composite_2 = new Composite(composite_1, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(200, 255, 196));
		composite_2.setLayout(null);
		
		StyledText styledText = new StyledText(composite_2, SWT.NONE);
		styledText.setBounds(10, 10, 722, 129);
		styledText.setBackground(SWTResourceManager.getColor(200, 255, 196));
		styledText.setText("/**\r\n * Write a description of class " + className + " here.\r\n *\r\n * @author (your name)\r\n * @version (a version number or a date)\r\n */\r\npublic class " + className + "\r\n{");
		
		StyledText styledText_1 = new StyledText(composite_2, SWT.NONE);
		styledText_1.setBounds(10, 145, 722, 44);
		styledText_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		styledText_1.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		styledText_1.setText("// instance variables - replace the example below with your own\r\n    private int x;");
		
		Composite composite_4 = new Composite(composite_2, SWT.NONE);
		composite_4.setBounds(10, 187, 722, 492);
		composite_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		
		StyledText styledText_2 = new StyledText(composite_4, SWT.NONE);
		styledText_2.setBackground(SWTResourceManager.getColor(255, 255, 224));
		styledText_2.setText("/**\r\n   * Constructor for objects of class " + className + "\r\n   */\r\n   public " + className + "()\r\n   {");
		styledText_2.setBounds(10, 10, 702, 84);
		
		Composite composite_5 = new Composite(composite_4, SWT.NONE);
		composite_5.setBackground(SWTResourceManager.getColor(250, 250, 210));
		composite_5.setBounds(10, 93, 702, 84);
		
		StyledText styledText_3 = new StyledText(composite_5, SWT.NONE);
		styledText_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		styledText_3.setText("// initialise instance variables\r\n        x = 0;");
		styledText_3.setBounds(10, 10, 682, 40);
		
		StyledText styledText_4 = new StyledText(composite_5, SWT.NONE);
		styledText_4.setBackground(SWTResourceManager.getColor(250, 250, 210));
		styledText_4.setText("}");
		styledText_4.setBounds(10, 55, 19, 19);
		
		StyledText styledText_5 = new StyledText(composite_4, SWT.NONE);
		styledText_5.setBackground(SWTResourceManager.getColor(250, 250, 210));
		styledText_5.setText("/**\r\n     * An example of a method - replace this comment with your own\r\n     *\r\n     * @param  y  a sample parameter for a method\r\n     * @return    the sum of x and y\r\n     */\r\n    public int sampleMethod(int y)\r\n    {");
		styledText_5.setBounds(10, 183, 702, 130);
		
		Composite composite_6 = new Composite(composite_4, SWT.NONE);
		composite_6.setBackground(SWTResourceManager.getColor(250, 250, 210));
		composite_6.setBounds(10, 314, 702, 111);
		
		StyledText styledText_6 = new StyledText(composite_6, SWT.NONE);
		styledText_6.setText("// put your code here\r\n        return x + y;");
		styledText_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		styledText_6.setBounds(10, 10, 682, 39);
		
		StyledText styledText_7 = new StyledText(composite_6, SWT.NONE);
		styledText_7.setBackground(SWTResourceManager.getColor(250, 250, 210));
		styledText_7.setText("}");
		styledText_7.setBounds(10, 55, 19, 19);
		scrolledComposite.setContent(composite_1);
		scrolledComposite.setMinSize(composite_1.computeSize(SWT.DEFAULT, SWT.DEFAULT));

	}

	
	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
