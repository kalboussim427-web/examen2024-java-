package examen2024;

public class StreamingPlatform {
	private Content[] contents;
    private User[] users;
    private int nbContents;
    private int nbUsers;
    
    public StreamingPlatform(int maxContents, int maxUsers) {
        contents = new Content[maxContents];
        users = new User[maxUsers];
        nbContents = 0;
        nbUsers = 0;
    }

    public void addContent(Content content) {
        if (nbContents < contents.length) {
            contents[nbContents] = content;
            nbContents++;
        }
    }

    public void addUser(User user) {
        if (nbUsers < users.length) {
            users[nbUsers] = user;
            nbUsers++;
        }
    }

    public Content findContent(String title) throws ContentNotFoundException {
        for (int i = 0; i < nbContents; i++) {
            if (contents[i].getTitle().equalsIgnoreCase(title)) {
                return contents[i];
            }
        }
        throw new ContentNotFoundException("Contenu introuvable : " + title);
    }

    public void playContent(User user, String title) throws ContentNotFoundException, AccessDeniedException {
        Content c = findContent(title);
        if (!user.canPlay(c)) {
            throw new AccessDeniedException("Accès refusé : abonnement requis pour " + title);
        }
        c.play();
        user.addWatchedContent(c);
    }

    public Content[] getRecommendations(User user) {
        String[] userGenres = user.getWatchedGenres();
        Content[] recommendations = new Content[10];
        int count = 0;

        for (int i = 0; i < nbContents && count < 10; i++) {
            Content c = contents[i];
            boolean matchGenre = false;
            for (String g : userGenres) {
                if (c.getGenre().equalsIgnoreCase(g)) {
                    matchGenre = true;
                    break;
                }
            }

            boolean alreadyWatched = false;
            Content[] watched = user.getWatchedContent();
            for (int j = 0; j < user.getNbWatched(); j++) {
                if (watched[j] == c) {
                    alreadyWatched = true;
                    break;
                }
            }

            if (matchGenre && !alreadyWatched) {
                recommendations[count] = c;
                count++;
            }
        }

  
        Content[] finalRecs = new Content[count];
        for (int i = 0; i < count; i++) {
            finalRecs[i] = recommendations[i];
        }
        return finalRecs;
    }
}


