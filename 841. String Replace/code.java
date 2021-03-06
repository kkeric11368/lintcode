//Given two identical-sized string array A, B and a string S.
//All substrings A appearing in S are replaced by B.
//(Notice: From left to right, it must be replaced if it can be replaced.
//If there are multiple alternatives, replace longer priorities.
//After the replacement of the characters can't be replaced again.)

//The size of each string array does not exceed 100, the total string length does not exceed 50000.
//The lengths of A [i] and B [i] are equal.
//The length of S does not exceed 50000.
//All characters are lowercase letters.
//We guarantee that the A array does not have the same string

//Example
//Given A = ["ab","aba"], B = ["cc","ccc"], S = "ababa", return "cccba".

//In accordance with the rules, the substring that can be replaced is "ab" or "aba".
//Since "aba" is longer, we replace "aba" with "ccc".

//Given A = ["ab","aba"], B = ["cc","ccc"] ,S = "aaaaa" ,return "aaaaa".

//S does not contain strings in A, so no replacement is done.
//Given A = ["cd","dab","ab"], B = ["cc","aaa","dd"], S = "cdab", return "ccdd".

//From left to right, you can find the "cd" can be replaced at first,
//so after the replacement becomes "ccab", then you can find "ab" can be replaced,
//so the string after the replacement is "ccdd".



//    Time complexity: O(a.length * s.length())
    public String stringReplace(String[] a, String[] b, String s) {
        if (a == null || b == null) {
            return s;
        }
        if (a.length == 0 || b.length == 0) {
            return s;
        }
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < s.length(); i++) {
            list.add(new ArrayList<Integer>());
        }
        // Calculate all the possible replacements on each string position
        for (int i = 0; i < a.length; i++) {
            int index = 0;
            while (s.indexOf(a[i], index) >= 0) {
                int tmp = s.indexOf(a[i], index);
                List<Integer> entry = list.get(tmp);
                entry.add(i);
                index = tmp + 1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int index = 0;
        // Check on each string position and replace with the longest one
        while (index < s.length()) {
            List<Integer> candidates = list.get(index);
            if (candidates.size() == 0) {
                sb.append(s.charAt(index));
                index++;
            } else {
                int target = findMaxLen(candidates, a);
                sb.append(b[target]);
                index = index + a[target].length();
            }
        }
        return sb.toString();
    }
    public int findMaxLen(List<Integer> list, String[] a) {
        int target = -1;
        int len = 0;
        for (int i: list) {
            if (a[i].length() > len) {
                len = a[i].length();
                target = i;
            }
        }
        return target;
    }
