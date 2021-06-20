package com.company;

/**
 * 미리보기를 먼저 보여주고
 * 실제이미지를 보여줘야할 시점에 실제이미지 객체생성해하고 보여주는 예제
 * **/
public class ProxyPattern {
    public static void main(String[] args) {
        Image image1 = new Proxy_Image("test1.png");
        Image image2 = new Proxy_Image("test2.png");

        image1.displayImage();
        image1.displayImage();
        System.out.println();
        image2.displayImage();
    }
}
interface Image {
    void displayImage();
}

class Real_Image implements Image {

    private String fileName;

    public Real_Image(String fileName) {
        this.fileName = fileName;
        loadFromDisk(fileName);
    }

    private void loadFromDisk(String fileName) {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void displayImage() {
        System.out.println("Displaying " + fileName);
    }
}
class Proxy_Image implements Image {
    private Real_Image realImage;
    private String fileName;

    /*실제로는 생성자일수도 생성자 내의 별도의 초기화함수라던지 다양하게 활용*/
    public Proxy_Image(String fileName) {
        System.out.println(fileName +  "Preview DisPlaying (이게 프록시패턴의 핵심) " );
        this.fileName = fileName;
    }

    @Override
    public void displayImage() {
        if (realImage == null) {
            realImage = new Real_Image(fileName);
        }
        realImage.displayImage();
    }
}
