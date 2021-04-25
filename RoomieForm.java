package OOPS;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

class UserDetailForm extends JFrame{

	private JPanel contentPane;
	JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,label14,label15,label22,label23,label16,label17,label18,label19,label20,label21,s1,s2,s3;
	
//	JFrame jf;
	JButton register;
	JTextField textfield1,textfield2,textfield3,textfield4a,textfield4b,textfield4c,textfield5,textfield6,textfield7,textfield8,textfield9;

	JRadioButton radiobutton2,radiobutton3,radiobutton4,radiobutton5,radiobutton6,radiobutton7,radiobutton8,radiobutton9,radiobutton10,radiobutton11,radiobutton12,radiobutton13;
	String name,gender,doj1,doj2,doj,dojj,food,drink,budget,room,langg,cook,selectedlangg;
	JComboBox combobox1;
	Connection con1;
	Statement st1;
	int index,count;
	private String Username;
	private boolean isLogin=false;
	private String Email;
	
	String lang[] = new String[50];

	public UserDetailForm()
	{

		initComponents();
		event();

	}

	public void initComponents() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 700);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		//contentPane.setVisible(true);
		
		JPanel panel=new JPanel();
		panel.setBackground(new Color(51, 0, 51));
		contentPane.add(panel, BorderLayout.NORTH);
		
		label1=new JLabel("Registration Form");
		label1.setFont(new Font("Dialog", Font.BOLD, 23));
		label1.setForeground(Color.WHITE);
		
		panel.add(label1);
		//contentPane.add(panel, BorderLayout.NORTH);
		JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new BoxLayout(groupPanel,BoxLayout.Y_AXIS));
		groupPanel.setBackground(new Color(151, 151, 151));
		contentPane.add(groupPanel, BorderLayout.CENTER);
		
		JPanel panelName = new JPanel();
		groupPanel.add(panelName);
		panelName.setBackground(new Color(51, 51, 51));
		
		label2=new JLabel("Name:	");
		label2.setFont(new Font("Dialog", Font.BOLD, 20));
		label2.setForeground(Color.WHITE);
		panelName.add(label2);
		
		
		JPanel genderPanel = new JPanel();
		groupPanel.add(genderPanel);
		genderPanel.setBackground(new Color(51, 51, 51));
		
		label3=new JLabel("Gender:	");
		label3.setFont(new Font("Dialog", Font.BOLD, 20));
		label3.setForeground(Color.WHITE);
		genderPanel.add(label3);
		
		label10=new JLabel("Male");
		label10.setFont(new Font("Dialog", Font.BOLD, 20));
		label10.setForeground(Color.WHITE);
		genderPanel.add(label10);
		
		radiobutton2=new JRadioButton();
		radiobutton2.setFont(new Font("Dialog", Font.BOLD, 20));
		//label10.setForeground(Color.WHITE);
		genderPanel.add(radiobutton2);
		

		label11=new JLabel("Female");
		label11.setFont(new Font("Dialog", Font.BOLD, 20));
		label11.setForeground(Color.WHITE);
		genderPanel.add(label11);
		
		radiobutton3=new JRadioButton();
		radiobutton3.setFont(new Font("Dialog", Font.BOLD, 20));
		//label10.setForeground(Color.WHITE);
		genderPanel.add(radiobutton3);

		JPanel foodPanel = new JPanel();
		groupPanel.add(foodPanel);
		foodPanel.setBackground(new Color(51, 51, 51));
		label4=new JLabel("Food Choice:	");
		label4.setFont(new Font("Dialog", Font.BOLD, 20));
		label4.setForeground(Color.WHITE);
		foodPanel.add(label4);
		
		label14=new JLabel("Veg");
		label14.setFont(new Font("Dialog", Font.BOLD, 20));
		label14.setForeground(Color.WHITE);
		foodPanel.add(label14);
		
		radiobutton10=new JRadioButton();
		radiobutton10.setFont(new Font("Dialog", Font.BOLD, 20));
		
		foodPanel.add(radiobutton10);


		label15=new JLabel("Non-veg");
		label15.setFont(new Font("Dialog", Font.BOLD, 20));
		label15.setForeground(Color.WHITE);
		foodPanel.add(label15);
		
		radiobutton11=new JRadioButton();
		radiobutton11.setFont(new Font("Dialog", Font.BOLD, 20));
		//radiobutton11.setBounds(570,200,20,30);
		foodPanel.add(radiobutton11);
		
		
		
		JPanel travelPanel = new JPanel();
		groupPanel.add(travelPanel);
		travelPanel.setBackground(new Color(51, 51, 51));

		label5=new JLabel("Date of travel:	");
		label5.setFont(new Font("Dialog", Font.BOLD, 20));
		label5.setForeground(Color.WHITE);
		travelPanel.add(label5);
		
		textfield4a=new JTextField();
		textfield4a.setFont(new Font("Dialog", Font.BOLD, 20));
		//textfield4a.setBounds(350,260,40,30);
		travelPanel.add(textfield4a);
		textfield4a.setColumns(3);

		s1=new JLabel("/");
		s1.setFont(new Font("Dialog", Font.BOLD, 20));
		s1.setForeground(Color.WHITE);
		travelPanel.add(s1);

		textfield4b=new JTextField();
		textfield4b.setFont(new Font("Dialog", Font.BOLD, 20));
		//textfield4b.setBounds(430,260,40,30);
		travelPanel.add(textfield4b);
		textfield4b.setColumns(3);

		s2=new JLabel("/");
		s2.setFont(new Font("Dialog", Font.BOLD, 20));
		s2.setForeground(Color.WHITE);
		travelPanel.add(s2);

		textfield4c=new JTextField();
		textfield4c.setFont(new Font("Dialog", Font.BOLD, 20));
		//textfield4c.setBounds(510,260,100,30);
		travelPanel.add(textfield4c);
		textfield4c.setColumns(3);

		s3=new JLabel("DD/MM/YYYY");
		s3.setFont(new Font("Dialog", Font.BOLD, 20));
		s3.setForeground(Color.WHITE);
		travelPanel.add(s3);
		
		JPanel drinkPanel = new JPanel();
		groupPanel.add(drinkPanel);
		drinkPanel.setBackground(new Color(51, 51, 51));
		
		
		

		label6=new JLabel("Drink:	");
		label6.setFont(new Font("Dialog", Font.BOLD, 20));
		label6.setForeground(Color.WHITE);
		drinkPanel.add(label6);
		
		label16=new JLabel("Alcohol");
		label16.setFont(new Font("Dialog", Font.BOLD, 20));
		label16.setForeground(Color.WHITE);
		drinkPanel.add(label16);
		
		radiobutton4=new JRadioButton();
		radiobutton4.setFont(new Font("Dialog", Font.BOLD, 16));
		//radiobutton4.setBounds(457,320,20,30);
		drinkPanel.add(radiobutton4);

		label17=new JLabel("Non-alcohol");
		label17.setFont(new Font("Dialog", Font.BOLD, 20));
		label17.setForeground(Color.WHITE);
		drinkPanel.add(label17);

		
		radiobutton5=new JRadioButton();
		radiobutton5.setFont(new Font("Dialog", Font.BOLD, 20));
	
		drinkPanel.add(radiobutton5);
		
		
		JPanel budgetPanel = new JPanel();
		groupPanel.add(budgetPanel);
		budgetPanel.setBackground(new Color(51, 51, 51));

		label7=new JLabel("Budget:	");
		label7.setFont(new Font("Dialog", Font.BOLD, 20));
		label7.setForeground(Color.WHITE);
	    budgetPanel.add(label7);
	    
	    label18=new JLabel("<$700");
		label18.setFont(new Font("Dialog", Font.BOLD, 20));
		label18.setForeground(Color.WHITE);
		budgetPanel.add(label18);
		
		radiobutton8=new JRadioButton();
		radiobutton8.setFont(new Font("Dialog", Font.BOLD, 20));
		//radiobutton8.setBounds(425,380,20,30);
		budgetPanel.add(radiobutton8);
		
		label19=new JLabel("$700-$1000");
		label19.setFont(new Font("Dialog", Font.BOLD, 20));
		label19.setForeground(Color.WHITE);
		budgetPanel.add(label19);


		radiobutton9=new JRadioButton();
		radiobutton9.setFont(new Font("Dialog", Font.BOLD, 20));
		//radiobutton9.setBounds(592,380,20,30);
		budgetPanel.add(radiobutton9);

		JPanel roomPanel = new JPanel();
		groupPanel.add(roomPanel);
		roomPanel.setBackground(new Color(51, 51, 51));
		
		label8=new JLabel("Room Choice:	");
		label8.setFont(new Font( "Dialog", Font.BOLD, 20));
		label8.setForeground(Color.WHITE);
		roomPanel.add(label8);
		
		label20=new JLabel("2BR");
		label20.setFont(new Font("Dialog", Font.BOLD, 20));
		label20.setForeground(Color.WHITE);
		roomPanel.add(label20);
		

		radiobutton12=new JRadioButton();
		radiobutton12.setFont(new Font("Dialog", Font.BOLD, 20));
	
		roomPanel.add(radiobutton12);

		label21=new JLabel("3BR");
		label21.setFont(new Font("Dialog", Font.BOLD, 20));
		label21.setForeground(Color.WHITE);
		roomPanel.add(label21);
		

		radiobutton13=new JRadioButton();
		radiobutton13.setFont(new Font("Dialog", Font.BOLD, 20));
	//	radiobutton13.setBounds(567,440,20,30);
		roomPanel.add(radiobutton13);

		
		JPanel langPanel = new JPanel();
		groupPanel.add(langPanel);
		langPanel.setBackground(new Color(51, 51, 51));
		label9=new JLabel("Language:	");
		label9.setFont(new Font("Dialog", Font.BOLD, 20));
		label9.setForeground(Color.WHITE);
		langPanel.add(label9);
		
		textfield8=new JTextField();
		textfield8.setFont(new Font("Dialog", Font.BOLD, 20));
		
		langPanel.add(textfield8);
		
		textfield8.setText("Choose Primary Language");
		textfield8.setBackground(new Color(51, 51, 51));
		textfield8.setForeground(Color.WHITE);
		textfield1=new JTextField();
		textfield1.setFont(new Font("Dialog", Font.BOLD, 20));
		
		panelName.add(textfield1);
		textfield1.setColumns(10);


		JPanel cookPanel = new JPanel();
		groupPanel.add(cookPanel);
		cookPanel.setBackground(new Color(51, 51, 51));

		label12=new JLabel("Can cook?:	");
		label12.setFont(new Font("Dialog", Font.BOLD, 20));
		label12.setForeground(Color.WHITE);
		cookPanel.add(label12);


		label22=new JLabel("Yes");
		label22.setFont(new Font("Dialog", Font.BOLD, 20));
		label22.setForeground(Color.WHITE);
		cookPanel.add(label22);
		

		radiobutton6=new JRadioButton();
		radiobutton6.setFont(new Font("Dialog", Font.BOLD, 20));
		//radiobutton6.setBounds(419,560,20,30);
		cookPanel.add(radiobutton6);

		label23=new JLabel("No");
		label23.setFont(new Font("Dialog", Font.BOLD, 20));
		label23.setForeground(Color.WHITE);
		cookPanel.add(label23);


		radiobutton7=new JRadioButton();
		radiobutton7.setFont(new Font("Dialog", Font.BOLD, 20));
		cookPanel.add(radiobutton7);

		
		ButtonGroup jb = new ButtonGroup();
		ButtonGroup jb1 = new ButtonGroup();
		ButtonGroup jb2 = new ButtonGroup();
		ButtonGroup jb3 = new ButtonGroup();
		ButtonGroup jb4 = new ButtonGroup();
		ButtonGroup jb5 = new ButtonGroup();
		
		
		jb.add(radiobutton2);
		jb.add(radiobutton3);
		jb2.add(radiobutton4);
		jb2.add(radiobutton5);
		jb5.add(radiobutton6);
		jb5.add(radiobutton7);
		jb3.add(radiobutton8);
		jb3.add(radiobutton9);
		jb1.add(radiobutton10);
		jb1.add(radiobutton11);
		jb4.add(radiobutton12);
		jb4.add(radiobutton13);



		
		
		
		JPanel regPanel = new JPanel();
		groupPanel.add(regPanel);
		regPanel.setBackground(new Color(51, 51, 51));
		
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
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setBackground(new Color(204, 0, 51));
		regPanel.add(btnBack);
		
		
		
		register = new JButton("Register");
		register.setFont(new Font("Dialog", Font.BOLD, 20));
		register.setForeground(Color.WHITE);
		register.setBackground(new Color(0, 153, 204));
		register.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		register.setOpaque(true);
		regPanel.add(register);

		combobox1 = new JComboBox();
		//combobox1.setBounds(350,500,180,30);
		combobox1.setFont(new Font("Dialog",Font.BOLD,18));
		langPanel.add(combobox1);

		lang[0] = "English";
		lang[1] = "Hindi";
		lang[2] = "Chinese";
		lang[3] = "Spanish";
		lang[4] = "Mandarin Chinese";
		lang[5] = "Wu Chinese";
		lang[6] = "Bengali";
		lang[7] = "Sanskrit";
		lang[8] = "Russian";
		lang[9] = "Japanese";
		lang[10] = "Punjabi";
		lang[11] = "Marathi";
		lang[12] = "Telugu";
		lang[13] = "Turkish";
		lang[14] = "Korean";
		lang[15] = "French";
		lang[16] = "German";
		lang[17] = "tamil";
		lang[18] = "Vietnamese";
		lang[19] = "Urdu";
		lang[20] = "Italian";
		lang[21] = "Arabic";
		lang[22] = "Gujarati";
		lang[23] = "Persian";
		lang[24] = "Min Nan Chinese";
		lang[25] = "Hakka Chinese";
		lang[26] = "Jin Chinese";
		lang[27] = "Dutch";
		lang[28] = "Thai";
		lang[29] = "Malaysian";
		lang[30] = "Nepali";
		lang[31] = "Greek";
		lang[32] = "Deccan";
		lang[33] = "Zulu";
		lang[34] = "Czech";

		for (int j= 0 ; j< 35; j++) { combobox1.addItem(lang[j]); } gender = ""; } public void event() { textfield1.addKeyListener(new KeyAdapter() { public void keyTyped(KeyEvent e) { char c = e.getKeyChar(); String sag=textfield1.getText(); if (!(((c >= 'a')||(c >= 'A')) && ((c <= 'z')||(c <= 'Z')) || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) { e.consume(); } } }); textfield4a.addKeyListener(new KeyAdapter() { public void keyTyped(KeyEvent e) { char c = e.getKeyChar(); if (!((c >= '0') && (c <= '9') || (c == KeyEvent.VK_BACK_SPACE) || (c == KeyEvent.VK_DELETE))) { 
			e.consume();
		}
		}
		});

		register.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{

				getUserInformation();
				validation();
				registerUserData();

			}
		});

		combobox1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)
			{
				Object selectedlanggobj = combobox1.getSelectedItem();
				selectedlangg = String.valueOf(selectedlanggobj);
				index = combobox1.getSelectedIndex();

			}
		});

		radiobutton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Male";
			}
		});
		radiobutton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gender = "Female";
			}
		});
		radiobutton10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food = "Veg";
			}
		});
		radiobutton11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				food = "Non-Veg";
			}
		});
		radiobutton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drink = "Alcohol";
			}
		});
		radiobutton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drink = "Non-Alcohol";
			}
		});
		radiobutton8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				budget = "<$700";
			}
		});
		radiobutton9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				budget = "$700-$1000";
			}
		});
		radiobutton12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room = "2BR";
			}
		});
		radiobutton13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				room = "3BR";
			}
		});
		radiobutton6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cook = "Yes";
			}
		});
		radiobutton7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cook = "No";
			}
		});


		}

		public void getUserInformation() {
			name = textfield1.getText();
			doj = textfield4a.getText();
			doj1 = textfield4b.getText();
			doj2 = textfield4c.getText();
			dojj = doj + "/" + doj1 + "/" + doj2;
			langg = selectedlangg;


		}

		public void validation() {
			count = 0;

			if(name.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Name");
			}
			else if(food.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select food preference");
			}
			else if(doj.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Date");
			}
			else if(doj1.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Month");
			}
			else if(doj2.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Enter Year");
			}

			else if(drink.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select drink preference");
			}

			else if(budget.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select budget");
			}

			else if(room.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select room preference");
			}

			else if(selectedlangg.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select langg");
			}
			else if(cook.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select Cooking preference");
			}
			else if(gender.equals(""))
			{
				JOptionPane.showMessageDialog(null,"Select gender");
			}
			else {
				if((Integer.parseInt(doj2)<=2050) && (Integer.parseInt(doj2)>=1900))
				{
					if((Integer.parseInt(doj1)<=12) && (Integer.parseInt(doj1)>0))
					{
						if((Integer.parseInt(doj1)==1) || (Integer.parseInt(doj1)==3) || (Integer.parseInt(doj1)==5) || (Integer.parseInt(doj1)==7) || (Integer.parseInt(doj1)==8) || (Integer.parseInt(doj1)==10) || (Integer.parseInt(doj1)==12))
						{
							if((Integer.parseInt(doj)<=31) && (Integer.parseInt(doj)>=1))
							{
								dojj=doj+"/"+doj1+"/"+doj2;

							}
							else
							{
								JOptionPane.showMessageDialog(null,"Invalid Date");
							}
						}
						else if((Integer.parseInt(doj1)==4) || (Integer.parseInt(doj1)==6) || (Integer.parseInt(doj1)==9) || (Integer.parseInt(doj1)==11))
						{
							if((Integer.parseInt(doj)<=30) && (Integer.parseInt(doj)>=1))
							{
								dojj=doj+"/"+doj1+"/"+doj2;

							}
							else
							{
								JOptionPane.showMessageDialog(null,"Invalid Date");
							}
						}
						else
						{
							if(((Integer.parseInt(doj2)%100)==0) || ((Integer.parseInt(doj2)%4)==0))
							{
								if((Integer.parseInt(doj)<=29) && (Integer.parseInt(doj)>=1))
								{
									dojj=doj+"/"+doj1+"/"+doj2;
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Invalid Date");
								}
							}
							else
							{
								if((Integer.parseInt(doj)<=28) && (Integer.parseInt(doj)>=1))
								{
									dojj=doj+"/"+doj1+"/"+doj2;
								}
								else
								{
									JOptionPane.showMessageDialog(null,"Invalid Date");
								}
							}
						}
					}
					else
					{
						JOptionPane.showMessageDialog(null,"Enter month between 1 and 12");
					}
				}
				else
				{
					JOptionPane.showMessageDialog(null,"Enter year between 1900 and 2050");
				}
			}
		}

		public void registerUserData() {
			try {

				if(count==0) {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//con1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl\", \"hr\", \"oracle");
					Connection con1 = DriverManager.getConnection(
			                "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
					st1 = con1.createStatement();
					st1.execute("INSERT INTO User_Details (Name,Gender,food,doj,drink,budget,room,langg,cook,langgIndex) VALUES('"+name+"','"+gender+"','"+food+"','"+dojj+"','"+drink+"','"+budget+"','"+room+"','"+langg+"','"+cook+"',"+index+")");
					st1.close();
					con1.close();
					JOptionPane.showMessageDialog(null,"User Data Registered Successfully");
				}

			}
			catch (Exception e) {
				System.out.println("Exception1 is " + e);
			}

		}
		public void SetName(String name)
		{
		this.Username=name;
		}
		public String getName()
		{
		return this.Username;
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

class RoomieForm {
	public static void main(String args[]) {
		UserDetailForm form = new UserDetailForm();
		form.setVisible(true);
		

	}
}

