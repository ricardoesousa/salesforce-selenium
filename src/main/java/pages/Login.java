package pages;

import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static org.junit.Assert.assertEquals;

public class Login extends DriverManagerFactory implements DefaultProperties {

    @FindBy(css="#username")
    private WebElement txtEmail;
    @FindBy(css="#password")
    private WebElement txtSenha;
    @FindBy(css="#Login")
    private WebElement btnEntrar;

    public void acessaAplicacao() {
        getDriver().get(URL_BASE);
        Report.tiraFotoDaTela();
    }

    public void entra(String email, String senha) {
        txtEmail.sendKeys(email);
        txtSenha.sendKeys(senha);
        Report.tiraFotoDaTela();
        btnEntrar.click();
    }






}
