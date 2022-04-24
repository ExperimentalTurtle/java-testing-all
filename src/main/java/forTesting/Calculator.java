package forTesting;

public class Calculator {
    public int add(int... nums) {
        int num = 0;

        for (int j : nums) {
            num += j;
        }

        return num;
    }
}
