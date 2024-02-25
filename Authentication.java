import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Authentication {
    private static final Map<String, String> CREDENTIALS = new HashMap();

    static {
        CREDENTIALS.put("student1", "password1");
        CREDENTIALS.put("student2", "2");
        CREDENTIALS.put("admin", "admin123");
    }

    public boolean authenticate(String username, String password) {
        return CREDENTIALS.computeIfPresent(username, (key, value) -> {
            if (value.equals(password)) {
                return value;
            } else {
                return null;
            }
        }) != null;
    }

    public static void main(String[] args) {
        Authentication auth = new Authentication();

        // Test authentication
        System.out.println("Authentication Test:");
        List<String> testCases = List.of(
                "Username: student1, Password: password1",
                "Username: student2, Password: password2",
                "Username: admin, Password: admin123",
                "Username: John Doe, Password: password123",
                "Username: student1, Password: password1"
        );

        testCases.forEach(testCase -> System.out.println(testCase + ": " + auth.authenticate("student1", "password1")));
    }
}