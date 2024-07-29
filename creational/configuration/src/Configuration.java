import java.util.Scanner;

public class Configuration {
    private static Configuration instance;
    private String databaseUrl;
    private String username;
    private String password;

    private Configuration() {
        databaseUrl = "";
        username = "";
        password = "";
    }

    public static Configuration getInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
        return instance;
    }

    public String getDatabaseUrl() {
        return databaseUrl;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setDatabaseUrl(String url) {
        databaseUrl = url;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static void main(String[] args) {
        Configuration config = Configuration.getInstance();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter database URL:");
        config.setDatabaseUrl(scanner.nextLine());

        System.out.println("Enter username:");
        config.setUsername(scanner.nextLine());

        System.out.println("Enter password:");
        config.setPassword(scanner.nextLine());

        System.out.println("\nInitial configuration:");
        System.out.println("Database URL: " + config.getDatabaseUrl());
        System.out.println("Username: " + config.getUsername());
        System.out.println("Password: " + config.getPassword());

        System.out.println("\nDo you want to update the configuration? (yes/no)");
        String response = scanner.nextLine();
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Enter new database URL:");
            config.setDatabaseUrl(scanner.nextLine());

            System.out.println("Enter new username:");
            config.setUsername(scanner.nextLine());

            System.out.println("Enter new password:");
            config.setPassword(scanner.nextLine());
        }

        System.out.println("\nUpdated configuration:");
        System.out.println("Database URL: " + config.getDatabaseUrl());
        System.out.println("Username: " + config.getUsername());
        System.out.println("Password: " + config.getPassword());
    }
}