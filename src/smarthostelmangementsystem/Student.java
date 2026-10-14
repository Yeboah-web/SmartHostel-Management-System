/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package smarthostelmangementsystem;

/**
 *
 * @author Humble😎
 */
public class Student {

    private final String studentId;
    private final String name;
    private final String gender;
    private final String level;
    private final String phone;

    public Student(String studentId, String name,
                   String gender, String level,
                   String phone) {

        this.studentId = studentId;
        this.name = name;
        this.gender = gender;
        this.level = level;
        this.phone = phone;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getLevel() {
        return level;
    }

    public String getPhone() {
        return phone;
    }

}
