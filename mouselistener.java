import java.awt.event.*;
import javax.swing.*;
public class MouseListenerDemo extends JFrame implements MouseListener
{
JLabel l;
 MouseListenerDemo()
 {
addMouseListener(this); //register
l=new JLabel();
l.setBounds(20,50,120,40);
add(l);
setSize(600,600);
setLayout(null);
setVisible(true);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
public void mouseClicked(MouseEvent e)
{
 l.setText("Mouse Clicked");
}
public void mouseEntered(MouseEvent e)
{
 l.setText("Mouse Entered");
}
public void mouseExited(MouseEvent e)
{
 l.setText("Mouse Exited");
}
public void mousePressed(MouseEvent e)
{
 l.setText("Mouse Pressed");
}
public void mouseReleased(MouseEvent e)
{
 l.setText("Mouse Released");
}
public static void main(String[] args)
{
new MouseListenerDemo();
}
} 