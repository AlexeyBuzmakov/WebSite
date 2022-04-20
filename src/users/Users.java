package users;

public abstract class Users {
    private final String login;
    private final int password;

    public Users() {
        this.login = generationLogin();
        this.password = generationPassword();
    }

    public String getLogin() {
        return login;
    }

    public int getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "Users: " + " Login: " + login + " Password: " + password;
    }

    private String generationLogin() {
        char[]login = new char[6];
        for(int i = 0; i < login.length; i++) {
            login[i] = (char) (65 + Math.random() * 26);
        }
        return String.valueOf(login);
    }

    private int generationPassword() {
        return (int) (100000 + Math.random() * 899999);
    }
}
