package org.example.designpattern.singleton;

// Subject interface
interface Image {
    void display();
}

// RealSubject
class RealImage implements Image {
    private String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadImageFromDisk();
    }

    private void loadImageFromDisk() {
        System.out.println("Loading image from disk: " + filename);
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filename);
    }
}

// Proxy
class ImageProxy implements Image {
    private RealImage realImage;
    private String filename;

    public ImageProxy(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

// Client code
public class ProxyPattern {
    public static void main(String[] args) {
        // Using the real image directly
        Image realImage = new RealImage("example.jpg");
        realImage.display();

        System.out.println("----------");

        // Using the proxy to control access to the real image
        Image proxyImage = new ImageProxy("example.jpg");
        proxyImage.display();
    }
}
