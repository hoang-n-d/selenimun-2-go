package org.hoangnd.selenium.main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

/**
 *
 * @author ngusi
 */

public class Selenium2Go {

    public static void main(String[] args) throws InterruptedException {
        
        System.out.println("please wait 3 second to launch the browser");
        Thread.sleep(3000);
        
        playGoogleSearch();
        
        
    }
    
    //Test case : search 
     public static void playGoogleSearch() throws InterruptedException {
        
        
        WebDriver myBrowser;//new sau
        
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang=en-GB");
        
        myBrowser = new ChromeDriver(opt);
      
        myBrowser.manage().window().maximize();
        
        myBrowser.get("https://youtube.com");
        
        WebElement searchBox = myBrowser.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("Một con vịt");
        searchBox.submit();
        
        Thread.sleep(50000); 
       
        myBrowser.quit();
        
        
    }


    
    //Test case : open google.come in Chrome
    //mở bằng code ko dùng sức người :)
    public static void playWithGoogle() throws InterruptedException {
        
        //Khai báo biến object đại diện biến trình duyệt 
        //Biến này s4 trỏ vào vùng new 1 Trình Duyệt (Tab ) khi chạy là 1 object đc new trong RAM
        WebDriver myBrowser;//new sau
        
        
        // Báo vs máy ảo java rằng có 1 driver cần đc cài đặt 
        //Driver là những class dùng để điều khiển 1 thứ gì đó 
        //Ví dụ 1 card đồ họa mới thì cần 1 loạt class để điều khiễn nó 
        //Báo cho máy ảo java cần tải nạp các class điều khiển trình duyệt 
        //Các class này nằm trong tập tin ChromeDriver.exe mình vừa copy vào dự án
        
        //Câu lệnh dưới đây trương đương câu lệnh 
        // class.forName("...")
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        
        //Ta thiết lập 1 số thông số cho cái trình duyệt trc hi mở nó lên
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito");
        opt.addArguments("--lang=ja-JP");
        
        // Gọi trinh duye6t5xua61t hiện tức là new 1 object 
        myBrowser = new ChromeDriver(opt);
        
        
        // MDefault 1/2 màn hình , ta phải mở rộng ra
        //Mybrowser đang trỏ vào tabChrome đ mở ra 
        // . gọi các hành động của tab Chrome , gọi modethod của object'
        // Mún browser làm gì thì gọi myBrowser;
        myBrowser.manage().window().maximize();
        
        
        //CHUYỆN CHÍNH NẰM Ở ĐÂY!!!
        myBrowser.get("https://youtube.com");
        //trình duyệt ơi mở tao cái trong này 
        
        Thread.sleep(50000); // app mình peding lại trong 5s
        
        // dọn rác sau khi xong trình duyệt 
        myBrowser.quit();
        
        
    }
}
