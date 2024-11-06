class Solution {
    public int maximumSwap(int num) {
        int lastOcc[] = new int[10];
        char numChrs[] = Integer.toString(num).toCharArray();
        int size = numChrs.length;
        for(int indx = 0; indx < size; indx++){
            lastOcc[numChrs[indx] - '0'] = indx;
        }
        for(int indx = 0; indx < size; indx++){
            char currDig = numChrs[indx];
            for(char dig = '9'; dig > currDig; dig--){
                if(indx < lastOcc[dig - '0']){
                    numChrs[indx] = dig;
                    numChrs[lastOcc[dig - '0']] = currDig;
                    return Integer.parseInt(new String(numChrs));
                }
            }
        }
        return Integer.parseInt(new String(numChrs));
    }
}