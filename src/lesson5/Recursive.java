package lesson5;

public class Recursive {
    public static int power(int value, int pow){
        if (pow == 1){
            return value;
        }
        if (pow % 2 == 0){
            int temp = power(value, pow / 2);
            return temp * temp;
        }
        return power(value, pow - 1) * value;
    }
}
