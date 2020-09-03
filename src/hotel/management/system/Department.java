package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import net.proteanit.sql.DbUtils;
public class Department extends JFrame implements ActionListener {
   
    JButton b1,b2;
    JTable t1;
Department(){
    
     
      JLabel l3 =new JLabel("Department");
    l3.setBounds(100,10,100,20);
    add(l3);
      JLabel l4 =new JLabel("Budget");
    l4.setBounds(370,10,100,20);
    add(l4);
     
  
  
   t1 =new JTable();
   t1.setBounds(0,50,700,350);
   add(t1);
   b1 = new JButton("Sumit");
   b1.setBackground(Color.black);
   b1.setForeground(Color.WHITE);
   b1.setBounds(180,400,120,30);
   b1.addActionListener(this);
   add(b1);
    b2 = new JButton("Back");
   b2.setBackground(Color.black);
   b2.setForeground(Color.WHITE);
   b2.setBounds(380,400,120,30);
   b2.addActionListener(this);
   add(b2);
   getContentPane().setBackground(Color.white);
   setLayout(null);
    setBounds(500,200,700,480);
}
public void actionPerformed(ActionEvent ae){
   
    if(ae.getSource()==b1){
    try{
    String str ="select * from department";
   Conn c = new Conn();
   ResultSet rs =c.s.executeQuery(str);
   t1.setModel(DbUtils.resultSetToTableModel(rs));
   
    }
     catch(Exception e){
      System.out.println(e);  
    }
}else if(ae.getSource()==b2){
    new Reception().setVisible(true);
    this.setVisible(false);
}
    
}
public static void main(String arg[]){
  
    new Department().setVisible(true);
}
}

