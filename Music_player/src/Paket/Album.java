package Paket;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
	
	private String name;
	private String artist;
	private ArrayList<Pesma> songs;
	
	public Album(String name, String artist)
	{
		this.name=name;
		this.artist=artist;
		this.songs=new ArrayList<Pesma>();
	}
	public Album()
	{}
	
	public Pesma findSong(String title)
	{
		for(Pesma p : songs)
		{
			if(p.getTitle().equals(title)) return p;
		}
		return null;
		
	}
	
	public boolean addSong(String title, double duration)
	{
		if(findSong(title) == null)
		{
			songs.add(new Pesma(title,duration));
			return true;
		}
		else
		{
			System.out.println("Song with name" + title + "already exists");
			return false;
		}
	}
	
    public boolean addToPlayList(int trackNumber, LinkedList<Pesma> PlayList)
    {
    	int index= trackNumber-1;
    	if(index > 0 && index <= this.songs.size())
    	{
    		PlayList.add(this.songs.get(index));
    		return true;
    	}
    	System.out.println("This album don't have song with tracknumber"+trackNumber);
    	return false;
    }
    
    //Overwritten method
    public boolean addToPlayList(String title, LinkedList<Pesma> PlayList)
    {
    	for(Pesma s: this.songs)
    	{
    		if(s.getTitle().equals(title))
    		{
    			PlayList.add(s);
    			return true;
    		}
    	}
    	System.out.println(title+" there is no such song in album");
    	return false;
    }
    

}
