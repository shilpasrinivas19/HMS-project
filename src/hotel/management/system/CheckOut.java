
package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
public class CheckOut extends JFrame implements ActionListener{
    Choice c1;
    JTextField t1;
    JButton b1,b2,b3;
CheckOut(){
    JLabel l1 = new JLabel("Check Out");
    l1.setBounds(30,20,100,30);
    l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    add(l1);
    JLabel l2 = new JLabel("Customer Id");
    l2.setBounds(30,80,100,30);
    add(l2);
    c1 =new Choice();
    try{
       Conn c = new Conn();
       ResultSet rs = c.s.executeQuery("select * from customer");
       while(rs.next()){
           c1.add(rs.getString("number"));
       }
    }catch(Exception e){
        
    } 
    c1.setBounds(150,80,150,30);
    add(c1);
    JLabel l3 = new JLabel("Room Number");
    l3.setBounds(30,130,100,30);
    add(l3);
    t1 = new JTextField();
    t1.setBounds(150,130,150,30);
    add(t1);
    b1 = new JButton("CheckOut");
    b1.setBackground(Color.black);
    b1.setForeground(Color.white);
    b1.setBounds(30,180,120,30);
    b1.addActionListener(this);
    add(b1);
    b2 = new JButton("Back");
    b2.setBackground(Color.black);
    b2.setForeground(Color.white);
    b2.setBounds(170,180,120,30);
    b2.addActionListener(this);
    add(b2);
    ImageIcon mi = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tick.png"));
    Image m2 = mi.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
    ImageIcon m3 =new ImageIcon(m2);
    b3 = new JButton(m3);
    b3.setBounds(310,80,20,20);
    b3.addActionListener(this);
    add(b3);
        ImageIcon m4 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/sixth.jpg"));
    Image m5 = m4.getImage().getScaledInstance(400,250,Image.SCALE_DEFAULT);
    ImageIcon m6 =new ImageIcon(m5);
    JLabel l7 = new JLabel(m6);
    l7.setBounds(350,0,400,250);
    add(l7);
setLayout(null);
setBounds(500,200,800,300);
setVisible(true);
}
public  void actionPerformed(ActionEvent ae){
    Conn c = new Conn();
    if(ae.getSource()==b1){
        String id =c1.getSelectedItem();
        String room =t1.getText();
        String str ="delete from customer  where number ='"+id+"'";
        String str1 ="update room set available='Available' where room_no ='"+room+"'";
        try{
            c.s.executeUpdate(str);
            c.s.executeUpdate(str1);
            JOptionPane.showMessageDialog(null,"CheckOut done");
            new Reception().setVisible(true);
            this.setVisible(false);
        }catch(Exception e){
            System.out.println(e);
        }
    }else if(ae.getSource()==b2){
      new Reception().setVisible(true);
      this.setVisible(false);
    }else if(ae.getSource()==b3){
        String id=c1.getSelectedItem();
        try{
         ResultSet rs = c.s.executeQuery("select * from customer where number = '"+id+"'");   
        while(rs.next()){
            t1.setText(rs.getString("room"));
        }
        }catch(Exception e){
            
        }
        
    }
}
public static void main(String arg[]){
    new CheckOut().setVisible(true);
}
}
