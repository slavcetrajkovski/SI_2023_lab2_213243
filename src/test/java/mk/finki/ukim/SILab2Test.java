package mk.finki.ukim;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SILab2Test {

    @Test
    void everyBranchTest() {
        List<User> users = new ArrayList<>();

        //test1
        String password1 = "12345678";
        String email1 = "s.trajkovski02@yahoo.com";
        User user1 = new User(null, password1, email1);
        users.add(user1);
        assertFalse(SILab2.function(user1, users));

        //test2
        String username2 = "Mila";
        String password2 = "12345@.!A";
        String email2 = null;
        User user2 = new User(username2, password2, email2);
        users.add(user2);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test3
        String username3 = "Stevo";
        String password3 = "12ccc345@.! A";
        String email3 = "stevoyahoo.com";
        User user3 = new User(username3, password3, email3);
        users.add(user3);
        assertFalse(SILab2.function(user3, users));

        //test4
        String username4 = "Iva";
        String password4 = "123";
        String email4 = "iva@yahoo.com";
        User user4 = new User(username4, password4, email4);
        users.add(user4);
        assertFalse(SILab2.function(user4, users));

        //test5
        String username5 = "Predrag";
        String password5 = "123!cdufhgr";
        String email5 = "predrag@yahoo.com";
        User user5 = new User(username5, password5, email5);
        assertTrue(SILab2.function(user5, users));
    }

    @Test
    void multipleConditionsTest(){
        List<User> users = new ArrayList<>();

        //test1
        User user1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test2
        User user2 = new User("Slavko", null, "s@yahoo.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test3
        User user3 = new User("Slavko", "12345", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

        //test4
        User user4 = new User("Stojko", "12345@.!A", "stojkovic@gmail.com");
        users.add(user4);
        assertFalse(SILab2.function(user4, users));
    }
}