package stepdefinitions;

import pages.HepsiburadaUrunEklemePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import utilities.ConfigurationReader;
import utilities.HepsiburadaUtility;

import java.util.ArrayList;

public class HepsiburadaUrunEklemeSteps {

    HepsiburadaUrunEklemePage pageObject = new HepsiburadaUrunEklemePage();
    String secilenUrunAdi;

    @Given("kullanici hepsiburadayi ziyaret eder")
    public void kullanici_hepsiburadayi_ziyaret_eder() {
        HepsiburadaUtility.getDriver().navigate().to("https://www.hepsiburada.com/");
    }

    @Given("kullanici {string} urun aramasi yapar")
    public void kullanici_urun_aramasi_yapar(String urun) {

        pageObject.aramaKutusu.sendKeys(urun);
        pageObject.araButonu.click();
    }

    @And("kullanici almak istedigi urunu secer")
    public void kullanici_almak_istedigi_urunu_secer() {
        HepsiburadaUtility.waitAndClickElement(pageObject.ikinciEleman,5);
    }

    @And("kullanici urunu iki farkli saticidan sepete ekler")
    public void kullanici_urunu_iki_farkli_saticidan_sepete_ekler() {
        ArrayList tabs = new ArrayList (HepsiburadaUtility.getDriver().getWindowHandles());
        HepsiburadaUtility.getDriver().switchTo().window((String) tabs.get(1));

        secilenUrunAdi = pageObject.secilenUrunAdi.getText();

        HepsiburadaUtility.waitAndClickElement(pageObject.ilkSaticidanEkle,5);
        HepsiburadaUtility.waitAndClickElement(pageObject.acilanPencereKapat,5);
        HepsiburadaUtility.waitAndClickElement(pageObject.ikinciSaticidanEkle,5);
    }

    @Then("kullanici sectigi urunleri sepetten dogrular")
    public void kullanici_sectigi_urunleri_sepetten_dogrular() {
        HepsiburadaUtility.waitAndClickElement(pageObject.sepetimButonu, 5);

        HepsiburadaUtility.waitForClickablility(pageObject.saticiSayisiDogrula,3);

        Assert.assertTrue(pageObject.saticiSayisiDogrula.getText().contains("2"));
        Assert.assertEquals(secilenUrunAdi, pageObject.urunAdiDogrula.get(0).getText());
        Assert.assertEquals(secilenUrunAdi, pageObject.urunAdiDogrula.get(1).getText());

        HepsiburadaUtility.closeDriver();
    }

    @Given("kullanici giris yapar")
    public void kullanici_giris_yapar() {
        Actions action = new Actions(HepsiburadaUtility.getDriver());
        action.moveToElement(pageObject.girisYapMenuHover).perform();

        HepsiburadaUtility.waitAndClickElement(pageObject.girisYapMenuButonu,5);
        HepsiburadaUtility.waitAndClickElement(pageObject.userNameTxt,5);
        pageObject.userNameTxt.sendKeys(ConfigurationReader.getProperty("hepsiburada_username"));
        HepsiburadaUtility.waitAndClickElement(pageObject.loginButton,5);
        HepsiburadaUtility.waitAndClickElement(pageObject.passwordTxt,5);
        pageObject.passwordTxt.sendKeys(ConfigurationReader.getProperty("hepsiburada_password"));
        HepsiburadaUtility.waitAndClickElement(pageObject.loginHesabaGirisButonu,5);
    }

    @Then("kullanici giris yapabildigini anasayfadan dogrular")
    public void kullanici_giris_yapabildigini_anasayfadan_dogrular() {
        HepsiburadaUtility.wait2(5);
        String hesabimYazisi = pageObject.hesabimYazisiDogrula.getText();
        Assert.assertEquals("Hesabım", hesabimYazisi);
        HepsiburadaUtility.closeDriver();
    }

}
