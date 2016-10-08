package string;

/**
 * Created by lafengnan on 16/10/7.
 */
public class TestStringSolution {

    public void testIsPalindrome() {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "!043XjqjX043!";
        String s3 = "8V8K;G;K;V;";
        System.out.println(StringSolution.isPalindrome(s));
        System.out.println(StringSolution.isPalindromeIII(s2));
        System.out.println(StringSolution.isPalindromeIII(s3));
    }

    public void testStrStr() {
        String hay = "mississippi";
        String needle = "issipi";
        System.out.println(StringSolution.strStr(hay, needle));
    }

    public void testAtoi() {
        String str = "2147483648";
        String str2 = "+2147a";
        String str3 = "-2a147a";
        System.out.println(StringSolution.atoi(str));
        System.out.println(StringSolution.atoi(str2));
        System.out.println(StringSolution.atoi(str3));
    }

    public void testAddBinary() {
        String l = "11011";
        String r = "1011";
        System.out.println(StringSolution.addBinary(l, r));
    }

    public static void main(String... args) {
        TestStringSolution solution = new TestStringSolution();
        solution.testIsPalindrome();
        solution.testStrStr();
        solution.testAtoi();
        solution.testAddBinary();
    }
}
