import java.io.BufferedReader;
import java.io.InputStreamReader;import java.util.HashSet;
import java.io.FileInputStream;

public class Main_백준_1316_그룹단어체커 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_그룹단어체커.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int c = Integer.parseInt(br.readLine());		int tot = c;		for(int z=0;z<c;z++) {			boolean[] alpha = new boolean[26];			String s = br.readLine();			for(int k=0;k<s.length();k++) {				if(!alpha[s.charAt(k)-'a']) {					char cur = s.charAt(k);					int p;					for(p=k+1;p<s.length();p++) {						if(cur!=s.charAt(p)) {							break;						}					}					k=p-1;					alpha[s.charAt(k)-'a']=true;				}				else {					tot--;					break;				}			}		}				System.out.println(tot);
	}

}
