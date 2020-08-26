package rj.gate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;
 
public class PlanFinder {

	public static void main(String... s){
		try{
			//Class.forName("com.mysql.jdbc.Driver");
			Class.forName("com.ibm.as400.access.AS400JDBCDriver");
			Connection con = DriverManager.getConnection("jdbc:as400:SXCD1.SXC.COM; database name= SXCD1 ;prompt=false;translate binary=true;naming=system", "RAKA", "Password17");
			//Connection con=DriverManager.getConnection(");
			//here sonoo is the database name, root is the username and root is the password
			if(con==null)
				System.out.println("error");
			else
				System.out.println("connected");			
			Statement stmt=con.createStatement();
			
			Scanner st=new Scanner(System.in);
	
			int i=0;
			while(i++<=10){
				String sqlQuery1=st.nextLine();
				ResultSet rs=stmt.executeQuery(sqlQuery1);
				int count=0;
				while(rs.next()){
					System.out.println(rs.getString(1)+" "+rs.getString(2));
					count++;
				}
				System.out.println(count);
				
				
			}
			
			

		con.close();

		}catch(Exception e){ System.out.println(e);}
		
		

	}

}


