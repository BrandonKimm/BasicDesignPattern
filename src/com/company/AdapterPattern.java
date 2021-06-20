package com.company;

/**
 *
 * **/
public class AdapterPattern {

    public static void main(String[] args) {
        MediaPlayer player  = new MP3();

        player.play("file.MP3");

        player = new FormatAdapter(new MP4());
        player.play("file.MP4");

        player = new FormatAdapter(new MKV());
        player.play("file.MKV");

    }
}
interface MediaPlayer{
    void play(String fileName);
}
interface MediaPackage{
    void playFile(String fileName);
}

class MP3 implements MediaPlayer {
    @Override
    public void play(String fileName) {
        System.out.println("Playing MP3 File : " + fileName);
    }
}

class MP4 implements MediaPackage{
    @Override
    public void playFile(String fileName) {
        System.out.println("Playing MP4 File : " +fileName );
    }
}
class MKV implements MediaPackage{
    @Override
    public void playFile(String fileName) {
        System.out.println("Playing MKV File : " +fileName );
    }
}

/* AdapterPattern */
class FormatAdapter implements MediaPlayer{
    private MediaPackage media;

    public FormatAdapter(MediaPackage media) {
        this.media = media;
    }
    @Override
    public void play(String fileName) {
        System.out.print("Using FormatAdapter-->  ");
        media.playFile(fileName);
    }
}