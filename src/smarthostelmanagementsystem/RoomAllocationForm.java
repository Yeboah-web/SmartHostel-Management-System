package smarthostelmanagementsystem;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import smarthostelmangementsystem.Room;

public class RoomAllocationForm extends JFrame {

    JTextField txtRoomNo;
    JTextField txtStudentId;
    JComboBox<String> cmbBlock;

    JTable table;
    DefaultTableModel model;

    ArrayList<Room> rooms = DataStore.rooms;

    public RoomAllocationForm() {

        setTitle("Room Allocation");
        setSize(1000,650);
        setLayout(null);

        JLabel lblRoom = new JLabel("Room Number");
        lblRoom.setBounds(20,20,100,25);
        add(lblRoom);

        txtRoomNo = new JTextField();
        txtRoomNo.setBounds(130,20,150,25);
        add(txtRoomNo);

        JLabel lblBlock = new JLabel("Block");
        lblBlock.setBounds(20,60,100,25);
        add(lblBlock);

        cmbBlock = new JComboBox<>(
                new String[]{"A","B","C","D"}
        );

        cmbBlock.setBounds(130,60,150,25);
        add(cmbBlock);

        JLabel lblStudent = new JLabel("Student ID");
        lblStudent.setBounds(20,100,100,25);
        add(lblStudent);

        txtStudentId = new JTextField();
        txtStudentId.setBounds(130,100,150,25);
        add(txtStudentId);

        JButton btnAssign =
                new JButton("Assign Room");

        btnAssign.setBounds(20,160,130,30);
        add(btnAssign);

        JButton btnRemove =
                new JButton("Remove");
        
        btnRemove.setBounds(170,160,100,30);
        add(btnRemove);
        
        JButton btnBack =
                new JButton("Back");
        
        btnBack.setBounds(20,400,100,30);
        add(btnBack);
        
        btnBack.addActionListener(e -> {
    dispose();
});

        model = new DefaultTableModel();

        model.addColumn("Room Number");
        model.addColumn("Block");
        model.addColumn("Student ID");

        table = new JTable(model);
        table.setRowHeight(25);
       for(Room r : DataStore.rooms) {

    model.addRow(new Object[]{

        r.getRoomNumber(),
        r.getBlock(),
        r.getStudentId()

    });
}

        JScrollPane pane =
                new JScrollPane(table);

        pane.setBounds(350,20,600,500);

        add(pane);

        btnAssign.addActionListener(
                e -> assignRoom());

        btnRemove.addActionListener(
                e -> removeRoom());
        
        
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void assignRoom() {

        String room =
                txtRoomNo.getText();

        String block =
                cmbBlock.getSelectedItem()
                        .toString();

        String student =
                txtStudentId.getText();

        if(room.isEmpty()
                || student.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Fill all fields"
            );

            return;
        }

        Room r =
                new Room(room,
                        block,
                        student);

        rooms.add(r);
        FileManager.saveRooms();

        model.addRow(new Object[]{
                room,
                block,
                student
        });

        txtRoomNo.setText("");
        txtStudentId.setText("");

        JOptionPane.showMessageDialog(
                this,
                "Room Assigned Successfully"
        );
    }

    private void removeRoom() {

        int row =
                table.getSelectedRow();

        if(row == -1) {

            JOptionPane.showMessageDialog(
                    this,
                    "Select a room first"
            );

            return;
        }

        rooms.remove(row);
        FileManager.saveRooms();
        model.removeRow(row);

        JOptionPane.showMessageDialog(
                this,
                "Allocation Removed"
        );
    }
}