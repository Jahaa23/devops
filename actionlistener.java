import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class AEvent1 extends JFrame implements ActionListener
{
JTextField tf;
 AEvent1()
 {
//create components
tf=new JTextField();
tf.setBounds(60,50,170,40);
JButton b=new JButton("click me");
b.setBounds(100,120,80,30);
//register listener
b.addActionListener(this);//passing current instance
//add components and set size, layout and visibility
add(b);add(tf);
setSize(600,600);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
public void actionPerformed(ActionEvent e)
{
tf.setText("Welcome to event handling");
tf.setBackground(Color.yellow);
}
public static void main(String args[])
{
new AEvent1();
}
}
