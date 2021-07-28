package Login;

//import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Assert;
import org.junit.Test;

public class LoginTest {

    @Test
    public void deve_IrParaPaginaDeCadastro_QuandoClicarNoBotao() {

        LoginPageObject paginaDeLogin = new LoginPageObject();

        paginaDeLogin.esperar();

        paginaDeLogin.entrarSingIn();

        Assert.assertTrue(paginaDeLogin.verificarPaginaSingIn());
    }
}
