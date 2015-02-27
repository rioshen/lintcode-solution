import java.util.*;

public class WordLadder {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (start == null || end == null || dict == null) {
            return 0;
        }

        int len = 1;
        Queue<String> queue = new LinkedList<String>();
        queue.offer(start);
        dict.remove(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String content = queue.poll();
                for (int j = 0; j < content.length(); j++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (content.charAt(j) == c) {
                            continue;
                        }
                        char[] t = content.toCharArray();
                        t[j] = c;
                        String temp = new String(t);
                        if (temp.equals(end)) {
                            return len + 1;
                        }
                        if (dict.contains(temp)) {
                            dict.remove(temp);
                            queue.offer(temp);
                        }
                    }
                }
            }
            len++;
        }
        return 0;
    }
}
