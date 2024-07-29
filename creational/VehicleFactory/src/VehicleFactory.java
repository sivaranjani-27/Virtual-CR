import java.util.Scanner;

public class VehicleFactory {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.println("Enter the type of vehicle to manufacture (car, truck, motorcycle): ");
    String vehicleType = scanner.nextLine();

    if (vehicleType.equalsIgnoreCase("car")) {
      manufactureVehicle("car");
    } else if (vehicleType.equalsIgnoreCase("truck")) {
      manufactureVehicle("truck");
    } else if (vehicleType.equalsIgnoreCase("motorcycle")) {
      manufactureVehicle("motorcycle");
    } else {
      System.out.println("Invalid input. Exiting.");
      return;
    }
  }

  public static void manufactureVehicle(String type) {
    if (type.equalsIgnoreCase("car")) {
      assembleCar();
      testCar();
    } else if (type.equalsIgnoreCase("truck")) {
      assembleTruck();
      testTruck();
    } else if (type.equalsIgnoreCase("motorcycle")) {
      assembleMotorcycle();
      testMotorcycle();
    }
  }

  public static void assembleCar() {
    System.out.println("1.Assembling a car");
  }

  public static void testCar() {
    System.out.println("2.Testing a car");
  }

  public static void assembleTruck() {
    System.out.println("1.Assembling a truck");
  }

  public static void testTruck() {
    System.out.println("2.Testing a truck");
  }

  public static void assembleMotorcycle() {
    System.out.println("1.Assembling a motorcycle");
  }

  public static void testMotorcycle() {
    System.out.println("2.Testing a motorcycle");
  }
}