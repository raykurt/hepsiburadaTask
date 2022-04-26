package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.HepsiburadaUtility;

import java.util.List;

public class HepsiburadaUrunEklemePage {

    public HepsiburadaUrunEklemePage(){
        PageFactory.initElements(HepsiburadaUtility.getDriver(),this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement aramaKutusu;

    @FindBy(xpath = "//div[@class='SearchBoxOld-buttonContainer']")
    public WebElement araButonu;

    @FindBy(xpath = "(//li[@class='productListContent-item'])[2]")
    public WebElement ikinciEleman;

    @FindBy(id = "product-name")
    public WebElement secilenUrunAdi;

    @FindBy(xpath = "(//div[@class='addToCart'])[1]")
    public WebElement ilkSaticidanEkle;

    @FindBy(xpath = "(//div[@class='addToCart'])[2]")
    public WebElement ikinciSaticidanEkle;

    @FindBy(xpath = "//a[@class='checkoutui-Modal-2iZXl']")
    public WebElement acilanPencereKapat;

    @FindBy(id = "shoppingCart")
    public WebElement sepetimButonu;

    @FindBy(xpath = "//div[@class='delete_all_2uTds']")
    public WebElement saticiSayisiDogrula;

    @FindBy(xpath = "//div[@class='product_name_3Lh3t']/a")
    public List<WebElement> urunAdiDogrula;

    @FindBy(id = "myAccount")
    public WebElement girisYapMenuHover;

    @FindBy(id = "login")
    public WebElement girisYapMenuButonu;

    @FindBy(id = "txtUserName")
    public WebElement userNameTxt;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "txtPassword")
    public WebElement passwordTxt;

    @FindBy(id = "btnEmailSelect")
    public WebElement loginHesabaGirisButonu;

    @FindBy(xpath = "//span[@class='sf-OldMyAccount-PhY-T']")
    public WebElement hesabimYazisiDogrula;

}
