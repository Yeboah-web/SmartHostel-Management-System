/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smarthostelmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import smarthostelmangementsystem.Student;


public class StudentForm extends JFrame {
    

    JTextField txtId, txtName, txtPhone;
    JComboBox<String> cmbGender, cmbLevel;

    DefaultTableModel model;
    JTable table;

    ArrayList<Student> students = DataStore.students;

   
    public StudentForm() {
        
        


        setTitle("Student Management");
        setSize(1000,650);
        setLayout(null);
        
        

        JLabel lblId = new JLabel("Student ID");
        lblId.setBounds(20,20,100,25);
        add(lblId);

        txtId = new JTextField();
        txtId.setBounds(120,20,150,25);
        add(txtId);

        JLabel lblName = new JLabel("Name");
        lblName.setBounds(20,60,100,25);
        add(lblName);

        txtName = new JTextField();
        txtName.setBounds(120,60,150,25);
        add(txtName);

        JLabel lblGender = new JLabel("Gender");
        lblGender.setBounds(20,100,100,25);
        add(lblGender);

        cmbGender = new JComboBox<>(new String[]{
            "Male", "Female"
        });
        cmbGender.setBounds(120,100,150,25);
        add(cmbGender);

        JLabel lblLevel = new JLabel("Level");
        lblLevel.setBounds(20,140,100,25);
        add(lblLevel);

        cmbLevel = new JComboBox<>(new String[]{
            "100","200","300","400"
        });
        cmbLevel.setBounds(120,140,150,25);
        add(cmbLevel);

        JLabel lblPhone = new JLabel("Phone");
        lblPhone.setBounds(20,180,100,25);
        add(lblPhone);

        txtPhone = new JTextField();
        txtPhone.setBounds(120,180,150,25);
        add(txtPhone);

        JButton btnAdd = new JButton("Add");
btnAdd.setBounds(20,230,80,30);
add(btnAdd);

JButton btnDelete = new JButton("Delete");
btnDelete.setBounds(120,230,90,30);
add(btnDelete);

JButton btnUpdate = new JButton("Update");
btnUpdate.setBounds(230,230,90,30);
add(btnUpdate);

JButton btnClear = new JButton("Clear");
btnClear.setBounds(200,550,120,35);
add(btnClear);

JButton btnBack = new JButton("Back");
btnBack.setBounds(50,550,120,35);
add(btnBack);

        model = new DefaultTableModel();
        model.addColumn("Student ID");
        model.addColumn("Name");
        model.addColumn("Gender");
        model.addColumn("Level");
        model.addColumn("Phone");

        table = new JTable(model);
        table.setRowHeight(25);
        
        for(Student s : DataStore.students) {

    model.addRow(new Object[]{

        s.getStudentId(),
        s.getName(),
        s.getGender(),
        s.getLevel(),
        s.getPhone()

    });
}

        JScrollPane scrollPane =
                new JScrollPane(table);

        scrollPane.setBounds(350,20,600,500);

        add(scrollPane);

        btnAdd.addActionListener(e -> addStudent());

btnDelete.addActionListener(e -> deleteStudent());

btnUpdate.addActionListener(e -> updateStudent());

btnClear.addActionListener(e -> clearFields());

btnBack.addActionListener(e -> {
    dispose();
});

table.getSelectionModel().addListSelectionListener(e -> {

    int row = table.getSelectedRow();

    if(row >= 0) {

        txtId.setText(model.getValueAt(row,0).toString());
        txtName.setText(model.getValueAt(row,1).toString());

        cmbGender.setSelectedItem(
                model.getValueAt(row,2).toString());

        cmbLevel.setSelectedItem(
                model.getValueAt(row,3).toString());

        txtPhone.setText(
                model.getValueAt(row,4).toString());
    }

});

model.setRowCount(0);

for(Student s : students) {

    model.addRow(new Object[]{

        s.getStudentId(),
        s.getName(),
        s.getGender(),
        s.getLevel(),
        s.getPhone()

    });
}

setLocationRelativeTo(null);
setVisible(true);
    }

    private void addStudent() {

        String id = txtId.getText();
        String name = txtName.getText();
        String gender = cmbGender.getSelectedItem().toString();
        String level = cmbLevel.getSelectedItem().toString();
        String phone = txtPhone.getText();

        if(id.isEmpty() || name.isEmpty()
                || phone.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Please fill all fields!"
            );

            return;
        }

        Student student =
                new Student(id,name,
                        gender,level,phone);

        students.add(student);
        
        System.out.println("Students = " + students.size());
        
        FileManager.saveStudents();

       model.addRow(new Object[]{
        id,name,gender,level,phone
});

        JOptionPane.showMessageDialog(
                this,
                "Student Added Successfully"
        );

        clearFields();
    }

    private void clearFields() {

        txtId.setText("");
        txtName.setText("");
        txtPhone.setText("");

        cmbGender.setSelectedIndex(0);
        cmbLevel.setSelectedIndex(0);

    }

    private void deleteStudent() {

    int selectedRow = table.getSelectedRow();

    if(selectedRow == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Please select a student to delete."
        );

        return;
    }

    students.remove(selectedRow);
    
    FileManager.saveStudents();

    model.removeRow(selectedRow);

    JOptionPane.showMessageDialog(
            this,
            "Student deleted successfully."
    );
}

   private void updateStudent() {

    int selectedRow = table.getSelectedRow();

    if(selectedRow == -1) {

        JOptionPane.showMessageDialog(
                this,
                "Please select a student first."
        );

        return;
    }

    model.setValueAt(
            txtId.getText(),
            selectedRow,
            0);

    model.setValueAt(
            txtName.getText(),
            selectedRow,
            1);

    model.setValueAt(
            cmbGender.getSelectedItem(),
            selectedRow,
            2);

    model.setValueAt(
            cmbLevel.getSelectedItem(),
            selectedRow,
            3);

    model.setValueAt(
            txtPhone.getText(),
            selectedRow,
            4);

    FileManager.saveStudents();
    
    JOptionPane.showMessageDialog(
            this,
            "Student Updated Successfully"
    );
}
    }

