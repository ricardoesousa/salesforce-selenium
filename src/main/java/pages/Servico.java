package pages;

import driver.DriverManagerFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

public class Servico extends DriverManagerFactory {

    @FindBy(xpath = "//a[span[text()='Contas']]")
    private WebElement lnkContas;

    public static void jsClick(WebElement elem) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].click();", elem
        );
    }

    public void acessaConta () {
        jsClick(lnkContas);
        Report.tiraFotoDaTela();
    }

}

