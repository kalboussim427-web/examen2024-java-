package examen2024;

public class Serie extends  Content {
	private int nbEpisodes;
	private int dureeEpisode;
    
	public Serie(String title, String genre , boolean isFree , int nbEpisodes , int dureeEpisodes) {
		super(title, genre , isFree);
		this.nbEpisodes=nbEpisodes;
		this.dureeEpisode=dureeEpisodes;
	}
	public int getDuration() {
		return nbEpisodes * dureeEpisode;
	}
	public void afficheDetails() {
		System.out.println(" Serie - Titre : " + title +
				" , Genre : " + genre +
				" , Episodes : " + nbEpisodes +
				" , Duree episode : " + dureeEpisode +
				" min , Gratuit : " + isFree );
	}
}
