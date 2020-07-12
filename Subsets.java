/*
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: nums = [1,2,3]
Output:
[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

Time Complexity : O(N*2^N)
Space Complexity : O(N*2^N)

https://leetcode.com/articles/subsets/
*/

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset;
        int setSize = nums.length;
        long powerSetLen =  (long)Math.pow(2, setSize);
        for(int i =0; i< powerSetLen; ++i){
            subset=new ArrayList();
            for(int j =0;j<=setSize;++j){
                if((i & (1<<j))>0)
                    subset.add(nums[j]);
            }
            result.add(subset);     
        }        
        return result;
    }
}
