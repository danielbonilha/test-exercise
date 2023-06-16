package test.bysix;

public class ExerciseOne {
    public static void printNumbers(int max) {
        if (max < 0) {
            throw new IllegalArgumentException();
        }
        for (int i = 1; i <= max; i++) {
            // print both multiples
            if (i % 3 == 0 && i % 5 == 0) {
                System.out.println("Visual Nuts");
            } else if (i % 3 == 0) {
                System.out.println("Visual");
            } else if (i % 5 == 0) {
                System.out.println("Nuts");
            } else {
                System.out.println(i);
            }
        }
    }
}
