class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for(int e : nums) {
            if(!count.containsKey(e)) count.put(e, 0);
            count.put(e, count.get(e) + 1);
        }

        List<Integer>[] freq = new List[nums.length + 1];
        for(int i = 0; i < freq.length; i++) {
            freq[i] = new ArrayList<>();
        }

        for(var  entry : count.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            freq[value].add(key);
        }

        int[] res = new int[k];
        int i = 0;


        for(int j = freq.length - 1; j > 0; j--) {
            List<Integer> curr = freq[j];
            for(Integer e : curr) {
                if(i == k) return res;
                res[i] = e.intValue();
                i++;
            }            
        }
        return res;
    }
}