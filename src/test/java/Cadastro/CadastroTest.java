package Cadastro;

import Login.LoginPageObject;
import org.easetech.easytest.annotation.DataLoader;
import org.easetech.easytest.annotation.Param;
import org.easetech.easytest.runner.DataDrivenTestRunner;
//import org.junit.jupiter.api.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(DataDrivenTestRunner.class)
@DataLoader(filePaths = "MassaDeDados.csv")
public class CadastroTest {

    public static final LoginPageObject paginaDeLogin = new LoginPageObject();
    @Before
    public void before(){

        paginaDeLogin.esperar();
        paginaDeLogin.entrarSingIn();
    }

    @Test
    public void preencher_cadastro(@Param(name = "Genero") String Genero,
            @Param(name = "Fnome") String Fnome, @Param(name = "Lnome") String Lnome,
            @Param(name = "Mail") String Mail,@Param(name = "Pass") String Pass,
            @Param(name = "End") String End, @Param(name = "City") String City,
            @Param(name = "State") String State,@Param(name = "CEP") String CEP,
            @Param(name = "MobilePhone") String MobilePhone,
            @Param(name = "EndRef") String EndRef,@Param(name = "DiaNas") String DiaNas,
            @Param(name = "MesNas") String MesNas,@Param(name = "AnoNas") String AnoNas){

        CadastroPageObject telaDeCadastro = paginaDeLogin.entrarPaginaCadastro(Mail);
        telaDeCadastro.esperar();
        telaDeCadastro.completar_Formulario(Genero,Fnome,Lnome,Mail,Pass,DiaNas,MesNas,AnoNas);


    }

}
