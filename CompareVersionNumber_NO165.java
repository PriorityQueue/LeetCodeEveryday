public class CompareVersionNumber_NO165 {
    public static void main(String[] args){
        System.out.print(new Solution().compareVersion("1.1","1.0"));

    }
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        if(v1.length == 0)
            v1 = new String[]{version1};
        if(v2.length == 0)
            v2 = new String[]{version2};

        int minL = v1.length < v2.length ? v1.length : v2.length;
        int n1,n2,i;
        for(i = 0; i < minL ; ++i){
            n1 = stringToInt(v1[i]);
            n2 = stringToInt(v2[i]);

            if( n1 < n2 )
                return -1;
            else if(n1 > n2)
                return 1;
            else
                continue;
        }

        if(v1.length != minL){
            for(;i< v1.length;++i){
                if(stringToInt(v1[i]) != 0)
                    return 1;
            }
        }else if ( v2.length!= minL){
            for(;i< v2.length;++i){
                if(stringToInt(v2[i]) != 0)
                    return -1;
            }
        }else{
            return 0;
        }
        return 0;

    }
    public int stringToInt(String s){
        int result = 0;
        char[] charArray = s.toCharArray();
        for(char c: charArray){
            result *= 10;
            if( c <= '9' && c >= '0' )
                result += ( c - '0');
            else
                return -1;
        }
        return result;
    }
}
