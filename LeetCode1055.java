// Time Complexity : O(t*log k)--> target length and k occurences of unique chars in s
// Space Complexity : O(s) s because unique chars have occurences array in map
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int shortestWay(String source, String target) {
        HashMap<Character, List<Integer>> map = new HashMap<>();
        int tlen = target.length();
        int slen = source.length();
        for(int i=0; i< slen ;i++){     // store the indexes of occurences of chars in source //o(slen)
            char s = source.charAt(i);
            if(!map.containsKey(s)){
            map.put(s,new ArrayList<>());
            }
            map.get(s).add(i);
        }
        int sp=0,tp=0,count=1; //pointers to traverse the souce and target strings
        while(tp <tlen){  //till the target pointer goes out of bound. // tlen

            char t = target.charAt(tp);
            if(!map.containsKey(t)) return -1;
            List<Integer> li = map.get(t);
            int k = Collections.binarySearch(li,sp); // binary search of occurence array //log k
            if(k<0){ // if element not found bs gives possible -insertionpoint-1
                k = -k-1;
            } 
            //check if k is inbounds
            if(k ==li.size()){
                count++; // we need to traverse again since we have not completed target string
                sp= li.get(0); // reset to first index of that char occurence list
            }else{                                                                       //k=//0,1,2,3
                sp = li.get(k);// make sp to occur(idx in source str) from the li index k li=[4,7,8,9] if k=2 sp=7
            }
            sp++; tp++;
        }
        return count;
    }
}