package codewritten;

import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

public class MainFrameVisibility {

	private Button btnDownarrow, btnShare, btnRunTests, btnRecording, btnEnd,
		btnCancel, btnUparrow, btnRightarrow, btnLeftarrow;
	private Label lblTeamwork, lblTesting;
	private Composite composite_2;

	public MainFrameVisibility(Button btnDownarrow, Button btnShare,
			Button btnRunTests, Button btnRecording,
			Button btnEnd, Button btnCancel, Button btnUparrow, Button btnRightarrow,
			Button btnLeftarrow, Label lblTeamwork, Label lblTesting, 
			Composite composite_2) {
		this.btnDownarrow = btnDownarrow;
		this.btnShare = btnShare;
		this.btnRunTests = btnRunTests;
		this.btnRecording = btnRecording;
		this.btnEnd = btnEnd;
		this.btnCancel = btnCancel;
		this.btnUparrow = btnUparrow;
		this.btnRightarrow = btnRightarrow;
		this.btnLeftarrow = btnLeftarrow;
		this.lblTeamwork = lblTeamwork;
		this.lblTesting = lblTesting;
		this.composite_2 = composite_2;

	}

	public void changeVisibilityBtnDownArrow() {
		changeVisibilityUpDownArrows(false);
	}

	public void changeVisibilityBtnUpArrow() {
		changeVisibilityUpDownArrows(true);
	}

	private void changeVisibilityUpDownArrows(boolean visibilityValue) {
		btnDownarrow.setVisible(visibilityValue);
		lblTeamwork.setVisible(visibilityValue);
		btnShare.setVisible(visibilityValue);
		lblTesting.setVisible(visibilityValue);
		btnRunTests.setVisible(visibilityValue);
		btnRecording.setVisible(visibilityValue);
		btnEnd.setVisible(visibilityValue);
		btnCancel.setVisible(visibilityValue);
		btnUparrow.setVisible(!visibilityValue);

	}

	public void changeVisibilityBtnLeftArrow() {
		changeVisibilityLeftRightArrows(true);
	}

	public void changeVisibilityBtnRightArrow() {
		changeVisibilityLeftRightArrows(false);
	}

	private void changeVisibilityLeftRightArrows(boolean visibilityValue) {
		composite_2.setVisible(visibilityValue);
		btnRightarrow.setVisible(visibilityValue);
		btnLeftarrow.setVisible(!visibilityValue);
	}
}
