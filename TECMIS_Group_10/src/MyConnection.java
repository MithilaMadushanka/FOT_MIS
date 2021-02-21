
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;


public class MyConnection {
    public static Connection getConnection()
    {
        Connection con=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tecmis","root","");
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return con;
    }        
    
    public static void main (String argc[]){
        getConnection();
    
    }
}
