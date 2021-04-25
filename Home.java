package OOPS;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;
	public JLabel lblUserName;
	private String Email;
    public JLabel lblSignin;
    public JLabel lblRegister;
    private boolean isLogin=false;
    Image bimage = new javax.swing.ImageIcon("image/32.gif").getImage();
    
    
    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Home() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(640, 500);
		getContentPane().setLayout(new BorderLayout(10, 10));
		setVisible(true);
		setLocationRelativeTo(null);

		getContentPane().add(panelEast(), BorderLayout.EAST);
		getContentPane().add(panelWest(), BorderLayout.WEST);
		getContentPane().add(panelSouth(), BorderLayout.SOUTH);
		getContentPane().add(panelNorth(), BorderLayout.NORTH);
		getContentPane().add(panelCentre(), BorderLayout.CENTER);

	}
	public JPanel panelNorth()
	{
		
		JPanel panelNorth = new JPanel(new BorderLayout());
		panelNorth.setBackground(new Color(51, 0, 51));
		
		JPanel eastPanel = new JPanel();
		eastPanel.setBackground(new Color(51, 0, 51));
		eastPanel.setForeground(Color.WHITE);
		
		lblRegister = new JLabel("Register ");
		lblRegister.setFont(new Font("Courier New", Font.BOLD, 14));
		lblRegister.setForeground(Color.WHITE);

		

		lblSignin = new JLabel("Signin ");
		lblSignin.setForeground(Color.WHITE);
		lblSignin.setFont(new Font("Courier New", Font.BOLD, 14));

		
		lblSignin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login l = new Login();
				l.setVisible(true);
				// reg.pack();
				l.setBounds(100, 100, 476, 335);
				l.setLocationRelativeTo(null);
				l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});
		

		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Registration reg = new Registration();
				reg.setVisible(true);
				// reg.pack();
				setBounds(100, 100, 600, 600);
				reg.setLocationRelativeTo(null);
				reg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});


		eastPanel.add(lblSignin);
		eastPanel.add(lblRegister);
		panelNorth.add(eastPanel, BorderLayout.EAST);
		
		JLabel text = new JLabel("One-Stop");
		text.setFont(new Font("Courier New", Font.BOLD, 28));
		text.setForeground(Color.WHITE);

		JPanel centrePanel = new JPanel();
		centrePanel.setBackground(new Color(51, 0, 51));
		centrePanel.add(text);
		panelNorth.add(centrePanel, BorderLayout.CENTER);
		
		lblUserName = new JLabel("");
		lblUserName.setFont(new Font("Courier New", Font.BOLD, 16));

		lblUserName.setForeground(Color.WHITE);
		lblUserName.setBounds(6, 20, 301, 16);

		JPanel westPanel = new JPanel();
		westPanel.setBackground(new Color(51, 0, 51));
		westPanel.add(lblUserName);
		panelNorth.add(westPanel, BorderLayout.WEST);
		
		return panelNorth;
	}
	
	public JPanel panelEast()
	{
		
		JPanel panelEast = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(bimage, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panelEast.setPreferredSize(new Dimension(100, 100));
		return panelEast;
	}
	
	public JPanel panelWest()
	{
		JPanel panelWest = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(bimage, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		panelWest.setPreferredSize(new Dimension(100, 100));
		return panelWest;
	}
	public JPanel panelSouth()
	{
		JPanel panelSouth = new JPanel(new GridLayout(3, 1));
		
		JLabel contactUs = new JLabel(" CONTACT US");
		contactUs.setFont(new Font("Dialog", Font.BOLD, 20));

		JLabel contact1 = new JLabel(" Astha: +1-919-432-7767");
		contactUs.setFont(new Font("Dialog", Font.BOLD, 17));
		JLabel contact2 = new JLabel(" Shivani: +1-408-759-8762");
		contactUs.setFont(new Font("Dialog", Font.BOLD, 17));

		panelSouth.add(contactUs);
		panelSouth.add(contact1);
		panelSouth.add(contact2);
		
		panelSouth.setPreferredSize(new Dimension(100, 100));

		return panelSouth;
	}
	public JPanel panelCentre()
	{
		Image bimage1 = new javax.swing.ImageIcon("image/background.jpeg").getImage();

		JPanel panelCentre = new JPanel() {

			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				Graphics2D g2 = (Graphics2D) g;
				g2.drawImage(bimage1, 0, 0, this.getWidth(), this.getHeight(), this);
			}
		};
		
		JPanel panelMenuBar = new JPanel();
		panelMenuBar.setLayout(new BorderLayout());
		panelMenuBar.add(menuBar(), BorderLayout.NORTH);
		
		panelCentre.add(panelMenuBar, BorderLayout.NORTH);
		
		return panelCentre;
	}
    public JMenuBar menuBar()
    {
    	JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("");

		JMenu mnHousing = new JMenu("Housing");
		menuBar.add(mnHousing);

		JMenuItem mntmFindRoomate = new JMenuItem("Find Roomate");
		mnHousing.add(mntmFindRoomate);

		JMenuItem mntmPostAd = new JMenuItem("New Application");
		mnHousing.add(mntmPostAd);

		JMenu mnGroceries = new JMenu("Groceries");
		menuBar.add(mnGroceries);

		JMenu mnEssentials = new JMenu("Essentials");
		menuBar.add(mnEssentials);

		JMenu mnReviews = new JMenu("Ratings");
		menuBar.add(mnReviews);

		JMenuItem mntmRate = new JMenuItem("Rate our App");
		mnReviews.add(mntmRate);

		JMenuItem mntmDisplay = new JMenuItem("Reviews");
		mnReviews.add(mntmDisplay);
		
		mnGroceries.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Groceries groceries = new Groceries();
				groceries.setVisible(true);

				groceries.SetName(lblUserName.getText());
				groceries.SetIsLogin(getIsLogin());
				groceries.SetEmail(getEmail());
				// reg.pack();
				groceries.setBounds(100, 100, 809, 488);
				groceries.setLocationRelativeTo(null);
				groceries.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});

		mnEssentials.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Essential essentials = new Essential();
				essentials.setVisible(true);

				essentials.SetName(lblUserName.getText());
				essentials.SetIsLogin(getIsLogin());
				essentials.SetEmail(getEmail());
				// reg.pack();
				essentials.setBounds(100, 100, 809, 488);
				essentials.setLocationRelativeTo(null);
				essentials.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
			}
		});

		mntmRate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(getIsLogin()==true)
				{
				Reviews review = new Reviews();
				review.setVisible(true);
				review.SetEmail(getEmail());
				review.SetName(lblUserName.getText());
				review.SetIsLogin(getIsLogin());
				// reg.pack();
				review.setBounds(100, 100, 549, 361);
				// review.pack();
				review.setLocationRelativeTo(null);
				review.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				}
				else
				{
					checkLogin();
				}
			}
		});

		mntmDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				
				DisplayReviews review = new DisplayReviews();
				review.setVisible(true);
				// review.SetEmail(getEmail());
				// review.SetName(lblUserName.getText());
				review.SetName(lblUserName.getText());
				review.SetEmail(getEmail());
				review.SetIsLogin(getIsLogin());
				// reg.pack();
				review.setBounds(100, 100, 549, 361);
				// review.pack();
				review.setLocationRelativeTo(null);
				review.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				
			}
		});

		mntmPostAd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(getIsLogin()==true)
				{
				UserDetailForm rm = new UserDetailForm();
				rm.setVisible(true);
				
				rm.SetName(lblUserName.getText());
				rm.SetEmail(getEmail());
				rm.SetIsLogin(getIsLogin());
				
				rm.setBounds(100, 100, 700, 700);
				
				rm.setLocationRelativeTo(null);
	rm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				}
				else
				{
					checkLogin();
				}
			}
		});
		mntmFindRoomate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if(getIsLogin()==true)
				{
				FilterRoomie fr = new FilterRoomie();
				fr.setVisible(true);

				fr.SetName(lblUserName.getText());
				fr.SetEmail(getEmail());
				fr.SetIsLogin(getIsLogin());
				// reg.pack();
				fr.setBounds(100, 100, 600, 600);
				// review.pack();
				fr.setLocationRelativeTo(null);
				fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				dispose();
				}
				else
				{
					checkLogin();
				}
			}
		});
		
		return menuBar;
    }
    public void checkLogin()
    {
    	JOptionPane.showMessageDialog(null,"To access this please signin.");
		Login l = new Login();
		l.setVisible(true);
		l.setBounds(100, 100, 476, 335);
		l.setLocationRelativeTo(null);
		l.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dispose();
    }
	public void SetEmail(String Email)
	{
		this.Email=Email;
	}
	public String getEmail()
	{
		return this.Email;
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





