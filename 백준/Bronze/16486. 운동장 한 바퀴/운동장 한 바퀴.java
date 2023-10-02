import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(Integer.parseInt(br.readLine())*2+3.141592*2*Integer.parseInt(br.readLine()));
	}
}