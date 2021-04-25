package OOPS;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Groceries extends JFrame {
private JPanel contentPane;
private String name;
private boolean isLogin=false;
private String Email;

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
Groceries frame = new Groceries();
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
public Groceries() {

setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//setBounds(100, 100, 450, 300);
//setBounds(100, 100, 600, 600);
setBounds(100, 100, 700, 400);
contentPane = new JPanel();
contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
contentPane.setLayout(new BorderLayout());
setContentPane(contentPane);
setLocationRelativeTo(null);

JLabel lblTitle=new JLabel();
lblTitle.setFont(new Font("Dialog", Font.BOLD, 23));
lblTitle.setForeground(Color.WHITE);
lblTitle.setText("GROCERIES/MEAT");
JPanel panel = new JPanel();
panel.setBackground(new Color(51, 0, 51));
panel.add(lblTitle);
contentPane.add(panel, BorderLayout.NORTH);


Image bimage =  new javax.swing.ImageIcon("image/veg8.gif").getImage();
JPanel panelGrocery = new JPanel(){
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	Graphics2D 	g2 = (Graphics2D) g;
        g2.drawImage(bimage, 0, 0, this.getWidth(),this.getHeight(), this);
    }
};
panelGrocery.setPreferredSize(new Dimension(140,10));
contentPane.add(panelGrocery, BorderLayout.EAST);

Image bimage1 =  new javax.swing.ImageIcon("image/veg9.gif").getImage();
JPanel panelMeat = new JPanel(){
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	@Override
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	Graphics2D 	g2 = (Graphics2D) g;
        g2.drawImage(bimage1, 0, 0, this.getWidth(),this.getHeight(), this);
    }
};
panelMeat.setPreferredSize(new Dimension(140,10));
contentPane.add(panelMeat, BorderLayout.WEST);

JPanel groupPanel = new JPanel();
groupPanel.setLayout(new BoxLayout(groupPanel,BoxLayout.Y_AXIS));
groupPanel.setBackground(new Color(51, 0, 51));
contentPane.add(groupPanel, BorderLayout.CENTER);


JPanel panelCategory = new JPanel();
groupPanel.add(panelCategory);
panelCategory.setBackground(new Color(51, 51, 51));
		
JLabel lblCategory = new JLabel("Grocery Choice:");
lblCategory.setForeground(Color.WHITE);
lblCategory.setFont(new Font("Dialog", Font.BOLD, 20));
panelCategory.add(lblCategory);
		
JComboBox<String> comboBoxCategory = new JComboBox<String>();
panelCategory.add(comboBoxCategory);
		
ArrayList<String> category=new ArrayList<String>();
category.add("Indian Grocery");
category.add("Asian Grocery");
category.add("International Grocery");
comboBoxCategory.setModel(new DefaultComboBoxModel<String>(category.toArray(new String[0])));
		

JPanel panelPricing = new JPanel();
groupPanel.add(panelPricing);
panelPricing.setBackground(new Color(51, 51, 51));

JLabel lblPricing = new JLabel("Pricing:");
lblPricing.setForeground(Color.WHITE);
lblPricing.setFont(new Font("Dialog", Font.BOLD, 20));
panelPricing.add(lblPricing);

JComboBox<String> comboBoxPricing = new JComboBox<String>();
panelPricing.add(comboBoxPricing);

ArrayList<String> pricing=new ArrayList<String>();
pricing.add("All");
pricing.add("Luxury");
pricing.add("Economical");
comboBoxPricing.setModel(new DefaultComboBoxModel<String>(pricing.toArray(new String[0])));


comboBoxCategory.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
    	comboBoxPricing.removeAllItems();
    	comboBoxPricing.setModel(new DefaultComboBoxModel<String>(pricing.toArray(new String[0])));
    }});


JPanel panelStores = new JPanel();
groupPanel.add(panelStores);
panelStores.setBackground(new Color(51, 51, 51));

JLabel lblStores = new JLabel("Stores:   ");
lblStores.setForeground(Color.WHITE);
lblStores.setFont(new Font("Dialog", Font.BOLD, 20));
panelStores.add(lblStores);

JComboBox<String> comboBoxStores = new JComboBox<String>();
panelStores.add(comboBoxStores);

ArrayList<String> ecoIndianCat=new ArrayList<String>();
ecoIndianCat.add("New India Bazaar");
ecoIndianCat.add("Patel Brothers");

ArrayList<String> luxIndianCat=new ArrayList<String>();
luxIndianCat.add("Taj Mahal Imports");
luxIndianCat.add("India Cash & Carry");

ArrayList<String> ecoChineseCat=new ArrayList<String>();
ecoChineseCat.add("Hanhook Supermarket");
ecoChineseCat.add("Lion market");

ArrayList<String> luxChineseCat=new ArrayList<String>();
luxChineseCat.add("99 Ranch Market");
luxChineseCat.add("Mitsuwa market");

ArrayList<String> ecoInternational=new ArrayList<String>();
ecoInternational.add("Nob Hill");
ecoInternational.add("Grocery Outlet");

ArrayList<String> luxInternational=new ArrayList<String>();
luxInternational.add("Safeway");
luxInternational.add("Whole Foods Market");

comboBoxPricing.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
    if(comboBoxPricing.getSelectedIndex()==0)
      {
      comboBoxStores.removeAllItems();
     
      for (String s : ecoIndianCat)
      comboBoxStores.addItem(s);
      for (String s : luxIndianCat)
      comboBoxStores.addItem(s);
     
      }
   
    else if(comboBoxPricing.getSelectedIndex()==1)
    {
    if( comboBoxCategory.getSelectedIndex()==0)
    {
    comboBoxStores.removeAllItems();
   
    for (String s : luxIndianCat)
    comboBoxStores.addItem(s);
    }
    else if( comboBoxCategory.getSelectedIndex()==1)
    {
    comboBoxStores.removeAllItems();
   
    for (String s : luxChineseCat)
    comboBoxStores.addItem(s);
    }
   
    else if( comboBoxCategory.getSelectedIndex()==2)
    {
    comboBoxStores.removeAllItems();
   
    for (String s : luxInternational)
    comboBoxStores.addItem(s);
    }
   
    //comboBox_1.setModel(new DefaultComboBoxModel<String>(luxuryCategory.toArray(new String[0])));
    }
    else if(comboBoxPricing.getSelectedIndex()==2)
    {
   
    if( comboBoxCategory.getSelectedIndex()==0)
    {
    comboBoxStores.removeAllItems();
   
    for (String s : ecoIndianCat)
    comboBoxStores.addItem(s);
   
    }
    else if( comboBoxCategory.getSelectedIndex()==1)
        {
        comboBoxStores.removeAllItems();
       
        for (String s : ecoChineseCat)
        comboBoxStores.addItem(s);
       
        }
    else if( comboBoxCategory.getSelectedIndex()==2)
        {
        comboBoxStores.removeAllItems();
       
        for (String s : ecoInternational)
        comboBoxStores.addItem(s);
       
        }
    //comboBox_1.setModel(new DefaultComboBoxModel<String>(economicalCategory.toArray(new String[0])));
   
   
    }
    }
   
    });


JPanel panelButton = new JPanel();
groupPanel.add(panelButton);
panelButton.setBackground(new Color(51, 51, 51));


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
                if(comboBoxStores.getSelectedItem()=="New India Bazaar")
                    Desktop.getDesktop().browse(new URI("http://www.newindiabazar.com/"));
                else if(comboBoxStores.getSelectedItem()=="Patel Brothers")
                Desktop.getDesktop().browse(new URI("https://www.patelbros.com/"));
                else if(comboBoxStores.getSelectedItem()=="India Cash & Carry")
                Desktop.getDesktop().browse(new URI("https://www.indiacashandcarry.com/"));
                else if(comboBoxStores.getSelectedItem()=="Taj Mahal Imports")
                  Desktop.getDesktop().browse(new URI("http://www.tajmahalmarket.com/"));
                else if(comboBoxStores.getSelectedItem()=="Hanhook Supermarket")
                  Desktop.getDesktop().browse(new URI("http://www.hankooksupermarket.com/index.htm"));
                else if(comboBoxStores.getSelectedItem()=="Lion market")
                Desktop.getDesktop().browse(new URI("https://www.lionsupermarket.com/"));
                else if(comboBoxStores.getSelectedItem()=="99 Ranch Market")
                Desktop.getDesktop().browse(new URI("https://www.99ranch.com/"));
                else if(comboBoxStores.getSelectedItem()=="Mitsuwa market")
                  Desktop.getDesktop().browse(new URI("https://mitsuwa.com/sj"));
                else if(comboBoxStores.getSelectedItem()=="Safeway")
                  Desktop.getDesktop().browse(new URI("https://local.safeway.com/safeway/ca/santa-clara/3970-rivermark-plaza.html?utm_source=G&utm_medium=Maps&utm_campaign=G+Places"));
                else if(comboBoxStores.getSelectedItem()=="Nob Hill")
                Desktop.getDesktop().browse(new URI("https://www.raleys.com/stores/nob-hill-foods-monroe-santa-california/"));
                else if(comboBoxStores.getSelectedItem()=="Grocery Outlet")
                Desktop.getDesktop().browse(new URI("https://groceryoutlet.com/circulars/storeid/238"));
                else if(comboBoxStores.getSelectedItem()=="Whole Foods Market")
                  Desktop.getDesktop().browse(new URI("https://www.wholefoodsmarket.com/stores/santaclara"));
               
               
               
               
                   
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
           



}

});
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

