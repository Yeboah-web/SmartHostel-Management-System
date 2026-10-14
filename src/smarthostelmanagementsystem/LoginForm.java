/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package smarthostelmanagementsystem;

import javax.swing.*;
import java.awt.event.*;
import smarthostelmangementsystem.Dashboard;

public class LoginForm extends JFrame {

    JTextField txtUser;
    JPasswordField txtPass;

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public LoginForm() {

        setTitle("Smart Hostel Management System");
        setSize(400,250);
        setLayout(null);

        JLabel lblUser = new JLabel("Username");
        lblUser.setBounds(50,50,100,25);
        add(lblUser);

        txtUser = new JTextField();
        txtUser.setBounds(150,50,150,25);
        add(txtUser);

        JLabel lblPass = new JLabel("Password");
        lblPass.setBounds(50,90,100,25);
        add(lblPass);

        txtPass = new JPasswordField();
        txtPass.setBounds(150,90,150,25);
        add(txtPass);

        JButton btnLogin = new JButton("Login");
        btnLogin.setBounds(80,150,100,30);
        add(btnLogin);

        JButton btnExit = new JButton("Exit");
        btnExit.setBounds(200,150,100,30);
        add(btnExit);

        btnLogin.addActionListener((ActionEvent e) -> {
            String user = txtUser.getText();
            String pass = String.valueOf(txtPass.getPassword());
            
            if(user.equals("admin") && pass.equals("1234")) {
                
                JOptionPane.showMessageDialog(null,
                        "Login Successful");
                
                dispose();
                new Dashboard();
                
            } else {
                
                JOptionPane.showMessageDialog(null,
                        "Invalid Username or Password");
                
            }
        });

        btnExit.addActionListener((ActionEvent e) -> {
            int choice = JOptionPane.showConfirmDialog(
                    null,
                    "Exit Application?",
                    "Confirm Exit",
                    JOptionPane.YES_NO_OPTION);
            
            if(choice == JOptionPane.YES_OPTION) {
                
                System.exit(0);
                
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
}


    

