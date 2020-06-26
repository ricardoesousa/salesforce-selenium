package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.support.PageFactory;
import pages.*;
import report.Report;

import static org.junit.Assert.assertTrue;

public class LoginSteps extends DriverManagerFactory implements DefaultProperties {

    private Inicio inicio = PageFactory.initElements(getDriver(), Inicio.class);
    private Login login = PageFactory.initElements(getDriver(), Login.class);

    @Dado("eu tenha acessado a aplicação e esteja na página de login")
    public void euTenhaAcessadoAAplicaçãoEEstejaNaPáginaDeLogin() {
        login.acessaAplicacao();
    }

    @Quando("eu logar no sistema com dados válidos")
    public void euLogarNoSistemaComDadosVálidos() {
        login.entra(EMAIL,SENHA);
    }

    @Entao("eu devo acessar a home e ver uma mensagem com o nome de usuário")
    public void euDevoAcessarAHomeEVerUmaMensagemComONomeDeUsuário() {
        assertTrue(inicio.validaEntrada(NOME));
    }

}
