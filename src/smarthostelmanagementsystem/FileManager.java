package smarthostelmanagementsystem;

import java.io.*;
import smarthostelmangementsystem.Room;
import smarthostelmangementsystem.Student;

public class FileManager {

    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch", "CallToPrintStackTrace"})
    public static void saveStudents() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(
                            new FileWriter("students.txt"));

            for(Student s : DataStore.students) {

                writer.write(
                        s.getStudentId() + "," +
                        s.getName() + "," +
                        s.getGender() + "," +
                        s.getLevel() + "," +
                        s.getPhone());

                writer.newLine();
            }

            writer.close();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
    
    
    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch", "CallToPrintStackTrace"})
    public static void saveRooms() {

    try {

        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("rooms.txt"));

        for(Room r : DataStore.rooms) {

            writer.write(
                    r.getRoomNumber() + "," +
                    r.getBlock() + "," +
                    r.getStudentId());

            writer.newLine();
        }

        writer.close();

    } catch(Exception e) {

        e.printStackTrace();

    }
}
    
    @SuppressWarnings({"ConvertToTryWithResources", "CallToPrintStackTrace", "UseSpecificCatch"})
    public static void loadRooms() {

    DataStore.rooms.clear();

    try {

        File file = new File("rooms.txt");

        if(!file.exists()) {
            return;
        }

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(file));

        String line;

        while((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            if(data.length == 3) {

                Room room =
                        new Room(
                                data[0],
                                data[1],
                                data[2]);

                DataStore.rooms.add(room);
            }
        }

        reader.close();

    } catch(Exception e) {

        e.printStackTrace();

    }
}
    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch", "CallToPrintStackTrace"})
    public static void saveComplaints() {

    try {

        BufferedWriter writer =
                new BufferedWriter(
                        new FileWriter("complaints.txt"));

        for(Complaint c : DataStore.complaints) {

            writer.write(
                    c.getComplaintId() + "," +
                    c.getStudentName() + "," +
                    c.getRoomNumber() + "," +
                    c.getIssueType() + "," +
                    c.getStatus());

            writer.newLine();
        }

        writer.close();

    } catch(Exception e) {

        e.printStackTrace();

    }
}
    @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch", "CallToPrintStackTrace"})
    public static void loadComplaints() {

    DataStore.complaints.clear();

    try {

        File file =
                new File("complaints.txt");

        if(!file.exists()) {
            return;
        }

        BufferedReader reader =
                new BufferedReader(
                        new FileReader(file));

        String line;

        while((line = reader.readLine()) != null) {

            String[] data = line.split(",");

            if(data.length == 5) {

                Complaint complaint =
                        new Complaint(
                                data[0],
                                data[1],
                                data[2],
                                data[3],
                                data[4]);

                DataStore.complaints.add(
                        complaint);
            }
        }

        reader.close();

    } catch(Exception e) {

        e.printStackTrace();

    }
}
     @SuppressWarnings({"ConvertToTryWithResources", "UseSpecificCatch", "CallToPrintStackTrace"})
    public static void loadStudents() {

        DataStore.students.clear();

        try {

            File file = new File("students.txt");

            if(!file.exists()) {
                return;
            }

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader(file));

            String line;

            while((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                if(data.length == 5) {

                    Student student =
                            new Student(
                                    data[0],
                                    data[1],
                                    data[2],
                                    data[3],
                                    data[4]);

                    DataStore.students.add(student);
                }
            }

            reader.close();

        } catch(Exception e) {

            e.printStackTrace();

        }
    }
}
