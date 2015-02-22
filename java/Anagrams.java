public class Anagrams {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        List<String> res = new LinkedList<String>();
        if (strs == null || strs.length == 0) {
            return res;
        }
    
        HashMap<String, ArrayList<String>> map = 
            new HashMap<String, ArrayList<String>>();
        for (String str : strs) {
            String key = sort(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(str);
        }
        
        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.addAll(map.get(key));
            }
        }
        
        return res;
    }


    private String sort(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }
}