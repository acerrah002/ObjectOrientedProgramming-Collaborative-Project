import Iterator.UserDataIterator;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI{
    //Current Avriable
    static int current = 0;

    //Firstname, Lastname, Address, Phonenumber, Email
    public static void main(String[] args) {
        //ArrayList<ArrayList<String>> result = Helper.Helper(); 
        //System.out.println(result.get(0).get(0));
        GUIHelper();

        // Added by ZM - Iterator Design Pattern
        UserDataIterator iterator =
                new UserDataIterator(ReadFile.getArrayList());

        if (iterator.hasNext()) {
            String[] user = iterator.next();
        }
    }

   

    public static void GUIHelper(){
        
        JFrame frame = new JFrame("InvoiceMaker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        
        int row = 0;


        JTextField firstNameInput = new JTextField(20);
        setupFieldLabelsText(panel, gbc, "First Name:", firstNameInput, row++);


        final JLabel currentuserposition = new JLabel("Current Position: 0");
        currentuserposition.setEnabled(false);

        // currentuser position is unique so i had to add it seperately
        gbc.gridx = 5; 
        gbc.gridy = 0;
        gbc.gridwidth = 1; 
        gbc.anchor = GridBagConstraints.EAST; 
        panel.add(currentuserposition, gbc);
        gbc.weightx = 1.0; 
        gbc.anchor = GridBagConstraints.WEST; 

        
        
        JTextField lastNameInput = new JTextField(20);
        setupFieldLabelsText(panel, gbc, "Last Name:", lastNameInput, row++);

        JTextField addressInput = new JTextField(20);
        setupFieldLabelsText(panel, gbc, "Address:", addressInput, row++);

        JTextField phoneNumberInput = new JTextField(20);
        setupFieldLabelsText(panel, gbc, "Phone Number:", phoneNumberInput, row++);

        JTextField emailInput = new JTextField(20);
        setupFieldLabelsText(panel, gbc, "Email:", emailInput, row++);

        JTextField hoursWorkedInput = new JTextField(20);
        setupFieldLabelsText(panel, gbc, "Hours Worked:", hoursWorkedInput, row++);

        JTextField ratePerHourInput = new JTextField(20);
        setupFieldLabelsText(panel, gbc, "Rate Per Hour:", ratePerHourInput, row++);


        //Special buttons that are connected to methods
        JButton submit = new JButton("Submit");
        setupFieldButtons(panel, gbc, submit,0, row);
        submit.setToolTipText("Submit the current user data to generate an invoice.");

        JButton savedData = new JButton("SavedData");
        setupFieldButtons(panel, gbc, savedData, 1, row);
        savedData.setToolTipText("View the saved user data.");

        JButton addButton = new JButton("+");
        setupFieldButtons(panel, gbc, addButton,2, row);
        addButton.setToolTipText("Add the current user data to the saved list.");

        
        
        /* Not working yet
        JButton removeButton = new JButton("-");
        setupFieldButtons(panel, gbc, removeButton,3, row);
        removeButton.setToolTipText("Remove the current user data from the saved list.");
        removeButton.setEnabled(false); //Disabled by defult because the user isn't viewing the userdata just entering
        */

        JButton previousButton = new JButton("Previous <<");
        setupFieldButtons(panel, gbc, previousButton, 4, row);
        previousButton.setToolTipText("View the previous saved user data.");
        previousButton.setEnabled(false); //Disabled by defult so the user can choose to use it
        

        JButton nextButton = new JButton("Next >>");
        setupFieldButtons(panel, gbc, nextButton, 5, row);
        nextButton.setToolTipText("View the next saved user data.");
        nextButton.setEnabled(false); //Disabled by defult so the user can choose to use it

        

        
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.setSize(1000, 350); 
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
                
        //Sumbit functionality
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

        savedData.addActionListener(new ActionListener() {
           //On and Off for the prev and next buttons
           int x = 1;
           public void actionPerformed(ActionEvent e) {
                x++;
                if (x % 2 == 1) {
                    //Main menu
                    nextButton.setEnabled(false);
                    previousButton.setEnabled(false);
                    //Not working yet
                    //removeButton.setEnabled(false);
                    firstNameInput.setText("");
                    lastNameInput.setText("");
                    addressInput.setText("");
                    phoneNumberInput.setText("");
                    emailInput.setText("");
                    hoursWorkedInput.setText("");
                    ratePerHourInput.setText("");
                    // RESET currentuserposition label
                    currentuserposition.setText("Current Position: 0");
                    currentuserposition.setEnabled(false);
                } else {
                    ArrayList<ArrayList<String>> users = ReadFile.getArrayList();
                    if (users == null || users.isEmpty()) {
                        // no saved users
                        nextButton.setEnabled(false);
                        previousButton.setEnabled(false);
                        //Not working yet
                        //removeButton.setEnabled(false);
                        firstNameInput.setText("EmptyList");
                        lastNameInput.setText("EmptyList");
                        addressInput.setText("EmptyList");
                        phoneNumberInput.setText("EmptyList");
                        emailInput.setText("EmptyList");
                        hoursWorkedInput.setText("EmptyList");
                        ratePerHourInput.setText("EmptyList");
                        // Current is back to 0 since no items
                        currentuserposition.setText("Current Position: 0");
                        currentuserposition.setEnabled(true);
                        return;
                    }
                    else{
                    //adjusting user data
                    int size = users.size();
                    current = ((current % size) + size) % size; //using modulo to make a circular array
                    ArrayList<String> user = ReadFile.getArrayList().get(current);
                    //current will be displayed

                    firstNameInput.setText(user.get(0));
                    lastNameInput.setText(user.get(1));
                    addressInput.setText(user.get(2));
                    phoneNumberInput.setText(user.get(3));
                    emailInput.setText(user.get(4));
                    hoursWorkedInput.setText(user.get(5));
                    ratePerHourInput.setText(user.get(6));
                    // current now shows the current position
                    currentuserposition.setText("Current Position: " + (current + 1) + " of " + size);
                    currentuserposition.setEnabled(true); // Enable label when viewing data
                    }
                    previousButton.setEnabled(true);
                    nextButton.setEnabled(true);
                    //Not working yet
                    //removeButton.setEnabled(true);
                }
           }
        });
        //Next functionality
        nextButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                ArrayList<ArrayList<String>> all = ReadFile.getArrayList();
                if (all == null) return;
                int size = all.size();
                current = (current + 1 + size) % size; //using modulo to make a circular array for next
                ArrayList<String> user = ReadFile.getArrayList().get(current);
                if (user != null) {
                    firstNameInput.setText(user.get(0));
                    lastNameInput.setText(user.get(1));
                    addressInput.setText(user.get(2));
                    phoneNumberInput.setText(user.get(3));
                    emailInput.setText(user.get(4));
                    hoursWorkedInput.setText(user.get(5));
                    ratePerHourInput.setText(user.get(6));

                    // current shows current position
                    currentuserposition.setText("Current Position: " + (current + 1) + " of " + size);
                }
           }
        });
        //Previous functionality
        previousButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                ArrayList<ArrayList<String>> all = ReadFile.getArrayList();
                if (all == null) return;
                int size = all.size();
                current = (current - 1 + size) % size; //using modulo to make a circular array for previous
                ArrayList<String> user = ReadFile.getArrayList().get(current);
                if (user != null) {
                    firstNameInput.setText(user.get(0));
                    lastNameInput.setText(user.get(1));
                    addressInput.setText(user.get(2));
                    phoneNumberInput.setText(user.get(3));
                    emailInput.setText(user.get(4));
                    hoursWorkedInput.setText(user.get(5));
                    ratePerHourInput.setText(user.get(6));
                     // UPDATE currentuserposition label
                    currentuserposition.setText("Current Position: " + (current + 1) + " of " + size);
                }
           }
        });


        //Add user data to data file
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (Writetofile.CheckIfFileExists()) {
                Writetofile.AppendToFile(firstNameInput.getText(), lastNameInput.getText(),addressInput.getText(), phoneNumberInput.getText(),emailInput.getText(), hoursWorkedInput.getText(),ratePerHourInput.getText());
                //Updates the current arraysize not the position
                ArrayList<ArrayList<String>> all = ReadFile.getArrayList();                           
                if (all == null) return;
                int size = all.size();
                currentuserposition.setText("Current Position: " + (current + 1) + " of " + size);
                } else {
                    Writetofile.writeToFile(firstNameInput.getText(), lastNameInput.getText(),addressInput.getText(), phoneNumberInput.getText(),emailInput.getText(), hoursWorkedInput.getText(),ratePerHourInput.getText());
                    ArrayList<ArrayList<String>> all = ReadFile.getArrayList();                      
                    if (all == null) return;
                    int size = all.size();
                    current = (current + 1 + size) % size;
                    currentuserposition.setText("Current Position: " + (current + 1) + " of " + size);
                }
            }
        });
        //not working yet
        //Remove user data from data file
        /* 
        removeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (CreateFile.CheckIfFileExists()) {
                    ArrayList<ArrayList<String>> all = ReadFile.getArrayList();
                    if (all == null) return;
                    int size = all.size();
                    //removes user data
                    ReadFile.removeFromFile(current);
                    current = (current - 1 + size) % size;
                    currentuserposition.setText("Current Position: " + (current) + " of " + size);
                } else {
                    //file does not exist pop up

                }
            }
        });*/
    }



    //This method sets the labels and text field as a grid and reduces the amount of repeated code
    public static void setupFieldLabelsText(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField, int row) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = 0; gbc.gridy = row; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 0.0;
        panel.add(label, gbc);

        gbc.gridx = 1; gbc.gridy = row; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panel.add(textField, gbc);
    }

    //This method sets the Buttons as a grid and reduces the amount of repeated code
    public static void setupFieldButtons(JPanel panel, GridBagConstraints gbc, JButton button, int gridx, int row) {
        gbc.gridx = gridx; gbc.gridy = row; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1.0;
        panel.add(button, gbc);
    }


    public static void CheckIfCorrect(String fn, String ln, String addr, String phone, String email, String hours, String rate) {
        System.out.println("First Name: " + fn);
        System.out.println("Last Name: " + ln);
        System.out.println("Address: " + addr);
        System.out.println("Phone Number: " + phone);
        System.out.println("Email: " + email);
        System.out.println("Hours Worked: " + hours);
        System.out.println("Rate Per Hour: " + rate);
        String fullName = fn + " " + ln;
        GenerateAndSaveHTML.generateAndSaveHtml(fullName, addr, phone, email, hours,rate);
    }


}
