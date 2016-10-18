/*************************************************************************
    > File Name: Backtracking.java
    > Author: zst
    > Mail: fstone.zh@gmail.com 
    > Created Time: Wed 12 Oct 2016 09:33:45 PM CST
 ************************************************************************/
import java.util.*;
public class Combinations_NO77{

	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		System.out.println("n:"+n+"  k:"+k);
		ArrayList<Integer> temp = new ArrayList<>(n+1);
		List<List<Integer>> result = new ArrayList<>();
		dfs(result,temp,1,n+1,k);
		System.out.println("result size:" + result.size() +"\n"+result);
	}
	private static void dfs(List<List<Integer>> result, ArrayList<Integer> temp,int i,int n,int k){
		//先遍历N中第一个元素被选中的情况，然后再遍历第二个元素被选中而第一个没被选中的情况，依次下去穷尽所有可能。
		if(k<1){
			result.add(new ArrayList<>(temp));
			return ;
		}
		for(int no = i; no <(n-k+1);no++){ 
			temp.add(no);
			dfs(result,temp,no+1,n,k-1);
			temp.remove(temp.size()-1);
		}
	}
}
