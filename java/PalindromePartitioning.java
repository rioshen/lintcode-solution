import java.util.*;

public class PalindromePartitioning {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) {
            return res;
        }

        List<String> path = new ArrayList<String>();
        helper(s, 0, path, res);
        return res;
    }

    private void helper(String s, int pos, List<String> path,
        List<List<String>> res)
    {
        if (s.length() == pos) {
            res.add(new ArrayList<String>(path));
            return;
        }

        for (int i = pos; i < s.length(); i++) {
            if (!isPalindrome(s, pos, i)) {
                continue;
            }
            path.add(s.substring(pos, i + 1));
            helper(s, i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
