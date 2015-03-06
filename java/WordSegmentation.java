import java.util.*;

public class WordSegmentation {
    /**
     * @param s: A string s
     * @param dict: A dictionary of words dict
     */
    public boolean wordSegmentation(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return false;
        }
        if (dict.contains(s)) {
            return true;
        }

        int len = s.length();
        boolean[] table = new boolean[len + 1];
        table[0] = true;
        for (int i = 0; i < len; i++) {
            if (!table[i]) {
                continue;
            }
            for (String segment : dict) {
                int end = i + segment.length();
                if (end > len || table[end]) {
                    continue;
                }

                if (s.substring(i, end).equals(segment)) {
                    table[end] = true;
                }
            }
        }

        return table[len];
    }
}
