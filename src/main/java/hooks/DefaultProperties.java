package hooks;

import org.openqa.selenium.support.ui.WebDriverWait;

public interface DefaultProperties {

    int TIME_OUT = 10;
    String URL_BASE = "https://login.salesforce.com/";
    String NOME = "Ricardo Sousa";
    String NOME_CONTA = "teste";
    String EMAIL = "ricardoesousa@hotmail.com";
    String SENHA = "@flavio1979";
    String MSG_CONTA_ADICIONADA = "Conta \""+NOME_CONTA+"\" foi criado(a).";
    String MSG_CONTA_EXCLUIDA = "Conta \""+NOME_CONTA+"\" foi excluído. Desfazer";
    String MSG_CONTA_EXCLUIDA2 = "Account \""+NOME_CONTA+"\" foi excluído. Desfazer";

}
