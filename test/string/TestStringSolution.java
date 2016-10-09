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
        System.out.println(StringSolution.addBinaryII(l, r));
    }

    public void testIsNumber() {
        String[] nums = {"  123", "1.1", "  1.1", "abc", "2e10", " 2e10", "2.", ".a", ".e", ".123", "1 2", "人2"};
//        String[] nums = {"", "  ", "1  1", "1.   "};
//        String[] nums = {".1", "1.", ".1.", "..1", "1..", ".."};
        String[] nums2 = {
                ".", "..", ".1.", ".1", "1.",
                "1..", "..1", "..1..", "-1",
                "+1", "+1.", "-.1", "+ 1", "+ .1",
                " ", "", "+-.1", "+-", "+-   ",
                "e.", "+e1", "+1e1", "+1.e1",
                "1e1.1", "1e1", "+1e1.1", "1e 1", "4e1.",
                "+1. e1", "+.e1", ".e1", "+1e 10",
                ".1.8", "..1.8", ".1 8", "1.8.", ".1.8.",
        };

        for (String num : nums) {
            System.out.println(num + " " + StringSolution.isNumber(num));
        }
        for (String num : nums2) {
            System.out.println(num + " " + StringSolution.isNumber(num));
        }
    }

    public void testRomanToInt() {
        String[] romans = {
                "MCDXXXVII", "MDCCCLXXX", "XIV", "CXCIX", "MMMCCCXXXIII", "CMLII", "D", "DD"
        };

        for (String roman : romans) {
            System.out.println(roman + " " + StringSolution.romanToInt(roman));
        }
    }

    public static void main(String... args) {
        TestStringSolution solution = new TestStringSolution();
        solution.testIsPalindrome();
        solution.testStrStr();
        solution.testAtoi();
        solution.testAddBinary();
        solution.testIsNumber();
        solution.testRomanToInt();
    }
}
