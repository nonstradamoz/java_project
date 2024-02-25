import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private String rollNumber;
    private String batch;
    private String department;
    private List<String> notes;
    private List<String> notifications;
    private List<String> events;

    public Student(String name, String rollNumber, String batch, String department) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty");
        }

        if (rollNumber == null || rollNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Roll number cannot be null or empty");
        }

        if (batch == null || batch.trim().isEmpty()) {
            throw new IllegalArgumentException("Batch cannot be null or empty");
        }

        if (department == null || department.trim().isEmpty()) {
            throw new IllegalArgumentException("Department cannot be null or empty");
        }

        this.name = name;
        this.rollNumber = rollNumber;
        this.batch = batch;
        this.department = department;
        this.notes = new ArrayList<>();
        this.notifications = new ArrayList<>();
        this.events = new ArrayList<>();
    }

    public void uploadNote(String note) {
        if (note == null || note.trim().isEmpty()) {
            throw new IllegalArgumentException("Note cannot be null or empty");
        }

        this.notes.add(note);
    }

    public List<String> viewNotes() {
        return this.notes;
    }

    public void addNotification(String notification) {
        if (notification == null || notification.trim().isEmpty()) {
            throw new IllegalArgumentException("Notification cannot be null or empty");
        }

        this.notifications.add(notification);
    }

    public List<String> viewNotifications() {
        return this.notifications;
    }

    public void addEvent(String event) {
        if (event == null || event.trim().isEmpty()) {
            throw new IllegalArgumentException("Event cannot be null or empty");
        }

        this.events.add(event);
    }

    public List<String> viewEvents() {
        return this.events;
    }

    public boolean authenticate(String username, String password) {
        Map<String, String> credentials = new HashMap<>();
        credentials.put("student1", "password1");
        credentials.put("student2", "password2");
        credentials.put("admin", "admin123");

        return credentials.computeIfPresent(username, (key, value) -> {
            if (value.equals(password)) {
                return value;
            } else {
                return null;
            }
        }) != null;
    }

    public static void main(String[] args) {
        // Create a new Student object
        Student student = new Student("John Doe", "2023001", "Batch A", "Computer Science");

        // Test authentication
        System.out.println("Authentication Test:");
        List<String> testCases = List.of(
                "Username: student1, Password: password1",
                "Username: student2, Password: password2",
                "Username: admin, Password: admin123",
                "Username: John Doe, Password: password123",
                "Username: student1, Password: password1"
        );

        testCases.forEach(testCase -> {
            String[] parts = testCase.split(", ");
            String username = parts[0].split(": ")[1];
            String password = parts[1].split(": ")[1];
            System.out.println(testCase + ": " + student.authenticate(username, password));
        });
    }
}

