public class CountingBits_NO338{
/*    public int[] countBits1(int num)
    {
        int j,k;
        int[] result = new int[num+1];
        for (int i = 0 ; i <= num ;i++)
        {
            if (result[i] != 0) {
                continue;
            }
            j = i;

           //此方法使用于求一个数的1的个数，countBits2为针对此题的优化，为动态规划

             //Step1:先把待求的数分成数段，每段两位（32位int分成16段），将每段减去其第一位的数，
            // 这样每段这两位数就能表示原来这两位数中1的个数了
            j = j - ((j>>1)&0x55555555);

            //Step2:再将相邻的两段相加使每段长度变为4 总段数变为原来的一半
            j = (j & 0x33333333)+ ((j >> 2) & 0x33333333);

            //Step3:再将相邻的两段相加使每段长度变为 8,总段数变为原来的一半
            j = (j + (j >> 4)) & 0x0f0f0f0f;

            //Steo4:同上，
            j = (j + (j >> 8))& 0x00ff00ff;
            j = j + (j >> 16) & 0xffff;
            k = i;
            do {
                result[k] = j;
                k *= 2;
            }while (0<k&&k<=num);
        }
        return result;
    }*/
    public int[] countBits2(int num) {
        int[] result = new int[num + 1];
        //将数分成奇数与偶数，通过（i&0x01)进行区分，若为偶数则1的个数与其二分之一的数的1的个数相等，
        // 若为奇数则减一除以二再加一即可
        for(int i = 0; i<= num ; ++i) result[i] = result[i>>1] + (i & 0x01);
        return result;
    }
}