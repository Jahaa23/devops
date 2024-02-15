import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class FactSum extends JFrame implements ActionListener
{
JLabel l1,l2;
JTextField t1; JTextField t2;
JButton b1;
 JButton b2;
 FactSum()
 {
l1=new JLabel("Enter any integer: "); l1.setBounds(100,200,150,100);
add(l1);
 t1=new JTextField(); t1.setBounds(300,200,100,50);
add(t1);
b1=new JButton(" FACTORIAL"); b1.setBounds(100,300,150,100);
add(b1);
 b1.addActionListener(this);
b2=new JButton("SUM"); b2.setBounds(400,300,150,100);
add(b2);
b2.addActionListener(this);
l2=new JLabel("RESULT is ");
l2.setBounds(100,400,150,100);
add(l2);
t2=new JTextField();
t2.setBounds(200,450,100,50);
add(t2);
setSize(800,800);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public void actionPerformed(ActionEvent e)
 {
if(e.getSource()==b1)
{
 int fact=fact(Integer.parseInt(t1.getText()));
 t2.setText(String.valueOf(fact));
 }
if(e.getSource()==b2)
{

 int sum=Sum(Integer.parseInt(t1.getText()));
 t2.setText(String.valueOf(sum));
 }
 }

 int fact(int f)
 {
if(f==0)
return 1;
else
return f*fact(f-1);
 }
int Sum(int n)
 {
int s=0;
for(int i=1;i<=n;i++)
 s=s+i;
return s;
 }
public static void main(String args[])
{
new FactSum();
}
}
