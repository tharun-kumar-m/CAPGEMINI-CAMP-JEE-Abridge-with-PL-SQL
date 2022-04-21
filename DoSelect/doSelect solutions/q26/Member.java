package q26;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Member {
	public List<String> match(List<String> memberNames){
		Collections.sort(memberNames);
		memberNames.replaceAll(String::toUpperCase);
		return memberNames;
	}
	public long countA(List<String> memberNames){
		int n=memberNames.size();
		int count=0;
		for(int i=0;i<n;i++) {
			if(memberNames.get(i).startsWith("A")) {
				count++;
			}
		}
		return count;
	}
	public static void main(String[] args) {
		List<String> memberNames = new ArrayList<>(Arrays.asList("Amitabh", "Shekhar", "Aman", "Rahul",
		        "Shahrukh", "Salman", "Yana", "Lokesh"));
		Member member=new Member();
		System.out.println(member.countA(memberNames));
		System.out.println(member.match(memberNames));
	}
}
