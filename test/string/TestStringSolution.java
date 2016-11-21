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

    public void testIntToRoman() {
        int[] values = {
                1, 4, 3333, 2500, 8,
                952, 199, 14, 1437, 1880
        };
        for (int v : values) {
            System.out.println(v + " " + StringSolution.intToRoman(v));
        }
    }

    public void testSimplifyPath() {
        String[] path = {"/home/", "/a/./b/../../c", "/../", "/a/b//c/", "./", "../", "a/b/c", "/home/ab/c/../.././abcd/d/f/g/../././sss/x"};
        for (String p : path) {
            System.out.println(StringSolution.simplifyPath(p));
            System.out.println(StringSolution.simplifyPathII(p));
        }
    }

    public void testGroupAngrams() {
//        String[] data = {"eat", "tea", "tan", "ate", "nat", "bat", "", ""};
        String[] data = {"ray","cod","abe","ned","arc","jar","owl","pop",
                "paw","sky","yup","fed","jul","woo","ado","why","ben","mys",
                "den","dem","fat","you","eon","sui","oct","asp","ago","lea",
                "sow","hus","fee","yup","eve","red","flo","ids","tic","pup",
                "hag","ito","zoo"};
//        [["hag"],["pup"],["ids"],["ito"],["flo"],["red"],["hus"],["sow"],["asp"],
//        ["oct"],["sui"],["fee"],["eon"],["tic"],["sky"],["ago"],["paw"],["jul"],
//        ["pop"],["jar"],["den","ned"],["abe"],["zoo"],["ado"],["lea"],["arc"],["dem"],
//        ["fat"],["owl"],["eve"],["mys"],["cod"],["ray"],["yup","yup"],["woo"],["fed"],["why"],["ben"],["you"]]
        System.out.println(StringSolution.groupAnagramsIII(data));

//        for (String str : data) {
//            for (int i = 0; i <= str.length(); i++) {
//                System.out.println(StringSolution.rShift(str, i));
//            }
//        }
    }

    public static void main(String... args) {
        TestStringSolution solution = new TestStringSolution();
//        solution.testIsPalindrome();
//        solution.testStrStr();
//        solution.testAtoi();
//        solution.testAddBinary();
//        solution.testIsNumber();
//        solution.testRomanToInt();
//        solution.testIntToRoman();
//        solution.testSimplifyPath();
        solution.testGroupAngrams();
    }
}
