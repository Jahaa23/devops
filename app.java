import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDetailsGUI extends JFrame {
    private JTextField nameField, idField;
    private JTextArea resultArea;

    public StudentDetailsGUI() {
        setTitle("Student Details");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name:"));
        nameField = new JTextField();
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("ID:"));
        idField = new JTextField();
        inputPanel.add(idField);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayStudentDetails();
            }
        });
        inputPanel.add(submitButton);

        add(inputPanel, BorderLayout.NORTH);

        resultArea = new JTextArea();
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }

    private void displayStudentDetails() {
        String name = nameField.getText();
        String id = idField.getText();

        if (!name.isEmpty() && !id.isEmpty()) {
            String result = "Name: " + name + "\nID: " + id;
            resultArea.setText(result);
        } else {
            resultArea.setText("Please enter both name and ID.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StudentDetailsGUI studentDetailsGUI = new StudentDetailsGUI();
            studentDetailsGUI.setVisible(true);
        });
    }
}
