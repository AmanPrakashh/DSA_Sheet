package Arrays;

public class January {


    public int findComplement(int num) {

        //masking will create a binary number with number of bit as same as num but all 1
        //it will find highestOneBit that is 2 to power n here 2 to power n is 4
        // increase one bit and substract by 1
        int mask = (Integer.highestOneBit(num) << 1) - 1;
        return num ^ mask; // XOR the number with the mask to get the complement
    }

}
