package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

import codewritten.BlueJSWTMyCode;

import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class PanelsWindow {

	protected Shell shell;
	BlueJSWTMyCode newReference;
	
	/**
	 * Open the window.
	 */
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void open(BlueJSWTMyCode newReference) {
		this.newReference = newReference;
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		shell.addListener(SWT.Close, new Listener() {
		      public void handleEvent(Event event) {
		    	  newReference.clearAll(event, shell);
		      }
		});
		newReference.setTabSelection();
		
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE));
		shell.setSize(830, 739);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmProject = new MenuItem(menu, SWT.CASCADE);
		mntmProject.setText("Project");
		
		Menu menu_1 = new Menu(mntmProject);
		mntmProject.setMenu(menu_1);
		
		MenuItem mntmMoveTab = new MenuItem(menu_1, SWT.CASCADE);
		mntmMoveTab.setText("Move tab...");
		
		Menu menu_3 = new Menu(mntmMoveTab);
		mntmMoveTab.setMenu(menu_3);
		
		MenuItem mntmToNewWindow = new MenuItem(menu_3, SWT.NONE);
		mntmToNewWindow.setEnabled(false);
		mntmToNewWindow.setText("To new window");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setText("Save");
		
		MenuItem mntmReload = new MenuItem(menu_1, SWT.NONE);
		mntmReload.setText("Reload");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmPrint = new MenuItem(menu_1, SWT.NONE);
		mntmPrint.setText("Print...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmClose = new MenuItem(menu_1, SWT.NONE);
		mntmClose.setText("Close");
		
		MenuItem mntmEdit = new MenuItem(menu, SWT.CASCADE);
		mntmEdit.setText("Edit");
		
		Menu menu_2 = new Menu(mntmEdit);
		mntmEdit.setMenu(menu_2);
		
		MenuItem mntmUndo = new MenuItem(menu_2, SWT.NONE);
		mntmUndo.setEnabled(false);
		mntmUndo.setText("Undo");
		
		MenuItem mntmRedo = new MenuItem(menu_2, SWT.NONE);
		mntmRedo.setEnabled(false);
		mntmRedo.setText("Redo");
		
		new MenuItem(menu_2, SWT.SEPARATOR);
		
		MenuItem mntmCut = new MenuItem(menu_2, SWT.NONE);
		mntmCut.setText("Cut");
		
		MenuItem mntmCopy = new MenuItem(menu_2, SWT.NONE);
		mntmCopy.setText("Copy");
		
		MenuItem mntmPaste = new MenuItem(menu_2, SWT.NONE);
		mntmPaste.setText("Paste");
		
		new MenuItem(menu_2, SWT.SEPARATOR);
		
		MenuItem mntmIndentMore = new MenuItem(menu_2, SWT.NONE);
		mntmIndentMore.setText("Indent more");
		
		MenuItem mntmIndentLess = new MenuItem(menu_2, SWT.NONE);
		mntmIndentLess.setText("Indent less");
		
		MenuItem mntmComment = new MenuItem(menu_2, SWT.NONE);
		mntmComment.setText("Comment");
		
		MenuItem mntmUncomment = new MenuItem(menu_2, SWT.NONE);
		mntmUncomment.setText("Uncomment");
		
		MenuItem mntmAutolayout = new MenuItem(menu_2, SWT.NONE);
		mntmAutolayout.setText("Auto-layout");
		
		new MenuItem(menu_2, SWT.SEPARATOR);
		
		MenuItem mntmInsertMethod = new MenuItem(menu_2, SWT.NONE);
		mntmInsertMethod.setText("Insert method");
		
		MenuItem mntmAddMethodComment = new MenuItem(menu_2, SWT.NONE);
		mntmAddMethodComment.setText("Add method comment");
		
		MenuItem mntmTools = new MenuItem(menu, SWT.CASCADE);
		mntmTools.setText("Tools");
		
		Menu menu_4 = new Menu(mntmTools);
		mntmTools.setMenu(menu_4);
		
		MenuItem mntmFind = new MenuItem(menu_4, SWT.NONE);
		mntmFind.setText("Find...");
		
		MenuItem mntmFindNext = new MenuItem(menu_4, SWT.NONE);
		mntmFindNext.setText("Find Next");
		
		MenuItem mntmFindNextBackward = new MenuItem(menu_4, SWT.NONE);
		mntmFindNextBackward.setText("Find Next Backward");
		
		MenuItem mntmReplace = new MenuItem(menu_4, SWT.NONE);
		mntmReplace.setText("Replace...");
		
		MenuItem mntmGoToLine = new MenuItem(menu_4, SWT.NONE);
		mntmGoToLine.setText("Go to line...");
		
		new MenuItem(menu_4, SWT.SEPARATOR);
		
		MenuItem mntmCompile = new MenuItem(menu_4, SWT.NONE);
		mntmCompile.setEnabled(false);
		mntmCompile.setText("Compile");
		
		MenuItem mntmSetclearBreakpoint = new MenuItem(menu_4, SWT.NONE);
		mntmSetclearBreakpoint.setEnabled(false);
		mntmSetclearBreakpoint.setText("Set/Clear Breakpoint");
		
		new MenuItem(menu_4, SWT.SEPARATOR);
		
		MenuItem mntmToggleDocumentationView = new MenuItem(menu_4, SWT.NONE);
		mntmToggleDocumentationView.setText("Toggle Documentation View");
		
		MenuItem mntmOptions = new MenuItem(menu, SWT.CASCADE);
		mntmOptions.setText("Options");
		
		Menu menu_5 = new Menu(mntmOptions);
		mntmOptions.setMenu(menu_5);
		
		MenuItem mntmIncreaseFontSize = new MenuItem(menu_5, SWT.NONE);
		mntmIncreaseFontSize.setText("Increase Font Size");
		
		MenuItem mntmDecreaseFontSize = new MenuItem(menu_5, SWT.NONE);
		mntmDecreaseFontSize.setText("Decrease Font Size");
		
		MenuItem mntmResetFontSize = new MenuItem(menu_5, SWT.NONE);
		mntmResetFontSize.setText("Reset Font Size");
		
		new MenuItem(menu_5, SWT.SEPARATOR);
		
		MenuItem mntmKeyBindings = new MenuItem(menu_5, SWT.NONE);
		mntmKeyBindings.setText("Key Bindings...");
		
		MenuItem mntmPreferences = new MenuItem(menu_5, SWT.NONE);
		mntmPreferences.setText("Preferences...");
		
		CTabFolder tabFolder = new CTabFolder(shell, SWT.BORDER);
		tabFolder.setBounds(0, 0, 824, 637);
		tabFolder.setSelectionBackground(Display.getCurrent().getSystemColor(SWT.COLOR_TITLE_INACTIVE_BACKGROUND_GRADIENT));
		
		Composite composite = new Composite(shell, SWT.NONE);
		composite.setBackground(SWTResourceManager.getColor(192, 192, 192));
		composite.setBounds(0, 634, 824, 56);
		
		Label label = new Label(composite, SWT.SEPARATOR | SWT.VERTICAL);
		label.setBackground(SWTResourceManager.getColor(128, 128, 128));
		label.setBounds(658, 0, 2, 64);
		
		Label lblSaved = new Label(composite, SWT.NONE);
		lblSaved.setBackground(SWTResourceManager.getColor(192, 192, 192));
		lblSaved.setAlignment(SWT.CENTER);
		lblSaved.setFont(SWTResourceManager.getFont("Tahoma", 13, SWT.BOLD | SWT.ITALIC));
		lblSaved.setBounds(666, 10, 127, 28);
		lblSaved.setText("Saved");

		newReference.setAppWindowFields(shell, tabFolder); //added
		newReference.addTabItems(); //added
		
		tabFolder.addMouseListener(new MouseListener() {
	        @Override
	        public void mouseUp(MouseEvent arg0) {
                    newReference.addTabFolderMouseUpListener(arg0);
	        }
	        
	        @Override
	        public void mouseDown(MouseEvent arg0) {
	        }
	        @Override
	        public void mouseDoubleClick(MouseEvent arg0) {
	        }
	    });	
	}
}
