package codewritten;

import org.eclipse.swt.widgets.Button;

public class NewClassWindowVisibility {

	private Button btnClass, btnAbstractClass, btnInterface,
		btnUnitTest, btnEnum, btnJavafxClass, btnJava, btnStride;
	private Button[] radioButtons;

	public NewClassWindowVisibility(Button btnClass, Button btnAbstractClass,
			Button btnInterface, Button btnUnitTest, Button btnEnum,
			Button btnJavafxClass, Button btnJava,
			Button btnStride) {

		this.btnClass = btnClass;
		this.btnAbstractClass = btnAbstractClass;
		this.btnInterface = btnInterface;
		this.btnUnitTest = btnUnitTest;
		this.btnEnum = btnEnum;
		this.btnJavafxClass = btnJavafxClass;
		this.btnJava = btnJava;
		this.btnStride = btnStride;
		radioButtons = new Button[]{btnUnitTest, btnEnum, btnJavafxClass,
				btnAbstractClass, btnInterface, btnClass};
	}

	public void setVisibilityBtnClass() {
		setRdButtonSelected(btnClass);
	}

	public void setVisibilityBtnAbstractClass() {
		setRdButtonSelected(btnAbstractClass);
	}

	public void setVisibilityBtnInterface() {
		setRdButtonSelected(btnInterface);
	}

	public void setVisibilityBtnUnitTest() {
		setRdButtonSelected(btnUnitTest);
	}

	public void setVisibilityBtnEnum() {
		setRdButtonSelected(btnEnum);
	}

	public void setVisibilityJavaFXClass() {
		setRdButtonSelected(btnJavafxClass);
	}

	private void setRdButtonSelected(Button buttonSelected) {
		buttonSelected.setSelection(true);
		for (int i = 0; i < 6; i++) {
			if (buttonSelected != radioButtons[i]) {
				radioButtons[i].setSelection(false);
			}
		}
	}

	public void setVisibilityBtnStride() {
		setVisibilityToggleBtn(false);
		btnJava.setSelection(false);
	}

	public void setVisibilityBtnJava() {
		setVisibilityToggleBtn(true);
		btnStride.setSelection(false);
	}

	private void setVisibilityToggleBtn(boolean visibilityValue) {
		btnJavafxClass.setVisible(visibilityValue);
		btnUnitTest.setVisible(visibilityValue);
		btnEnum.setVisible(visibilityValue);
	}

}
