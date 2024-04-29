import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		String monthStr = st.nextToken();
		int day = Integer.parseInt(st.nextToken().replace(",", ""))-1;
		int year = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(st.nextToken(), ":");
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		int month = 0;	
		int sum = 0;
		switch(monthStr) {
		case "January":
			month = 1;
			break;
		case "February":
			month = 2;
			break;
		case "March":
			month = 3;
			break;
		case "April":
			month = 4;
			break;
		case "May":
			month = 5;
			break;
		case "June":
			month = 6;
			break;
		case "July":
			month = 7;
			break;
		case "August":
			month = 8;
			break;
		case "September":
			month = 9;
			break;
		case "October":
			month = 10;
			break;
		case "November":
			month = 11;
			break;
		case "December":
			month = 12;
			break;
		}
		switch (month) {
        case 12: sum += 43200;
        case 11: sum += 44640;
        case 10: sum += 43200;
        case 9: sum += 44640;
        case 8: sum += 44640;
        case 7: sum += 43200;
        case 6: sum += 44640;
        case 5: sum += 43200;
        case 4: sum += 44640;
        case 3: sum += 40320;
        case 2: sum += 44640;
        }
		int time = 525600;
		if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
			time = 527040;
			if (month >= 3) {
				sum += 1440;
			}
		}
		sum += day*1440 + hour*60 + minute;
		System.out.println((double)sum/time*100);
	}
}