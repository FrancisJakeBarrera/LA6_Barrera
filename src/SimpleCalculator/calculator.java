package SimpleCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator {
    private JTextField tfNumber1;
    private JTextField tfNumber2;
    private JComboBox<String> cbOperations;
    private JButton btnCompute;
    private JLabel lblResult;
    private JPanel mainPanel;


    public calculator() {

        cbOperations.setModel(new DefaultComboBoxModel<>(new String[]{"+", "-", "*", "/"}));
        lblResult.setName(" ");

        btnCompute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(tfNumber1.getText().trim());
                    double num2 = Double.parseDouble(tfNumber2.getText().trim());
                    String operation = (String) cbOperations.getSelectedItem();
                    double result = 0;

                    switch (operation) {
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
                            if (num2 != 0) {
                                result = num1 / num2;
                            } else {
                                lblResult.setText("Cannot divide by zero");
                                return;
                            }
                            break;
                        case null:
                            break;
                        default:
                            lblResult.setText("Invalid Operation");
                            return;
                    }

                    lblResult.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    lblResult.setText("Please enter valid numbers");
                }


            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new calculator().mainPanel);
        frame.setTitle("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}


