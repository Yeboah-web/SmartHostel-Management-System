package smarthostelmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ComplaintForm extends JFrame {

    JTextField txtComplaintId;
    JTextField txtStudentName;
    JTextField txtRoomNumber;

    JComboBox<String> cmbIssueType;
    JComboBox<String> cmbStatus;

    JTable table;
    DefaultTableModel model;

   ArrayList<Complaint> complaints =
        DataStore.complaints;

    public ComplaintForm() {

        setTitle("Complaint Management");
        setSize(1100,700);
        setLayout(null);

        JLabel lblId =
                new JLabel("Complaint ID");

        lblId.setBounds(20,20,100,25);
        add(lblId);

        txtComplaintId =
                new JTextField();

        txtComplaintId.setBounds(
                140,20,150,25);

        add(txtComplaintId);

        JLabel lblStudent =
                new JLabel("Student Name");

        lblStudent.setBounds(
                20,60,100,25);

        add(lblStudent);

        txtStudentName =
                new JTextField();

        txtStudentName.setBounds(
                140,60,150,25);

        add(txtStudentName);

        JLabel lblRoom =
                new JLabel("Room Number");

        lblRoom.setBounds(
                20,100,100,25);

        add(lblRoom);

        txtRoomNumber =
                new JTextField();

        txtRoomNumber.setBounds(
                140,100,150,25);

        add(txtRoomNumber);

        JLabel lblIssue =
                new JLabel("Issue Type");

        lblIssue.setBounds(
                20,140,100,25);

        add(lblIssue);

        cmbIssueType =
                new JComboBox<>(
                        new String[]{
                                "Water Problem",
                                "Electricity Problem",
                                "Internet Problem",
                                "Furniture Damage"
                        });

        cmbIssueType.setBounds(
                140,140,150,25);

        add(cmbIssueType);

        JLabel lblStatus =
                new JLabel("Status");

        lblStatus.setBounds(
                20,180,100,25);

        add(lblStatus);

        cmbStatus =
                new JComboBox<>(
                        new String[]{
                                "Pending",
                                "In Progress",
                                "Resolved"
                        });

        cmbStatus.setBounds(
                140,180,150,25);

        add(cmbStatus);

        JButton btnSubmit =
                new JButton("Submit");

        btnSubmit.setBounds(
                20,240,100,30);

        add(btnSubmit);

        JButton btnDelete =
                new JButton("Delete");

        btnDelete.setBounds(
                140,240,100,30);

        add(btnDelete);

        JButton btnUpdate =
                new JButton("Update");

        btnUpdate.setBounds(
                260,240,100,30);
        
        JButton btnBack = new JButton("Back");
btnBack.setBounds(20,400,100,30);
add(btnBack);

btnBack.addActionListener(e -> {
    dispose();
});

        add(btnUpdate);

        model =
                new DefaultTableModel();

        model.addColumn("Complaint ID");
        model.addColumn("Student");
        model.addColumn("Room");
        model.addColumn("Issue");
        model.addColumn("Status");

        table =
                new JTable(model);
        table.setRowHeight(25);
        for(Complaint c : DataStore.complaints) {

    model.addRow(new Object[]{

        c.getComplaintId(),
        c.getStudentName(),
        c.getRoomNumber(),
        c.getIssueType(),
        c.getStatus()

    });
}

        JScrollPane pane =
                new JScrollPane(table);

        pane.setBounds(400,20,650,550);

        add(pane);

        btnSubmit.addActionListener(
                e -> addComplaint());

        btnDelete.addActionListener(
                e -> deleteComplaint());

        btnUpdate.addActionListener(
                e -> updateComplaint());

        table.getSelectionModel()
                .addListSelectionListener(
                        e -> loadSelectedRow());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addComplaint() {

        String id =
                txtComplaintId.getText();

        String student =
                txtStudentName.getText();

        String room =
                txtRoomNumber.getText();

        String issue =
                cmbIssueType.getSelectedItem()
                        .toString();

        String status =
                cmbStatus.getSelectedItem()
                        .toString();

        if(id.isEmpty()
                || student.isEmpty()
                || room.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Fill all fields");

            return;
        }

        Complaint complaint =
                new Complaint(
                        id,
                        student,
                        room,
                        issue,
                        status);

        complaints.add(complaint);
        FileManager.saveComplaints();

        model.addRow(new Object[]{
                id,
                student,
                room,
                issue,
                status
        });

        JOptionPane.showMessageDialog(
                this,
                "Complaint Submitted");

        clearFields();
    }

    private void deleteComplaint() {

        int row =
                table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a complaint");

            return;
        }

        complaints.remove(row);
        FileManager.saveComplaints();
        model.removeRow(row);

        JOptionPane.showMessageDialog(
                this,
                "Complaint Deleted");
    }

    private void updateComplaint() {

        int row =
                table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a complaint");
            FileManager.saveComplaints();

            return;
        }

        model.setValueAt(
                txtComplaintId.getText(),
                row,
                0);

        model.setValueAt(
                txtStudentName.getText(),
                row,
                1);

        model.setValueAt(
                txtRoomNumber.getText(),
                row,
                2);

        model.setValueAt(
                cmbIssueType.getSelectedItem(),
                row,
                3);

        model.setValueAt(
                cmbStatus.getSelectedItem(),
                row,
                4);

        JOptionPane.showMessageDialog(
                this,
                "Complaint Updated");
    }

    private void loadSelectedRow() {

        int row =
                table.getSelectedRow();

        if(row >= 0) {

            txtComplaintId.setText(
                    model.getValueAt(row,0)
                            .toString());

            txtStudentName.setText(
                    model.getValueAt(row,1)
                            .toString());

            txtRoomNumber.setText(
                    model.getValueAt(row,2)
                            .toString());

            cmbIssueType.setSelectedItem(
                    model.getValueAt(row,3)
                            .toString());

            cmbStatus.setSelectedItem(
                    model.getValueAt(row,4)
                            .toString());
        }
    }

    private void clearFields() {

        txtComplaintId.setText("");
        txtStudentName.setText("");
        txtRoomNumber.setText("");
    }
}