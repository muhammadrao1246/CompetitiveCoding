class Solution {
    public int calPoints(String[] operations) {
        int[] scores = new int[operations.length];
        int curr = 0;
        for(String op : operations){
            if(op.equals("+")){
                scores[curr] = scores[curr-1] + scores[curr-2];
                curr++;
            }
            else if(op.equals("C")){
                scores[curr-1] = 0;
                curr--;
            }
            else if(op.equals("D")){
                scores[curr] = scores[curr-1]*2;
                curr++;
            }else{
                scores[curr] = Integer.parseInt(op);
                curr++;
            }
        }

        int score = 0;
        for(int s : scores){
            score += s;
        }

        return score;
    }
}