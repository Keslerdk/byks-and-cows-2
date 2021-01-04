package com.example.byks;

public class generation {
    public int x = (1000 + (int) (Math.random() * 8999));

    public String guess(String n) {
        int chislo = Integer.parseInt(n);
        int a = 0;
        int b = 0;
        int arr[] = new int[4];
        arr[0] = chislo / 1000;
        arr[1] = (chislo / 100) % 10;
        arr[2] = (chislo / 10) % 10;
        arr[3] = chislo % 10;
        int array[] = new int[4];
        array[0] = this.x / 1000;
        array[1] = (this.x / 100) % 10;
        array[2] = (this.x / 10) % 10;
        array[3] = this.x % 10;
        for (int i = 0; i < 4; i++) {
            for (int g = 0; g < 4; g++) {
                if (arr[i] == array[g] && i == g) a++;
                else if (arr[i] == array[g] && i != g) b++;
            }
        }
        if (a == 4) return "Вы угадали!";
        else
            return "Правильно: " + Integer.toString(a) + "\n" + "Неправильно: " + Integer.toString(b);
    }
}
