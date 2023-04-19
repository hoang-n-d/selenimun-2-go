/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package org.hoangnd.guru99;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 *
 * @author ngusi
 */
public class Guru99Test {

    private static WebDriver myBrowser;

    //Chạy 1 lần duy nhất trước các hàm @test khác 
    //Thường dùng để khởi động các giá trị sẽ dùng trong các @Test
    @BeforeAll
    public static void setUpClass() {
        // Khởi động trình duyệt 1 lần 
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        myBrowser = new ChromeDriver();
        myBrowser.manage().window().maximize();
    }

    @Test// test case check the logi process with valid account
    // input username = mngr451760; pass =Adyjuby ;
    // Kết quả hy vọng là Manger ID : <username>
    public void checkLoginGivenValidAccountShowTheWelcomeMassage() throws InterruptedException {
        myBrowser.get("https://demo.guru99.com/v4/index.php");
        String username = "mngr451760";
        String password = "Adyjuby";
        //tìm các tag của hình login
        WebElement txtUsername = myBrowser.findElement(By.cssSelector("input[name='uid']"));
        txtUsername.sendKeys(username);

        WebElement txtPassword = myBrowser.findElement(By.xpath("//input[@name='password']"));
        txtPassword.sendKeys(password);

        WebElement btLogin = myBrowser.findElement(By.xpath("//input[@name='btnLogin']"));
        btLogin.submit();
        // sau cú nhấn thì app sẽ chuyển sang trang mới 
        // myBrowser chứa dom mới do trang mới được tỉa về - trang Welcome
        //ode java của mình ko chờ trang chạy xong mà cứ thế chạy tiếp lệnh sau 
        //tìm tag trong treang mới nên có khả năng exception do lag chưa tải xong 
        // do đó phải có thao tác wait chờ trang mới tải xong rồi mới tìm tag
        Thread.sleep(3000);// wait chờ trang tải xong 

        WebElement welcomeMessage = myBrowser.findElement(By.cssSelector("tr[class='heading3'] td"));
        //lvltd iconMsg chính là cái thẻ td chứa chuỗi Manger ID : <username>
        // NẾU THÀNH CÔNG THÌ ĐÂY LÀ CON BOT CÀO DATA - CRAWLER
        //System.out.println("Welcome message"+ welcomeMessage.getText());
        assertEquals("Manger Id : " + username, welcomeMessage.getText());
        Thread.sleep(10000);
    }

    //hàm này chạy 1 lần duy nhất, sau khi chạy tất cả các 
    // hàm @Test khác đã chạy xong 
    //
    @AfterAll
    public static void tearDownClass() {
        myBrowser.quit();

    }

}
