/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smarthostelmangementsystem;

/**
 *
 * @author Humble😎
 */
public class Room {
    private final String roomNumber;
    private final String block;
    private final String studentId;

    public Room(String roomNumber,
                String block,
                String studentId) {

        this.roomNumber = roomNumber;
        this.block = block;
        this.studentId = studentId;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getBlock() {
        return block;
    }

    public String getStudentId() {
        return studentId;
    }
}

