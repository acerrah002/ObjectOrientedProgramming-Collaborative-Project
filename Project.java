import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Project {
    public static void main(String[] args) {
        GUI();
    }

   

    public static void GUI(){
        
        JFrame frame = new JFrame("InvoiceMaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        
        
        JLabel firstNameLabel = new JLabel("First Name:");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        panel.add(firstNameLabel, gbc);

        
        JTextField firstNameInput = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(firstNameInput, gbc);
        
        
        JLabel lastNameLabel = new JLabel("Last Name:");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        panel.add(lastNameLabel, gbc);

        
        JTextField lastNameInput = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(lastNameInput, gbc);

        JLabel AddressLabel = new JLabel("Address:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        panel.add(AddressLabel, gbc);

        
        JTextField addressInput = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(addressInput, gbc);
        

        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        panel.add(phoneNumberLabel, gbc);
        
        JTextField phoneNumberInput = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(phoneNumberInput, gbc);

        JLabel emailLabel = new JLabel("Email:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        panel.add(emailLabel, gbc);

        
        JTextField emailInput = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(emailInput, gbc);

        JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        panel.add(hoursWorkedLabel, gbc);

        
        JTextField hoursWorkedInput = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(hoursWorkedInput, gbc);

        JLabel ratePerHourLabel = new JLabel("Rate Per Hour:");
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.weightx = 0;
        panel.add(ratePerHourLabel, gbc);

        
        JTextField ratePerHourInput = new JTextField(15);
        gbc.gridx = 1;
        gbc.gridy = 6;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        panel.add(ratePerHourInput, gbc);

        JButton submit = new JButton("Submit");
        gbc.gridx = 0;
        gbc.gridy = 7;
       gbc.gridwidth = 2;
       gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(submit, gbc);

        submit.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                String fn = firstNameInput.getText();
                String ln = lastNameInput.getText();
                String addr = addressInput.getText();
                String phone = phoneNumberInput.getText();
                String email = emailInput.getText();
                String hours = hoursWorkedInput.getText();                
                String rate = ratePerHourInput.getText();
                CheckIfCorrect(fn, ln, addr, phone, email, hours, rate);
           }
        });
        
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    } 
    public static void CheckIfCorrect(String fn, String ln, String addr, String phone, String email, String hours, String rate) {
        System.out.println("First Name: " + fn);
        System.out.println("Last Name: " + ln);
        System.out.println("Address: " + addr);
        System.out.println("Phone Number: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Hours Worked: " + hours);
        System.out.println("Rate Per Hour: " + rate);
    }
}
