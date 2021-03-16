package com.company;

import javax.sql.rowset.spi.TransactionalWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<tower> Towers=new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Начинаем игру в башни, для начала создайте башню!");
        String answer;
        answer=scan.next();

        if(answer.equals("Создать"))
        {
            System.out.println("Итак, вы приобретаете новую башню.");

            Towers.add(tower.addTower(scan));
        }
        while (true)
        {
            System.out.println("Выберите действие:");
            System.out.println("1. Построить новую башню");
            System.out.println("2. Добавить оружие на башню");
            System.out.println("3. Информация о нужной башне");
            System.out.println("4. Закончить игру");
            int choose=scan.nextInt();
            switch (choose)
            {
                case 1:
                    Towers.add(tower.addTower(scan));
                    break;
                case 2:
                    System.out.println("Введите название башни:");
                    Towers.get(chooseTower(scan.next())).addWeapon(scan);
                    //Towers.get(0).addWeapon(scan);
                    System.out.println("Оружие успешно установлено!");
                    break;
                case 3:
                    System.out.println("Введите название башни:");
                    //Towers.get(chooseTower(scan.next())).showInfo();
                    Towers.get(chooseTower(scan.next())).showInfo();
                    break;
                case 4:
                    System.out.println("Пока!");
                    System.exit(0);

                default:
                    System.out.println("Введите корректный вариант!");
                    break;
            }
        }

    }
    static int chooseTower(String nameTower)
    {
        int numOfTower=0;
        for (int i = 0; i < Towers.size(); i++) {
            if(Towers.get(i).equals(nameTower))
                numOfTower=i;
        }
        return numOfTower;
    }

}

class tower
{

    String name;
    String wall;
    int height;
    ArrayList<weapon> weapons=new ArrayList<>();
    tower()
    {
        this.name="Башня №"+ counts.countOfTower;
        this.wall="Кирпич";
        this.height=100;
        counts.countOfTower++;
    }
    tower(String name,String wall,int height)
    {
        this.name=name;
        this.wall=wall;
        this.height=height;

    }
    static tower addTower(Scanner scan)
    {

        tower tempTower=new tower();
        System.out.println("Введите название башни:");
        tempTower.name=scan.next();
        System.out.println("Введите высоту башни:");
        tempTower.height=scan.nextInt();
        System.out.println("Введите материал стен башни:");
        tempTower.wall=scan.next();

        return tempTower;
    }
    void addWeapon(Scanner scan)
    {
        System.out.println("Введите название оружия");
        String nameWeap=scan.next();
        System.out.println("Введите количество патронов до перезарядки");
        int ammoWeap=scan.nextInt();
        System.out.println("Введите время перезарядки");
        int timeReloadWeap=scan.nextInt();
        this.weapons.add(new weapon(nameWeap,ammoWeap,timeReloadWeap));
    }

    void showInfo()
    {
        System.out.println("Название башни: "+this.name+" Материал: "+this.wall+" Высота: "+this.height);
        System.out.println("Оружия:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println(weapons.get(i).name);
        }
        System.out.println("\n");
    }
    static class weapon
    {
        String name;
        int ammo;
        int timeReload;
        weapon()
        {

        }
        weapon(String name,int ammo,int timeReload)
        {
            this.name=name;
            this.ammo=ammo;
            this.timeReload=timeReload;
        }
        void shoot()
        {
            this.ammo--;
            if(ammo==0)
            {
                reloading();
            }

        }
        void reloading()
        {
           int count=0;
           count+=this.timeReload;
        }

    }
}