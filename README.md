# Втора лабораториска вежба по Софтверско инженерство
## Славко Трајковски, 213243
### Control Flow Graph
![CFG LABS2](https://github.com/slavcetrajkovski/SI_2023_lab2_213243/assets/126784837/f0608ce0-9938-4b27-9177-2d46eda974b3)
### Цикломатска комплексност
Со примена на формулата P+1, каде што P=10, а P е бројот на предикатни јазли, цикломатската комплексност изнесува 10+1=11.
### Every Branch
За која линија код ја обележуваат буквите, може да се види на (https://github.com/slavcetrajkovski/SI_2023_lab2_213243/blob/master/src/main/java/mk/finki/ukim/SILab2.java)

![image](https://github.com/slavcetrajkovski/SI_2023_lab2_213243/assets/126784837/f1e159cb-81e9-48a6-b632-d053e260d5f4)

На сликата е прикажана матрица, со чија помош се претставени тестовите и соодветните гранки во кои влегуваат. (црвената боја означува дека гранката не е измината, а ѕвездата означува дека гранката е измината со соодветниот тест)

Со "test1" се изминуваат најголемиот дел од гранките. Само гранките: Q-R, T-Z, X-Y, A-B, C-E, F-P остануваат не изминати.

Со "test2" се изминува A-B и поради тоа што се фрла искучок во јазол B, тука функцијата завршува, што значи има потреба за нов тест случај, за да се изминат останатите гранки.

Со "test3" се изминува C-E, F-P и T-Z. По изминување на T-Z, функицијата завршува, поради "return statement" во јазолот Z. Q-R и X-Y остануваат не изминати.

Со "test4" и "test5" се изминуваат Q-R и X-Y соодветно.

Test 1
        
        List<User> users = new ArrayList<>();
        String password1 = "12345678";
        String email1 = "s.trajkovski02@yahoo.com";
        User user1 = new User(null, password1, email1);
        users.add(user1);
        assertEquals(false, SILab2.function(user1, users));

Test 2
        
        String username2 = "Mila";
        String password2 = "12345@.!A";
        String email2 = null;
        User user2 = new User(username2, password2, email2);
        users.add(user2);
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

Test 3
        
        String username3 = "Stevo";
        String password3 = "12ccc345@.! A";
        String email3 = "stevoyahoo.com";
        User user3 = new User(username3, password3, email3);
        users.add(user3);
        assertEquals(false, SILab2.function(user3, users));

Test 4
        
        String username4 = "Iva";
        String password4 = "123";
        String email4 = "iva@yahoo.com";
        User user4 = new User(username4, password4, email4);
        users.add(user4);
        assertEquals(false, SILab2.function(user4, users));

Test 5 (за овој тест user5, не е ставен во листата на users, па затоа се очекува true во assertEquals)
        
        String username5 = "Predrag";
        String password5 = "123!cdufhgr";
        String email5 = "predrag@yahoo.com";
        User user5 = new User(username5, password5, email5);
        assertEquals(true, SILab2.function(user5, users));
        
### Multiple Condition
![image](https://github.com/slavcetrajkovski/SI_2023_lab2_213243/assets/126784837/6402ee7c-6cf8-4a91-81ea-ddb6ca03d4e0)
1. user==null враќа "true", што значи дека останатите нема потреба да се проверуваат. (условот е исполнет, A-B)
2. user==null враќа "false", па сега се проверува user.getPassword()==null, што со дадениот тест ќе врати "true", и наредниот израз нема потреба да се проверува. (условот е исполнет, A-B)
3. user==null и user.getPassword()==null враќаат "false", па сега се проверува user.getEmail()==null, што со дадениот тест ќе врати "true", дополнителни изрази нема за проверување, што значи условот е исполнет. (A-B)
4. доколку сите вратат "false" условот не е исполнет и јазолот B се прескокнува. (A-C)
 
Test 1

        List<User> users = new ArrayList<>();
        User user1 = null;
        RuntimeException ex;
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user1, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

Test 2

        User user2 = new User("Slavko", null, "s@yahoo.com");
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user2, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

Test 3

        User user3 = new User("Slavko", "12345", null);
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(user3, users));
        assertTrue(ex.getMessage().contains("Mandatory information missing!"));

Test 4

        User user4 = new User("Stojko", "12345@.!A", "stojkovic@gmail.com");
        assertTrue(SILab2.function(user4, users));
