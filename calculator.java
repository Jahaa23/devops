import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stack;
class Calculator extends JFrame
{
    JTextField tf;
    StringBuilder expression;
    Calculator()
    {
        JButton b0 = new JButton("0");
        JButton b1 = new JButton("1");
        JButton b2 = new JButton("2");
        JButton b3 = new JButton("3");
        JButton b4 = new JButton("4");
        JButton b5 = new JButton("5");
        JButton b6 = new JButton("6");
        JButton b7 = new JButton("7");
        JButton b8 = new JButton("8");
        JButton b9 = new JButton("9");
        JButton b10 = new JButton("+");
        JButton b11 = new JButton("-");
        JButton b12 = new JButton("*");
        JButton b13 = new JButton("/");
        JButton b14 = new JButton("%");
        JButton b15 = new JButton("Clear");
        JButton b16 = new JButton("=");

        ActionListener numberAction = new ActionListener() 
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton source = (JButton) e.getSource();
                expression.append(source.getText());
                tf.setText(expression.toString());
            }
        };
        ActionListener operatorAction = new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                JButton source = (JButton) e.getSource();
                expression.append(" ").append(source.getText()).append(" ");
                tf.setText(expression.toString());    
            }
        };
    
        b0.addActionListener(numberAction);
        b1.addActionListener(numberAction);
        b2.addActionListener(numberAction);
        b3.addActionListener(numberAction);
        b4.addActionListener(numberAction);
        b5.addActionListener(numberAction);
        b6.addActionListener(numberAction);
        b7.addActionListener(numberAction);
        b8.addActionListener(numberAction);
        b9.addActionListener(numberAction);
        b10.addActionListener(operatorAction);
        b11.addActionListener(operatorAction);
        b12.addActionListener(operatorAction);
        b13.addActionListener(operatorAction);
        b14.addActionListener(operatorAction);
        b15.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                expression.setLength(0);
                tf.setText("");
            }
        });

        b16.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e) 
            {
                try 
                {
                    String result = evaluateExpression();
                    tf.setText(result);
                    expression.setLength(0);
                    expression.append(result);
                }
                catch(ArithmeticException ex) 
                {
                    tf.setText("Error");
                    expression.setLength(0);
                }
            }
        });

        add(tf);
        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);

        setLayout(new GridLayout(6,3));
        setSize(300,300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private String evaluateExpression() 
    {
        String[] tokens = expression.toString().split(" ");
        Stack<Integer> numbers = new Stack<>();
        Stack<Integer> operators = new Stack<>();

        for(String token : tokens) 
        {
            if(isNumber(token)) 
            {
                numbers.push(Integer.parseInt(token));
            }
            else if(isOperator(token)) 
            {
                while(!operators.isEmpty() && precedence(operators.peek()) >= precedence(token)) 
                {
                    applyOperator(numbers,operators);
                }
                operators.push(token);
            }
        }
        while(!operators.isEmpty()) 
        {
            applyOperator(numbers, operators);
        }
        return String.valueOf(numbers.pop());
    }
    private boolean isNumber(String token) 
    {
        try 
        {
            Integer.parseInt(token);
            return true;
        }
        catch(NumberFormatException e) 
        {
            return false;
        }
    }
    private boolean isOperator(String token) 
    {
        return "+-*/%".contains(token);
    }
    private int precedence(String operator) 
    {
        switch(operator) {
            case "+" :
            case "-" :
                return 1;
            case "*" :
            case "/" :
            case "%" :
                return 2;
            default : return 0;
        }
    }
    private void applyOperator(Stack<Integer> numbers, Stack<String> operators) 
    {
        int b = numbers.pop();
        int a = numbers.pop();
        String operator = operators.pop();
        switch(operator) {
            case "+" : numbers.push(a+b);break;
            case "-" : numbers.push(a-b);break;
            case "*" : numbers.push(a*b);break;
            case "/" : if(b==0)
                {
                    throw new ArithmeticException("Division by zero");
                }
                numbers.push(a/b);break;
            case "%" : numbers.push(a%b); break;
        }
    }
    public static void main(String args[])
    {
        new Calculator();
    }
}
