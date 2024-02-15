import java.awt.*;
import javax.swing.*;
class MyFlowLayout{
JFrame f;
MyFlowLayout(){
f=new JFrame();
JButton b1=new JButton("1");
JButton b2=new JButton("2");
JButton b3=new JButton("3");
f.add(b1);f.add(b2);f.add(b3);
f.setLayout(new FlowLayout(FlowLayout.RIGHT));//setting flow layout of right alignment
f.setSize(300,300);
f.setVisible(true); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
public static void main(String[] args) {
new MyFlowLayout();
}
}