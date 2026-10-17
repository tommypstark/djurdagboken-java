import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AnimalRegister register = new AnimalRegister();
        Scanner scanner = new Scanner(System.in);

        int choice = -1;
        while (choice != 3) {

            System.out.println("\n*** DJURDAGBOKEN 0.1 ***");
            System.out.println("\n1. Lägg till djur");
            System.out.println("2. Lista alla djur");
            System.out.println("3. Avsluta");
            System.out.print("\nDitt val: ");

            String input = scanner.nextLine();
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("\nDu måste skriva ett nummer.");
                continue;
            }

            if (choice == 1) {
                System.out.print("\nNamn: ");
                String name = scanner.nextLine();

                System.out.print("Art: ");
                String species = scanner.nextLine();

                System.out.print("Ålder: ");

                String ageInput = scanner.nextLine();
                double age;
                try {
                    age = Double.parseDouble(ageInput);

                    if (age < 0) {
                        System.out.println("\nÅlder kan inte vara negativ.");
                        continue;
                    }

                } catch (NumberFormatException e) {
                    System.out.println("\nDu måste skriva ett nummer.");
                    continue;
                }

                register.createAnimal(name, species, age);

            } else if (choice == 2) {
                register.printAll();

            } else if (choice == 3) {
                System.out.println("\nAvslutar...");

            } else {
                System.out.println("\nOgiltigt val, var god försök igen.");

            }
        }

    }
}