package smarthostelmanagementsystem;

import javax.swing.*;

public class ReportForm extends JFrame {

    public ReportForm() {

        setTitle("System Reports");
        setSize(500,350);
        setLayout(null);

        JLabel lblTitle =
                new JLabel("SYSTEM REPORTS");

        lblTitle.setBounds(
                180,20,200,30);

        add(lblTitle);

        JLabel lblStudents =
                new JLabel(
                        "Total Students: "
                                + DataStore.students.size());

        lblStudents.setBounds(
                50,80,300,30);

        add(lblStudents);

        JLabel lblRooms =
                new JLabel(
                        "Total Room Allocations: "
                                + DataStore.rooms.size());

        lblRooms.setBounds(
                50,130,300,30);

        add(lblRooms);

        JLabel lblComplaints =
                new JLabel(
                        "Total Complaints: "
                                + DataStore.complaints.size());

        lblComplaints.setBounds(
                50,180,300,30);

        add(lblComplaints);

        JButton btnClose =
                new JButton("Close");

        btnClose.setBounds(
                180,240,100,30);
        
        

        add(btnClose);

        btnClose.addActionListener(
                e -> dispose());
        
        JButton btnBack = new JButton("Back");
btnBack.setBounds(20,400,100,30);
add(btnBack);

btnBack.addActionListener(e -> {
    dispose();
});

        setLocationRelativeTo(null);
        setVisible(true);
    }
}