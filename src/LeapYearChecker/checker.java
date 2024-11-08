package LeapYearChecker;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class checker {
    private JTextField yearTextField;
    private JButton checkYearButton;
    private JPanel mainPanel;

    public checker() {
        yearTextField.setName("yearTextField");
        checkYearButton.setName("checkYearButton");

        checkYearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int year = Integer.parseInt(yearTextField.getText().trim());

                    boolean isLeap = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
                    String message = isLeap ? "Leap year" : "Not a leap year";

                    JOptionPane.showMessageDialog(null, message, "Message", JOptionPane.INFORMATION_MESSAGE);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid year", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setContentPane(new checker().mainPanel);
        frame.setTitle("Leap Year Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}



