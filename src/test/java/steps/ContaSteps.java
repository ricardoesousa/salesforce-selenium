package steps;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import driver.DriverManagerFactory;
import hooks.DefaultProperties;
import org.openqa.selenium.support.PageFactory;
import pages.*;

import static org.junit.Assert.assertTrue;

public class ContaSteps extends DriverManagerFactory implements DefaultProperties {

    private Login login = PageFactory.initElements(getDriver(), Login.class);
    private Inicio inicio = PageFactory.initElements(getDriver(), Inicio.class);
    private Servico servico = PageFactory.initElements(getDriver(), Servico.class);
    private Contas contas = PageFactory.initElements(getDriver(), Contas.class);

    @Dado("eu esteja logado e tenha acessado a página de contas")
    public void euEstejaLogadoETenhaAcessadoAPáginaDeContas() {
        login.acessaAplicacao();
        login.entra(EMAIL, SENHA);
        inicio.acessaServico();
        servico.acessaConta();
    }

    @Quando("eu criar uma nova conta com dados válidos")
    public void euCriarUmaNovaContaComDadosVálidos() {
        contas.adicionaConta(NOME_CONTA);
    }

    @Entao("eu devo ver uma mensagem indicando que a conta foi cadastrada com sucesso")
    public void euDevoVerUmaMensagemIndicandoQueAContaFoiCadastradaComSucesso() {
        assertTrue(contas.validaAdicionarConta(MSG_CONTA_ADICIONADA));

    }

    @Quando("eu selecionar e excluir uma conta")
    public void euSelecionarUmaContaEExcluirUmaConta() {
        contas.excluiConta(NOME_CONTA);
    }

    @Entao("eu devo ver uma mensagem indicando que a conta foi excluida com sucesso")
    public void euDevoVerUmaMensagemIndicandoQueAContaFoiExcluidaComSucesso() {
        assertTrue(contas.validaExcluirConta(MSG_CONTA_EXCLUIDA, MSG_CONTA_EXCLUIDA2));
    }
}
