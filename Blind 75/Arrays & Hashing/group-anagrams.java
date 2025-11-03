import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, ArrayList<String>> map = new HashMap<>();

        for (String curr : strs) {
            char[] charCurr = curr.toCharArray();
            Arrays.sort(charCurr);
            String tmp = new String(charCurr);
            if (!map.containsKey(tmp))
                map.put(tmp, new ArrayList<>());
            map.get(tmp).add(curr);
        }

        for (var entry : map.entrySet()) {
            ArrayList<String> val = entry.getValue();
            res.add(new ArrayList<>(val));
        }
        return res;
    }
}