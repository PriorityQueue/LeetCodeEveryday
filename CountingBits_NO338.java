public class CountingBits_NO338{
    public int[] countBits1(int num)
    {
        int j,k;
        int[] result = new int[num+1];
        for (int i = 0 ; i <= num ;i++)
        {
            if (result[i] != 0) {
                continue;
            }
            j = i;
            j = j - ((j>>1)&0x55555555);
            j = (j & 0x33333333)+ ((j >> 2) & 0x33333333);
            j = (j + (j >> 4)) & 0x0f0f0f0f;
            j = (j + (j >> 8))& 0x00ff00ff;
            j = j + (j >> 16) & 0xffff;
            k = i;
            do {
                result[k] = j;
                k *= 2;
            }while (0<k&&k<=num);
        }
        return result;
    }
    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        for(int i = 0; i<= num ; ++i) result[i] = result[i>>1] + (i & 0x01);
        return result;
    }
}