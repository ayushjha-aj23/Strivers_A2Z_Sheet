class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        
        HashSet<Integer> hashSet1 = new HashSet<>();
        HashSet<Integer> hashSet2 = new HashSet<>();


        for(int i: nums1)
            hashSet1.add(i);
        
        for(int j: nums2)
            hashSet2.add(j);

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for(int i: hashSet1)
            if(!hashSet2.contains(i))
                a.add(i);

        for(int j: hashSet2)
            if(!hashSet1.contains(j))
                b.add(j);
        
        List<List<Integer>> result = new ArrayList<>();

        result.add(a);
        result.add(b);

        return result;
    }
}
