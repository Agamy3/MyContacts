/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package phonee;

/**
 *
 * @author Acer
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class MobileContactsGUI extends JFrame {

    private mycontacts phoneBook;
    private JTextField nameField, phoneNumberField;
    private JTextArea outputArea;

    public MobileContactsGUI() {
        phoneBook = new mycontacts();

 setTitle("MY Contacts App - Developed By @Mohamed Agamy");     
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        createComponents();
        setVisible(true);
    }

    private void createComponents() {
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(4, 2, 10, 10));
        inputPanel.setBackground(new Color(238, 238, 238));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        JLabel phoneNumberLabel = new JLabel("Phone Number:");
        phoneNumberField = new JTextField();
        JButton addButton = new JButton("Add Contact");
        JButton searchButton = new JButton("Search Contact");
        JButton deleteButton = new JButton("Delete Contact");
        JButton displayButton = new JButton("Display All Contacts");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(phoneNumberLabel);
        inputPanel.add(phoneNumberField);
        inputPanel.add(addButton);
        inputPanel.add(searchButton);
        inputPanel.add(deleteButton);
        inputPanel.add(displayButton);

        outputArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBorder(null);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String phoneNumber = phoneNumberField.getText();
                phoneBook.insert(new contact(name, phoneNumber));
                outputArea.append("Contact added: " + name + ", " + phoneNumber + "\n");
                nameField.setText("");
                phoneNumberField.setText("");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchName = nameField.getText();
                contact contact = phoneBook.search(searchName);
                if (contact != null) {
                    outputArea.append("Contact found - Name: " + contact.name + ", Phone: " + contact.number + "\n");
                } else {
                    outputArea.append("Contact not found.\n");
                }
                nameField.setText("");
                phoneNumberField.setText("");
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String deleteName = nameField.getText();
                phoneBook.delete(deleteName);
                outputArea.append("Contact deleted: " + deleteName + "\n");
                nameField.setText("");
                phoneNumberField.setText("");
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<contact> contacts = new ArrayList<>();
                collectContacts(phoneBook.root, contacts);

                if (!contacts.isEmpty()) {
                    StringBuilder allContacts = new StringBuilder("<html><body><h2>All Contacts:</h2>");
                    for (contact c : contacts) {
                        allContacts.append("<b>Name:</b> ").append(c.name).append(", <b>Phone:</b> ").append(c.number).append("<br>");
                    }
                    allContacts.append("</body></html>");
                    JLabel label = new JLabel(allContacts.toString());
                    label.setFont(new Font("Arial", Font.PLAIN, 14));
                    JOptionPane.showMessageDialog(MobileContactsGUI.this, label, "All Contacts", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(MobileContactsGUI.this, "No contacts found.", "All Contacts", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Apply styling
        addButton.setBackground(new Color(52, 152, 219)); // Blue
        addButton.setForeground(Color.WHITE);
        searchButton.setBackground(new Color(243, 156, 18)); // Orange
        searchButton.setForeground(Color.WHITE);
        deleteButton.setBackground(new Color(231, 76, 60)); // Red
        deleteButton.setForeground(Color.WHITE);
        displayButton.setBackground(new Color(46, 204, 113)); // Green
        displayButton.setForeground(Color.WHITE);

        nameLabel.setForeground(new Color(52, 73, 94)); // Dark Gray
        phoneNumberLabel.setForeground(new Color(52, 73, 94)); // Dark Gray

        outputArea.setBackground(new Color(248, 248, 248)); // Light Gray
        outputArea.setEditable(false);

        inputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }

    private void collectContacts(Node root, ArrayList<contact> contacts) {
        if (root != null) {
            collectContacts(root.left, contacts);
            contacts.add(root.contact);
            collectContacts(root.right, contacts);
        }
    }
}


