package examen2024;

public class Main {
	public static void main(String[] args) {
        StreamingPlatform platform = new StreamingPlatform(10, 5);

        Content c1 = new Movie("Inception", "Sci-Fi", false, 148);
        Content c2 = new Serie("Stranger Things", "Thriller", false, 25, 50);
        Content c3 = new Movie("Charlie Chaplin", "Comedy", true, 75);
        Content c4 = new Serie("Friends", "Comedy", true, 236, 22);

        platform.addContent(c1);
        platform.addContent(c2);
        platform.addContent(c3);
        platform.addContent(c4);

        User user1 = new User("Imene", false);
        User user2 = new User("Jihene", true);

        platform.addUser(user1);
        platform.addUser(user2);

        System.out.println("--- Tests de lecture ---");
        try {
            platform.playContent(user1, "Inception");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            platform.playContent(user1, "Charlie Chaplin");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            platform.playContent(user2, "Stranger Things");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        try {
            platform.playContent(user2, "Friends");
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\n--- Recommandations pour Jihene ---");
        Content[] recs = platform.getRecommendations(user2);
        for (Content c : recs) {
            System.out.println("- " + c.getTitle());
        }
    }

}
