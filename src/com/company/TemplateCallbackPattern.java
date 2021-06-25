package com.company;

public class TemplateCallbackPattern {
    public static void main(String[] args) {
        Soldier soldier = new Soldier();
        soldier.runContext("슈슈슝 슈슝");
    }
}
interface Strategy{
    public abstract void runStrategy();
}
class Soldier{
    public void runContext(String weaponSound){
        System.out.println("전투 시작!");
        executeWeapon(weaponSound).runStrategy();
        System.out.println("전투 끝!");
    }

    private Strategy executeWeapon(String weaponSound) {
        return new Strategy() {
            @Override
            public void runStrategy() {
                System.out.println(weaponSound);
            }
        };
    }
}
