package q50;

import java.util.ArrayList;
import java.util.List;

public class Song {
	String name;
    String runTime;
    String singer;
	public Song(String name, String runTime, String singer) {
		super();
		this.name = name;
		this.runTime = runTime;
		this.singer = singer;
	}
	public String getName() {
		return name;
	}
	public String getRunTime() {
		return runTime;
	}
	public String getSinger() {
		return singer;
	}
    public static void main(String[] args) {
    	PlayList lis=new PlayList();
    	Song s1=new Song("Venom", "4:58","Eminem");
    	Song s2=new Song("Venom", "4:58","Eminem");
    	System.out.println(lis.playSong("3:58",s1));
    	System.out.println(lis.addSong(s1));
    	System.out.println(lis.addSong(s2));
	}
}
class PlayList{
	List<Song> songs = new ArrayList<>();
	public String playSong(String currentTime,Song song) {
		String tempRunTime=""+song.getRunTime();
		tempRunTime=tempRunTime.replaceAll("[^a-zA-Z0-9]","");
		currentTime=currentTime.replaceAll("[^a-zA-Z0-9]","");
		if(tempRunTime.compareTo(currentTime)==-1)
			return "Song replayed";
		return "Song is being continued";
	}
	public String addSong(Song song) {
		for(Song l:songs) {
			if(l.getName().equals(song.getName())&&l.getSinger().equals(song.getSinger()))
				return "Cannot be added";
		}
		songs.add(song);
		return "Added";
	}
}