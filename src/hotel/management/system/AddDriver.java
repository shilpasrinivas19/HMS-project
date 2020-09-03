package hotel.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class AddDriver extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5;
    JComboBox c1,c2;
    JButton b1,b2;
    AddDriver(){
        JLabel title = new JLabel("Add Driver");
        title.setBounds(150,10,150,30);
        title.setFont(new Font("Tahoma",Font.BOLD,18));
        add(title);
        JLabel name = new JLabel("Name");
        name.setBounds(60,70,100,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(name);
        t1 =new JTextField();
        t1.setBounds(200,70,150,30);
        add(t1);
         JLabel age = new JLabel("Age");
        age.setBounds(60,110,100,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(age);
        t2 =new JTextField();
        t2.setBounds(200,110,150,30);
        add(t2);
         JLabel gender = new JLabel("Gender");
        gender.setBounds(60,150,100,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(gender);
        c1 = new JComboBox(new String[]{"Male","Female"});
        c1.setBounds(200,150,150,30);
        c1.setBackground(Color.white);
        add(c1);
         JLabel car = new JLabel("Car Company");
        car.setBounds(60,190,100,30);
        car.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(car);
        t3 =new JTextField();
        t3.setBounds(200,190,150,30);
        add(t3);
         JLabel model = new JLabel("Car Model");
        model.setBounds(60,230,100,30);
        model.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(model);
        t4 =new JTextField();
        t4.setBounds(200,230,150,30);
        add(t4);
         JLabel available = new JLabel("Available");
        available.setBounds(60,270,100,30);
        available.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(available);
         c2 = new JComboBox(new String[]{"Available","Busy"});
        c2.setBounds(200,270,150,30);
        add(c2);
        c2.setBackground(Color.white);
         JLabel location = new JLabel("Location");
        location.setBounds(60,310,100,30);
        location.setFont(new Font("Tahoma",Font.PLAIN,14));
        add(location);
        t5 =new JTextField();
        t5.setBounds(200,310,150,30);
        add(t5);
        b1 = new JButton("Add Driver");
        b1.setBackground(Color.black);
        b1.setForeground(Color.white);
        b1.setBounds(60,370,130,30);
        b1.addActionListener(this);
        add(b1);
         b2 = new JButton("Add Driver");
        b2.setBackground(Color.black);
        b2.setForeground(Color.white);
        b2.setBounds(210,370,130,30);
        b2.addActionListener(this);
        add(b2);
        getContentPane().setBackground(Color.white);
        ImageIcon m1 = new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/eleven.jpg"));
        Image m2 = m1.getImage().getScaledInstance(500,300,Image.SCALE_DEFAULT);
        ImageIcon m3 =new ImageIcon(m2);
        JLabel l7 =new JLabel(m3);
        l7.setBounds(400,80,500,300);
        add(l7);
        setLayout(null);
        setBounds(400,200,940,470);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==b1){
            String name =t1.getText();
            String age =t2.getText();
            String gender =(String)c1.getSelectedItem();
            String company =t3.getText();
            String brand = t4.getText();
            String available =(String)c2.getSelectedItem();
            String location =t5.getText();
            Conn c = new Conn();
            String str ="insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+brand+"','"+available+"','"+location+"')";
            try{
            c.s.executeUpdate(str);
        }
            catch(Exception e){
                System.out.println(e);
                
            }
            JOptionPane.showMessageDialog(null,"Driver information is added");
        }
            else if(ae.getSource()==b2){
            this.setVisible(false);
        }
    }
    
    public static void main(String arg[]){
        new AddDriver().setVisible(true);
    }
    
}
