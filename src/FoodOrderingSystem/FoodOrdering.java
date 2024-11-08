package FoodOrderingSystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FoodOrdering {
    private JPanel mainPanel;
    private JPanel pnlBotLeft;
    private JPanel pnlBotCent;
    private JPanel pnlBotRight;
    private JPanel pnlTopLeft;
    private JPanel pnlTopRight;
    private JCheckBox cPizza;
    private JCheckBox cBurger;
    private JCheckBox cFries;
    private JCheckBox cSoftDrinks;
    private JCheckBox cTea;
    private JCheckBox cSundae;
    private JRadioButton rbNone;
    private JRadioButton rb5;
    private JRadioButton rb10;
    private JRadioButton rb15;
    private JButton btnOrder;

    public FoodOrdering() {
        cPizza.setName("cPizza");
        cBurger.setName("cBurger");
        cFries.setName("cFries");
        cSoftDrinks.setName("cSoftDrinks");
        cTea.setName("cTea");
        cSundae.setName("cSundae");

        rb5.setName("rb5");
        rb10.setName("rb10");
        rb15.setName("rb15");
        rbNone.setName("rbNone");

        btnOrder.setName("btnOrder");

        ButtonGroup discountGroup = new ButtonGroup();
        discountGroup.add(rb5);
        discountGroup.add(rb10);
        discountGroup.add(rb15);
        discountGroup.add(rbNone);
        rbNone.setSelected(true);


        btnOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
    }

        private void calculateTotal() {
            double total = 0;

            if (cPizza.isSelected()) total += 100;
            if (cBurger.isSelected()) total += 80;
            if (cFries.isSelected()) total += 65;
            if (cSoftDrinks.isSelected()) total += 55;
            if (cTea.isSelected()) total += 50;
            if (cSundae.isSelected()) total += 40;

            double discount = 0;
            if (rb5.isSelected()) discount = 0.05;
            else if (rb10.isSelected()) discount = 0.10;
            else if (rb15.isSelected()) discount = 0.15;

            double discountedTotal = total - (total * discount);
            String message = String.format("The total price is Php %.2f", discountedTotal);
            JOptionPane.showMessageDialog(null, message, "Total Price", JOptionPane.INFORMATION_MESSAGE);
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setTitle("Food Ordering System");
            frame.setContentPane(new FoodOrdering().mainPanel);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        }

}

