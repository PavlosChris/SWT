package codewritten;

import gui.ClassCreationWindow;
import gui.ClassInformationPanel;
import gui.MainApplicationWindow;
import gui.PanelsWindow;
import gui.ProjectInformationPanel;
import java.util.ArrayList;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.custom.CTabItem;
import org.eclipse.swt.events.DragDetectEvent;
import org.eclipse.swt.events.DragDetectListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;


public class BlueJSWTMyCode {
	/*
		NOTE: Class Created with the purpose of not interfering with the code produced by
		the GUI designers and NOT for creating extensible and/or easily maintainable software.
	*/

	private ClassWidget firstClass;
	private Composite composite;
	private PanelsWindow appWindow = new PanelsWindow();
	private Button btnClassbtn; 
	private Label lblButton;
	private int appWindowOpen = 0; 
	private int newWindowX = 100; 
	private int newWindowY = 185;

	//Panels Window Fields
	private Shell shell;
	private CTabFolder tabFolder;
	private ArrayList<ProjectInformationPanel> docList = new ArrayList<ProjectInformationPanel>();
	private ArrayList<ClassInformationPanel> classList = new ArrayList<ClassInformationPanel>();
	private ArrayList<String> classNames = new ArrayList<>();
	private static boolean docSelection;
	private static Shell tempShell = new Shell();

	//Main Application Window Code
	public BlueJSWTMyCode() {
		addFirstClass();
	}

	public final void setWidgets(final Composite composite,
			final Button btnClassbtn, final Label lblButton) {
		this.composite = composite;
		this.btnClassbtn = btnClassbtn;
		this.lblButton = lblButton;
	}

	private void addFirstClass() {
		ClassWidget firstClass = new ClassWidget("First Class",
				SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/ClassNull.png"),
			this, composite);
		this.firstClass = firstClass;
	}

	public final void setFirstClassDragged(final boolean set) {
		firstClass.setDragged(set);
	}

	public final void addNewClassWindow() {
		ClassCreationWindow newClassWindow = new ClassCreationWindow();
		newClassWindow.open(this, composite);
	}

	public final void addActionListenerToDocumentBtn() {
		if (appWindowOpen == 0) {
			appWindowOpen++;
			addDocumentToList();
			appWindow.open(this);
			setTabSelection();
		} else {
			addDocumentToList();
			refresh();
		}
	}

	public final void addActionListenerToClassBtn() {
		if (!firstClass.getDragged()) {
			if (appWindowOpen == 0) {
				appWindowOpen++;
				addClassToListIfPossible("FirstClass");
				appWindow.open(this);
				setTabSelection();
			} else {
				addClassToListIfPossible("FirstClass");
				refresh();
			}
		}
		firstClass.setDragged(false);
	}

	private void addClassToListIfPossible(final String newName) {
		if (checkIfNameEligible(newName)) {
			addClassToList(newName);
		}
	}

	public final void addMouseMoveListenerToClassBtn(final MouseEvent e) {
		setUpMouseListener(e);
	}

	public final void addMouseUpListenerToBtn(final MouseEvent e) {
		setUpMouseListener(e);
	}
	
	private void setUpMouseListener(final MouseEvent e) {
		if (firstClass.getDragged()) {
			firstClass.setWindowX(e.x + btnClassbtn.getLocation().x - 25);
			firstClass.setWindowY(e.y + btnClassbtn.getLocation().y - 25);

			btnClassbtn.setBounds(firstClass.getWindowX(), firstClass.getWindowY(), 93, 59);
			lblButton.setBounds(firstClass.getWindowX() + 10, 
					firstClass.getWindowY() + 10, 46, 14);
		}
	}

	public final void createClassIcon(final String className, final Shell shell) {
		ClassWidget newClass = new ClassWidget(className,
				SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/ClassNull.png"), 
			this, composite);
		initializeVariables(newClass);

		Label lblButton = createNewLabel(newClass);
		Button btnNewClassbtn = createNewBtn(newClass);
		newClass.setClassBtnAndLbl(btnNewClassbtn, lblButton);

		addListenersToBtn(newClass);
		shell.dispose();
	}

	private void initializeVariables(final ClassWidget newClass) {
		if (newWindowX<=400) newWindowX += 100;
		newClass.setWindowX(newWindowX);
		newClass.setWindowY(newWindowY);
	}

	private Label createNewLabel(final ClassWidget newClass) {
		Label lblButton = new Label(newClass.getComposite(), SWT.NONE);
		lblButton.setBackground(SWTResourceManager.getColor(255, 222, 173));
		lblButton.setBounds(newClass.getWindowX() + 10, newClass.getWindowY() + 10, 46, 14);
		lblButton.setText(newClass.getName());
		return lblButton;
	}

	private Button createNewBtn(final ClassWidget newClass) {
		Button btnNewClassbtn = new Button(newClass.getComposite(), SWT.NONE);
		btnNewClassbtn.setImage(SWTResourceManager.getImage(MainApplicationWindow.class, "/org/eclipse/wb/swt/ClassNull.png"));
		btnNewClassbtn.setBounds(newClass.getWindowX(), newClass.getWindowY(), 93, 59);
		return btnNewClassbtn;
	}

	private void addListenersToBtn(final ClassWidget newClass) {
		addSelectionListenerToBtn(newClass);
		addMouseMoveListenerToButton(newClass);
		addMouseListenerToButton(newClass);
		addDragDetectListenerToButton(newClass);
	}

	private void addSelectionListenerToBtn(final ClassWidget newClass) {
		newClass.getClassBtn().addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				excecuteButtonAction(e, newClass);
			}
		});
	}

	private void excecuteButtonAction(final SelectionEvent e, final ClassWidget newClass) {
		if (!newClass.getDragged()) {
			if (appWindowOpen == 0) {
				appWindowOpen++;
				addClassToListIfPossible(newClass.getName());
				appWindow.open(this);
			} else {
				addClassToListIfPossible(newClass.getName());
				refresh();
			}
		}
		newClass.setDragged(false);

	}

	private void addMouseMoveListenerToButton(final ClassWidget newClass) {
		newClass.getClassBtn().addMouseMoveListener(new MouseMoveListener() {
			public void mouseMove(final MouseEvent e) {
				setOnMouseDrag(e, newClass);
			}
		});
	}

	private void setOnMouseDrag(final MouseEvent mouseEvent, final ClassWidget newClass) {
		if (newClass.getDragged()) {
			newClass.setWindowX(calculateNewX(mouseEvent, newClass.getClassBtn()));
			newClass.setWindowY(calculateNewY(mouseEvent, newClass.getClassBtn()));

			newClass.getClassBtn().setBounds(newClass.getWindowX(), newClass.getWindowY(), 93, 59);
			newClass.getClassLbl().setBounds(newClass.getWindowX() + 10, newClass.getWindowY() + 10, 46, 14);
		}
	}

	private void addMouseListenerToButton(final ClassWidget newClass) {
		newClass.getClassBtn().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(final MouseEvent e) {
				setOnMouseDrag(e, newClass);
			}
			@Override
			public void mouseDown(final MouseEvent e) {
			}
		});
	}

	private int calculateNewX(final MouseEvent mouseEvent, final Button btnNewClassbtn) {
		return mouseEvent.x + btnNewClassbtn.getLocation().x - 25;
	}

	private int calculateNewY(final MouseEvent mouseEvent, final Button btnNewClassbtn) {
		return mouseEvent.y + btnNewClassbtn.getLocation().y - 25;
	}

	private void addDragDetectListenerToButton(final ClassWidget newClass) {
		newClass.getClassBtn().addDragDetectListener(new DragDetectListener() {
			public void dragDetected(final DragDetectEvent e) {
				newClass.setDragged(true);
			}
		});
	}

	//Panels Window Code
	public final void setAppWindowFields(final Shell shell, final CTabFolder tabFolder) {
		this.shell = shell;
		this.tabFolder = tabFolder;
	}

	public final void addTabFolderMouseUpListener(final MouseEvent arg0) {
		CTabFolder curFolder = (CTabFolder) arg0.widget;
        Point eventLocation = new Point(arg0.x, arg0.y);
        CTabItem item = curFolder.getItem(eventLocation);
        if (item == null) {
            return;
        }

        if (checkIfClickIsOnXImage(eventLocation, item)) {
            removeTab(tabFolder.getSelectionIndex());
            clearIfTabItemsZero();
        }
	}

	public final void removeTab(final int index) {
		removeTabFromList(tabFolder.getItem(index));
		tabFolder.getItem(index).dispose();
		clearIfTabItemsZero();
	}

	private void clearIfTabItemsZero() {
		if (tabFolder.getItemCount() == 0) {
        	clearAll();
        	shell.setVisible(false);
        }
	}

	private void clearAll() {
		clearTabs();
		clearTabs();
		resetAppWindowCounter();
		docList.clear();
		classList.clear();
		classNames.clear();
	}

	private void clearTabs() {
		for (int i = 0; i < tabFolder.getItemCount(); i++) {
			tabFolder.getItem(i).dispose();
		}
	}

	private void resetAppWindowCounter() {
		appWindowOpen = 0;
	}

	public final void clearAll(final Event event, final Shell shell) {
		event.doit = false;
		clearAll();
		shell.setVisible(false);
	}

	private boolean checkIfClickIsOnXImage(final Point eventLocation, final CTabItem item) {
		Image image = item.getImage();
		return (eventLocation.x >= item.getBounds().x + image.getBounds().x
				&& eventLocation.x <= item.getBounds().x
				+ image.getBounds().x + image.getBounds().width
                && eventLocation.y >= item.getBounds().y + image.getBounds().y
                && eventLocation.y <= item.getBounds().y + image.getBounds().y + image.getBounds().height);
	}

	private void addClassTabItems() {
		for (int i = 0; i < classList.size(); i++) {
			classList.get(i).setParent(tabFolder);
			createCTabItem(classNames.get(i)).setControl(classList.get(i));
		}
	}

	private CTabItem createCTabItem(final String className) {
		CTabItem cTabItem = new CTabItem(tabFolder, SWT.NONE);
		cTabItem.setText(className);
		cTabItem.setImage(SWTResourceManager.getImage
			(MainApplicationWindow.class, "/org/eclipse/wb/swt/CloseTab.PNG"));
		return cTabItem;
	}

	private void addDocumentToList() {
		if (docList.size() == 0) {
			docSelection = true;
			ProjectInformationPanel docCom = new ProjectInformationPanel(tempShell, 0, this);
			docList.add(docCom);
			shellSetActive();
		}
	}

	private boolean checkIfNameEligible(final String newName) {
		for (int i = 0; i < classList.size(); i++) {
			if (classNames.get(i).equals(newName)) {
				return false;
			}
		}
		return true;
	}

	private void addClassToList(final String className) {
		ClassInformationPanel classCom = new ClassInformationPanel(tempShell, 0, this, className);
		classNames.add(className);
		classList.add(classCom);
		shellSetActive();
	}

	private void shellSetActive() {
		if (docList.size() + classList.size() > 1) {
			shell.setActive();
		}
	}

	public final void setTabSelection() {
		if (docList.size() + classList.size() > 1) {
			tabFolder.setSelection(classList.size() + docList.size() - 1);
		}
		if (docSelection) {
			tabFolder.setSelection(0);
			docSelection = false;
		}
	}

	public final int getTabIndex() {
		return tabFolder.getSelectionIndex();
	}

	private void removeTabFromList(final CTabItem cTabItem) {
		for (int i = 0; i < classList.size(); i++) {
			if (cTabItem.getText().equals(classNames.get(i))) {
				classList.remove(i);
				classNames.remove(i);
			}
		}
	}

	private void refresh() {
		clearTabs();
		clearTabs();
		addTabItems();
		setTabSelection();
	}

	public final void addTabItems() {
		addDocumentTabItems();
		addClassTabItems();
	}

	private void addDocumentTabItems() {
		for (int i = 0; i < docList.size(); i++) {
			docList.get(i).setParent(tabFolder);
			createCTabItem("README.TXT").setControl(docList.get(i));
		}
	}

	public final void addKeyReleasedLisener(final Text text, final Button btnOk) {
		if (!text.getText().equals("")) {
			btnOk.setEnabled(true);
		} else {
			btnOk.setEnabled(false);
		}
	}

}


