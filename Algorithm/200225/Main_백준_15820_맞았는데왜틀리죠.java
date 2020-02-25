import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main_백준_15820_맞았는데왜틀리죠 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_맞았는데왜틀리죠.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int STC = Integer.parseInt(s[0]);
		int SysTC = Integer.parseInt(s[1]);
		
		boolean stc = true;
		boolean systc = true;
		
		for(int z=0;z<STC;z++) {
			String[] ss = br.readLine().split(" ");
			if(!ss[0].equals(ss[1])) {
				stc=false;
				break;
			}
		}
		for(int z=0;z<SysTC;z++) {
			String[] ss = br.readLine().split(" ");
			if(!ss[0].equals(ss[1])) {
				systc=false;
				break;
			}
		}
		
		if(!stc) System.out.println("Wrong Answer");
		else if(stc && !systc) System.out.println("Why Wrong!!!");
		else if(stc && systc) System.out.println("Accepted");

	}

}
