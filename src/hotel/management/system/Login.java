
package hotel.management.system;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    JLabel l1,l2;
    JTextField p1;
    JTextField t1;
    JButton b1,b2;
    Login(){
     l1 =new JLabel("UserName");
     l1.setBounds(40,20,100,30);
     add(l1);
    l2 =new JLabel("Password");
     l2.setBounds(40,70,100,30);
     add(l2);
     t1 =new JTextField();
     t1.setBounds(150,20,150, 30);
     add(t1);
     p1 =new JTextField();
     p1.setBounds(150,70,150,30);
     add(p1);
     b1= new JButton("Login");
     b1.setBackground(Color.black);
     b1.setForeground(Color.white);
    b1.setBounds(40,150,120,30);
    b1.addActionListener(this);
      add(b1);
      b2= new JButton("Cancel");
     b2.setBackground(Color.black);
     b2.setForeground(Color.white);
    b2.addActionListener(this);
    b2.setBounds(180,150,120,30);
      add(b2);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/second.jpg"));
      Image i2 =i1.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel l3 = new JLabel(i3);
      l3.setBounds(350,10,200,200);
      add(l3);
      getContentPane().setBackground(Color.white);
    setBounds(600,300,600,300);
    setLayout(null);
    setVisible(true);    
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==b1){
           String username =t1.getText();
           String password = p1.getText();
           Conn c= new Conn();
           String srg ="select *from login where username='"+username+"'and password='"+password+"'";
           try{
                ResultSet rs=c.s.executeQuery(srg);
                if(rs.next()){
                   new Dashboard().setVisible(true);
                 this.setVisible(false);
                    }else{
                    JOptionPane.showMessageDialog(null,"invalid");
                    this.setVisible(false);
                }
           }catch(Exception es){
               es.printStackTrace();
               
           }
       
           
            
        }else if(e.getSource()==b2){
            System.exit(0);
            
        }
    }
    public static void main(String arg[]){
        new Login();
        
    }
}
