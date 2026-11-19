package examen2024;

public class User {
	private String name;
	private boolean isSubscribed;
	private Content[] watchedContent;
	private int nbWatched;
	private final int MAX_WATCHED = 100;
	
	public User(String name , boolean isSubscribed) {
		this.name = name;
		this.isSubscribed = isSubscribed;
		this.watchedContent = new Content [MAX_WATCHED];
		this.nbWatched = 0;
		
	}
	public boolean canPlay(Content content) {
		if(content.isFree()) {
			return true;
		}
		return isSubscribed;
	}
	
	public void addWatchedContent(Content content) {
		if (nbWatched < MAX_WATCHED ) {
			watchedContent[nbWatched] = content;
			nbWatched++;
		}
	}
	
	public String[] getWatchedGenres() {
        String[] tempGenres = new String[nbWatched];
        int count = 0;
        for (int i = 0; i < nbWatched; i++) {
            String g = watchedContent[i].getGenre();
            boolean exists = false;
            for (int j = 0; j < count; j++) {
                if (tempGenres[j].equalsIgnoreCase(g)) {
                    exists = true;
                    break;
                }
            }
            if (!exists) {
                tempGenres[count] = g;
                count++;
            }
        }
        String[] uniqueGenres = new String[count];
        for (int i = 0 ; i < count ; i++) {
        	uniqueGenres[i] = tempGenres[i];
        }
        return uniqueGenres;
    }

    public String getName() {
        return name;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public Content[] getWatchedContent() {
        return watchedContent;
    }

    public int getNbWatched() {
        return nbWatched;
    }

}
