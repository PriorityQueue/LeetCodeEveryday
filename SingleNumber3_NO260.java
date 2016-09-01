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
            diff ^= nums;
        }
        diff &= -diff;
        for (int n:nums)
        {
            result[!(nums & diff)]^=nums;
        }
        return result;
    }
}