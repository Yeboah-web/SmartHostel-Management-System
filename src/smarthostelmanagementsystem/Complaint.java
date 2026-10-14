package smarthostelmanagementsystem;

public class Complaint {

    private final String complaintId;
    private final String studentName;
    private final String roomNumber;
    private final String issueType;
    private final String status;

    public Complaint(String complaintId,
                     String studentName,
                     String roomNumber,
                     String issueType,
                     String status) {

        this.complaintId = complaintId;
        this.studentName = studentName;
        this.roomNumber = roomNumber;
        this.issueType = issueType;
        this.status = status;
    }

    public String getComplaintId() {
        return complaintId;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getStatus() {
        return status;
    }
}