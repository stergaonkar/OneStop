package OOPS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldLastName;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JPasswordField passwordField;
	private JTextField textFieldPhone;
	private JLabel lblMessage;
	private int count=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		setLocationRelativeTo(null);

		contentPane.add(panelHeader(), BorderLayout.NORTH);

		JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new BoxLayout(groupPanel, BoxLayout.Y_AXIS));
		groupPanel.setBackground(new Color(51, 51, 51));

		contentPane.add(groupPanel, BorderLayout.CENTER);

		groupPanel.add(panelFirstName());

		groupPanel.add(panelLastName());

		groupPanel.add(panelEmail());

		groupPanel.add(panelPassword());

		groupPanel.add(panelPhone());

		groupPanel.add(panelButton());

		groupPanel.add(panelError());

	}
	public JPanel panelHeader()
	{
		JLabel lblTitle=new JLabel();
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 23));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setText("REGISTRATION");
		
		JPanel panelHeader = new JPanel();
		panelHeader.setBackground(new Color(51, 0, 51));
		panelHeader.add(lblTitle);
		
		return panelHeader;
	}
	public JPanel panelFirstName()
	{
		JPanel panelName = new JPanel();
		panelName.setBackground(new Color(51, 51, 51));
		
		JLabel lblName = new JLabel("First Name: ");
		lblName.setFont(new Font("Dialog", Font.BOLD, 20));
		lblName.setForeground(Color.WHITE);
		panelName.add(lblName);
		
		
		textFieldName = new JTextField();
		panelName.add(textFieldName);
		textFieldName.setColumns(10);
		textFieldName.setFont(new Font("Dialog", Font.BOLD, 20));
		
		return panelName;
	}
	
	public JPanel panelLastName()
	{
		JPanel panelLastName = new JPanel();
		panelLastName.setBackground(new Color(51, 51, 51));
		
		JLabel lblLastName = new JLabel("Last Name:  ");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Dialog", Font.BOLD, 20));
		panelLastName.add(lblLastName);
		
		textFieldLastName = new JTextField();
		panelLastName.add(textFieldLastName);
		textFieldLastName.setColumns(10);
		textFieldLastName.setFont(new Font("Dialog", Font.BOLD, 20));
		
		return panelLastName;
	}
	public JPanel panelEmail()
	{
		JPanel panelEmail= new JPanel();
		panelEmail.setBackground(new Color(51, 51, 51));
		
		JLabel lblEmail = new JLabel("Email Id:   ");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		lblEmail.setForeground(Color.WHITE);
		panelEmail.add(lblEmail);
		
		textFieldEmail = new JTextField();
		panelEmail.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		textFieldEmail.setFont(new Font("Dialog", Font.BOLD, 20));
		
		textFieldEmail.addActionListener(new ActionListener() {
		      public void actionPerformed(ActionEvent e) {
		    	  DatabaseConn db=new DatabaseConn();
		    	  int value=db.CheckEmail(textFieldEmail.getText());
		    	  lblMessage.setVisible(false);
				   if(value > 0)
				   {
					   lblMessage.setVisible(true);
					   lblMessage.setText("Email already exists. Please enter different email");
					   
				   }
		      }
		    });
		return panelEmail;
	}
	public JPanel panelPassword()
	{
		JPanel panelPassword= new JPanel();
		
		panelPassword.setBackground(new Color(51, 51, 51));
		
		
		JLabel lblPassword = new JLabel("Password:   ");
		lblPassword.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPassword.setForeground(Color.WHITE);
		panelPassword.add(lblPassword);
		
		passwordField = new JPasswordField();
		panelPassword.add(passwordField);
		passwordField.setColumns(10);
		passwordField.setFont(new Font("Dialog", Font.BOLD, 20));
		
		return panelPassword;
	}
	public JPanel panelPhone()
	{
		JPanel panelPhoneNo= new JPanel();
		
		panelPhoneNo.setBackground(new Color(51, 51, 51));
		
		JLabel lblPhone = new JLabel("Phone No:   ");
		lblPhone.setForeground(Color.WHITE);
		lblPhone.setFont(new Font("Dialog", Font.BOLD, 20));
		panelPhoneNo.add(lblPhone);
		
		textFieldPhone = new JTextField();
		panelPhoneNo.add(textFieldPhone);
		textFieldPhone.setColumns(10);
		textFieldPhone.setFont(new Font("Dialog", Font.BOLD, 20));
		
		return panelPhoneNo;
	}
	public JPanel panelButton()
	{
		JPanel panelButton= new JPanel();
		panelButton.setBackground(new Color(51, 51, 51));
		
		JButton btnCancel = new JButton("Home");
		btnCancel.setFont(new Font("Dialog", Font.BOLD, 20));
		btnCancel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnCancel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hp=new Home();
				hp.setVisible(true);
				//reg.pack();
				hp.setBounds(100, 100, 726, 511);
				hp.setLocationRelativeTo(null);
				hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setBackground(new Color(204, 0, 51));
		btnCancel.setOpaque(true);
		panelButton.add(btnCancel);
		
		
		JButton btnSignup = new JButton("Signup");
		btnSignup.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSignup.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				count=validation();
				if(count==0)
				{
				DatabaseConn db=new DatabaseConn();
				String password=new String(passwordField.getPassword());
				db.InsertRegisterQuery(textFieldName.getText(),textFieldLastName.getText(),textFieldEmail.getText(),password,textFieldPhone.getText());
				lblMessage.setForeground(Color.GREEN);
				lblMessage.setText("Registered Successfully.");
				}
				
				
			}
		});
		
		btnSignup.setForeground(Color.WHITE);
		
		btnSignup.setOpaque(true);
		
		btnSignup.setFont(new Font("Dialog", Font.BOLD, 20));
		
		btnSignup.setBackground(new Color(0, 153, 204));
		panelButton.add(btnSignup);
		
		return panelButton;

	}
	
	public JPanel panelError()
	{
		JPanel panelError = new JPanel();
		
		panelError.setBackground(new Color(51, 51, 51));
		
	
		lblMessage = new JLabel("New label");
		
		
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMessage.setForeground(new Color(235, 0, 51));
		lblMessage.setVisible(false);
		
		panelError.add(lblMessage);
		
		return panelError;
	}
	public int validation()
	{
		lblMessage.setVisible(true);
		if(textFieldName.getText().equals(""))
		{
			lblMessage.setText("Please enter First Name");
			return 1;
		}
		else if(textFieldLastName.getText().equals(""))
		{
			lblMessage.setText("Please enter Last Name");
			return 1;
		}
		else if(textFieldEmail.getText().equals(""))
		{
			lblMessage.setText("Please enter Email Id");
			return 1;
		}
		else if(passwordField.getPassword().length==0)
		{
			lblMessage.setText("Please enter Password");
			return 1;
		}
		else if(textFieldPhone.getText().equals(""))
		{
			lblMessage.setText("Please enter Phone No");
			return 1;
		}
		else
		{
			return 0;
			
		}
		
	}

}
