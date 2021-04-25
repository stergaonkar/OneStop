package OOPS;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class FilterRoomie extends JFrame {
	DefaultTableModel dtm;
	JPanel bottom= new JPanel();
	ResultSet resultset=null;
	JTable jTable1;
	private JPanel contentPane;
	JPanel groupPanel = new JPanel();
	private String name;
	String sql2;
	JComboBox<String> comboBoxFood = new JComboBox<String>();
	JComboBox<String> comboBoxPartner = new JComboBox<String>();
	JComboBox<String> comboBoxApartment = new JComboBox<String>();
	int count =0;
	Connection con1;
	Statement st1;
	private String UserName;
	private boolean isLogin=false;
	private String Email;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FilterRoomie frame = new FilterRoomie();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FilterRoomie() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.textHighlight);
		panel.setBackground(new Color(51, 0, 51));
		contentPane.add(panel, BorderLayout.NORTH);
		
		
		JLabel lblHeader = new JLabel("Finding a Roommate");
		lblHeader.setFont(new Font("Dialog", Font.BOLD, 23));;
		lblHeader.setForeground(Color.white);
		panel.add(lblHeader);
		
		JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new BoxLayout(groupPanel,BoxLayout.Y_AXIS));
		groupPanel.setBackground(new Color(51, 51, 51));
		contentPane.add(groupPanel, BorderLayout.CENTER);
		
		JPanel room=new JPanel();
		groupPanel.add(room);
		room.setBackground(new Color(51, 51, 51));
		
		JLabel lblCategory = new JLabel("Room Partner:");
		lblCategory.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCategory.setForeground(Color.white);
		room.add(lblCategory);
		
		room.add(comboBoxPartner);
		ArrayList<String> category=new ArrayList<String>();
		category.add("Male");
		category.add("Female");
		comboBoxPartner.setModel(new DefaultComboBoxModel<String>(category.toArray(new String[0])));
		
	
		JPanel apart=new JPanel();
		groupPanel.add(apart);
		apart.setBackground(new Color(51, 51, 51));
		
		JLabel lblPricing = new JLabel("Apartment Preference");
		lblPricing.setForeground(Color.white);
		lblPricing.setFont(new Font("Dialog", Font.BOLD, 20));
		apart.add(lblPricing);
		
		
		ArrayList<String> apartmCategories=new ArrayList<String>();
		apartmCategories.add("2BR");
		apartmCategories.add("3BR");
		comboBoxApartment.setModel(new DefaultComboBoxModel<String>(apartmCategories.toArray(new String[0])));
		apart.add(comboBoxApartment);
		
		comboBoxPartner.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	comboBoxApartment.removeAllItems();
            	comboBoxApartment.setModel(new DefaultComboBoxModel<String>(apartmCategories.toArray(new String[0])));
            }});
		
		
		JPanel f=new JPanel();
		f.setBackground(new Color(51, 51, 51));
		groupPanel.add(f);
		
		JLabel lblStores = new JLabel("Food Preference");
		lblStores.setForeground(Color.white);
		lblStores.setFont(new Font("Dialog", Font.BOLD, 20));
		f.add(lblStores);
		
		 
	
		ArrayList<String> foodCategory=new ArrayList<String>();
		foodCategory.add("Veg");
		foodCategory.add("Non-veg");
        comboBoxFood.setModel(new DefaultComboBoxModel<String>(foodCategory.toArray(new String[0])));
        f.add(comboBoxFood);
		
        /*
		comboBoxApartment.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent event) {
            	for (String s : foodCategory)
         			comboBoxFood.addItem(s);
            	
            	for (String s : category)
            		comboBoxPartner.addItem(s);
            	
            	for (String s : apartmCategories)
            		comboBoxApartment.addItem(s);
            }   
            });*/
		
		JPanel k=new JPanel();
		k.setBackground(new Color(51, 51, 51));
		groupPanel.add(k);
		
		JButton btnBack = new JButton("Home");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Home hp=new Home();
				hp.setVisible(true);
				//reg.pack();
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
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setForeground(Color.WHITE);
		btnBack.setBackground(new Color(0, 153, 204));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		k.add(btnBack);
		
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSearch.setForeground(Color.white);
		btnSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearch.setBackground(new Color(204, 0, 51));
		btnSearch.setOpaque(true);
		k.add(btnSearch);
		
		
		
		
		JPanel tablePanel=new JPanel();
		tablePanel.setBackground(new Color(51, 51, 51));
	    groupPanel.add(tablePanel);
	    JTable table1=null;
	    tablePanel.setSize(getSize());
		btnSearch.addMouseListener(new MouseAdapter() {
			 
            @Override
            public void mouseClicked(MouseEvent e) {
            	UserInfo();
           // System.out.println("count:"+count);
            	registerUserData();
            	
            }

		});
		
		
	    
	    
	    
		
	}
	
	public int UserInfo()
	{
	   
    	if(comboBoxPartner.getSelectedItem()=="Male" && comboBoxFood.getSelectedItem()=="Veg" && comboBoxApartment.getSelectedItem()=="2BR")
        count=1;
    	else if(comboBoxPartner.getSelectedItem()=="Male" && comboBoxFood.getSelectedItem()=="Non-Veg" && comboBoxApartment.getSelectedItem()=="2BR")
    		count=2;
    	else if(comboBoxPartner.getSelectedItem()=="Male" && comboBoxFood.getSelectedItem()=="Veg" && comboBoxApartment.getSelectedItem()=="3BR")
    		count=3;
    	else if(comboBoxPartner.getSelectedItem()=="Male" && comboBoxFood.getSelectedItem()=="Non-Veg" && comboBoxApartment.getSelectedItem()=="3BR")
    		count=4;
    	else if(comboBoxPartner.getSelectedItem()=="Female" && comboBoxFood.getSelectedItem()=="Veg" && comboBoxApartment.getSelectedItem()=="2BR")
    		count=5;
    	else if(comboBoxPartner.getSelectedItem()=="Female" && comboBoxFood.getSelectedItem()=="Non-Veg" && comboBoxApartment.getSelectedItem()=="2BR")
    		count=6;
    	else if(comboBoxPartner.getSelectedItem()=="Female" && comboBoxFood.getSelectedItem()=="Veg" && comboBoxApartment.getSelectedItem()=="3BR")
    		count=7;
    	else if(comboBoxPartner.getSelectedItem()=="Female" && comboBoxFood.getSelectedItem()=="Non-Veg" && comboBoxApartment.getSelectedItem()=="3BR")
    		count=8;
    	
    	return count;
	}
	
	public void createColumns() {
		
		dtm.addColumn("Name");
		dtm.addColumn("Gender");
		dtm.addColumn("food");
		dtm.addColumn("doj");
		dtm.addColumn("drink");
		dtm.addColumn("budget");

		dtm.addColumn("room");
		dtm.addColumn("langg");
		dtm.addColumn("cook");
		dtm.addColumn("langgIndex");
		
		
	}
	
	public void populate() 
	{	
		try {
			while(resultset.next()){
				System.out.println("hi");
	
				String Name=resultset.getString("Name");
				System.out.println(Name);
				String Gender=resultset.getString("Gender");
				System.out.println(Gender);
				String food=resultset.getString("food");
				System.out.println(food);
				String doj=resultset.getString("doj");
				System.out.println(doj);
				String drink=resultset.getString("drink");
				System.out.println(drink);
				String budget=	resultset.getString("budget");
				System.out.println(budget);
				String room=resultset.getString("room");
				System.out.println(room);
				String langg=resultset.getString("langg");
				System.out.println(langg);
				String cook=resultset.getString("cook");
				System.out.println(cook);
				String langgIndex=resultset.getString("langgindex");
				System.out.println(langgIndex);
				
				
				String[] columnNames = {"Name",
                        "Gender",
                        "Food",
                        "DOJ",
                        "Drink","Budget","Room","langg","cook","langgIndex"};
				String[] datap= {Name,Gender,food,doj,drink,budget,room,langg,cook,langgIndex};
				
				
				System.out.println("result");
				
				JTable table = new JTable();
				

				dtm=(DefaultTableModel) jTable1.getModel();
				
				System.out.println("result1");
				dtm.addRow(datap);
				System.out.println("result2");
				
		
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public JTable registerUserData() {
		JTable table=null;
		try {

		//System.out.println(count);
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
				st1 = con1.createStatement();
				if(count==1) {
					
					sql2="select * from User_Details where Gender='Male' AND room= '2BR' AND food='Veg'";
				
					resultset=st1.executeQuery(sql2);
					
				}
				else if(count==2)
				{
					sql2="select * from User_Details where Gender='Male' AND room= '2BR' AND food='Non-Veg'";
					
					resultset=st1.executeQuery(sql2);
				}
				else if(count==3)
				{
					sql2="select * from User_Details where Gender='Male' AND room= '3BR' AND food='Veg'";
					
					resultset=st1.executeQuery(sql2);
				}
				else if(count==4)
				{
					
					sql2="select * from User_Details where Gender='Male' AND room= '3BR' AND food='Non-Veg'";
					
					resultset=st1.executeQuery(sql2);
				}
				else if(count==5)
				{
					sql2="select * from User_Details where Gender='Female' AND room= '2BR' AND food='Veg'";
					
					resultset=st1.executeQuery(sql2);
				}
				else if(count==6)
				{
					sql2="select * from User_Details where Gender='Female' AND room= '2BR' AND food='Non-Veg'";
					
					resultset=st1.executeQuery(sql2);
				}
				else if(count==7)
				{
					sql2="select * from User_Details where Gender='Female' AND room= '3BR' AND food='Veg'";
					
					resultset=st1.executeQuery(sql2);
				}
				else if(count==8)
				{
					sql2="select * from User_Details where Gender='Female' AND room= '3BR' AND food='Non-Veg'";
					
					resultset=st1.executeQuery(sql2);
				}
			    table = new JTable(buildTableModel(resultset));
			   JScrollPane s=new JScrollPane(table);
			   s.setPreferredSize(new Dimension(800,250));
			   JOptionPane.showMessageDialog(null,"Search Successful");
			    
			   JOptionPane.showMessageDialog(null, s);

				
				//populate();
				st1.close();
				
				con1.close();
				
				
			

		}
		catch (Exception e) {
			System.out.println("Exception1 is " + e);
		}
		return table;

	}
	public static DefaultTableModel buildTableModel(ResultSet rs)
	        throws SQLException {

	    ResultSetMetaData metaData = rs.getMetaData();

	    // names of columns
	    Vector<String> columnNames = new Vector<String>();
	    int columnCount = metaData.getColumnCount();
	    for (int column = 1; column <= columnCount; column++) {
	        columnNames.add(metaData.getColumnName(column));
	    }

	    // data of the table
	    Vector<Vector<Object>> data = new Vector<Vector<Object>>();
	    while (rs.next()) {
	        Vector<Object> vector = new Vector<Object>();
	        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
	            vector.add(rs.getObject(columnIndex));
	        }
	        data.add(vector);
	    }

	    return new DefaultTableModel(data, columnNames);

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
	public void SetEmail(String Email)
	{
		this.Email=Email;
	}
	public String getEmail()
	{
		return this.Email;
	}

	
}


//male,2br,veg
//male,2br,nonveg
//male,3br,veg
//male,3br,nonveg
//female,2br,veg
//female,2br,nonveg
//female,3br,veg
//female,3br,nonveg
//select * from User_Details where Gender="Male" AND room= "2BR" AND food="Veg";
//select * from User_Details where Gender="Male" AND room= "2BR" AND food="Non-Veg";
//select * from User_Details where Gender="Male" AND room= "3BR" AND food="Veg";
//select * from User_Details where Gender="Male" AND room= "3BR" AND food="Non-Veg";
//select * from User_Details where Gender="Female" AND room= "2BR" AND food="Veg";
//select * from User_Details where Gender="Female" AND room= "2BR" AND food="Non-Veg";
//select * from User_Details where Gender="Female" AND room= "3BR" AND food="Veg";
//select * from User_Details where Gender="Female" AND room= "3BR" AND food="Non-Veg";



