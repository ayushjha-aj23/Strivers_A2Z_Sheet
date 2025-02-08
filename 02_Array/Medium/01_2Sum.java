class Solution {
    public int[] twoSum(int[] nums, int target) {

        // Method 1: Nested Loops - TC-O(N2)
        // for(int i=0;i<nums.length;i++){
        // for(int j=i+1;j<nums.length;j++){
        // int complement = target - nums[i];

        // if(complement == nums[j])
        // return new int[] {i, j};
        // }
        // }

        // return null;

        // Method 2: Using HashMap - TC-O(N)
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int complement = target - nums[i];

            if (numMap.containsKey(complement))
                return new int[] { numMap.get(complement), i };

            numMap.put(nums[i], i);
        }
        return null;
    }
}
