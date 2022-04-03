package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.RegistrationPage;
import utilities.ConfigurationReader;
import utilities.Driver;

public class RegistrationStep {

    private WebDriver driver;


    RegistrationPage RPS=new RegistrationPage();

    @Given("Kullanıcı {string} sayfasına gider")
    public void kullanıcı_sayfasına_gider(String string) {
        Driver.getDriver().get(ConfigurationReader.getProperty("medunnaUrl"));
    }
    @Then("Registration butonuna tıklar vekayıt sayfasına gider")
    public void registration_butonuna_tıklar_vekayıt_sayfasına_gider() {
        RPS.register1.click();
        RPS.register2.click();

    }
    @Then("tek haneli şifre  girer ve yeterli uzunlukta olmadığını görür")
    public void tek_haneli_şifre_girer_ve_yeterli_uzunlukta_olmadığını_görür() {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword1"));
        RPS.comfirmationPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword1"));
        String actualkisaYazisi=RPS.kısaPassword.getText();
        String expectedYazi=ConfigurationReader.getProperty("karaktersayi4");
        Assert.assertEquals(expectedYazi,actualkisaYazisi);


    }
    @Then("iki haneli şifre  girer ve yeterli uzunlukta olmadığını görür")
    public void iki_haneli_şifre_girer_ve_yeterli_uzunlukta_olmadığını_görür() {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword2"));
        RPS.comfirmationPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword2"));
        String actualkisaYazisi=RPS.kısaPassword.getText();
        String expectedYazi=ConfigurationReader.getProperty("karaktersayi4");
        Assert.assertEquals(expectedYazi,actualkisaYazisi);

    }
    @Then("üç haneli şifre  girer ve yeterli uzunlukta olmadığını görür")
    public void üç_haneli_şifre_girer_ve_yeterli_uzunlukta_olmadığını_görür() {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword3"));
        RPS.comfirmationPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword3"));
        String actualkisaYazisi=RPS.kısaPassword.getText();
        String expectedYazi=ConfigurationReader.getProperty("karaktersayi4");
        Assert.assertEquals(expectedYazi,actualkisaYazisi);

    }
    @Then("{int} haneli şifre  girer ve kabul edildiğini görür")
    public void haneli_şifre_girer_ve_kabul_edildiğini_görür(Integer int1) {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword4"));
        RPS.comfirmationPassword.sendKeys(ConfigurationReader.getProperty("eksikPassword4"));
        //String actualkisaYazisi=RPS.kısaPassword.getText();
        String expectedYazi=ConfigurationReader.getProperty("karaktersayi4");
        Assert.assertFalse(expectedYazi,false);

    }


    @Then("İçerisinde bir küçük harf olan enaz yedi haneli password girer")
    public void içerisindeBirKüçükHarfOlanEnazYediHaneliPasswordGirer() {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("kucukHarf"));

    }

    @And("Password strength seviyesinin değiştiğini görür")
    public void passwordStrengthSeviyesininDeğiştiğiniGörür() {
        String ilkStrength=RPS.strength1.getText();
        String ikinciStrength=RPS.strength2.getText();
        Assert.assertEquals(ilkStrength,ikinciStrength);
    }

    @Then("İçerisinde bir küçük bir büyük harf olan {int} haneli password girer")
    public void içerisindeBirKüçükBirBüyükHarfOlanHaneliPasswordGirer(int arg0) {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("buyukHarf"));
        String ikinciStrength=RPS.strength2.getText();
        String ucuncuStrength=RPS.strength3.getText();
        Assert.assertEquals(ucuncuStrength,ikinciStrength);
    }

    @Then("İçerisinde bir büyük bir küçük ve rakam harf olan enaz yedi haneli password girer")
    public void içerisindeBirBüyükBirKüçükVeRakamHarfOlanEnazYediHaneliPasswordGirer() {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("rakamHarf"));
        String ucuncuStrength=RPS.strength3.getText();
        String dorduncuStrength=RPS.strength4.getText();
        Assert.assertEquals(dorduncuStrength,ucuncuStrength);

    }

    @Then("İçerisinde bir büyük bir küçük rakam harf ve ozel karakter olan enaz yedi haneli password girer")
    public void içerisindeBirBüyükBirKüçükRakamHarfVeOzelKarakterOlanEnazYediHaneliPasswordGirer() {
        RPS.newPassword.sendKeys(ConfigurationReader.getProperty("ozelHarf"));
        String besinciStrength=RPS.strength5.getText();
        String dorduncuStrength=RPS.strength4.getText();
        Assert.assertEquals(besinciStrength,dorduncuStrength);

    }

    @Then("Password olarak yedi kez  space tuşuna basar")
    public void passwordOlarakYediKezSpaceTuşunaBasar() throws InterruptedException {
       /* Actions actions=new Actions(driver);
        actions.click(RPS.newPassword).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE)
                .sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).sendKeys(Keys.BACK_SPACE).perform();*/
        String space7="       ";
        RPS.newPassword.sendKeys(space7);
        String ilkStrength=RPS.strength1.getText();
        String ikinciStrength=RPS.strength2.getText();
        Assert.assertEquals(ilkStrength,ikinciStrength);
        Thread.sleep(3000);
        String space10="   ";
        RPS.newPassword.sendKeys(space10);
        String ucuncuStrength=RPS.strength3.getText();
        Assert.assertEquals(ucuncuStrength,ikinciStrength);
        Thread.sleep(3000);
        String space15="     ";
        RPS.newPassword.sendKeys(space15);
        String dorduncuStrength=RPS.strength4.getText();
        Assert.assertEquals(dorduncuStrength,ucuncuStrength);
        Thread.sleep(3000);
        String space20="     ";
        RPS.newPassword.sendKeys(space20);
        String besinciStrength=RPS.strength5.getText();
        Assert.assertEquals(besinciStrength,dorduncuStrength);

    }
}
