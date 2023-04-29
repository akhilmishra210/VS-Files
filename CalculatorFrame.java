import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalculatorFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton addButton;
    private JButton subtractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton equalsButton;
    private JButton clearButton;
    private double num1;
    private double num2;
    private String operator;

    public CalculatorFrame() {
        setTitle("Calculator");

        // Create input field
        inputField = new JTextField();
        inputField.setEditable(false);
        add(inputField, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        // Add buttons to button panel
        addButton = new JButton("+");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        subtractButton = new JButton("-");
        subtractButton.addActionListener(this);
        buttonPanel.add(subtractButton);

        multiplyButton = new JButton("*");
        multiplyButton.addActionListener(this);
        buttonPanel.add(multiplyButton);

        divideButton = new JButton("/");
        divideButton.addActionListener(this);
        buttonPanel.add(divideButton);

        for (int i = 1; i <= 9; i++) {
            JButton numberButton = new JButton("" + i);
            numberButton.addActionListener(this);
            buttonPanel.add(numberButton);
        }

        JButton zeroButton = new JButton("0");
        zeroButton.addActionListener(this);
        buttonPanel.add(zeroButton);

        equalsButton = new JButton("=");
        equalsButton.addActionListener(this);
        buttonPanel.add(equalsButton);

        clearButton = new JButton("C");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        add(buttonPanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("C")) {
            inputField.setText("");
            num1 = 0.0;
            num2 = 0.0;
            operator = "";
        } else if (action.equals("+") || action.equals("-") || action.equals("*") || action.equals("/")) {
            operator = action;
            num1 = Double.parseDouble(inputField.getText());
            inputField.setText("");
        } else if (action.equals("=")) {
            num2 = Double.parseDouble(inputField.getText());
            double result = 0.0;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    result = num1 / num2;
                    break;
            }
            inputField.setText("" + result);
        } else {
            inputField.setText(inputField.getText() + action);
        }
    }

    public static void main(String[] args) {
        CalculatorFrame calculatorFrame = new CalculatorFrame();
        calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculatorFrame.pack();
        calculatorFrame.setVisible(true);
    }
}
