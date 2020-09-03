
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class HotelManagementSystem extends JFrame implements ActionListener{
    HotelManagementSystem(){
        setBounds(200,200,1366,565);
        ImageIcon s1 =new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/first.jpg"));
        
        JLabel l1 = new JLabel(s1);
        add(l1);
        l1.setBounds(0,0,1366,565);
        JLabel l2 = new JLabel("Hotel Managemant System");
        l2.setBounds(20,430,1000,90);
       l2.setFont(new Font("serif",Font.PLAIN,70));
       l2.setForeground(Color.white);
        l1.add(l2);
        JButton b1 = new JButton("Next");
        b1.setBackground(Color.white);
        b1.setForeground(Color.black);
        b1.setBounds(1110,470,150,30);
        b1.addActionListener(this);
        l1.add(b1);
        
        setLayout(null);
         setVisible(true);
        
        while(true)
        {
            l2.setVisible(false);
            try{
                Thread.sleep(500);
            }
            catch(Exception ec){
                
                
            }
            l2.setVisible(true);
            
                try{
                    Thread.sleep(500);
                }
                catch(Exception ec){
                    
                }
            
        }
       
        
    }
    public void actionPerformed(ActionEvent ec)
    {
        new Login().setVisible(true);
        this.setVisible(false);
    }

    
    public static void main(String[] args) {
        new HotelManagementSystem().setVisible(true);
        
    }
    
}
