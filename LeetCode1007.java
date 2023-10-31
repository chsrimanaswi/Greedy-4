// Time Complexity : O(n) -->len of arrs
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {

        int result =0;
        result = check(tops, bottoms, tops[0]);
        if(result!=-1) return result;   // we get min from top & bottom so safe to return
        return check(tops,bottoms, bottoms[0]);  // we can't fill array with tops[0] ele so check bottoms[0]
    }

    private int check(int[] tops, int[] bottoms, int candidate){
        int tRot=0, bRot=0;
        for(int i=0; i<tops.length;i++){
        //if both places missing candidate we can't fill array with that candidate(means candidatecount<len of arr)
            if(tops[i]!=candidate && bottoms[i]!=candidate) return -1; // so return -1;
            // tops is missing and bottoms is having so swap and increase count for top
            if(tops[i]!=candidate) tRot++;
            // bottoms is missing and tops is having so swap and increase count for top
            if(bottoms[i]!=candidate) bRot++;
        }
        return Math.min(tRot,bRot );  //return min rotations
    }
}