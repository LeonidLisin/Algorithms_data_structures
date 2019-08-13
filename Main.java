import java.util.Random;

public class Main {
    public static void main(String[] args) {
        final int SIZE = 1000_000, ARR_NUMBER = 3;
        Random r = new Random();
        double time;
        Array<Integer>[] arr = new AdvancedArray[ARR_NUMBER];
        for (int i = 0; i < ARR_NUMBER; i++)
            arr[i] = new AdvancedArray(SIZE);

        for (int i = 0; i < SIZE; i++) {
            Integer n = r.nextInt(1000_000);
            for(Array<Integer> a: arr)
                a.add(n);
        }

        System.out.println("Линейный поиск элемента...");
        time = System.currentTimeMillis();
        arr[0].contains(arr[0].get(SIZE-1));
        System.out.println("Линейный поиск занял " + (System.currentTimeMillis() - time) + " мс\n");

        System.out.println("Сортирую пузырьковым методом...");
        time = System.currentTimeMillis();
        arr[1].sort(SortingMethod.BUBBLE);
        System.out.println("Сортировка пузырьковым методом заняла " + (System.currentTimeMillis() - time) + " мс\n");

        System.out.println("Сортирую методом вставки...");
        time = System.currentTimeMillis();
        arr[0].sort(SortingMethod.INSERT);
        System.out.println("Сортировка методом вставки заняла " + (System.currentTimeMillis() - time) + " мс\n");

        System.out.println("Сортирую методом выбора...");
        time = System.currentTimeMillis();
        arr[2].sort(SortingMethod.SELECT);
        System.out.println("Сортировка методом выбора заняла " + (System.currentTimeMillis() - time) + " мс\n");

        System.out.println("Бинарный поиск элемента...");
        time = System.currentTimeMillis();
        arr[0].contains(arr[0].get(SIZE-1));
        System.out.println("Бинарный поиск занял " + (System.currentTimeMillis() - time) + " мс\n");
    }
}
