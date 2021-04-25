package OOPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class DisplayReviews extends JFrame {

	private JPanel contentPane;
	private String Email;
	private String name;
	private boolean isLogin=false;
	private JTextArea reviews;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayReviews frame = new DisplayReviews();
					
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
	public DisplayReviews() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		contentPane.add(panelHeader(), BorderLayout.NORTH);
		
		contentPane.add(reviewPanel(), BorderLayout.CENTER);
	    
		contentPane.add(backPanel(), BorderLayout.SOUTH);
	    
		retrieveReviews();
	    
	}
	
	public JPanel panelHeader()
	{
		JLabel lblTitle=new JLabel();
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 23));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setText("REVIEWS");
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 51));
		panel.add(lblTitle);
		
		return panel;
	}
	
	public JPanel reviewPanel()
	{
		JPanel reviewPanel = new JPanel();
		reviewPanel.setLayout(new BoxLayout(reviewPanel,BoxLayout.Y_AXIS));
		reviewPanel.setBackground(new Color(51, 51, 51));
	    
	    reviews=new JTextArea();
	    JScrollPane sp=new JScrollPane(reviews);
	    reviewPanel.add(sp);
	    
	    return reviewPanel;
	}
	
	public JPanel backPanel()
	{
		    JPanel backPanel = new JPanel();
		    backPanel.setBackground(new Color(51, 0, 51));
		    
			
			JButton btnBack = new JButton("Home");
			btnBack.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Home hp=new Home();
					hp.setVisible(true);
			
					hp.lblUserName.setText(getName());
				    hp.SetEmail(getEmail());
					if(getIsLogin())
					{
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
			btnBack.setOpaque(true);
			btnBack.setForeground(Color.WHITE);
			btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
			btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
			btnBack.setBackground(new Color(204, 0, 51));
			backPanel.add(btnBack);
			
			return backPanel;
	}
	
	public void retrieveReviews() {
		Connection conn = null;
		try {
			DatabaseConn db = new DatabaseConn();

			Class.forName("oracle.jdbc.driver.OracleDriver");

			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");

			String query = "SELECT * FROM REGISTER WHERE COMMENTS IS NOT NULL";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet result = ps.executeQuery();

			while (result.next()) {

				reviews.append(result.getString("FIRSTNAME") + "\n");
				reviews.append("Ratings: " + result.getInt("RATINGS") + "\n");
				reviews.append("Comments: " + result.getString("COMMENTS") + "\n\n");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
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
