public class SortLettersbyCase {
    /**
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }

        int left = 0, right = chars.length - 1;
        while (left < right) {
            if (Character.isLowerCase(chars[left])) {
                left++;
            } else if (Character.isUpperCase(chars[right])) {
                right--;
            } else {
                swap(chars, left, right);
                left++;
                right--;
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
