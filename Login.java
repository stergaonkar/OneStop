package OOPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JPasswordField;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import java.awt.Rectangle;

public class Login extends JFrame {

	/**
	 * Launch the application.
	 */
	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	protected String userName;
	private String Email;
	private boolean isLogin = false;
	private JLabel lblMessage;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
        contentPane = new JPanel(new BorderLayout());
		contentPane.setBackground(new Color(51, 51, 51));
        setContentPane(contentPane);

        contentPane.add(panelHeader(), BorderLayout.NORTH);
		

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(4, 2, 0, 0));
		topPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		
        contentPane.add(topPanel, BorderLayout.CENTER);
        
        topPanel.add(panelEmail());

        topPanel.add(panelPassword());

		
		JPanel panel_button = new JPanel();
		panel_button.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_button.setBackground(new Color(51, 51, 51));
		topPanel.add(panel_button);

		panel_button.add(btnCancel());

		panel_button.add(btnLogin());
		
		topPanel.add(panelError());

	}
	public JPanel panelHeader()
	{
		JPanel titlePanel = new JPanel();
		titlePanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		titlePanel.setBackground(new Color(51, 0, 51));

		JLabel lblLogin = new JLabel("LOGIN HERE");
		lblLogin.setForeground(new Color(235, 235, 235));
		lblLogin.setFont(new Font("Dialog", Font.BOLD, 23));
		titlePanel.add(lblLogin);
		
		return titlePanel;
	}
	
	public JPanel panelEmail()
	{
		JPanel panelEmail = new JPanel();
		
		panelEmail.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelEmail.setBackground(new Color(51, 51, 51));

		JLabel lblEmail = new JLabel("Email:    ");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEmail.setForeground(Color.WHITE);
		panelEmail.add(lblEmail);

		textFieldEmail = new JTextField();
		panelEmail.add(textFieldEmail);
		textFieldEmail.setColumns(13);
		textFieldEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		
		return panelEmail;
	}
	
	public JPanel panelPassword()
	{
		JPanel panelPassword = new JPanel();
		panelPassword.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelPassword.setBackground(new Color(51, 51, 51));

		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPassword.setForeground(Color.WHITE);
		panelPassword.add(lblPassword);

		passwordField = new JPasswordField();
		panelPassword.add(passwordField);
		passwordField.setColumns(13);
		passwordField.setFont(new Font("Dialog", Font.BOLD, 20));
		
		return panelPassword;

	}
	public JButton btnCancel()
	{
		JButton btnCancel = new JButton("Home");
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBounds(new Rectangle(0, 0, 50, 50));
		btnCancel.setBackground(new Color(204, 0, 51));
		btnCancel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCancel.setOpaque(true);
		

		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hp = new Home();
				hp.setVisible(true);
				hp.setBounds(100, 100, 726, 511);
				hp.setLocationRelativeTo(null);
				hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		
		return btnCancel;
	}
	
	public JButton btnLogin()
	{
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("Dialog", Font.BOLD, 20));
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setBounds(new Rectangle(0, 0, 30, 30));
		btnLogin.setOpaque(true);
		btnLogin.setBackground(new Color(51, 153, 204));
		btnLogin.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));

		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (textFieldEmail.getText().equals("")) {
					lblMessage.setText("Please enter email");
					lblMessage.setVisible(true);
					return;
				}

				if (passwordField.getPassword().length == 0) {
					lblMessage.setText("Please enter password");
					lblMessage.setVisible(true);
					return;
				}

				DatabaseConn db = new DatabaseConn();
				String password = new String(passwordField.getPassword());

				// int value=db.CheckLoginRecord(textField.getText(),password);
				userName = db.CheckLoginRecord(textFieldEmail.getText(), password);

				if (userName != "") {
					int passValue = db.CheckPassword(textFieldEmail.getText(), password);
					if (passValue > 0) {
						JOptionPane.showMessageDialog(contentPane, "Login Successful!", "", JOptionPane.PLAIN_MESSAGE);
						Login l = new Login();
						lblMessage.setText("");
						lblMessage.setVisible(false);
						Home mod = new Home();
						mod.SetIsLogin(true);
						mod.setVisible(true);
						mod.SetEmail(textFieldEmail.getText());
						mod.lblUserName.setVisible(true);
						mod.lblUserName.setText("Hello " + userName);
						mod.lblSignin.setText("Signout");
						mod.lblRegister.setVisible(false);
						// reg.pack();
						mod.setBounds(100, 100, 726, 511);
						mod.setLocationRelativeTo(null);
						mod.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						dispose();

					} else {
						lblMessage.setText("Please enter correct password");
						lblMessage.setVisible(true);
					}

				} else {
					lblMessage.setText("Incorrect Email");
					lblMessage.setVisible(true);
				}
			}
		});
		return btnLogin;
	}

	public JPanel panelError() {
		JPanel panel_error = new JPanel(new BorderLayout());

		panel_error.setBackground(new Color(51, 51, 51));

		lblMessage = new JLabel("New label");
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMessage.setForeground(new Color(235, 0, 51));
		lblMessage.setVisible(false);

		panel_error.add(lblMessage, BorderLayout.WEST);

		JLabel lblSignup = new JLabel("Signup");
		lblSignup.setAlignmentX(2.0f);

		lblSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration reg = new Registration();
				reg.setVisible(true);
				// reg.pack();
				reg.setBounds(100, 100, 600, 600);
				reg.setLocationRelativeTo(null);
				reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();

			}
		});
		lblSignup.setFont(new Font("Dialog", Font.BOLD, 20));
		lblSignup.setForeground(Color.WHITE);
		lblSignup.setBounds(373, 270, 76, 37);
		panel_error.add(lblSignup, BorderLayout.EAST);

		return panel_error;
	}
	
	public void SetEmail(String Email) {
		this.Email = Email;
	}

	public String getEmail() {
		return this.Email;
	}

	public void SetIsLogin(boolean isLogin) {
		this.isLogin = isLogin;
	}

	public boolean getIsLogin() {
		return this.isLogin;
	}

}
