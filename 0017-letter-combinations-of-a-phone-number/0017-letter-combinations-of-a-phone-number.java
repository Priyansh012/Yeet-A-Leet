class Solution {
    //recursive solution
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) 
            return Collections.emptyList();

        String[] phone_map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> output = new ArrayList<>();
        backtrack("", digits, phone_map, output);
        return output;
    }

    private void backtrack(String combination, String next_digits, String[] phone_map, List<String> output) {
        if (next_digits.isEmpty()) {
            output.add(combination);
        } else {
            //We are doing minus '2' because the digits are from 2 to 9 but our phone map is from 0 to 7
            String letters = phone_map[next_digits.charAt(0) - '2'];
            for (char letter : letters.toCharArray()) {

                //.subtring(1) returns empty string when there is no further character after the current character.
                backtrack(combination + letter, next_digits.substring(1), phone_map, output);
            }
        }
    }
}