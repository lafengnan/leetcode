package string;
import java.util.*;

/**
 * Created by lafengnan on 16/10/7.
 */
public class StringSolution {

    public static String reverse(String s) {
        char[] chars = s.toCharArray();
        int mid = chars.length >> 1;
        for (int i = 0; i < mid; i++) {
            int j = chars.length - 1 - i;
            chars[i] ^= chars[j];
            chars[j] ^= chars[i];
            chars[i] ^= chars[j];
        }

        return String.valueOf(chars);
    }

    /**
     * Given an absolute path for a file (Unix-style), simplify it.
     * For example,
     * path = "/home/", => "/home"
     * path = "/a/./b/../../c/", => "/c"
     * click to show corner cases.
     *
     * Corner Cases:
     * 1. Did you consider the case where path="/../"? In this case,you should return"/".
     * 2. Another corner case is the path might contain multiple slashes '/' together, such as
     "/home//foo/". In this case, you should ignore redundant slashes and return "/home/foo".
     * @param path The complicated path to simplify
     * @return the simplified path
     */
    public static String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        String[] paths = path.split("/");
        List<String> sp = new LinkedList<>();
        boolean goodPath = path.startsWith("/");
        for (int i = 0; goodPath && i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].isEmpty()) continue;
            if (paths[i].equals("..")) {
                if (!sp.isEmpty()) {
                    sp.remove(sp.size() - 1);
                }
            } else {
                sp.add(paths[i]);
            }
        }

        if (goodPath) {
            if (sp.isEmpty()) {
                sb.append("/");
            } else {
                sp.forEach(p -> sb.append("/").append(p));
            }
        }
        return sb.toString();
    }

    public static String simplifyPathII(String path) {
        String[] paths = path.split("/");
        String[] sp = new String[path.length()];
        StringBuilder sb = new StringBuilder();
        int j = 0;
        boolean goodPath = path.startsWith("/");
        for (int i = 0; goodPath && i < paths.length; i++) {
            if (paths[i].equals(".") || paths[i].isEmpty()) continue;
            if (paths[i].equals("..")) {
                if (j > 0) {
                    --j;
                }
                if (sp[j] != null && !sp[j].isEmpty()) {
                    sp[j] = "";
                }
            } else {
                sp[j++] = paths[i];
            }
        }

        int k = 0;
        if (goodPath && (sp[k] == null || sp[k].isEmpty())) return "/";
        while (sp[k] != null) {
            if (!sp[k].isEmpty()) {
                sb.append("/").append(sp[k]);
            }
            k++;
        }
        return sb.toString();
    }

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     * @param s The src string to check
     * @return true if s is palindrome otherwise false
     */
    public static boolean isPalindrome(String s) {
        boolean flag = true;
        s = s.toLowerCase();
        char[] chars = new char[s.length()];
        int i = 0;
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) {
                chars[i++] = c;
            }
        }
        for (int j = 0; flag && j < (i >> 1) ; j++) {
            flag = chars[j] == chars[i - 1 - j];
        }

        return flag;
    }

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     * @param s The src string to check
     * @return true if s is palindrome otherwise false
     */
    public static boolean isPalindromeII(String s) {
        boolean flag = true;
        s = s.toLowerCase();
        for (int i = 0, j = s.length() -1; flag && i <= j;) {
            char c = s.charAt(i);
            char t = s.charAt(j);
            if (!Character.isAlphabetic(c) && !Character.isDigit(c)) {
                i++;
                continue;
            }
            if (!Character.isAlphabetic(t) && !Character.isDigit(t)) {
                j--;
                continue;
            }
            flag = s.charAt(i) == s.charAt(j);
            i++;
            j--;
        }

        return flag;
    }

    /**
     * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
     * For example,
     * "A man, a plan, a canal: Panama" is a palindrome.
     * "race a car" is not a palindrome.
     * Note:
     * Have you consider that the string might be empty? This is a good question to ask during an interview.
     * For the purpose of this problem, we define empty string as valid palindrome.
     * @param s The src string to check
     * @return true if s is palindrome otherwise false
     */
    public static boolean isPalindromeIII(String s) {
        boolean flag = true;
        // define code points of digit and alphabetic
        int digit_cp_l = 48, digit_cp_h = 57;
        int alpha_cp_uc_l = 65, alpha_cp_uc_h = 90;
        int alpha_cp_lc_l = 97, alpha_cp_lc_h = 122;
        for (int i = 0, j = s.length() - 1; flag && i <= j;) {
            char c = s.charAt(i);
            char t = s.charAt(j);
            if (!(digit_cp_l <= c && c <= digit_cp_h ||
                    alpha_cp_uc_l <= c && c <= alpha_cp_uc_h ||
                    alpha_cp_lc_l <= c && c <= alpha_cp_lc_h)) {
                i++;
                continue;
            }
            if (!(digit_cp_l <= t && t <= digit_cp_h ||
                    alpha_cp_uc_l <= t && t <= alpha_cp_uc_h ||
                    alpha_cp_lc_l <= t && t <= alpha_cp_lc_h)) {
                j--;
                continue;
            }
            flag = c == t || (c < t && c >= alpha_cp_uc_l && c <= alpha_cp_uc_h ? t == c + 32 :
                    (c > t && c >= alpha_cp_lc_l && c < alpha_cp_lc_h) && t == c - 32);
            i++;
            j--;
        }

        return flag;
    }


    /**
     * Implement strStr().
     * Returns the index of the first occurrence of needle in haystack,
     * or -1 if needle is not part of haystack.
     * @param hayStack the source string
     * @param needle the string to find
     * @return the index if needle is in hayStack otherwise -1
     */
    public static int strStr(String hayStack, String needle) {
        if (hayStack == null || needle == null) return -1;
        if (hayStack.isEmpty() && !needle.isEmpty()) return -1;
        if (!hayStack.isEmpty() && needle.isEmpty()) return -1;
        if (hayStack.length() < needle.length()) return -1;
        if (hayStack.isEmpty() && needle.isEmpty()) return 0;

        int pos = 0, cur = 0, index = -1;
        for (; cur < needle.length() && pos < hayStack.length(); ) {
            if (hayStack.charAt(pos) != needle.charAt(cur)) {
                pos = cur > 0?pos - 1:pos + 1;
                cur = 0;
                index = -1;
                continue;
            }
            if (hayStack.charAt(pos) == needle.charAt(cur)) {
                index = index == -1?pos:index;
                pos++;
                cur++;
            }
        }

        return cur < needle.length()?-1:index;
    }

    /**
     * Implement atoi to convert a string to an integer.
     * Hint: Carefully consider all possible input cases. If you want a challenge,
     * please do not see below and ask yourself what are the possible input cases.
     * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
     * You are responsible to gather all the input requirements up front.
     *
     * Update (2015-02-10):
     * The signature of the C++ function had been updated. If you still see your function signature
     * accepts a const char * argument, please click the reload button  to reset your code definition.
     *
     * spoilers alert... click to show requirements for atoi.
     *
     * Requirements for atoi:
     * The function first discards as many whitespace characters as necessary until the first
     * non-whitespace character is found. Then, starting from this character, takes an optional initial
     * plus or minus sign followed by as many numerical digits as possible, and interprets them as a
     * numerical value.
     * The string can contain additional characters after those that form the integral number,
     * which are ignored and have no effect on the behavior of this function.
     *
     * If the first sequence of non-whitespace characters in str is not a valid integral number,
     * or if no such sequence exists because either str is empty or it contains only whitespace characters,
     * no conversion is performed.
     *
     * If no valid conversion could be performed, a zero value is returned.
     * If the correct value is out of the range of representable values,
     * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
     * @param str The string of number to convert
     * @return The integer value of given str if the convert could be performed, otherwise 0
     */
    public static int atoi(String str) {
        if (str == null || str.isEmpty()) return 0;

        boolean negFlag = false;
        int i = 0;
        int len = str.length();
        while(str.charAt(i) == ' ' && i < len) i++;

        if (str.charAt(i) == '+') {
            i++;
        } else if (str.charAt(i) == '-') {
            i++;
            negFlag = true;
        }

        int digit = 0;
        for (; i < len; i++) {
            char c = str.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }

            if (digit > Integer.MAX_VALUE / 10 ||
                    (digit == Integer.MAX_VALUE / 10 && c - '0' > Integer.MAX_VALUE % 10)) {
                digit = negFlag?Integer.MIN_VALUE:Integer.MAX_VALUE;
                break;
            }

            digit = digit * 10 + c - '0';
        }

        return negFlag?-digit:digit;
    }

    /**
     * Given two binary strings, return their sum (also a binary string).
     * For example,
     * a = "11"
     * b = "1"
     * Return "100".
     * @param left The first binary string
     * @param right The second binary string
     * @return The sum of two binaries in binary format
     */
    public static String addBinary(String left, String right) {
        boolean good = true;
        boolean carry = false;
        int lLen = left.length(), rLen = right.length();
        int steps = lLen <= rLen? lLen : rLen;

        int i = 1;
        StringBuilder sb = new StringBuilder("");

        for (; good && i <= steps; i++) {
            char l = left.charAt(lLen - i), r = right.charAt(rLen - i);
            switch (l) {
                case '0':
                    if (r == '0') {
                        sb.insert(0, carry?'1':'0');
                        carry = false;
                    } else if (r == '1'){
                        sb.insert(0, carry?'0':'1');
                    } else {
                        good = false;
                    }
                    break;
                case '1':
                    if (r == '0') {
                        sb.insert(0, carry?'0':'1');
                    } else if (r == '1') {
                        sb.insert(0, carry?'1':'0');
                        carry = true;
                    } else {
                        good = false;
                    }
                    break;
                default:
                    good = false;
                    break;
            }
        }

        steps = lLen > rLen?lLen:rLen;
        String longStr = lLen > rLen?left:right;

        for (; good && i <= steps; i++) {
            char remain = longStr.charAt(steps - i);
            switch (remain) {
                case '0':
                    sb.insert(0, carry?'1':'0');
                    carry = false;
                    break;
                case '1':
                    sb.insert(0, carry?'0':'1');
                    break;
                default:
                    good = false;
                    break;
            }
        }

        return good?carry?sb.insert(0, '1').toString():sb.toString():"";
    }

    public static String addBinaryII(String left, String right) {
        int lLen = left.length(), rLen = right.length();
        int steps = lLen > rLen? lLen:rLen;

        int carry = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= steps; i++) {
            int lv = i <= lLen?left.charAt(lLen - i) - '0':0;
            int rv = i <= rLen?right.charAt(rLen - i) - '0':0;
//            int v = (lv + rv + carry) % 2;
            int v = lv ^ rv ^ carry;
            carry = (lv + rv + carry) >> 1;
            sb.insert(0, (char)(v + '0'));
        }
        if (carry > 0) sb.insert(0, '1');

        return sb.toString();
    }

    /**
     * Validate if a given string is numeric.
     * Some examples:
     * "0" => true
     * " 0.1 " => true
     * "abc" => false
     * "1 a" => false
     * "2e10" => true
     * Note: It is intended for the problem statement to be ambiguous.
     * You should gather all requirements up front before implementing one.
     *
     * Update (2015-02-10):
     * The signature of the C++ function had been updated. If you still see your function signature
     * accepts a const char * argument, please click the reload button  to reset your code definition.
     *
     * @param str The source string for analysis
     * @return true if str is a number, otherwise false
     */
    public static boolean isNumber(String str) {
        if (str.isEmpty()) return false;
        int i = 0, len = str.length(), j = len - 1;

        while (i < len && str.charAt(i) == ' ') i++;
        while (j >= 0 && str.charAt(j) == ' ') j--;

        boolean good = i <= j;
        List<Integer> eIndices = new LinkedList<>();
        List<Integer> dotIndices = new LinkedList<>();

        for (int k = i; good && k <= j; k++) {
            char c = str.charAt(k);
            if (c < '0' || c > '9') {
                if (c != '.' && c != 'e' && c != '+' && c != '-') {
                    good = false;
                } else if (c == '+' || c == '-') {
                    good = k == i;
                } else if (c == '.') {
                    eIndices.add(i);
                    good = eIndices.size() < 2;
                } else {
                    dotIndices.add(i);
                    good = dotIndices.size() < 2;
                }
            }
        }

        if (good) { // only 1 'e' and 1 '.' or no '.' and 'e'
            if (!eIndices.isEmpty()) {
                int e = eIndices.get(0);
                good = e != i && e != j;
                if (good && !dotIndices.isEmpty()) {
                    good = dotIndices.get(0) < e;
                }
            } else {
                if (!dotIndices.isEmpty()) {
                    int dot = dotIndices.get(0);
                    good = dot >= i && dot <= j;
                }
            }
        }

        return good;
    }

    /**
     * Given a roman numeral, convert it to an integer.
     * Input is guaranteed to be within the range from 1 to 3999.
     * Subscribe to see which companies asked this question
     * @param s The roman string to convert
     * @return the integer value of given roman string s
     */
    public static int romanToInt(String s) {
        int len = s.length();
        Map<Character, Integer> map = new HashMap<>(7);
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int v = 0, i = len - 1, cv = 0, pv = 0;
        for (; i > 0; i--) {
            cv = map.get(s.charAt(i));
            pv = map.get(s.charAt(i - 1));
            if (cv <= pv) v += cv;
            if (cv > pv) {
                v += cv - pv;
                i--;
            }
        }

        if (len > 1 && i == 0) {
            cv = map.get(s.charAt(i));
            pv = map.get(s.charAt(i + 1));
            v = cv < pv? v - cv: v + cv;
        } else if (len == 1 && i == 0) {
            v = map.get(s.charAt(i));
        }
        return v;
    }

    /**
     * Given an integer, convert it to a roman numeral.
     * Input is guaranteed to be within the range from 1 to 3999.
     * @param num the number to convert
     * @return The roman string of given number
     */
    public static String intToRoman(int num) {
        int[] romanBase = {
                1000, 900, 500, 400,
                100, 90, 50, 40,
                10, 9, 5, 4, 1
        };
        String[] symbol = {
                "M", "CM", "D", "CD",
                "C", "XC", "L", "XL",
                "X", "IX", "V", "IV",
                "I"
        };

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0) {
            int steps = num / romanBase[i];
            num %= romanBase[i];
            while (steps-- > 0) sb.append(symbol[i]);
            i++;
        }
        return sb.toString();
    }

    /**
     * String-58
     * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
     * return the length of last word in the string.
     * If the last word does not exist, return 0.
     * Note: A word is defined as a character sequence consists of non-space characters only.
     * For example,
     * Given s = "Hello World", return 5.
     * @param s The word to to analyze
     * @return The length of last word
     */
    public static int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int cnt = 0;
        boolean tailSpace = true;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == ' ') {
                if (!tailSpace) break;
            } else {
                tailSpace = false;
                cnt++;
            }
        }
        return cnt;
    }

    public static int lengthOfLastWordII(String s) {
        int cnt = 0;
        boolean flag = false;
        int i = s.length();
        while (i >= 0) {
            if (s.charAt(i) == ' ') {
                if (flag) break;
            } else {
                flag = true;
                cnt++;
            }
        }
        return cnt;
    }

    /**
     * String-49
     * Given an array of strings, group anagrams together.
     * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Return:
     * [
     *     ["ate", "eat","tea"],
     *     ["nat","tan"],
     *     ["bat"]
     * ]
     *
     * Note: All inputs will be in lower-case.
     * @param strs The input datas
     * @return The list of anagrams
     */
    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        String[] clones = new String[strs.length];
        System.arraycopy(strs, 0, clones, 0, strs.length);

        for (int i = 0; i < clones.length; i++) {
            if (clones[i] == null) continue;
            char[] chars = clones[i].toCharArray();
            Arrays.sort(chars);
            clones[i] = String.valueOf(chars);
            List<String> list = new LinkedList<>();
            if (clones[i] != null) list.add(strs[i]);
            for (int j = i + 1; j < clones.length; j++) {
                if (clones[j] == null) continue;
                char[] charsJ = clones[j].toCharArray();
                Arrays.sort(charsJ);
                clones[j] = String.valueOf(charsJ);
                if (clones[i].equals(clones[j])) {
                    list.add(strs[j]);
                    clones[j] = null;
                }
            }
            result.add(list);
        }

        return result;
    }

    /**
     * String-49
     * Given an array of strings, group anagrams together.
     * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Return:
     * [
     *     ["ate", "eat","tea"],
     *     ["nat","tan"],
     *     ["bat"]
     * ]
     *
     * Note: All inputs will be in lower-case.
     * @param strs The input datas
     * @return The list of anagrams
     */
    public static List<List<String>> groupAnagramsIII(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int[] primes = {
                2, 3, 5, 7, 11, 13,
                17, 19, 23, 29, 31, 41,
                43, 47, 53, 59, 61, 67,
                71, 73, 79, 83, 89, 97,
                101, 103};

        int msk, index = 0;
        for (String s : strs) {
            msk = 1;
            for (int i = 0; i < s.length(); i++) msk *= primes[s.charAt(i) - 'a'];
            if (!map.containsKey(msk)) {
                result.add(new LinkedList<>());
                map.put(msk, index++);
            }
            result.get(map.get(msk)).add(s);
        }

        return result;
    }

    /**
     * Build blance bi-tree for each string, then compare the bi-tree
     * @param strs
     * @return
     */
    public static List<List<String>> groupAnagramsII(String[] strs) {
        return null;
    }

    public static boolean equivalent(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        boolean flag = chars1.length == chars2.length;
        if (flag) {
            if (chars1.length == 0) return true; // empty str

            Arrays.sort(chars1);
            Arrays.sort(chars2);
            for (int i = 0; flag && i < chars1.length; i++) {
                flag = chars1[i] == chars2[i];
            }
        }

        return flag;
    }

    /**
     * rotate right shift the string
     * @param s the original string to rotate
     * @param n how many bits to shift
     *
     * Example:
     *          s = "1234", after shifting 1
     *          s = "4123", after shifting 2
     *          s = "3412", etc
     * @return the shifted string
     */
    public static String rShift(String s, int n) {
        int len = s.length();
        int i = 0, shiftLen = n < len?n:len;
        StringBuilder sb = new StringBuilder(len);

        while (i < shiftLen) {
            sb.insert(0, s.charAt(len - 1 - i++));
        }
        if (shiftLen <= len)
            sb.append(s.substring(0, len - shiftLen));

        return sb.toString();
    }
}
