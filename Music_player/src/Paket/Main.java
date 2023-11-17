package Paket;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {

	public static ArrayList<Album> albums = new ArrayList<Album>();
	
	public static void main(String[] args) {

		Album album1= new Album("Black Album","Metallica");
		
		album1.addSong("Holier Than Thou", 4.0);
		album1.addSong("Nothing Else Matters", 4.6);
		album1.addSong("Wherever I May Roam", 6.2);
		album1.addSong("Sad But True", 4.2);
		
		albums.add(album1);
		
		Album album2= new Album("Led Zeppelin","Led Zeppelin");
		
		album2.addSong("You Shock Me", 3.0);
		album2.addSong("Black Mountain Side", 2.6);
		album2.addSong("Good Times Bad Times", 2.2);
		
		albums.add(album2);
		
		
		LinkedList<Pesma> playList_1= new LinkedList<>();
		
		albums.get(0).addToPlayList("Sad But True", playList_1);
		albums.get(0).addToPlayList("Holier Than Thou", playList_1);
		albums.get(0).addToPlayList("Wherever I May Roam", playList_1);
		albums.get(1).addToPlayList("You Shock Me", playList_1);
		albums.get(1).addToPlayList("Good Times Bad Times", playList_1);
		
		play(playList_1);

	}
	
	private static void play(LinkedList<Pesma> playList)
	{
		Scanner sc=new Scanner(System.in);
		boolean quit=false;
		boolean forward=true;
		ListIterator<Pesma> listIterator= playList.listIterator();
		
		
		if(playList.size()==0)
		{
			System.out.println("The playlist is empty");
		}
		else
		{
			System.out.println("Now playing - "+ listIterator.next().toString());
		    printMenu();
		}
		
		while(!quit)
		{
			int action=sc.nextInt();
			sc.nextLine();
			
			switch (action) {
			
			
			case 0: {
				
				System.out.println("Playlist is complited.");
				quit=true;
				break;
			}
			
			
			
            case 1: {
				
				if(!forward)
				{
					if(listIterator.hasNext())
					{
						listIterator.next();
					}
					forward=true;
				}
				if(listIterator.hasNext())
				{
					System.out.println("Now playing " + listIterator.next().toString() );
				}
				else 
				{
					System.out.println("Reach to the end of list");
					forward=false;
				}
				break;
			}
            
            
            
			case 2: {
				
				if(forward)
				{
					if(listIterator.hasPrevious())
					{
						listIterator.previous();
					}
					forward=false;
					
				}
				if(listIterator.hasPrevious())
				{
					System.out.println("Now playing " + listIterator.previous().toString() );
				}
				else 
				{
					System.out.println("You are at the first song.");
					forward=false;
				}
				break;
			}
			
			
			case 3: {
				
				if(forward)
				{
					if(listIterator.hasPrevious())
					{
						System.out.println("Now paying "+ listIterator.previous().toString());
						forward=false;
					}
					else {System.out.println("You are at the start of a list");}
					
						
				}
				else
				{
					if(listIterator.hasNext())
					{
						System.out.println("Now paying "+ listIterator.next().toString());
						forward=true;
					}
					else {System.out.println("You are at the end of a list");}
				}
				break;
			}
			
			
            case 4: {
				
				printList(playList);
				break;
			}
			
              
            case 5: {
  				
				printMenu();
				break;
			}
            
            case 6: {
  				
				if(playList.size() > 0)
				{
					listIterator.remove();
					if(listIterator.hasNext())
					{
						System.out.println("now playing" + listIterator.next().toString());
					}
					else if(listIterator.hasPrevious())
					{
						System.out.println("now playing" + listIterator.previous().toString());
					}
				}
				
			}
			
			
			
			
			} 
		}
		
		
	}
	
	private static void printMenu()
	{
		System.out.println("Available options\n press;");
		System.out.println("0 - to quit\n"+
                "1 - to play next song\n"+
                "2 - to play previous song\n"+
                "3 - to replay the current song\n"+
                "4 - list of all songs \n"+
                "5 - print all available options\n"+
                "6 - delete current song");
	}
	
	private static void printList(LinkedList<Pesma> playList)
	{
		Iterator<Pesma> iterator = playList.iterator();
		System.out.println("-----------------");
		
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
		System.out.println("-----------------");
	}

}
