package Cadastro;

import Login.LoginPageObject;

import org.json.simple.parser.ParseException;
import org.junit.Before;
import org.junit.Test;


import java.io.IOException;

public class CadastroTestJson {

    LoginPageObject paginaDeLogin = new LoginPageObject();

    @Before
    public void before(){

        paginaDeLogin.esperar();
        //paginaDeLogin.entrarSingIn();
    }

    @Test
    public void preencher_cadastro() throws IOException, ParseException {

        //Cria o parse de tratamento
//        JSONParser parser = new JSONParser();
//
//        try {
//            FileReader reader = new FileReader("src/test/resources/MassaDeDados.json");
//            Object obj = parser.parse(reader);
//            arrJ = (JSONArray) obj;
//            System.out.println(arrJ);
//
//            arrJ.forEach( user -> parseUserObject( (JSONObject) user ) );
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    private void parseUserObject(JSONObject user) {
//
//
//        String genero = (String) user.get("Genero");
//        System.out.println(genero);
//
//        String fnome = (String) user.get("Fnome");
//        System.out.println(fnome);
//
//        String pass = (String) user.get("Pass");
//        System.out.println(pass);
//
//    }

        CadastroPageObject telaDeCadastro = paginaDeLogin.entrarSingIn_For_Json_Files();
        telaDeCadastro.realizar_cadastro_Json_File();

    }

//    private void parseUserObject(JSONObject user) {
//        CadastroPageObject telaDeCadastro = paginaDeLogin.entrarPaginaCadastro_Json(user);
//        telaDeCadastro.completar_cadastro_Json(user);
//    }
}
