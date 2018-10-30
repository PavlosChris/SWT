package gui;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;

import codewritten.BlueJSWTMyCode;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Label;

public class ProjectInformationPanel extends Composite {

	/**
	 * Create the composite.
	 * @param parent
	 * @param style
	 */
	public ProjectInformationPanel(Composite parent, int style, BlueJSWTMyCode newReference) {
		super(parent, style);
		
		Composite composite = new Composite(this, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_DARK_SHADOW));
		composite.setBounds(0, 0, 816, 46);
		
		CCombo combo = new CCombo(composite, SWT.BORDER);
		combo.setEnabled(false);
		combo.setEditable(false);
		combo.setBounds(695, 10, 111, 25);
		
		Button btnCompile = new Button(composite, SWT.NONE);
		btnCompile.setEnabled(false);
		btnCompile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCompile.setBounds(10, 10, 65, 25);
		btnCompile.setText("Compile");
		
		Button btnUndo = new Button(composite, SWT.NONE);
		btnUndo.setEnabled(false);
		btnUndo.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnUndo.setBounds(81, 10, 65, 25);
		btnUndo.setText("Undo");
		
		Button btnCut = new Button(composite, SWT.NONE);
		btnCut.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCut.setBounds(152, 10, 65, 25);
		btnCut.setText("Cut");
		
		Button btnCopy = new Button(composite, SWT.NONE);
		btnCopy.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCopy.setBounds(223, 10, 65, 25);
		btnCopy.setText("Copy");
		
		Button btnPaste = new Button(composite, SWT.NONE);
		btnPaste.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnPaste.setBounds(294, 10, 65, 25);
		btnPaste.setText("Paste");
		
		Button btnFind = new Button(composite, SWT.NONE);
		btnFind.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnFind.setBounds(366, 10, 65, 25);
		btnFind.setText("Find...");
		
		Button btnClose = new Button(composite, SWT.NONE);
		btnClose.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newReference.removeTab(0);
			}
		});
		btnClose.setBounds(437, 10, 65, 25);
		btnClose.setText("Close");
		
		StyledText styledText = new StyledText(this, SWT.BORDER);
		styledText.setLocation(73, 45);
		styledText.setSize(743, 580);
		styledText.setFont(SWTResourceManager.getFont("Segoe UI", 10, SWT.NORMAL));
		styledText.setText("------------------------------------------------------------------------\r\nThis is the project README file. Here, you should describe your project.\r\nTell the reader (someone who does not know anything about this project)\r\nall he/she needs to know. The comments should usually include at least:\r\n------------------------------------------------------------------------\r\n\r\nPROJECT TITLE:\r\nPURPOSE OF PROJECT:\r\nVERSION or DATE:\r\nHOW TO START THIS PROJECT:\r\nAUTHORS:\r\nUSER INSTRUCTIONS:\r\n\r\n");
		
		Composite composite_2 = new Composite(this, SWT.NONE);
		composite_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		composite_2.setBounds(0, 46, 74, 579);
		
		Label label = new Label(composite_2, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBounds(72, 0, 2, 242);

	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}
}
