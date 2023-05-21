# Втора лабораториска вежба по Софтверско инженерство
## Славко Трајковски, 213243
### Control Flow Graph
![CFG LABS2](https://github.com/slavcetrajkovski/SI_2023_lab2_213243/assets/126784837/d65ae75f-41ab-41c8-a846-1c2bb8623195)
### Цикломатска комплексност
Со примена на формулата E-N+2, добив дека цикломатската комплексност е 8, каде E е бројот на ребра (31), a N бројот на јазли (25). => 31-25+2=8
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
        function(user1, users);
//test2

        String username2 = "Mila";
        String password2 = "12345@.!A";
        String email2 = "mila02yahoo.com";
        User user2 = new User(username2, password2, null);
        function(user2, users);
//test3

        String username3 = "Stevo";
        String password3 = "12ccc345@.! A";
        String email3 = "stevoyahoo.com";
        User user3 = new User(username3, password3, email3);
        function(user3, users);
//test4

        String username4 = "Iva";
        String password4 = "123";
        String email4 = "iva@yahoo.com";
        User user4 = new User(username4, password4, email4);
        function(user4, users);
//test5

        String username5 = "Predrag";
        String password5 = "123!cdufhgr";
        String email5 = "predrag@yahoo.com";
        User user5 = new User(username5, password5, email5);
        function(user5, users);



