import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TrainConsistManagementApp
 * UC13: Performance Comparison (Loops vs Streams)
 */
public class TrainConsistManagementApp {

    public static class Bogie {
        public String name;
        public int capacity;

        public Bogie(String name, int capacity) {
            this.name = name;
            this.capacity = capacity;
        }
    }

    /**
     * Filters bogies using a traditional for-loop (Imperative approach).
     */
    public static List<Bogie> filterWithLoop(List<Bogie> bogies, int threshold) {
        List<Bogie> filtered = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.capacity > threshold) {
                filtered.add(b);
            }
        }
        return filtered;
    }

    /**
     * Filters bogies using Java Streams (Declarative approach).
     */
    public static List<Bogie> filterWithStream(List<Bogie> bogies, int threshold) {
        return bogies.stream()
                .filter(b -> b.capacity > threshold)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("==========================================");
        System.out.println(" UC13 - Performance Comparison ");
        System.out.println("==========================================\n");

        // 1. Create a large dataset of bogies for benchmarking
        List<Bogie> bogies = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            bogies.add(new Bogie("Sleeper", 72));
            bogies.add(new Bogie("General", 50));
        }

        // 2. Measure Loop Performance
        long startLoop = System.nanoTime();
        List<Bogie> loopResult = filterWithLoop(bogies, 60);
        long endLoop = System.nanoTime();
        long loopDuration = endLoop - startLoop;

        // 3. Measure Stream Performance
        long startStream = System.nanoTime();
        List<Bogie> streamResult = filterWithStream(bogies, 60);
        long endStream = System.nanoTime();
        long streamDuration = endStream - startStream;

        // 4. Display Results
        System.out.println("Loop Execution Time: " + loopDuration + " ns");
        System.out.println("Stream Execution Time: " + streamDuration + " ns");
        System.out.println("Results Match: " + (loopResult.size() == streamResult.size()));

        System.out.println("\nUC13 performance check completed...");
    }
}