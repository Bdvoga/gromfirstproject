package lesson9.Ex2SearchUser;

import java.util.Arrays;

public class Demo {
    // Создаем массивы пользователей
    static User user = new User(12345, "Mike", "111");
    static User user1 = new User(1232, "Dock", "222");
    static User user2 = new User(2134, "Tom", "333");

    //Объединяем массивы пользователей в новый массив
    static User[] users = {user, user1, user2};

    // Создаем объект из массивов
    static UserRepository userRepository = new UserRepository(users);

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getUserNames()));
        System.out.println(Arrays.toString(getUserIds()));
        //long id = 12345;
        System.out.println(getUserNameById(1232));
    }

    //Метод для получения массива имен
    public static String[] getUserNames() {
        String[] arrayName = new String[userRepository.getUsers().length]; // Создаем массив для имен пользователей

        // заполняем массив id пользователей
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            arrayName[i] = userRepository.getUsers()[i].getName();
        }

        return arrayName;
    }

    //Метод для получения массива id
    public static long[] getUserIds() {
        long[] arrayId = new long[userRepository.getUsers().length]; // Создаем массив для имен пользователей

        // заполняем массив id пользователей
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            arrayId[i] = userRepository.getUsers()[i].getId();
        }

        return arrayId;
    }

    // Метода для получ. имени по ид
    public static String getUserNameById(long id) {
        String str = "";
        for (int i = 0; i < userRepository.getUsers().length; i++) {
            if (userRepository.getUsers()[i].getId() == id)
                str = userRepository.getUsers()[i].getName();
        }
        return str;
    }

}
