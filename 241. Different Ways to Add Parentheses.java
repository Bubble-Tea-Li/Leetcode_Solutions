class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<>();
        int index = 0;
        int num = 0;
        while(index < input.length() && !isOperation(input.charAt(index))){
            num = num * 10 + (int)(input.charAt(index) - '0');
            index++;
        }
        if(index == input.length()){
            res.add(num);
            return res;
        }
        for(int i = 0; i < input.length(); i++){
            if(isOperation(input.charAt(i))){
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i + 1));
                for(int l : left){
                    for(int r : right){
                        char op = input.charAt(i);
                        res.add(calculate(l, r, op));
                    }
                }
            }
        }
        return res;
    }
    
    private int calculate(int left, int right, char op){
        if(op == '+')
            return left + right;
        else if(op == '-')
            return left - right;
        else
            return left * right;
    }
    
    private boolean isOperation(char c){
        if(c == '+' || c == '-' || c == '*')
            return true;
        else return false;
    }
}