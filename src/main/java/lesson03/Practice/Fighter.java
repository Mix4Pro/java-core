package lesson03.Practice;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class Fighter {
    private static int codeCounter = 0;
    private static final ArrayList<Fighter> fightersCollection = new ArrayList<>();
    private final int code;
    private final String name;
    private int health;
    private final int attack;

    Fighter(String name, int health, int attack) {
        ++codeCounter;
        this.code = codeCounter;
        this.name = name;
        if (health < 1) {
            throw new IllegalArgumentException("Health can't be less than 1");
        }

        if (attack < 1) {
            throw new IllegalArgumentException("Attack can't be less than 1");
        }

        this.health = health;
        this.attack = attack;
        fightersCollection.add(this);
    }

    // Getters
    public int getAttack() {
        return this.attack;
    }

    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    // Setter
    public void subFromHealth(int attack) {
        this.health -= attack;
    }

    public void getFighterInfo() {
        System.out.println("--------------------------------------");
        System.out.println("Fighter information : ");
        System.out.println("Code : " + this.code);
        System.out.println("Name : " + this.name);
        System.out.println("Health : " + this.health);
        System.out.println("Attack : " + this.attack);
    }

    public void getFighters() {
        if (!fightersCollection.isEmpty()) {
            for (Fighter fighter : fightersCollection) {
                fighter.getFighterInfo();
            }
        } else {
            System.out.println("The fighter list is empty");
        }
    }

    public void fight() {
        if (fightersCollection.size() >= 2) {

            Random random = new Random();

            int fighter_1_index = random.nextInt(0, fightersCollection.size());
            int fighter_2_index = random.nextInt(0, fightersCollection.size());

            while (fighter_1_index == fighter_2_index) {
                fighter_2_index = random.nextInt(0, fightersCollection.size());
            }

            Fighter fighter_1 = fightersCollection.get(fighter_1_index);
            Fighter fighter_2 = fightersCollection.get(fighter_2_index);

            while (fighter_1.getHealth() > 0 && fighter_2.getHealth() > 0) {

                System.out.println(fighter_1.getName() + " attacking " + fighter_2.getName());
                System.out.print(fighter_2.getName() + " health : " + fighter_2.getHealth() + " -> ");

                fighter_2.subFromHealth(fighter_1.getAttack());

                System.out.println(fighter_2.getHealth());

                if (fighter_2.getHealth() <= 0) {
                    fighter_2.setHealth(0);
                    System.out.println(fighter_1.getName() + " won");
                    break;
                }

                System.out.println(fighter_2.getName() + " attacking " + fighter_1.getName());
                System.out.print(fighter_1.getName() + " health : " + fighter_1.getHealth() + " -> ");

                fighter_1.subFromHealth(fighter_2.getAttack());

                System.out.println(fighter_1.getHealth());

                if (fighter_1.getHealth() <= 0) {
                    fighter_1.setHealth(0);
                    System.out.println(fighter_2.getName() + " won");
                    break;
                }
            }
        } else {
            System.out.println("Not enough fighters");
        }
    }
}


class FighterMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Create your fighters : ");

        System.out.print("Fighter 1 name : ");
        String name_1 = scanner.nextLine();

        System.out.print("Set health for " + name_1 + " : ");
        int health_1 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Set attack for " + name_1 + " : ");
        int attack_1 = scanner.nextInt();
        scanner.nextLine();

        System.out.println("------------------------------------------");

        System.out.print("Fighter 2 name : ");
        String name_2 = scanner.nextLine();

        System.out.print("Set health for " + name_2 + " : ");
        int health_2 = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Set attack for " + name_2 + " : ");
        int attack_2 = scanner.nextInt();
        scanner.nextLine();

        try {
            Fighter fighter_1 = new Fighter(name_1, health_1, attack_1);
            Fighter fighter_2 = new Fighter(name_2, health_2, attack_2);
            fighter_1.getFighters();
            fighter_1.fight();
        } catch (IllegalArgumentException e) {
            System.out.println("Error happened while creating fighters");
        }
    }
}