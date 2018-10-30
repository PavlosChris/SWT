package codewritten;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class ClassWidget {

	private String name;
	private int windowX, windowY;
	private Image img;
	private boolean dragged;
	private Composite composite;
	private Button classBtn;
	private Label classLbl;

	public ClassWidget(final String name, final Image img,
			final BlueJSWTMyCode newReference, final Composite composite) {
		this.name = name;
		this.img = img;
		dragged = false;
		this.composite = composite;
	}

	public void setClassBtnAndLbl(final Button classBtn, final Label classLbl) {
		this.classBtn = classBtn;
		this.classLbl = classLbl;
	}

	public Button getClassBtn() {
		return classBtn;
	}

	public Label getClassLbl() {
		return classLbl;
	}

    public void setDragged(final boolean dragged) {
		this.dragged = dragged;
	}

    public Composite getComposite() {
    	return composite;
    }

	public boolean getDragged() {
		return dragged;
	}

	public void setWindowX(final int winX) {
		windowX = winX;
	}

	public void setWindowY(final int winY) {
		windowY = winY;
	}

	public String getName() {
		return name;
	}

	public int getWindowX() {
		return windowX;
	}

	public int getWindowY() {
		return windowY;
	}

	public Image getImageIcon() {
		return img;

	}
}
