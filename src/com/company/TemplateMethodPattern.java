package com.company;

public class TemplateMethodPattern {
    public static void main(String[] args) {
        System.out.println("=====================");
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();
        System.out.println("=====================");
        HouseTemplate glassHouse = new GlassHouse();
        glassHouse.buildHouse();
        System.out.println("=====================");

    }
}
abstract class HouseTemplate{

    /* final ==> override 방지 */
    public final void buildHouse(){
        /* 템플릿에서 제공하는 주택공통 메소드 - 서브클래스에서 수정할 수 도 없음. */
        buildFoundation();
        buildWindow();

        /*각 서브클래스들이 커스터마이징하여 사용하는 메소드 - 메소드생성을 강제하기위해서 추상메소드로 구현 */
        buildPillars();
        buildWalls();
        buildBathroom();

    }
    /* 템플릿에서 제공하는 주택공통 메소드 - 서브클래스에서 수정할 수 도 없음. */
    private void buildFoundation() {
        System.out.println("주택공통 - 기초토목공사");
    }
    private void buildWindow(){
        System.out.println("주택공통 - 유리창문공사");
    }

    /* 각 서브클래스들이 커스터마이징하여 사용해야만 하는 메소드 - 메소드생성을 강제하기위해서 추상메소드로 구현 */
    protected abstract void buildWalls();
    protected abstract void buildPillars();

    /* 각 서브클래들이 커스터마이징하여 사용 할 수도 있고 기존템플릿을 사용 할 수도 있는 선택메소드 */
    protected void buildBathroom(){
        System.out.println("주택공통 - 기본화장실공사");
    }
}
class WoodenHouse extends HouseTemplate{

    @Override
    protected void buildWalls() {
        System.out.println("나무집전용 - 나무벽공사");
    }

    @Override
    protected void buildPillars() {
        System.out.println("나무집전용 - 나무기둥공사");
    }
}

class GlassHouse extends HouseTemplate{
    @Override
    protected void buildBathroom() {
        System.out.println("유리집전용 - 유리화장실공사");
    }

    @Override
    protected void buildWalls() {
        System.out.println("유리집전용 - 유리벽공사");
    }

    @Override
    protected void buildPillars() {
        System.out.println("유리집전용 - 유리기둥공사");
    }
}