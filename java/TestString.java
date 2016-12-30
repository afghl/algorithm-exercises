import java.util.TreeMap;

public class TestString {
    public static void main(String[] args) {
        String s1 = "aa" + "a";
        String s2 = "aaa";

        System.out.println(s1 == s2);

        String s3 = "ab";
        String s4 = "cd";
        String s5 = "abcd";
        String s6 = s3 + s4;
        System.out.println(s6 == s5);
        s5.intern();
    }
}
