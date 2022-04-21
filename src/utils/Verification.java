package utils;

public class Verification {
    private static int currentUser;

    public static int getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(int currentUser) {
        Verification.currentUser = currentUser;
    }
}
