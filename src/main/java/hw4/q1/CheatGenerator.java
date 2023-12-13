package hw4.q1;


import java.util.Random;

public class CheatGenerator{
    static String chars = "1234567890-=qwertyuiop[!@#$%^&*()_QWERTYUIOP{ASDFGHJKL:asdfghjkl;ZXCVBNM<>xcvbnm";
    static String name = "qwertyuiopasdfghjklzxcvbnmqwertyuiop[zxcvbnm,.";
    public void generate(Random random, String... args) {
        int n = random.nextInt(5);
        while (n == 0) {
            n = random.nextInt(5);
        }
        System.out.println(n);
        int nameRandom = random.nextInt(20);
        for (int i = 0;i < n ; i++) {
            int length = random.nextInt(40);
            String sender = name.substring(i+nameRandom,i+nameRandom+10);
            String code = "";
            int startIndex = random.nextInt(50);
            for (int j = 0 ; j < length ; j++) {
                code = code + chars.charAt(startIndex+j%chars.length());
            }
            System.out.println(sender+" "+code);
        }
    }
}
