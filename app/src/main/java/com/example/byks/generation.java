package com.example.byks;

public class generation {
    public int array[]=new int [4];
    private boolean find (int a, int array[]) {
        for (int i=0; i<4; i++) {
            if (array[i]==a) return true;
        }
        return false;
    }
    public generation() {
        for (int i=0; i<4; i++) {
            while (true) {
                int temp=(int) (Math.random()*9);
                if ((i==0 && temp==0) || (find(temp, this.array))) {
                    continue;
                }
                else {
                    this.array[i]=temp;
                    break;
                }
            }
        }
    }
    private int[] Refactor(String n) {
        int chislo = Integer.parseInt(n);
        int arr[] = new int[4];
        arr[0] = chislo / 1000;
        arr[1] = (chislo / 100) % 10;
        arr[2] = (chislo / 10) % 10;
        arr[3] = chislo % 10;
        return arr;
    }
    public int x=this.array[0]*1000+this.array[1]*100+this.array[2]*10+this.array[3];
    public String guess(String n) {
        int arr[]=Refactor(n);
        int a = 0;
        int b = 0;
        /*
        int array[] = new int[4];
        array[0] = this.x / 1000;
        array[1] = (this.x / 100) % 10;
        array[2] = (this.x / 10) % 10;
        array[3] = this.x % 10; */
        for (int i = 0; i < 4; i++) {
            for (int g = 0; g < 4; g++) {
                if (arr[i] == this.array[g] && i == g) a++;
                else if (arr[i] == this.array[g] && i != g) b++;
            }
        }
        if (a == 4) return "Вы угадали!";
        else
            return "Правильно: " + Integer.toString(a) + "\n" + "Неправильно: " + Integer.toString(b);
    }
    public String Hint() {
        int a=(int) (Math.random()*3);
        return "В числе есть цифра: "+ this.array[a];
    }
}
