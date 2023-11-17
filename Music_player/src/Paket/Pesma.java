package Paket;

public class Pesma {
   
   String title;
   double duration;
   
   public Pesma(String title, double duration)
   {
	   this.title=title;
	   this.duration=duration;
   }
   public Pesma()
   {}
   
   public String getTitle()
   {
	   return title;
   }
   public double getDuration()
   {
	   return duration;
   }
   
   @Override
	public String toString() {
		return "Song{ "+" Title-" + title+"  |  Duration="+duration+"min }";
	}

}
   

