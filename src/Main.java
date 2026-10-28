import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AnimalRegister register = new AnimalRegister();
        int val = 0;

        while (val != 5) {
            System.out.println("\n\u001B[35m***  DJURDAGBOKEN  ***\u001B[0m");
            System.out.println("\u001B[96m1.\u001B[0m Lägg till djur");
            System.out.println("\u001B[96m2.\u001B[0m Visa alla djur");
            System.out.println("\u001B[96m3.\u001B[0m Sök efter djur");
            System.out.println("\u001B[96m4.\u001B[0m Ta bort djur");
            System.out.println("\u001B[96m5.\u001B[0m Avsluta");
            System.out.print("\u001B[93mDitt val: \u001B[0m");

            if (!input.hasNextInt()) {
                System.out.println("\n\u001B[91mSkriv ett heltal mellan 1 och 5.\u001B[0m");
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

                case 2 -> register.printAll();

                case 3 -> {
                    System.out.print("\n\u001B[93mSkriv namnet på djuret du söker efter: \u001B[0m");
                    register.findAnimal(input.nextLine());
                }

                case 4 -> {
                    System.out.print("\n\u001B[93mSkriv namnet på djuret du vill ta bort: \u001B[0m");
                    register.removeAnimal(input.nextLine());
                }

                case 5 -> System.out.println("\u001B[92mProgrammet avslutas...\u001B[0m");

                default -> System.out.println("\n\u001B[91mVälj ett nummer mellan 1 och 5.\u001B[0m");
            }
        }
    }
}