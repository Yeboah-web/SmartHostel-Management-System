package smarthostelmanagementsystem;

import javax.swing.*;

public class Dashboard extends JFrame {

    @SuppressWarnings("ResultOfObjectAllocationIgnored")
    public Dashboard() {

        setTitle("Dashboard");
        setSize(700,500);
        setLayout(null);
        
        getContentPane().setBackground(
        new java.awt.Color(230,240,255));
        
        

        JLabel lblTitle = new JLabel("SMART HOSTEL MANAGEMENT SYSTEM");
        lblTitle.setBounds(120,10,300,30);
        add(lblTitle);
        
        JLabel lblCount =
        new JLabel(
                "Students Registered: "
                + DataStore.students.size());

lblCount.setBounds(
        120,
        40,
        250,
        30);

add(lblCount);

lblCount.setBounds(
        120,
        40,
        250,
        30);

add(lblCount);

        lblTitle.setFont(
    new java.awt.Font(
        "Arial",
        java.awt.Font.BOLD,
        20));
        
        JButton btnStudent =
                new JButton("Student Management");
        
        
      btnStudent.setFont(
    new java.awt.Font(
        "Arial",
        java.awt.Font.BOLD,
        14));

        btnStudent.setBounds(220,100,250,40);

        JButton btnRoom =
                new JButton("Room Allocation");
        
        
        btnRoom.setFont(
    new java.awt.Font(
        "Arial",
        java.awt.Font.BOLD,
        14));

        btnRoom.setBounds(220,160,250,40);

        JButton btnComplaint =
                new JButton("Complaint Management");
        
        btnComplaint.setFont(
    new java.awt.Font(
        "Arial",
        java.awt.Font.BOLD,
        14));

        btnComplaint.setBounds(220,220,250,40);

        JButton btnReport =
                new JButton("Reports");
        
        btnReport.setFont(
    new java.awt.Font(
        "Arial",
        java.awt.Font.BOLD,
        14));

        btnReport.setBounds(220,280,250,40);

        JButton btnLogout =
                new JButton("Logout");
        
        btnLogout.setFont(
    new java.awt.Font(
        "Arial",
        java.awt.Font.BOLD,
        14));

       btnLogout.setBounds(220,340,250,40);

        add(btnStudent);
        add(btnRoom);
        add(btnComplaint);
        add(btnReport);
        add(btnLogout);

        btnStudent.addActionListener(e -> {
    new StudentForm();
        });
    
        btnRoom.addActionListener(e -> {
    new RoomAllocationForm();
    
        });
    
    btnComplaint.addActionListener(e -> {
    new ComplaintForm();

    
});
        btnLogout.addActionListener(e -> {

            dispose();
            new LoginForm();
         });
       
        btnReport.addActionListener(e -> {
    new ReportForm();
});
        setLocationRelativeTo(null);
        setVisible(true);
        }
}