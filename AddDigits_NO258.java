public class AddDigits_NO258 {
    public int addDigits(int num) {
        int total = 0 ;
        int temp = num;
        while( temp > 9 ) {
            total =0 ;
            while (temp != 0) {
                total += (temp % 10);
                temp /= 10;
            }
            temp = total;
        }
        return temp;
    }
}