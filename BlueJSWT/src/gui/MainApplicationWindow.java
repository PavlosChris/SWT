package gui;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

import codewritten.BlueJSWTMyCode;
import codewritten.MainFrameVisibility;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.custom.ScrolledComposite;

public class MainApplicationWindow {

  protected static Shell shell;
  BlueJSWTMyCode newReference = new BlueJSWTMyCode();
  MainFrameVisibility newVisibility;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			MainApplicationWindow window = new MainApplicationWindow();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
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
		shell.setForeground(SWTResourceManager.getColor(SWT.COLOR_INFO_BACKGROUND));
		shell.setBackground(SWTResourceManager.getColor(245, 245, 245));
		shell.setSize(772, 672);
		shell.setText("BlueJ");
		shell.setLayout(null);
		
		Menu menu = new Menu(shell, SWT.BAR);
		shell.setMenuBar(menu);
		
		MenuItem mntmProject = new MenuItem(menu, SWT.CASCADE);
		mntmProject.setText("Project");
		
		Menu menu_1 = new Menu(mntmProject);
		mntmProject.setMenu(menu_1);
		
		MenuItem mntmNewProject = new MenuItem(menu_1, SWT.NONE);
		mntmNewProject.setText("New Project...");
		
		MenuItem mntmOpenProject = new MenuItem(menu_1, SWT.NONE);
		mntmOpenProject.setText("Open Project...");
		
		MenuItem mntmOpenRecent = new MenuItem(menu_1, SWT.CASCADE);
		mntmOpenRecent.setText("Open Recent");
		
		Menu menu_3 = new Menu(mntmOpenRecent);
		mntmOpenRecent.setMenu(menu_3);
		
		MenuItem mntmCusersuserdocumentsbluej = new MenuItem(menu_3, SWT.NONE);
		mntmCusersuserdocumentsbluej.setText("C:\\Users\\User1\\Documents\\BlueJ");
		
		MenuItem mntmOpenNonBluej = new MenuItem(menu_1, SWT.NONE);
		mntmOpenNonBluej.setText("Open Non BlueJ...");
		
		MenuItem mntmOpenZipjar = new MenuItem(menu_1, SWT.NONE);
		mntmOpenZipjar.setText("Open ZIP/JAR...");
		
		MenuItem mntmClose = new MenuItem(menu_1, SWT.NONE);
		mntmClose.setText("Close");
		
		MenuItem mntmSave = new MenuItem(menu_1, SWT.NONE);
		mntmSave.setText("Save");
		
		MenuItem mntmSaveAs = new MenuItem(menu_1, SWT.NONE);
		mntmSaveAs.setText("Save As...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmImport = new MenuItem(menu_1, SWT.NONE);
		mntmImport.setText("Import...");
		
		MenuItem mntmCreateJarFile = new MenuItem(menu_1, SWT.NONE);
		mntmCreateJarFile.setText("Create Jar File...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmPrint = new MenuItem(menu_1, SWT.NONE);
		mntmPrint.setText("Print...");
		
		new MenuItem(menu_1, SWT.SEPARATOR);
		
		MenuItem mntmQuit = new MenuItem(menu_1, SWT.NONE);
		mntmQuit.setText("Quit");
		
		MenuItem mntmEdit = new MenuItem(menu, SWT.CASCADE);
		mntmEdit.setText("Edit");
		
		Menu menu_4 = new Menu(mntmEdit);
		mntmEdit.setMenu(menu_4);
		
		MenuItem mntmNewClass = new MenuItem(menu_4, SWT.NONE);
		mntmNewClass.setText("New Class...");
		
		MenuItem mntmNewPackage = new MenuItem(menu_4, SWT.NONE);
		mntmNewPackage.setText("New Package...");
		
		MenuItem mntmNewCssFile = new MenuItem(menu_4, SWT.NONE);
		mntmNewCssFile.setText("New CSS File...");
		
		MenuItem mntmAddClassFrom = new MenuItem(menu_4, SWT.NONE);
		mntmAddClassFrom.setText("Add Class from File...");
		
		MenuItem mntmDelete = new MenuItem(menu_4, SWT.NONE);
		mntmDelete.setText("Delete");
		
		new MenuItem(menu_4, SWT.SEPARATOR);
		
		MenuItem mntmNewInheritanceArrow = new MenuItem(menu_4, SWT.NONE);
		mntmNewInheritanceArrow.setText("New Inheritance Arrow...");
		
		MenuItem mntmTools = new MenuItem(menu, SWT.CASCADE);
		mntmTools.setText("Tools");
		
		Menu menu_5 = new Menu(mntmTools);
		mntmTools.setMenu(menu_5);
		
		MenuItem mntmCompile = new MenuItem(menu_5, SWT.NONE);
		mntmCompile.setText("Compile");
		
		MenuItem mntmCompileSelected = new MenuItem(menu_5, SWT.NONE);
		mntmCompileSelected.setText("Compile Selected");
		
		MenuItem mntmRebuildPackage = new MenuItem(menu_5, SWT.NONE);
		mntmRebuildPackage.setText("Rebuild Package");
		
		MenuItem mntmResetJavaVirtual = new MenuItem(menu_5, SWT.NONE);
		mntmResetJavaVirtual.setText("Reset Java Virtual Machine");
		
		new MenuItem(menu_5, SWT.SEPARATOR);
		
		MenuItem mntmUseLibraryClass = new MenuItem(menu_5, SWT.NONE);
		mntmUseLibraryClass.setText("Use Library Class...");
		
		MenuItem mntmProjectDocumentation = new MenuItem(menu_5, SWT.NONE);
		mntmProjectDocumentation.setText("Project Documentation");
		
		MenuItem mntmTesting = new MenuItem(menu_5, SWT.CASCADE);
		mntmTesting.setText("Testing");
		
		Menu menu_6 = new Menu(mntmTesting);
		mntmTesting.setMenu(menu_6);
		
		MenuItem mntmRunTests = new MenuItem(menu_6, SWT.NONE);
		mntmRunTests.setText("Run Tests");
		
		MenuItem mntmEndRecording = new MenuItem(menu_6, SWT.NONE);
		mntmEndRecording.setEnabled(false);
		mntmEndRecording.setText("End Recording");
		
		MenuItem mntmCancelRecording = new MenuItem(menu_6, SWT.NONE);
		mntmCancelRecording.setEnabled(false);
		mntmCancelRecording.setText("Cancel Recording");
		
		MenuItem mntmTeam = new MenuItem(menu_5, SWT.CASCADE);
		mntmTeam.setText("Team");
		
		Menu menu_7 = new Menu(mntmTeam);
		mntmTeam.setMenu(menu_7);
		
		MenuItem mntmCheckoutProject = new MenuItem(menu_7, SWT.NONE);
		mntmCheckoutProject.setText("Checkout Project...");
		
		MenuItem mntmShareThisProject = new MenuItem(menu_7, SWT.NONE);
		mntmShareThisProject.setText("Share this Project...");
		
		new MenuItem(menu_7, SWT.SEPARATOR);
		
		MenuItem mntmUpdateFromRepository = new MenuItem(menu_7, SWT.NONE);
		mntmUpdateFromRepository.setEnabled(false);
		mntmUpdateFromRepository.setText("Update from Repository");
		
		MenuItem mntmCommitToRepository = new MenuItem(menu_7, SWT.NONE);
		mntmCommitToRepository.setEnabled(false);
		mntmCommitToRepository.setText("Commit to Repository");
		
		MenuItem mntmShare = new MenuItem(menu_7, SWT.NONE);
		mntmShare.setEnabled(false);
		mntmShare.setText("Share");
		
		MenuItem mntmProjectHistory = new MenuItem(menu_7, SWT.NONE);
		mntmProjectHistory.setEnabled(false);
		mntmProjectHistory.setText("Project History");
		
		new MenuItem(menu_7, SWT.SEPARATOR);
		
		MenuItem mntmTeamworkSettings = new MenuItem(menu_7, SWT.NONE);
		mntmTeamworkSettings.setEnabled(false);
		mntmTeamworkSettings.setText("Teamwork Settings");
		
		new MenuItem(menu_5, SWT.SEPARATOR);
		
		MenuItem mntmPreferences = new MenuItem(menu_5, SWT.NONE);
		mntmPreferences.setText("Preferences...");
		
		new MenuItem(menu_5, SWT.SEPARATOR);
		
		MenuItem mntmSubmit = new MenuItem(menu_5, SWT.NONE);
		mntmSubmit.setEnabled(false);
		mntmSubmit.setText("Submit...");
		
		MenuItem mntmView = new MenuItem(menu, SWT.CASCADE);
		mntmView.setText("View");
		
		Menu menu_8 = new Menu(mntmView);
		mntmView.setMenu(menu_8);
		
		MenuItem mntmShowUses = new MenuItem(menu_8, SWT.CHECK);
		mntmShowUses.setSelection(true);
		mntmShowUses.setText("Show Uses");
		
		MenuItem mntmShowInheritance = new MenuItem(menu_8, SWT.CHECK);
		mntmShowInheritance.setSelection(true);
		mntmShowInheritance.setText("Show Inheritance");
		
		new MenuItem(menu_8, SWT.SEPARATOR);
		
		MenuItem mntmShowDebugger = new MenuItem(menu_8, SWT.CHECK);
		mntmShowDebugger.setText("Show Debugger");
		
		MenuItem mntmShowTerminal = new MenuItem(menu_8, SWT.CHECK);
		mntmShowTerminal.setText("Show Terminal");
		
		MenuItem mntmShowCodePad = new MenuItem(menu_8, SWT.CHECK);
		mntmShowCodePad.setText("Show Code Pad");
		
		MenuItem mntmShowTeamAnd = new MenuItem(menu_8, SWT.CHECK);
		mntmShowTeamAnd.setText("Show Team and Test Controls");
		
		MenuItem mntmShowTestResults = new MenuItem(menu_8, SWT.CHECK);
		mntmShowTestResults.setText("Show Test Results");
		
		MenuItem mntmHelp = new MenuItem(menu, SWT.CASCADE);
		mntmHelp.setText("Help");
		
		Menu menu_2 = new Menu(mntmHelp);
		mntmHelp.setMenu(menu_2);
		
		MenuItem mntmAboutBluej = new MenuItem(menu_2, SWT.NONE);
		mntmAboutBluej.setText("About BlueJ");
		
		MenuItem mntmCheckVersion = new MenuItem(menu_2, SWT.NONE);
		mntmCheckVersion.setText("Check Version...");
		
		MenuItem mntmInstalledExtentions = new MenuItem(menu_2, SWT.NONE);
		mntmInstalledExtentions.setText("Installed Extentions");
		
		MenuItem mntmCopyright = new MenuItem(menu_2, SWT.NONE);
		mntmCopyright.setText("Copyright");
		
		new MenuItem(menu_2, SWT.SEPARATOR);
		
		MenuItem mntmBluejWebSite = new MenuItem(menu_2, SWT.NONE);
		mntmBluejWebSite.setText("BlueJ Web Site");
		
		MenuItem mntmOnlineDocumentation = new MenuItem(menu_2, SWT.NONE);
		mntmOnlineDocumentation.setText("Online Documentation");
		
		MenuItem mntmInteractiveTutorial = new MenuItem(menu_2, SWT.NONE);
		mntmInteractiveTutorial.setText("Interactive Tutorial");
		
		MenuItem mntmJavaClassLibraries = new MenuItem(menu_2, SWT.NONE);
		mntmJavaClassLibraries.setText("Java Class Libraries");
		
		
		Composite composite_2 = new Composite(shell, SWT.BORDER);
		composite_2.setVisible(false);
		composite_2.setBackground(SWTResourceManager.getColor(253, 245, 230));
		composite_2.setBounds(501, 392, 255, 185);
		
		Text text = new Text(composite_2, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(255, 255, 255));
		text.setBounds(0, 159, 251, 28);
		
		Composite composite_1 = new Composite(shell, SWT.BORDER);
		composite_1.setBackground(SWTResourceManager.getColor(253, 245, 230));
		composite_1.setBounds(10, 392, 746, 185);
		
		Button btnLeftarrow = new Button(composite_1, SWT.NONE);
		btnLeftarrow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newVisibility.changeVisibilityBtnLeftArrow();
			}
		});
		btnLeftarrow.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/ArrowLeft.PNG"));
		btnLeftarrow.setBounds(720, 78, 24, 44);
		
		Button btnRightarrow = new Button(composite_1, SWT.NONE);
		btnRightarrow.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/ArrowRight.PNG"));
		btnRightarrow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newVisibility.changeVisibilityBtnRightArrow();
			}
		});
		btnRightarrow.setVisible(false);
		btnRightarrow.setBounds(467, 78, 22, 44);
		
		Button btnNewClass = new Button(shell, SWT.NONE);
		btnNewClass.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newReference.addNewClassWindow();
			}
		});
		btnNewClass.setBounds(10, 21, 110, 25);
		btnNewClass.setText("New Class");
		
		Button btnArrowr = new Button(shell, SWT.NONE);
		btnArrowr.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnArrowr.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/arrow.PNG"));
		btnArrowr.setBounds(10, 52, 110, 25);
		
		Label lblInitialisingVirtualMachine = new Label(shell, SWT.NONE);
		lblInitialisingVirtualMachine.setBounds(10, 594, 204, 19);
		lblInitialisingVirtualMachine.setText("Initialising virtual machine... Done.");
		
		Button btnCompile = new Button(shell, SWT.NONE);
		btnCompile.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    lblInitialisingVirtualMachine.setText("Compiling... Done.");
			}
		});
		btnCompile.setBounds(10, 83, 110, 25);
		btnCompile.setText("Compile");
		
		Button btnDownarrow = new Button(shell, SWT.NONE);
		btnDownarrow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newVisibility.changeVisibilityBtnDownArrow();
			}
		});
		btnDownarrow.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/DownArrow.PNG"));
		btnDownarrow.setVisible(false);
		btnDownarrow.setBounds(45, 145, 41, 16);
		
		Label lblTeamwork = new Label(shell, SWT.NONE);
		lblTeamwork.setVisible(false);
		lblTeamwork.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.BOLD));
		lblTeamwork.setBounds(10, 167, 95, 18);
		lblTeamwork.setText("Teamwork");
		
		Button btnShare = new Button(shell, SWT.NONE);
		btnShare.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnShare.setVisible(false);
		btnShare.setBounds(10, 195, 110, 23);
		btnShare.setText("Share...");
		
		Label lblTesting = new Label(shell, SWT.NONE);
		lblTesting.setVisible(false);
		lblTesting.setFont(SWTResourceManager.getFont("Tahoma", 11, SWT.BOLD));
		lblTesting.setBounds(10, 220, 67, 18);
		lblTesting.setText("Testing");
		
		Button btnRunTests = new Button(shell, SWT.NONE);
		btnRunTests.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnRunTests.setVisible(false);
		btnRunTests.setBounds(30, 239, 90, 23);
		btnRunTests.setText("Run Tests");
		
		Button btnRecording = new Button(shell, SWT.RADIO);
		btnRecording.addSelectionListener(new SelectionAdapter() {
	    	@Override
	    	public void widgetSelected(SelectionEvent e) {
	    	}
	    });
		btnRecording.setVisible(false);
		btnRecording.setBounds(10, 279, 90, 16);
		btnRecording.setText("Recording");
		
		Button btnEnd = new Button(shell, SWT.NONE);
		btnEnd.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnEnd.setVisible(false);
		btnEnd.setBounds(45, 301, 75, 22);
		btnEnd.setText("End");
		
		Button btnCancel = new Button(shell, SWT.NONE);
		btnCancel.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnCancel.setVisible(false);
		btnCancel.setBounds(45, 328, 75, 22);
		btnCancel.setText("Cancel");
		
		Button btnUparrow = new Button(shell, SWT.NONE);
		btnUparrow.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/UpArrow.PNG"));
		btnUparrow.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newVisibility.changeVisibilityBtnUpArrow();
			}
		});
		btnUparrow.setBounds(52, 368, 41, 18);
		
		Button btnRetbtn = new Button(shell, SWT.NONE);
		btnRetbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                   lblInitialisingVirtualMachine.setText("Initializing Virtual Machine... Done.");
			}
		});
		btnRetbtn.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/return.PNG"));
		btnRetbtn.setBounds(727, 589, 29, 25);
		
		ProgressBar progressBar = new ProgressBar(shell, SWT.NONE);
		progressBar.setBounds(550, 592, 170, 18);
		
		ScrolledComposite scrolledComposite = new ScrolledComposite(shell, SWT.BORDER | SWT.H_SCROLL | SWT.V_SCROLL);
		scrolledComposite.setBounds(128, 10, 628, 376);
		scrolledComposite.setExpandHorizontal(true);
		scrolledComposite.setExpandVertical(true);
		
		Composite composite = new Composite(scrolledComposite, SWT.BORDER);
		composite.setLayout(null);
		composite.setDragDetect(false);
		composite.setBackground(SWTResourceManager.getColor(253, 245, 230));
		composite.setForeground(SWTResourceManager.getColor(0, 0, 0));
		
		Label lblButton = new Label(composite, SWT.NONE);
		lblButton.setBackground(SWTResourceManager.getColor(255, 222, 173));
		lblButton.setBounds(165, 58, 55, 15);
		lblButton.setText("FirstClass");
		
		Button btnButton = new Button(composite, SWT.NONE);
		btnButton.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newReference.addActionListenerToDocumentBtn();
			}
		});
		btnButton.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/document.PNG"));
		btnButton.setBounds(40, 20, 55, 70);
		
		Button btnClassbtn = new Button(composite, SWT.NONE);
		btnClassbtn.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
                    newReference.addActionListenerToClassBtn();
			}
		});
		btnClassbtn.addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(MouseEvent e) {
                    newReference.addMouseMoveListenerToClassBtn(e);
			}
		});
		btnClassbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent e) {
                    newReference.addMouseUpListenerToBtn(e);
			}
		});
		btnClassbtn.addDragDetectListener(new DragDetectListener() {
			public void dragDetected(DragDetectEvent e) {
                    newReference.setFirstClassDragged(true);
			}
		});
		btnClassbtn.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/ClassNull.png"));
		btnClassbtn.setBounds(146, 46, 92, 66);
		scrolledComposite.setContent(composite);
		scrolledComposite.setMinSize(composite.computeSize(SWT.DEFAULT, SWT.DEFAULT));
		
		
    newVisibility = new MainFrameVisibility(btnDownarrow, btnShare, 
                    btnRunTests, btnRecording,
                    btnEnd,  btnCancel,  btnUparrow,  btnRightarrow,  btnLeftarrow,
                    lblTeamwork,  lblTesting,  composite_2);
    newReference.setWidgets(composite, btnClassbtn, lblButton);  //added
    
	}
}
