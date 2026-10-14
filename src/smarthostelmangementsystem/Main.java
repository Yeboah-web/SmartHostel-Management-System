/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smarthostelmangementsystem;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import smarthostelmanagementsystem.FileManager;
import smarthostelmanagementsystem.LoginForm;

/**
 *
 * @author Humble😎
 */
public class Main {

    @SuppressWarnings({"CallToPrintStackTrace", "ResultOfObjectAllocationIgnored"})
    public static void main(String[] args) {

        try {

            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName()
            );

        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {

            e.printStackTrace();

        }
        FileManager.loadStudents();
        FileManager.loadRooms();
        FileManager.loadComplaints();
        new LoginForm();

    }
}
