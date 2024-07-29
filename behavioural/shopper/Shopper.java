import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Shopper {
    private List<Product> products;
    private List<User> users;

    public Shopper() {
        products = new ArrayList<>();
        users = new ArrayList<>();
    }

    // Product class
    public class Product {
        private int id;
        private String name;
        private double price;
        private int quantity;

        public Product(int id, String name, double price, int quantity) {
            this.id = id;
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }

    // User class
    public class User {
        private int id;
        private String username;
        private String password;
        private ShoppingCart cart;

        public User(int id, String username, String password) {
            this.id = id;
            this.username = username;
            this.password = password;
            this.cart = new ShoppingCart();
        }

        public int getId() {
            return id;
        }

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        public ShoppingCart getCart() {
            return cart;
        }
    }

    // ShoppingCart class
    public class ShoppingCart {
        private List<Product> products;
        private double total;

        public ShoppingCart() {
            products = new ArrayList<>();
            total = 0.0;
        }

        public void addProduct(Product product) {
            products.add(product);
            total += product.getPrice() * product.getQuantity();
        }

        public void removeProduct(Product product) {
            products.remove(product);
            total -= product.getPrice() * product.getQuantity();
        }

        public List<Product> getProducts() {
            return products;
        }

        public double getTotal() {
            return total;
        }
    }

    // Shopper methods
    public void addProduct(Product product) {
        products.add(product);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public Product getProduct(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public User getUser(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void displayProducts() {
        for (Product product : products) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("Product Quantity: " + product.getQuantity());
            System.out.println();
        }
    }

    public void displayCart(User user) {
        ShoppingCart cart = user.getCart();
        System.out.println("Cart Contents:");
        for (Product product : cart.getProducts()) {
            System.out.println("Product ID: " + product.getId());
            System.out.println("Product Name: " + product.getName());
            System.out.println("Product Price: " + product.getPrice());
            System.out.println("Product Quantity: " + product.getQuantity());
            System.out.println();
        }
        System.out.println("Total: " + cart.getTotal());
    }

    public static void main(String[] args) {
        Shopper shopper = new Shopper();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Product");
            System.out.println("2. Add User");
            System.out.println("3. Display Products");
            System.out.println("4. Display Cart");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter product ID: ");
                    int productId = scanner.nextInt();
                    System.out.print("Enter product name: ");
                    String productName = scanner.next();
                    System.out.print("Enter product price: ");
                    double productPrice = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int productQuantity = scanner.nextInt();
                    Product product = shopper.new Product(productId, productName, productPrice, productQuantity);
                    shopper.addProduct(product);
                    break;
                case 2:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter username: ");
                    String username = scanner.next();
                    System.out.print("Enter password:");
                     String password = scanner.next();
                    User user = shopper.new User(userId, username, password);
                    shopper.addUser(user);
                    break;
                case 3:
                    shopper.displayProducts();
                    break;
                case 4:
                    System.out.print("Enter username: ");
                    String username2 = scanner.next();
                    System.out.print("Enter password: ");
                    String password2 = scanner.next();
                    User user2 = shopper.getUser(username2, password2);
                    if (user2 != null) {
                        shopper.displayCart(user2);
                    } else {
                        System.out.println("Invalid username or password");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}