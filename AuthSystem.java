import java.io.*;

public class AuthSystem {
    private final String filename;

    public AuthSystem(String filename) {
        this.filename = filename;
        File file = new File(filename);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error initializing user file: " + e.getMessage());
        }
    }

    public void register(String username, String password) {
        if (userExists(username)) {
            System.out.println("⚠️ Username already exists. Try another.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.write(username + "," + password);
            writer.newLine();
            System.out.println("✅ Registered successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    public void login(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    System.out.println("✅ Login successful. Welcome " + username + "!");
                    return;
                }
            }
            System.out.println("❌ Invalid username or password.");
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }

    private boolean userExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error checking username: " + e.getMessage());
        }
        return false;
    }
}
