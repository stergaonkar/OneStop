package OOPS;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URI;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Essential extends JFrame {

	private JPanel contentPane;
	private String name;
	private boolean isLogin=false;
	private String Email;
	private ArrayList<String> category;
	private JComboBox<String> comboBoxCategory;
	private JComboBox<String> comboBoxPricing;
	private ArrayList<String> pricing;
	private JComboBox<String> comboBoxStores;
	private ArrayList<String> ecoFurnitureCategory;
	private ArrayList<String> luxFurnitureCategory;
	private ArrayList<String> ecoHouseCategory;
	private ArrayList<String> luxHouseCategory;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Essential frame = new Essential();
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
	public Essential() 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout());
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		
		
		contentPane.add(headerPanel(), BorderLayout.NORTH);
		
		JPanel groupPanel = new JPanel();
		groupPanel.setLayout(new BoxLayout(groupPanel,BoxLayout.Y_AXIS));
		groupPanel.setBackground(new Color(51, 51, 51));
	    contentPane.add(groupPanel, BorderLayout.CENTER);
	    
	    contentPane.add(eastPanel(), BorderLayout.EAST);
		
		contentPane.add(westPanel(), BorderLayout.WEST);
	    
		groupPanel.add(panelCategory());
		
		groupPanel.add(panelPricing());
		 
		groupPanel.add(panelStores());
 
		groupPanel.add(panelButtons());
		
		
		
	}
	
	public JPanel headerPanel()
	{

		
		JLabel lblTitle=new JLabel();
		lblTitle.setFont(new Font("Dialog", Font.BOLD, 23));
		lblTitle.setForeground(Color.WHITE);
		lblTitle.setText("ESSENTIALS");
		
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 0, 51));
		panel.add(lblTitle);
		
		return panel;
	}
	
	public JPanel eastPanel()
	{
	    Image bimage =  new javax.swing.ImageIcon("image/Furniture.gif").getImage();
	    JPanel panelFurniture = new JPanel(){
		    
			private static final long serialVersionUID = 1L;

			@Override
		    public void paintComponent(Graphics g)
		    {
		    	super.paintComponent(g);
		    	Graphics2D 	g2 = (Graphics2D) g;
		        g2.drawImage(bimage, 0, 0, this.getWidth(),this.getHeight(), this);
		    }
		};
		panelFurniture.setPreferredSize(new Dimension(140,10));
		
		return panelFurniture;
	}
	public JPanel westPanel()
	{
		Image bimage1 =  new javax.swing.ImageIcon("image/Kitchen.gif").getImage();
	    JPanel panelKitchen = new JPanel(){
		    
			private static final long serialVersionUID = 1L;

			@Override
		    public void paintComponent(Graphics g)
		    {
		    	super.paintComponent(g);
		    	Graphics2D 	g2 = (Graphics2D) g;
		        g2.drawImage(bimage1, 0, 0, this.getWidth(),this.getHeight(), this);
		    }
		};
		panelKitchen.setPreferredSize(new Dimension(140,10));
		
		return panelKitchen;
	}
	
	public JPanel panelCategory()
	{
		    JPanel panelCategory = new JPanel();
			
			panelCategory.setBackground(new Color(51, 51, 51));
			
			JLabel lblCategory = new JLabel("Category:");
			lblCategory.setFont(new Font("Dialog", Font.BOLD, 20));
			lblCategory.setForeground(Color.WHITE);
			panelCategory.add(lblCategory);
			
			comboBoxCategory = new JComboBox<String>();
			panelCategory.add(comboBoxCategory);
			
			category=new ArrayList<String>();
			category.add("Funiture");
			category.add("Kitchen Essentials");
			comboBoxCategory.setModel(new DefaultComboBoxModel<String>(category.toArray(new String[0])));
			
			comboBoxCategory.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent event) {
	            	comboBoxPricing.removeAllItems();
	            	comboBoxPricing.setModel(new DefaultComboBoxModel<String>(pricing.toArray(new String[0])));
	            }});
			
			return panelCategory;
	}
	public JPanel panelPricing()
	{
		JPanel panelPricing = new JPanel();
		
		panelPricing.setBackground(new Color(51, 51, 51));
		
		JLabel lblPricing = new JLabel("Pricing:");
		lblPricing.setFont(new Font("Dialog", Font.BOLD, 20));
		lblPricing.setForeground(Color.WHITE);
		panelPricing.add(lblPricing);
		
		comboBoxPricing = new JComboBox<String>();
		panelPricing.add(comboBoxPricing);
		
		pricing=new ArrayList<String>();
		pricing.add("All");
		pricing.add("Luxury");
		pricing.add("Economical");
		comboBoxPricing.setModel(new DefaultComboBoxModel<String>(pricing.toArray(new String[0])));
		
		comboBoxPricing.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (comboBoxPricing.getSelectedIndex() == 0) {
					comboBoxStores.removeAllItems();

					for (String s : ecoFurnitureCategory)
						comboBoxStores.addItem(s);
					for (String s : luxFurnitureCategory)
						comboBoxStores.addItem(s);

				}

				else if (comboBoxPricing.getSelectedIndex() == 1) {
					if (comboBoxCategory.getSelectedIndex() == 0) {
						comboBoxStores.removeAllItems();

						for (String s : luxFurnitureCategory)
							comboBoxStores.addItem(s);
					} else if (comboBoxCategory.getSelectedIndex() == 1) {
						comboBoxStores.removeAllItems();

						for (String s : luxHouseCategory)
							comboBoxStores.addItem(s);
					}

				} else if (comboBoxPricing.getSelectedIndex() == 2) {

					if (comboBoxCategory.getSelectedIndex() == 0) {
						comboBoxStores.removeAllItems();

						for (String s : ecoFurnitureCategory)
							comboBoxStores.addItem(s);

					} else if (comboBoxCategory.getSelectedIndex() == 1) {
						comboBoxStores.removeAllItems();

						for (String s : ecoHouseCategory)
							comboBoxStores.addItem(s);

					}
					

				}
			}
            
            });
		
		
		return panelPricing;
	}
	
	public JPanel panelStores()
	{
		JPanel panelStores = new JPanel();
		
		panelStores.setBackground(new Color(51, 51, 51));
		
		JLabel lblStores = new JLabel("Stores:   ");
		lblStores.setFont(new Font("Dialog", Font.BOLD, 20));
		lblStores.setForeground(Color.WHITE);
		panelStores.add(lblStores);
		
		comboBoxStores = new JComboBox<String>();
		panelStores.add(comboBoxStores);
		
		ecoFurnitureCategory=new ArrayList<String>();
		ecoFurnitureCategory.add("Ikea");
		ecoFurnitureCategory.add("Direct Factory Furniture");
		
		luxFurnitureCategory=new ArrayList<String>();
		luxFurnitureCategory.add("Ashley");
		luxFurnitureCategory.add("Living Spaces");
		luxFurnitureCategory.add("NorCal Furniture");
		
		ecoHouseCategory=new ArrayList<String>();
		ecoHouseCategory.add("Ikea");
		ecoHouseCategory.add("TJ Maxx");
		ecoHouseCategory.add("Walmart");
		ecoHouseCategory.add("Target");
		
		luxHouseCategory=new ArrayList<String>();
		luxHouseCategory.add("Crate&Barrel");
		luxHouseCategory.add("Bed Bath and Beyond");
		luxHouseCategory.add("Macy's");
		
		return panelStores;
	}
	
	public JPanel panelButtons() {
		JPanel panelButton = new JPanel();

		panelButton.setBackground(new Color(51, 51, 51));

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
		btnBack.setOpaque(true);
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 20));
		btnBack.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnBack.setBackground(new Color(204, 0, 51));
		panelButton.add(btnBack);

		JButton btnSearch = new JButton("Search");
		btnSearch.setFont(new Font("Dialog", Font.BOLD, 20));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(new Color(0, 153, 204));
		btnSearch.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		btnSearch.setOpaque(true);
		panelButton.add(btnSearch);

		btnSearch.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (comboBoxStores.getSelectedItem() == "Ikea")
						Desktop.getDesktop().browse(new URI("https://www.ikea.com/us/en/stores/east-palo-alto/"));
					else if (comboBoxStores.getSelectedItem() == "Target")
						Desktop.getDesktop().browse(new URI("https://www.target.com/sl/santa-clara/2830"));
					else if (comboBoxStores.getSelectedItem() == "Walmart")
						Desktop.getDesktop().browse(new URI("https://www.walmart.com/store/5435-san-jose-ca"));
					else if (comboBoxStores.getSelectedItem() == "TJ Maxx")
						Desktop.getDesktop().browse(
								new URI("https://tjmaxx.tjx.com/store/stores/Santa+Clara-CA-95054/398/aboutstore"));
					else if (comboBoxStores.getSelectedItem() == "Crate&Barrel")
						Desktop.getDesktop().browse(new URI(
								"https://www.crateandbarrel.com/stores/santana-row/str404?utm_source=gmb&utm_medium=organic_search"));
					else if (comboBoxStores.getSelectedItem() == "Bed Bath and Beyond")
						Desktop.getDesktop().browse(
								new URI("https://stores.bedbathandbeyond.com/Campbell-CA-95008-1121?MCID=YT_YEXT"));
					else if (comboBoxStores.getSelectedItem() == "Macy's")
						Desktop.getDesktop().browse(new URI("https://l.macys.com/santa-clara-ca"));
					else if (comboBoxStores.getSelectedItem() == "Ashley")
						Desktop.getDesktop().browse(new URI(
								"https://stores.ashleyfurniture.com/store/us/california/milpitas/7710000045?cmpid=ls-&utm_source=Local&utm_medium=LocalSEO&utm_campaign=LocalSearch"));
					else if (comboBoxStores.getSelectedItem() == "Living Spaces")
						Desktop.getDesktop().browse(new URI("https://www.livingspaces.com/stores/fremont"));
					else if (comboBoxStores.getSelectedItem() == "NorCal Furniture")
						Desktop.getDesktop().browse(new URI("https://norcalfurniture.com/"));
					else if (comboBoxStores.getSelectedItem() == "Direct Factory Furniture")
						Desktop.getDesktop().browse(new URI("https://www.factorydirectfurniture-ca.com/"));

				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}

		});
		return panelButton;

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
