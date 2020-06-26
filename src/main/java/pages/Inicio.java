package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import report.Report;

import static org.junit.Assert.assertEquals;

public class Inicio {

    @FindBy(css="span .uiImage")
    private WebElement btnMostrarPerfil;

    @FindBy(css="h1 a[class=profile-link-label]")
    private WebElement lblNomeDoUsuario;

    @FindBy(css="div.slds-icon-waffle")
    private WebElement btnIniciadorDeAplicativos;

    @FindBy(xpath="//p[text()='Serviço']")
    private WebElement lnkServico;

    public boolean validaEntrada(String valEntrada) {
        btnMostrarPerfil.click();
        String txtNomeDoUsuario = lblNomeDoUsuario.getText();
        assertEquals(valEntrada, txtNomeDoUsuario);
        Report.tiraFotoDaTela();
        return true;
    }

    public void acessaServico (){
        btnIniciadorDeAplicativos.click();
        lnkServico.click();
        Report.tiraFotoDaTela();
    }



}

