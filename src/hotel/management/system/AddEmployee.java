
package hotel.management.system;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import java.awt.event.*;
public class AddEmployee extends JFrame implements ActionListener {
    JTextField t1,t2,t3,t4,t5,t6;
    JComboBox c1;
    JButton b1;
    JRadioButton r1,r2;
    AddEmployee(){
        JLabel name =new JLabel("NAME");
        name.setBounds(60,30,120,30);
        name.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(name);
       t1 =new JTextField();
       t1.setBounds(200,30,150,30);
       add(t1);
        JLabel age =new JLabel("AGE");
        age.setBounds(60,80,120,30);
        age.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(age);
       t2 =new JTextField();
       t2.setBounds(200,80,150,30);
       add(t2);
        JLabel gender =new JLabel("GENDER");
        gender.setBounds(60,130,120,30);
        gender.setFont(new Font("Tahoma",Font.PLAIN,17));
        add(gender);
        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Tahoma",Font.PLAIN,14));
        r1.setBounds(200,130,70,30);
         r1.setBackground(Color.white);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Tahoma",Font.PLAIN,14));
        r2.setBounds(280,130,70,30);
         r2.setBackground(Color.white);
        add(r2);
       JLabel job =new JLabel("JOB");
        job.setBounds(60,180,120,30);
        job.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(job);
       String[] str ={"Front Desk Clerks","Porters","Housekepping","kitchen Staff","Room Service","waiter/Waitress","Manager","Accountant","Cheif"};
       c1 =new JComboBox(str);
       c1.setBounds(200,180,150,30);
        c1.setBackground(Color.white);
       add(c1);
        JLabel salary =new JLabel("SALARY");
        salary.setBounds(60,230,120,30);
        salary.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(salary);
          t3 =new JTextField();
       t3.setBounds(200,230,150,30);
       add(t3);
        JLabel phone =new JLabel("PHONE");
        phone.setBounds(60,280,120,30);
        phone.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(phone);
          t4 =new JTextField();
       t4.setBounds(200,280,150,30);
       add(t4);
        JLabel aadhar =new JLabel("AADHAR");
        aadhar.setBounds(60,330,120,30);
        aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(aadhar);
          t5 = new JTextField();
       t5.setBounds(200,330,150,30);
       add(t5);
        JLabel email =new JLabel("EMAIL");
        email.setBounds(60,380,120,30);
        email.setFont(new Font("Tahoma",Font.PLAIN,17));
       add(email);
          t6 =new JTextField();
       t6.setBounds(200,380,150,30);
       add(t6);
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("hotel/management/system/icons/tenth.jpg"));
       Image s1 =i1.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
       ImageIcon s2 =new ImageIcon(s1);
       JLabel l1 =new JLabel(s2);
       l1.setBounds(380,65,450,450);
       add(l1);
       JLabel l2= new JLabel("ADD EMPLOYEE DETAILS");
       l2.setForeground(Color.BLUE);
       l2.setBounds(420,30,400,30);
       l2.setFont(new Font("Tamoha",Font.PLAIN,30));
       add(l2);
       b1 =new JButton("Submit");
       b1.setBackground(Color.black);
       b1.setForeground(Color.white);
       b1.setBounds(200,430,150,30);
       b1.addActionListener(this);
       add(b1);
       getContentPane().setBackground(Color.white);
        setLayout(null);
        setBounds(450,200,850,540);
        setVisible(true);
        
        
    }
    public void actionPerformed(ActionEvent ae){
        String name =t1.getText();
         String age =t2.getText();
          String salary =t3.getText();
           String phone =t4.getText();
            String aadhar =t5.getText();
             String email =t6.getText();
             String gender =null;
             if(r1.isSelected())
             {
                 gender ="Male";
             }else if(r2.isSelected()){
                 gender ="Female";
             }
             String job =(String) c1.getSelectedItem();
             Conn c =new Conn();
             String str ="insert into employee values('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
             try{
             c.s.executeUpdate(str);
             JOptionPane.showMessageDialog(null,"employee information added");
             this.setVisible(false);
             
    }catch(Exception e){
        
    }
    }
             
    public static void main(String arg[]){
        new AddEmployee().setVisible(true);
    }
    
}
