package OOPS;
import java.sql.*;  
import java.sql.Connection;



public class DatabaseConn {
	
	void InsertRegisterQuery(String FirstName,String LastName,String Email,String PasswordID,String PhoneNo)
	{
		
			try{  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			
			Connection conn = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
			
			
			Statement stmt=conn.createStatement();  
			  
			
			
			String query = "INSERT INTO REGISTER(FIRSTNAME,LASTNAME,EMAIL,PASSWORDID,PHONENO) VALUES (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,FirstName);
			ps.setString(2,LastName);
			ps.setString(3,Email);
			ps.setString(4,PasswordID);
			ps.setString(5,PhoneNo);
			
			
			ps.execute();
			
			conn.close();  
			  
			}
			catch(Exception e){ 
				;
				System.out.println(e);
			}  
			  
			
	}
	String CheckLoginRecord(String Email,String PasswordID)
	{
		int count = 0;
		String name="";
			try{  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			
			Connection conn = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
			
			
			Statement stmt=conn.createStatement();  
			  
			
			
			String query = "SELECT * FROM REGISTER WHERE EMAIL=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,Email);
			
			ResultSet value=ps.executeQuery();
			
			
		      while (value.next()) {
		    	name=value.getString("FIRSTNAME");
		        count++;
		      }  
		     
			  
			 
			
		    conn.close();
		    
		    
		
			  
			}
			catch(Exception e){ 
				System.out.println("hello");
				System.out.println(e);
			}
			 
			  
			return name;
	}
	int CheckPassword(String Email,String PasswordID)
	{
		int count = 0;
			try{  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			
			Connection conn = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
			
			 
			Statement stmt=conn.createStatement();  
			  
			
			
			String query = "SELECT * FROM REGISTER WHERE EMAIL=? and PASSWORDID=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,Email);
			ps.setString(2,PasswordID);
			
			ResultSet value=ps.executeQuery();
			
			
		      while (value.next()) {
		        count++;
		      }  
		     
			  
			
			
		    conn.close();
		    
		    
		
			  
			}
			catch(Exception e){ 
				System.out.println("hello");
				System.out.println(e);
			}
			 
			  
			return count;
	}
	int CheckEmail(String Email)
	{
		int count = 0;
			try{  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			
			Connection conn = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
			
			
			Statement stmt=conn.createStatement();  
			  
			
			
			String query = "SELECT * FROM REGISTER WHERE EMAIL=?";
			PreparedStatement ps = conn.prepareStatement(query);
			
			ps.setString(1,Email);
			
			
			ResultSet value=ps.executeQuery();
			
			
		      while (value.next()) {
		        count++;
		      }  
		     
			  
			
			
		    conn.close();
		    
		    
		
			  
			}
			catch(Exception e){ 
				System.out.println("hello");
				System.out.println(e);
			}
			 
			  
			return count;
	}
	void UpdateRegisterQuery(String Comment,int rating,String EmailID)
	{
		
			try{  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			
			Connection conn = DriverManager.getConnection(
	                "jdbc:oracle:thin:@localhost:1521/orcl", "hr", "oracle");
			
			
			Statement stmt=conn.createStatement();  
			  
			
			System.out.println("Hello");
			String query = "UPDATE REGISTER SET COMMENTS=?,RATINGS=? WHERE EMAIL=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1,Comment);
			ps.setInt(2,rating);
			ps.setString(3,EmailID);
			
			
			
			ps.execute();
			
			conn.close();  
			  
			}
			catch(Exception e){ 
				
				System.out.println(e);
			}  
			  
			
	}
	ResultSet DisplayReviews(Connection con)
	{
		int count = 0;

		
		
		
			try{  
			
			Class.forName("oracle.jdbc.driver.OracleDriver");  
			  
			
			
			Connection conn = con;
			
			
			Statement stmt=conn.createStatement();  
			
			String query = "SELECT * FROM REGISTER WHERE COMMENTS IS NOT NULL";
			PreparedStatement ps = conn.prepareStatement(query);
			
			
			
		    ResultSet value=ps.executeQuery();
			
			
		    while (value.next()) {
		        System.out.println(value.getString("FIRSTNAME"));
		        count++;
		      }  
		     
		     
		   
			
		   
		    return value;
		  
		    
		    
		
			  
			}
			catch(Exception e){ 
				System.out.println(e);
				return null;
				
			}
			
			
			
	}

}
