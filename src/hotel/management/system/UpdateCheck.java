
package hotel.management.system;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import javax.swing.*;
public class UpdateCheck extends JFrame implements ActionListener {
    JButton b1,b2,b3;
    Choice c1;
    JTextField t1,t2,t3,t4,t5;
    UpdateCheck(){
        JLabel l1 = new JLabel("Check-in Details");
        l1.setForeground(Color.blue);
        l1.setFont(new Font("Tahoma",Font.PLAIN,20));
        l1.setBounds(90,30,200,30);
        JLabel l2 = new JLabel("Customer-Id");
        l2.setBounds(30,80,100,20);
        add(l2);
        c1 = new Choice();
        try{
            Conn c = new Conn();
            ResultSet rs =c.s.executeQuery("select * from customer");
            while(rs.next()){
                c1.add(rs.getString("number"));
            }
            
            
        }catch(Exception e){
         System.out.println(e);   
        }
        c1.setBounds(200,80,150,25);
        add(c1);
         JLabel l3 = new JLabel("Room Number");
        l3.setBounds(30,120,100,20);
        add(l3);
        t1 = new JTextField();
        t1.setBounds(200,120,150,25);
        add(t1);
         JLabel l4 = new JLabel("Name");
        l4.setBounds(30,160,100,20);
        add(l4);
        t2 = new JTextField();
        t2.setBounds(200,160,150,25);
        add(t2);
         JLabel l5 = new JLabel("Check-In");
        l5.setBounds(30,200,100,20);
        add(l5);
        t3 = new JTextField();
        t3.setBounds(200,200,150,25);
        add(t3);
         JLabel l6 = new JLabel("Amount-Paid");
        l6.setBounds(30,240,100,20);
        add(l6);
        t4 = new JTextField();
        t4.setBounds(200,240,150,25);
        add(t4);
         JLabel l7 = new JLabel("Pending Amount");
        l7.setBounds(30,280,100,20);
        add(l7);
        t5 = new JTextField();
        t5.setBounds(200,280,150,25);
        add(t5);
        add(l1);
        b1 = new JButton("Check");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(30,340,100,30);
        b1.addActionListener(this);
        add(b1);
         b2 = new JButton("Update");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.addActionListener(this);
        b2.setBounds(150,340,100,30);
        add(b2);
         b3 = new JButton("Back");
        b3.setBackground(Color.black);
        b3.setForeground(Color.white);
        b3.addActionListener(this);
        b3.setBounds(270,340,100,30);
        add(b3);
        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/nine.jpg"));
        JLabel l9 =new JLabel(m1);
        l9.setBounds(400,50,500,300);
        add(l9);
        setLayout(null);
        setBounds(500,200,980,500);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            try{
                String room =null;
                  String deposit=null;
                    String amountPaid=null;
                      String price =null;
               String number =c1.getSelectedItem();
                Conn c =new Conn();
                String sr = "select * from Customer where number='"+number+"'";
            ResultSet rs = c.s.executeQuery(sr);
            while(rs.next()){
                t1.setText(rs.getString("room"));
                t2.setText(rs.getString("name"));
                t3.setText(rs.getString("status"));
                t4.setText(rs.getString("deposit"));
                room =rs.getString("room");
                deposit=rs.getString("deposit");
            }
            ResultSet rs1 =c.s.executeQuery("select * from room where room_no ='"+room+"'");
            while(rs1.next())
            {
               price =rs1.getString("price");
               amountPaid = String.valueOf(Integer.parseInt(price)-Integer.parseInt(deposit));
               t5.setText(amountPaid);
            }
                
            }catch(Exception e){
                
            }
            
        }else if(ae.getSource()==b2){
            
        }else if(ae.getSource()==b3){
            new Reception().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String arg[]){
        new UpdateCheck().setVisible(true);
    }
    
}
