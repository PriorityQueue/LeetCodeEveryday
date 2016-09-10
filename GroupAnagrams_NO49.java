public class GroupAnagrams_NO49{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> result = new HashMap<>();
        for (String s: strs)
        {
            String type;
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            type = String.valueOf(chars);
            ArrayList<String> tempTypeInfo ;
            if ((tempTypeInfo = result.get(type) )!= null)
            {
                tempTypeInfo.add(s);
            }else{
                tempTypeInfo =new ArrayList<String>();
                tempTypeInfo.add(s);
                result.put(type,tempTypeInfo);
            }

        }
        List<List<String>> r = new ArrayList<>();
        for(List list:result.values())
        {
            r.add(list);
        }
        return r;
    }
    }
    public List<List<String>> groupAnagrams2(String[] strs)
    {
        final int[] prime =  {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        List<List<String>> result = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();

        for(String s:strs)
        {
            List<String> list;
            int key = 1;
            for (char c:s.toCharArray())
            {
                key*= prime[c - 'a'];
            }
            if (map.get(key)!= null){
                list = result.get(map.get(key));
            }else{
                list = new ArrayList<String>();
                result.add(list);
                map.put(key,result.size()-1);
            }
            list.add(s);
        }
        return result;
    }
}