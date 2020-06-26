package pages;

import driver.DriverManagerFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import report.Report;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;


public class Contas extends DriverManagerFactory {

    @FindBy(css = "a[title='Contas']")
    private WebElement lnkContas;

    @FindBy(css = "a[title='Novo(a)']")
    private WebElement btnNovaConta;

    @FindBy(css = "input[data-interactive-lib-uid='6']")
    private WebElement txtNomeDaConta;

    @FindBy(css = "button[title='Salvar e criar']")
    private WebElement btnSalvarECriar;

    @FindBy(css = ".toastMessage")
    private WebElement msgContaFoiCriada;

    private WebElement lnkNomeDaConta;

    @FindBy(css = "a[title='Mostrar mais 7 ações']")
    private WebElement btnMostrarMais7Acoes;

    @FindBy(css = "a[title='Excluir']")
    private WebElement btnExcluirConta;

    @FindBy(xpath = "//button/span[text()='Excluir']")
    private WebElement btnConfirmarExcluir;

    @FindBy(css = ".toastMessage")
    private WebElement msgContaFoiExcluida;

    WebDriverWait wait = new WebDriverWait(driver,10000);

    public void adicionaConta (String nomeDaConta){
        btnNovaConta.click();
        txtNomeDaConta.sendKeys(nomeDaConta);
        Report.tiraFotoDaTela();
        btnSalvarECriar.click();
    }

    public boolean validaAdicionarConta(String valAdicionarConta) {
        wait.until(ExpectedConditions.visibilityOf(msgContaFoiCriada));
        String txtContaFoiCriada = msgContaFoiCriada.getText();
        assertEquals(valAdicionarConta, txtContaFoiCriada);
        Report.tiraFotoDaTela();
        return true;
    }

    public void excluiConta (String nomeDaConta){
        lnkNomeDaConta = driver.findElement(By.cssSelector("a[title='"+nomeDaConta+"']"));
        lnkNomeDaConta.click();
        try {
            btnMostrarMais7Acoes.click();
        } catch (org.openqa.selenium.StaleElementReferenceException ex)
        {
            btnMostrarMais7Acoes.click();
        }
        btnExcluirConta.click();
        Report.tiraFotoDaTela();
        btnConfirmarExcluir.click();
    }

    public boolean validaExcluirConta(String valExcluirConta, String valExcluirConta2) {
        wait.until(ExpectedConditions.visibilityOf(msgContaFoiExcluida));
        String txtContaFoiExcluida = msgContaFoiExcluida.getText();
        assertThat(txtContaFoiExcluida, anyOf(is(valExcluirConta), is(valExcluirConta2)));
        return true;
    }
}
