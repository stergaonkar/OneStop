package OOPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;


public class Reviews extends JFrame {
	private JPanel contentPane;
	private String Email;
	private String name;
	private boolean isLogin=false;
	private JTextArea textAreaComments;
	private JTextField text;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reviews frame = new Reviews();
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
	public Reviews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 361);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new GridLayout(4,1,0,0));
		setContentPane(contentPane);
		
		
		contentPane.add(headerPanel());
		
		contentPane.add(commentsPanel());
		
		contentPane.add(sliderPanel());
		
		contentPane.add(submitPanel());
		
		
		
		
		
		
	}
	
	public JPanel headerPanel()
	{
		
		JPanel panel_1 = new JPanel(new GridLayout(2,1,0,0));
		panel_1.setBackground(new Color(51, 51, 51));
		
		
		JPanel panel_header = new JPanel();
		panel_header.setBackground(new Color(51, 0, 51));
		panel_1.add(panel_header);
		
		JLabel lblHeader = new JLabel("RATE US");
		lblHeader.setFont(new Font("Dialog", Font.BOLD, 23));
		lblHeader.setForeground(Color.WHITE);
		panel_header.add(lblHeader);
		
		return panel_1;
	}
	
	public JPanel commentsPanel()
	{
		JPanel panel_comment = new JPanel();
		panel_comment.setBackground(new Color(51, 51, 51));
		
		
		JLabel lblComments = new JLabel("Comments:");
		lblComments.setForeground(Color.WHITE);
		lblComments.setFont(new Font("Dialog", Font.BOLD, 20));
		panel_comment.add(lblComments);
		
		textAreaComments = new JTextArea("",3,20);
		textAreaComments.setLineWrap(true);
		JScrollPane scroll=new JScrollPane(textAreaComments);
		
		panel_comment.add(scroll);
		
		return panel_comment;
		
		
		
	}
	
	public JPanel sliderPanel() {
		JPanel panel_slider = new JPanel();
		panel_slider.setBackground(new Color(51, 51, 51));
		
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL,0,5,1);
		slider.setForeground(Color.WHITE);
		slider.setMajorTickSpacing(5);
		slider.setMinorTickSpacing(1);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
	    text = new JTextField(20);
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e)
			{
				int val=((JSlider)e.getSource()).getValue();
				text.setText(Integer.toString(val));
			
			}
		});
		
		panel_slider.add(slider);
		
		return panel_slider;
	}
	
	public JPanel submitPanel() {
		JPanel submit_panel = new JPanel();
		submit_panel.setBorder(null);
		submit_panel.setBackground(new Color(51, 51, 51));
		
		JButton btnBack = new JButton("Home");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hp = new Home();
				hp.setVisible(true);
				hp.lblUserName.setText(getName());
				hp.SetEmail(getEmail());
				if (getIsLogin()) {
					hp.lblSignin.setText("Signout");
					hp.lblRegister.setVisible(false);
					hp.SetIsLogin(getIsLogin());
				}
				hp.setBounds(100, 100, 726, 511);
				hp.setLocationRelativeTo(null);
				hp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setOpaque(true);
		btnBack.setBackground(new Color(204,0,0));
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setForeground(Color.WHITE);
		submit_panel.add(btnBack);


		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSubmit.setForeground(Color.WHITE);
		btnSubmit.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSubmit.setOpaque(true);
		btnSubmit.setBackground(new Color(0, 153, 204));

		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				DatabaseConn db = new DatabaseConn();
				db.UpdateRegisterQuery(textAreaComments.getText(), Integer.parseInt(text.getText()), getEmail());
				JOptionPane.showMessageDialog(contentPane, "Thank you!", "", JOptionPane.PLAIN_MESSAGE);

			}
		});

		submit_panel.add(btnSubmit);

		
		return submit_panel;
	}
	public void SetEmail(String Email)
	{
		this.Email=Email;
	}
	public String getEmail()
	{
		return this.Email;
	}
	public void SetName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return this.name;
	}
	public void SetIsLogin(boolean isLogin)
	{
		this.isLogin=isLogin;
	}
	public boolean getIsLogin()
	{
		return this.isLogin;
	}
}
