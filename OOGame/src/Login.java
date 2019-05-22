import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Button;

public class Login {

	protected Shell shlMonsterchase;
	private Text text;
	private Text text_1;
	private String userstring;
	private String passstring;
	String masteruser = "xpert";
	String masterpass = "menace";

	/**
	 * Launch the application.
	 * 
	 * @param args
	 */

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlMonsterchase.open();
		shlMonsterchase.layout();
		while (!shlMonsterchase.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlMonsterchase = new Shell();
		shlMonsterchase.setSize(517, 364);
		shlMonsterchase.setText("Monster-Chase");

		shlMonsterchase.addListener(SWT.Close, new Listener() {
			public void handleEvent(Event event) {
				System.exit(0);
				event.doit = true;
			}
		});
		Label lblMonsterchaseGame = new Label(shlMonsterchase, SWT.NONE);
		lblMonsterchaseGame.setFont(SWTResourceManager.getFont("Yu Gothic UI", 16, SWT.BOLD));
		lblMonsterchaseGame.setBounds(110, 31, 280, 37);
		lblMonsterchaseGame.setText("Monster-Chase Game");

		Label lblXpertMenaceIi = new Label(shlMonsterchase, SWT.NONE);
		lblXpertMenaceIi.setFont(SWTResourceManager.getFont("Segoe UI", 13, SWT.NORMAL));
		lblXpertMenaceIi.setBounds(170, 74, 220, 46);
		lblXpertMenaceIi.setText("X-Pert Menace II");

		text = new Text(shlMonsterchase, SWT.BORDER);
		text.setBounds(170, 163, 220, 26);

		text_1 = new Text(shlMonsterchase, SWT.BORDER);
		text_1.setBounds(170, 211, 220, 26);

		Label lblUsername = new Label(shlMonsterchase, SWT.NONE);
		lblUsername.setBounds(94, 166, 70, 20);
		lblUsername.setText("Username:");

		Label lblPassword = new Label(shlMonsterchase, SWT.NONE);
		lblPassword.setBounds(94, 214, 70, 20);
		lblPassword.setText("Password:");

		final Button btnLogin = new Button(shlMonsterchase, SWT.NONE);
		btnLogin.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				userstring = text.getText().toString();
				passstring = text_1.getText().toString();
				// System.out.println(userstring);
				// System.out.println(passstring);
				if (userstring.equals(masteruser) && passstring.equals(masterpass)) {
					// System.out.println("Correct");
					shlMonsterchase.dispose();
				}
			}
		});
		btnLogin.setBounds(206, 263, 90, 30);
		btnLogin.setText("Login");
	}
}
