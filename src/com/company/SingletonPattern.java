package com.company;

public class SingletonPattern {
    public static void main(String[] args) {
        /* private 생성자라서 직접생성 불가능 */
        //Singleton singleton = new Singleton();

        Singleton singletonA = Singleton.getInstance();
        Singleton singletonB = Singleton.getInstance();

        // 3개의 참조변수의 주소값이 모두 같음을 확인
        System.out.println(Singleton.singletonObject);
        System.out.println(singletonA);
        System.out.println(singletonB);
    }
}
class Singleton{
    static  Singleton singletonObject;

    private Singleton(){ }

    public static  Singleton getInstance(){
        if(singletonObject == null)
            singletonObject = new Singleton();
        return singletonObject;
    }
}