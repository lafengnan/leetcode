package string;

/**
 * Created by lafengnan on 16/10/7.
 */
public class StringSolution {

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
}
