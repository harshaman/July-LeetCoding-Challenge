/*
Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, add spaces in s to construct a sentence where each word is a valid dictionary word. Return all such possible sentences.

Note:

The same word in the dictionary may be reused multiple times in the segmentation.
You may assume the dictionary does not contain duplicate words.
Example 1:

Input:
s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
Example 2:

Input:
s = "pineapplepenapple"
wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
Output:
[
  "pine apple pen apple",
  "pineapple pen apple",
  "pine applepen apple"
]
Explanation: Note that you are allowed to reuse a dictionary word.
Example 3:

Input:
s = "catsandog"
wordDict = ["cats", "dog", "sand", "and", "cat"]
Output:
[]
*/

class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        if( s.length() > 100 ) 
            return new ArrayList();
        List<String> res= new ArrayList<>();
        dfs(wordDict,s, res, new StringBuilder());
        return res;
    }
    
    public void dfs(List<String> dir, String word, List<String> res, StringBuilder s) {
        if( s.length()>0)
        {
            s.append(" ");
        }
        for(String str:  dir){
            if(word.startsWith(str)){
                StringBuilder strBuilder = new StringBuilder(s);
                strBuilder.append(str);
                
                if(word.equals(str)){
                    res.add(new String(strBuilder));
                }
                else {
                    dfs(dir, word.substring(str.length()),res, strBuilder);
                }
            }
        }
    }
}
