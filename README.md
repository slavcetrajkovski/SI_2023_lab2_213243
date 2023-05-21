# Втора лабораториска вежба по Софтверско инженерство
## Славко Трајковски, 213243
### Control Flow Graph
![CFG LABS2](https://github.com/slavcetrajkovski/SI_2023_lab2_213243/assets/126784837/f0608ce0-9938-4b27-9177-2d46eda974b3)
### Цикломатска комплексност
Со примена на формулата E-N+2, добив дека цикломатската комплексност е 10, каде E е бројот на ребра (34), a N бројот на јазли (26). => 34-26+2=10
### Every Branch
За која линија код ја обележуваат буквите, може да се види на (ЛИНК)

![image](https://github.com/slavcetrajkovski/SI_2023_lab2_213243/assets/126784837/1aedd19e-6f32-4cff-a7eb-814832c73927)

На сликата е прикажана матрица, со чија помош се претставени тестовите и соодветните гранки во кои влегуваат. (црвената боја означува дека гранката не е измината, а ѕвездата означува дека гранката е измината со соодветниот тест)

Со "test1" се изминуваат најголемиот дел од гранките. Само гранките: Q-R, T-Z, X-Y, A-B, C-E, F-P остануваат не изминати.

Со "test2" се изминува A-B и поради тоа што се фрла искучок во јазол B, тука функцијата завршува, што значи има потреба за нов тест случај, за да се изминат останатите гранки.

Со "test3" се изминува C-E, F-P и T-Z. По изминување на T-Z, функицијата завршува, поради "return statement" во јазолот Z. Q-R и X-Y остануваат не изминати.

Со "test4" и "test5" се изминуваат Q-R и X-Y соодветно.

//test1

        String password1 = "12345678";
        String email1 = "s.trajkovski02@yahoo.com";
        User user1 = new User(null, password1, email1);
        List<User> users = new ArrayList<>();
        users.add(user1);
        function(user1, users);
//test2

        String username2 = "Mila";
        String password2 = "12345@.!A";
        String email2 = "mila02yahoo.com";
        User user2 = new User(username2, password2, null);
        users.add(user2);
        function(user2, users);
//test3

        String username3 = "Stevo";
        String password3 = "12ccc345@.! A";
        String email3 = "stevoyahoo.com";
        User user3 = new User(username3, password3, email3);
        users.add(user3)
        function(user3, users);
//test4

        String username4 = "Iva";
        String password4 = "123";
        String email4 = "iva@yahoo.com";
        User user4 = new User(username4, password4, email4);
        users.add(user4);
        function(user4, users);
//test5

        String username5 = "Predrag";
        String password5 = "123!cdufhgr";
        String email5 = "predrag@yahoo.com";
        User user5 = new User(username5, password5, email5);
        users.add(user5);
        function(user5, users);
### Multiple Condition
![image](https://github.com/slavcetrajkovski/SI_2023_lab2_213243/assets/126784837/01c0a93f-9abe-4e62-8918-2ec67c5ba7ec)
1. user==null враќа "true", што значи дека останатите нема потреба да се проверуваат. (условот е исполнет, A-B)
2. user==null враќа "false", па сега се проверува user.getPassword()==null, што со дадениот тест ќе врати "true", и наредниот израз нема потреба да се проверува. (условот е исполнет, A-B)
3. user==null и user.getPassword()==null враќаат "false", па сега се проверува user.getEmail()==null, што со дадениот тест ќе врати "true", дополнителни изрази нема за проверување, што значи условот е исполнет. (A-B)
4. доколку сите вратат "false" условот не е исполнет и јазолот B се прескокнува. (A-C)
