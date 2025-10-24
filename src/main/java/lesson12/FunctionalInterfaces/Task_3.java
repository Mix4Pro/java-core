package lesson12.FunctionalInterfaces;

import java.util.UUID;
import java.util.function.Supplier;

// Show random UUID
public class Task_3 {
    public static void main(String[] args) {
        Supplier<UUID> generateUUID = () -> UUID.randomUUID();

        System.out.println(generateUUID.get());
    }
}
