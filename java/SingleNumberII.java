public class SingleNumberII {
   /**
    * @param A : An integer array
    * @return : An integer
    */
    public int singleNumberII(int[] A) {
        if (A.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int elem : A) {
            map.put(elem, map.containsKey(elem) ? map.get(elem) + 1 : 1);
        }
        for (int key : map.keySet()) {
            if (map.get(key) == 1) return key;
        }
        throw new NoSuchElementException();
    }

   /**
    * @param A : An integer array
    * @return : An integer
    */
    public int singleNumberII(int[] A) {

    }
}
