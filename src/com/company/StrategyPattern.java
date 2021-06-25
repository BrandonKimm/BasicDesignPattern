package com.company;

public class StrategyPattern {
    public static void main(String[] args) {
        Robot taekwonV = new TaekwonV("TaekwonV");  // 태권 브이 객체 생성
        Robot atom = new Atom("Atom");              // 아톰 객체 생성

        taekwonV.setMovingStrategy(new WalkingStrategy());  // 이동 전략 설정 : 걷기
        taekwonV.setAttackStrategy(new MissileStrategy());  // 공격 전략 설정 : 미사일

        atom.setMovingStrategy(new FlyingStrategy());       // 이동 전략 설정 : 날기
        atom.setAttackStrategy(new PunchStrategy());        // 공격 전략 설정 : 펀치

        System.out.println("My name is " + taekwonV.getName());
        taekwonV.move();
        taekwonV.attack();

        System.out.println("My name is " + atom.getName());
        atom.move();
        atom.attack();
    }
}
abstract class Robot {

    private String name;
    private MovingStrategy movingStrategy;
    private AttackStrategy attackStrategy;

    public Robot(String name) {
        this.name = name;
    }

    public void move() {
        movingStrategy.move();
    }

    public void attack() {
        attackStrategy.attack();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MovingStrategy getMovingStrategy() {
        return movingStrategy;
    }

    public void setMovingStrategy(MovingStrategy movingStrategy) {
        this.movingStrategy = movingStrategy;
    }

    public AttackStrategy getAttackStrategy() {
        return attackStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy) {
        this.attackStrategy = attackStrategy;
    }
}
class Atom extends Robot {

    public Atom(String name) {
        super(name);
    }

}
class TaekwonV extends Robot {

    public TaekwonV(String name) {
        super(name);
    }

}
// 공격 인터페이스
interface AttackStrategy {
    public void attack();
}
// 펀치 공격 클래스 : 공격 인터페이스 구현
class PunchStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("I have strong punch and can attack with it.");
    }
}
// 미사일 공격 클래스 : 공격 인터페이스 구현
class MissileStrategy implements AttackStrategy {
    @Override
    public void attack() {
        System.out.println("I have Missile and can attack with it.");
    }
}
// 이동 인터페이스
interface MovingStrategy {
    public void move();
}
// 걷기 이동 클래스 : 이동 인터페이스 구현
class WalkingStrategy implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("I can only walk.");
    }
}
// 하늘 이동 클래스 : 이동 인터페이스 구현
class FlyingStrategy implements MovingStrategy {
    @Override
    public void move() {
        System.out.println("I can fly.");
    }
}