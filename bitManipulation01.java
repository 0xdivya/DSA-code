public class bitManipulation01 {
    public static void main(String[] args) {
        printBits(33);
        printOddEven(45);
        int res =setIthbit(32,0);
        printBits(res);
        int res1 =toggleIthbit(33,5);
        printBits(res1);
        int res2 =unSetIthbit(33,5);
        printBits(res2);
    }
     
    public static void printBits(int num){
        for(int i=7; i>=0; i--){
            int bit = (num >> i) & 1;
            System.out.print(bit);
        }
        System.out.println();
    }

    public static void printOddEven(int num){
        if(isBitSet(num, 0)){
            System.out.println("\nEven Number");
        } else {
            System.out.println("\nOdd Number");
        }
    }

    public static boolean isBitSet(int num, int bit){
        int res = num & (1<< bit);
        return res != 0;
    }
    
    public static int setIthbit(int num, int bit){
        int res = num | (1<< bit);
        return res;
    }

    public static int toggleIthbit(int num, int bit){
        int res = num ^ (1<< bit);
        return res;
    }

    public static int unSetIthbit(int num, int bit){
        int res = num & ~(1<< bit);
        return res;
    }

    

}
