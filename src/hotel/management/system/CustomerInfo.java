
package hotel.management.system;
import java.awt.Color;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class CustomerInfo extends JFrame implements ActionListener {
    JTable t1;
    JButton b1,b2;
     CustomerInfo(){
        JLabel l1 =new JLabel("Document Type");
        l1.setBounds(10,10,100,20);
        add(l1);
        JLabel l2 =new JLabel("Number");
        l2.setBounds(160,10,70,20);
        add(l2);
         JLabel l3 =new JLabel("Name");
        l3.setBounds(290,10,70,20);
        add(l3);
         JLabel l4 =new JLabel("Gender");
        l4.setBounds(410,10,70,20);
        add(l4);
         JLabel l5 =new JLabel("Country");
        l5.setBounds(540,10,70,20);
        add(l5);
         JLabel l6 =new JLabel("Room Number");
        l6.setBounds(640,10,100,20);
        add(l6);
         JLabel l7 =new JLabel("Status");
        l7.setBounds(790,10,70,20);
        add(l7);
         JLabel l8 =new JLabel("Deposit");
        l8.setBounds(910,10,70,20);
        add(l8);
        t1 =new JTable();
        t1.setBounds(0,40,1000,500);
        add(t1);
        b1 =new JButton("Load Data");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(350,560,120,30);
        b1.addActionListener(this);
        add(b1);
        b2 =new JButton("Cancel");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(530,560,120,30);
        b2.addActionListener(this);
        add(b2);
        
        setLayout(null);
        setBounds(450,100,1000,650);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                Conn c = new Conn();
                String str ="select * from customer";
             ResultSet rs = c.s.executeQuery(str);
               t1.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource()==b2){
            new Reception().setVisible(true);
            this.setVisible(false);
            
        }
        
    }
    public static void main(String arg[]){
        new  CustomerInfo().setVisible(true);
    }
}
