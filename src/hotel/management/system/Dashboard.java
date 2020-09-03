
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class Dashboard extends JFrame implements ActionListener {
    
       JMenuBar mb;
       JMenu m1,m2;
       JMenuItem i1,i2,i3,i4;
        
        Dashboard(){
            mb = new JMenuBar();
            add(mb);
            m1 =new JMenu("Hotel Management");
            m2 =new JMenu("admin");
            mb.add(m1);
            mb.add(m2);
            i1 = new JMenuItem("reception");
            i1.addActionListener(this);
            i2 = new JMenuItem("add employee");
             i2.addActionListener(this);
            i3 = new JMenuItem("add rooms");
             i3.addActionListener(this);
            i4 = new JMenuItem("add drivers");
             i4.addActionListener(this);
            m1.add(i1);
              m2.add(i2);
             m2.add(i3);
               m2.add(i4);
               ImageIcon l1 =new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/third.jpg"));
               Image l3 = l1.getImage().getScaledInstance(1600,900,Image.SCALE_DEFAULT);
               ImageIcon l4 =new ImageIcon(l3);
               JLabel l2 = new JLabel(l4);
               add(l2);
               l2.setBounds(0,0,1600,900);
               setLayout(null);
               mb.setBounds(0,0,1600,50);
               JLabel l5 =new JLabel("The TAJ GROUP WELCOME YOU");
               l5.setForeground(Color.white);
               l5.setBounds(500,60,1000,50);
               l5.setFont(new Font("Tahoma",Font.PLAIN,50));
               l2.add(l5);
            setBounds(0,0,1600,900);
               setVisible(true);
              }
        public void actionPerformed(ActionEvent ae){
            if(ae.getActionCommand().equals("reception")){
              new Reception().setVisible(true);
            }else if(ae.getActionCommand().equals("add employee")){
                new AddEmployee().setVisible(true);
            }else if(ae.getActionCommand().equals("add rooms")){
              new AddRooms().setVisible(true);
            }else if(ae.getActionCommand().equals("add drivers")){
             new AddDriver().setVisible(true);
            }
        }
        public static void main(String arg[]){
            new Dashboard();
        }
    }

    
