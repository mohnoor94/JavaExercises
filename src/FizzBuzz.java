public class FizzBuzz {

    public static void main(String[] args) {
        fizzBuzz1();
        fizzBuzz2();
    }

    private static void fizzBuzz1() {
        for (int i = 1; i < 100; i++) {
            if (i % 15 == 0)
                System.out.println("FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Fizz");
            else if (i % 5 == 0)
                System.out.println("Buzz");
            else
                System.out.println(i);
        }
    }

    private static void fizzBuzz2() {
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < 100; i++) {
            int length = builder.length();
            if (i % 3 == 0) builder.append("Fizz");
            if (i % 5 == 0) builder.append("Buzz");
            if (builder.length() == length) builder.append(i);
            builder.append('\n');
        }
        System.out.println(builder.toString());
    }
}