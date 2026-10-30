import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        AnimalRegister register = new AnimalRegister();
        int val = 0;

        while (val != 4) {
            System.out.println("\n\u001B[35m***  DJURDAGBOKEN 0.8 ***\u001B[0m");
            System.out.println("\u001B[96m1.\u001B[0m Lägg till djur");
            System.out.println("\u001B[96m2.\u001B[0m Visa alla djur");
            System.out.println("\u001B[96m3.\u001B[0m Sök efter djur");
            System.out.println("\u001B[96m4.\u001B[0m Avsluta");
            System.out.print("\u001B[93mDitt val: \u001B[0m");

            if (!input.hasNextInt()) {
                System.out.println("\n\u001B[91mSkriv ett heltal mellan 1 och 4.\u001B[0m");
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

                    System.out.print("Födelsedatum (ÅÅÅÅ-MM-DD): ");

                    try {
                        LocalDate birthDate = LocalDate.parse(input.nextLine());

                        if (birthDate.isAfter(LocalDate.now())) {
                            System.out.println("\n\u001B[91mDatumet kan inte vara i framtiden.\u001B[0m");
                            continue;
                        }

                        System.out.print("Vikt i gram: ");

                        if (!input.hasNextInt()) {
                            System.out.println("\n\u001B[91mVikten måste vara ett heltal.\u001B[0m");
                            input.nextLine();
                            continue;
                        }

                        int weight = input.nextInt();
                        input.nextLine();

                        if (weight <= 0) {
                            System.out.println("\n\u001B[91mVikten måste vara större än 0.\u001B[0m");
                            continue;
                        }

                        register.createAnimal(name, species, birthDate, weight);

                    } catch (DateTimeParseException e) {
                        System.out.println("\n\u001B[91mOgiltigt datum. Använd ÅÅÅÅ-MM-DD.\u001B[0m");
                    }

                }

                case 2 -> register.printAll();

                case 3 -> {
                    System.out.print("\n\u001B[93mVilket djur vill du visa? \u001B[0m");
                    String name = input.nextLine();
                    Animal animal = register.getAnimal(name);

                    if (animal == null) {
                        System.out.println("\n\u001B[91mInget djur hittades.\u001B[0m");
                        continue;
                    }

                    System.out.print("\n\u001B[92mDjurprofil:\u001B[0m");
                    animal.printInfo();

                    System.out.println("\n\u001B[96m1.\u001B[0m Registrera vikt");
                    System.out.println("\u001B[96m2.\u001B[0m Visa vikthistorik");
                    System.out.println("\u001B[96m3.\u001B[0m Redigera djur");
                    System.out.println("\u001B[96m4.\u001B[0m Ta bort djur");
                    System.out.println("\u001B[96m5.\u001B[0m Tillbaka");
                    System.out.print("\u001B[93mDitt val: \u001B[0m");


                    if (!input.hasNextInt()) {
                        System.out.println("\n\u001B[91mVälj ett heltal mellan 1 och 5.\u001B[0m");
                        input.nextLine();
                        continue;
                    }

                    int profileChoice = input.nextInt();
                    input.nextLine();

                    switch (profileChoice) {

                        case 1 -> {
                            System.out.print("\n\u001B[93mAnge djurets vikt i gram: \u001B[0m");

                            if (!input.hasNextInt()) {
                                System.out.println("\n\u001B[91mVikten måste vara ett heltal.\u001B[0m");
                                input.nextLine();
                                continue;
                            }

                            int weight = input.nextInt();
                            input.nextLine();

                            if (weight <= 0) {
                                System.out.println("\n\u001B[91mVikten måste vara större än 0.\u001B[0m");
                                continue;
                            }

                            WeightEntry entry = new WeightEntry(LocalDate.now(), weight);
                            animal.addWeightEntry(entry);

                            System.out.println("\n\u001B[92mVikten har registrerats!\u001B[0m");
                        }

                        case 2 -> {
                            if (animal.getWeightHistory().isEmpty()) {
                                System.out.println("\n\u001B[91mInga vägningar registrerade.\u001B[0m");
                            } else {
                                System.out.println("\n\u001B[92mVikthistorik för " + animal.getName() + ":\u001B[0m");

                                for (WeightEntry entry : animal.getWeightHistory()) {
                                    System.out.println(entry.getDate() + ": " + entry.getWeight() + " g");
                                }
                            }
                        }

                        case 3 -> {
                            System.out.println("\n\u001B[96m1.\u001B[0m Ändra namn");
                            System.out.println("\u001B[96m2.\u001B[0m Ändra art");
                            System.out.println("\u001B[96m3.\u001B[0m Ändra födelsedatum");
                            System.out.println("\u001B[96m4.\u001B[0m Avbryt");
                            System.out.print("\u001B[93mDitt val: \u001B[0m");

                            if (!input.hasNextInt()) {
                                System.out.println("\n\u001B[91mSkriv ett heltal mellan 1 och 4.\u001B[0m");
                                input.nextLine();
                                continue;
                            }

                            int editChoice = input.nextInt();
                            input.nextLine();

                            switch (editChoice) {

                                case 1 -> {
                                    System.out.print("\nSkriv det nya namnet på djuret: ");
                                    animal.setName(input.nextLine());
                                    System.out.println("\n\u001B[92mDjurets namn har ändrats!\u001B[0m");
                                }

                                case 2 -> {
                                    System.out.print("\nSkriv den nya arten: ");
                                    animal.setSpecies(input.nextLine());
                                    System.out.println("\n\u001B[92mDjurets art har ändrats!\u001B[0m");
                                }

                                case 3 -> {
                                    System.out.print("\nNytt födelsedatum (ÅÅÅÅ-MM-DD): ");

                                    try {
                                        LocalDate birthDate = LocalDate.parse(input.nextLine());

                                        if (birthDate.isAfter(LocalDate.now())) {
                                            System.out.println("\n\u001B[91mDatumet kan inte vara i framtiden.\u001B[0m");
                                        } else {
                                            animal.setBirthDate(birthDate);
                                            System.out.println("\n\u001B[92mFödelsedatumet har ändrats!\u001B[0m");
                                        }

                                    } catch (DateTimeParseException e) {
                                        System.out.println("\n\u001B[91mOgiltigt datum. Använd ÅÅÅÅ-MM-DD.\u001B[0m");
                                    }
                                }

                                case 4 -> System.out.println("\nRedigering avbruten.");
                                default -> System.out.println("\n\u001B[91mVälj ett nummer mellan 1 och 4.\u001B[0m");
                            }
                        }
                        case 4 -> register.removeAnimal(animal.getName());

                        case 5 -> System.out.println("\nTillbaka till huvudmenyn.");
                        default -> System.out.println("\n\u001B[91mVälj ett nummer mellan 1 och 5.\u001B[0m");
                    }

                }

                case 4 -> System.out.println("\u001B[92mProgrammet avslutas...\u001B[0m");

                default -> System.out.println("\n\u001B[91mVälj ett nummer mellan 1 och 4.\u001B[0m");
            }
        }
    }
}
