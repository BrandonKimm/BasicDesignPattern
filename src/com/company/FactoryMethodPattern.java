package com.company;

public class FactoryMethodPattern {
    public static void main(String[] args) {

        RobotFactory rf = new SuperRobotFactory();
        Robot r = rf.createRobot("super");
        Robot r2 = rf.createRobot("power");

        System.out.println(r.getName());
        System.out.println(r2.getName());

        RobotFactory mrf = new ModifiedSuperRobotFactory();
        Robot r3 =  mrf.createRobot("com.company.SuperRobot");
        Robot r4 =  mrf.createRobot("com.company.PowerRobot");

        System.out.println(r3.getName());
        System.out.println(r4.getName());
    }
}

abstract class Robot {
    public abstract String getName();
}
class SuperRobot extends Robot {
    @Override
    public String getName() {
        return "SuperRobot";
    }
}
class PowerRobot extends Robot {
    @Override
    public String getName() {
        return "PowerRobot";
    }
}

abstract class RobotFactory {
    abstract Robot createRobot(String name);
}
class SuperRobotFactory extends RobotFactory {
    @Override
    Robot createRobot(String name) {
        switch( name ){
            case "super": return new SuperRobot();
            case "power": return new PowerRobot();
        }
        return null;
    }
}
/* 리플렉션 제네릭 와일드카드 키워드 숙지하기! */
class ModifiedSuperRobotFactory extends RobotFactory {
    @Override
    Robot createRobot(String name) {
        try {
            // forName 메소드 만드로도 수퍼로봇의 객체는 초기화 되고.. 클래..어쩌고저쩌고.. 꽤 복잡하네...
            //Class 클래스는 클래스들의 정보(클래스의 필드, 메서드, 클래스의 종류(인터페이스 등))를 담는 메타 클래스이고 JVM은 이 Class 클래스를 통해 클래스들에 대한 정보를 로드한다.
            //return (Robot) (Object)Class.forName(name); 이렇게 해볼까도 했는데 엔피이 발생 ㅠㅠ
            Class<?> cls = Class.forName(name);
            Object obj = cls.newInstance();

            return (Robot) obj;
        } catch (Exception e) {
            return null;
        }
    }
}