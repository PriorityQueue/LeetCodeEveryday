public class SingleNumber3_NO260{
   public int[] singleNumber(int[] nums)
   {
       HashMap<Integer,Integer> c = new HashMap<>();
       for (int n:nums)
       {
           if (c.containsKey(n) == true )
               c.remove(n);
           else
               c.put(n,null);
       }
       int i = 0;
       int[] result = new int[2];
       for (int k:c.keySet())
       {

           if (i < 2)
               result[i++] = k;
           else
               break;
       }
       return result;
   }
   public int[] singleNumber2(int[] nums)
   {
       Arrays.sort(nums);
       Stack<Integer> stack = new Stack<>();
       int[] result = new int[2];
       int rp = 0;
       stack.push(nums[0]);
       for (int i = 1;i<nums.length;++i) {
           if (stack.empty() ||stack.peek()!= nums[i])
               stack.push(nums[i]);
           else
               stack.pop();
       }
       while(stack.empty() == false){
           result[rp++] = stack.pop();
       }
       return result;
   }
    public int[] singleNumber3(int[] nums)
    {
        int diff = 0;
        int[] result = new int[2];
        for (int n:nums)
        {
            diff ^= nums;//两个不同的数异或后的结果,一定至少有一位为1。把这一位挑出来用来区分这两个数。
        }
        diff &= -diff;    //一个数的补码一定有一位与原码同为1，通过这样的方法找出上述的这一位。
        for (int n:nums)
        {
            result[!(nums & diff)]^=nums;
        }
        return result;
    }
}