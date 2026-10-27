import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AnimalRegister register = new AnimalRegister();
        int val = 0;

        while (val != 3) {
            System.out.println("\n\u001B[93m===  DJURDAGBOKEN  ===\u001B[0m");
            System.out.println("1. Lägg till djur\n2. Visa alla djur\n3. Avsluta");
            System.out.print("\u001B[93mDitt val: \u001B[0m");

            if (!input.hasNextInt()) {
                System.out.println("\n\u001B[91mSkriv ett heltal mellan 1 och 3.\u001B[0m");
                input.nextLine();
                continue;
            }

            val = input.nextInt();
            input.nextLine();

            switch (val) {
                case 1 -> {
                    System.out.print("\n\u001B[92mLägg till djur: \u001B[0m");
                    System.out.print("\nNamn: ");
                    String name = input.nextLine();

                    System.out.print("Art: ");
                    String species = input.nextLine();

                    System.out.print("Ålder: ");
                    String ageInput = input.nextLine().replace(',', '.');

                    double age;

                    try {
                        age = Double.parseDouble(ageInput);
                    } catch (NumberFormatException e) {
                        System.out.println("\n\u001B[91mDu måste skriva ett nummer.\u001B[0m");
                        continue;
                    }

                    if (age < 0) {
                        System.out.println("\n\u001B[91mÅlder kan inte vara negativ.\u001B[0m");
                        continue;
                    }


                    register.createAnimal(name, species, age);
                }

                case 2 -> {
                    if (register == null) {
                        System.out.println("Det finns inga sparade djur.");
                    }
                    register.printAll();
                }

                case 3 -> System.out.println("\u001B[92mProgrammet avslutas...\u001B[0m");

                default -> System.out.println("\n\u001B[91mVälj ett nummer mellan 1 och 3.\u001B[0m");
            }
        }
    }
}