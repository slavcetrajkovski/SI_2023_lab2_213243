package mk.finki.ukim;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class User {
    String username;
    String password;
    String email;

    public User(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username){
        this.username=username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}

public class SILab2 {

    public static boolean function(User user, List<User> allUsers) { //START
        if (user == null || user.getPassword() == null || user.getEmail() == null) { //A
            throw new RuntimeException("Mandatory information missing!"); //B
        }

        if (user.getUsername() == null) { //C
            user.setUsername(user.getEmail()); //D
        }

        int same = 1; //E
        if (user.getEmail().contains("@") && user.getEmail().contains(".")) { //F
            same = 0; //G
            for (int i = 0; i < allUsers.size(); i++) { //H, I, J
                User existingUser = allUsers.get(i); //K
                if (existingUser.getEmail() == user.getEmail()) { //L
                    same += 1; //M
                }
                if (existingUser.getUsername() == user.getUsername()) { //N
                    same += 1; //O
                }
            }
        }

        String specialCharacters = "!#$%&'()*+,-./:;<=>?@[]^_`{|}"; //P
        String password = user.getPassword(); //P
        String passwordLower = password.toLowerCase(); //P

        if (passwordLower.contains(user.getUsername().toLowerCase()) || password.length() < 8) { //Q
            return false; //R
        } else { //S
            if (!passwordLower.contains(" ")) { //T
                for (int i = 0; i < specialCharacters.length(); i++) { //U, V, W
                    if (password.contains(String.valueOf(specialCharacters.charAt(i)))) { //X
                        return same == 0; //Y
                    }
                }
            }
        }
        return false; //Z
    } //END
}