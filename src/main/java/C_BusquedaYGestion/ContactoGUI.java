package C_BusquedaYGestion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ContactoGUI extends JFrame {
    private final List<Contact> contacts = new ArrayList<>();
    private final DefaultListModel<String> contactsModel = new DefaultListModel<>();
    private final JList<String> contactsList = new JList<>(contactsModel);
    private final JTextField nameField = new JTextField(20);
    private final JTextField emailField = new JTextField(20);
    private final JTextField phoneField = new JTextField(20);

    public ContactoGUI() {
        setTitle("Agenda de Contactos");
        setLayout(new BorderLayout());
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel de entrada
        JPanel inputPanel = new JPanel(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Nombre:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Email:"));
        inputPanel.add(emailField);
        inputPanel.add(new JLabel("Teléfono:"));
        inputPanel.add(phoneField);

        // Botones
        JButton addButton = new JButton("Agregar Contacto");
        addButton.addActionListener(this::addContact);

        // Lista de contactos
        contactsList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(contactsList), BorderLayout.CENTER);
        add(addButton, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addContact(ActionEvent event) {
        String name = nameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();

        // Validación simple
        if (name.isEmpty() || email.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Contact contact = new Contact(name, email, phone);
        contacts.add(contact);
        contactsModel.addElement(contact.toString());

        // Limpiar campos
        nameField.setText("");
        emailField.setText("");
        phoneField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ContactoGUI::new);
    }

    static class Contact {
        String name;
        String email;
        String phone;

        Contact(String name, String email, String phone) {
            this.name = name;
            this.email = email;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return name + " - " + email + " - " + phone;
        }
    }
}
