package examen2024;

public class Movie extends Content {
	private int duration;

	public Movie(String title, String genre , boolean isFree , int duration) {
		super(title, genre, isFree);
		this.duration = duration;
	}
public int getDuration() {
	return duration;
}
public void afficheDetails() {
	System.out.println(" Movie - Titre : " + title + " , Genre : " + genre + " , Durée : " + duration + " min , Gratuit : " + isFree);
}
}
