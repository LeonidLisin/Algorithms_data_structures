public class PowMake {
    public static void main(String[] args) {
        System.out.println(pow(2, 3));
        System.out.println(pow(2, 0));
        System.out.println(pow(2, -3));
    }

    private static float pow(float value, int degree) {
        if (degree >= 0)
            return powWork(value, degree);
        else
            return 1 / powWork(value, -degree);
    }

    private static float powWork(float value, int degree) {
        if (degree == 0) return 1;
        if (degree == 1) return value;
        return value * pow(value, degree - 1);
    }
}