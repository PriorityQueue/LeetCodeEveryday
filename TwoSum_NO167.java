public class TwoSum_NO167 {
    /*public int[] twoSum(int[] numbers, int target) {
        boolean notOk = true;
        int[] result = new int[2];

        for (int i = numbers.length - 1; i >= 0; --i) {
            if (numbers[i] <= target) {
                result[1] = i;
                break;
            }
        }
        do {
            for (int j = 0; j < result[1]; ++j) {
                if (numbers[j] + numbers[result[1]] == target) {
                    result[0] = j;
                    notOk = false;
                    break;
                }
            }
            result[1]--;
        } while (result[1] > 0 && notOk);
        result[1] += 2;
        result[0]++;
        return result;
    }

    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        result[0] = 0;
        result[1] = numbers.length - 1;
        do {
            if (numbers[result[0]] + numbers[result[1]] > target)
                result[1]--;
            else if (numbers[result[0]] + numbers[result[1]] < target) {
                result[0]++;
                result[1] = numbers.length - 1;
            } else {
                result[0]++;
                result[1]++;
                return result;
            }

        } while (result[0] < result[1]);
        return result;
    }

    public int[] twoSum2(int[] numbers, int target) {
        int temp = 0;
        boolean left = true;
        int[] result = new int[2];
        int sum = 0;
        result[0] = 0;
        result[1] = numbers.length - 1;

        do {
            sum = numbers[result[0]] + numbers[result[1]];
            if (sum > target && left == true) {
                while ((numbers[result[1]] == numbers[--result[1]]) && result[1] > result[0]) ;
            } else if (sum < target && left == false) {
                while ((numbers[result[1]] == numbers[++result[1]]) && result[1] > result[0]) ;
            } else if (sum == target) {
                result[0]++;
                result[1]++;
                return result;
            } else {
                while ((numbers[result[0]] == numbers[++result[0]]) && result[1] > result[0]) ;
                sum = numbers[result[0]] + numbers[result[1]];
                if (sum > target)
                    left = true;
                else if (sum < target)
                    left = false;
                else {
                    result[0]++;
                    result[1]++;
                    return result;
                }
            }

        } while (result[0] < result[1]);
        return result;
    }
    public int[] twoSum3(int[] numbers, int target)
    {
        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) return indice;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }
    public int[] twoSum4(int[] numbers, int target)
    {
        int b = 0;
        for (int i = 0;i< numbers.length - 2 ; ++i)
        {
            if ((b = binarySearch(i+1,numbers.length-1, target - numbers[i],numbers) )>  0)
            {
                return new int[]{++i, ++b};
            }
        }
        return null;
    }
    private int binarySearch(int start,int end,int tar,int[] numbers)
    {
        while(start <= end) {
            int p = (start + end)>>>1;
            if (numbers[p] == tar)
            {
                return p;
            }
            else if (numbers[p] > tar)
            {
                end = p -1;
            }
            else
            {
               start = p +1;
            }
        }
        return  -1;
    }
    */
    public int[] twoSum(int[] numbers, int target) {
        int[] indice = new int[2];
        if (numbers == null || numbers.length < 2) return indice;
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int v = numbers[left] + numbers[right];
            if (v == target) {
                indice[0] = left + 1;
                indice[1] = right + 1;
                break;
            } else if (v > target) {
                right --;
            } else {
                left ++;
            }
        }
        return indice;
    }
}