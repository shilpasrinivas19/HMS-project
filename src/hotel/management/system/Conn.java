package hotel.management.system;
import java.sql.*;

public class Conn {
    Connection c;
    Statement s;
    Conn(){
        try{
    Class.forName("com.mysql.jdbc.Driver");
}catch(Exception e){
    e.printStackTrace();
}
        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/projecthms","root","");
            s=c.createStatement();
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    
}
    
}
