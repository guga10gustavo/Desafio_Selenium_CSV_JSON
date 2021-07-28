package Cadastro;


import com.desafioseleniumV2.desafioseleniumV2.PageObject;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.concurrent.TimeUnit;

public class CadastroPageObject extends PageObject {

    public CadastroPageObject(WebDriver browser) {
        super(browser);
    }

    public void esperar() {
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }


    public void completar_Formulario(String genero, String fnome, String lnome, String mail, String pass, String diaNas, String mesNas, String anoNas) {

        esperar();
        if(genero.equals("M")|| genero.equals("m")){
            browser.findElement(By.cssSelector("#id_gender1")).click();
        }
        else {
            browser.findElement(By.cssSelector("#id_gender2")).click();
        }
        browser.findElement(By.cssSelector("#customer_firstname")).sendKeys(fnome);
        browser.findElement(By.cssSelector("#customer_lastname")).sendKeys(lnome);
        browser.findElement(By.cssSelector("#email")).clear();
        browser.findElement(By.cssSelector("#email")).sendKeys(mail);
        browser.findElement(By.cssSelector("#passwd")).sendKeys(pass);
        //______________________________________________________________________________________
        //JEITO 1 DE PREENCHER CAMPOS DE DATA/MES/ANO,O MES TEM QUE SER ESCRITO O NOME NA MASSA DE DADOS
//        int dia = Integer.parseInt(diaNas) + 1;
//        browser.findElement(By.cssSelector("#days > option:nth-child("+dia+")")).click();
//        String mes = mesNas ;
//        int mesValue=1;
//        switch (mes){
//            case "Janeiro":
//                mesValue=2;
//                break;
//            case "Fevereiro":
//                mesValue=3;
//                break;
//            case "Marco":
//                mesValue=4;
//                break;
//            case "Abril":
//                mesValue=5;
//                break;
//            case "Maio":
//                mesValue=6;
//                break;
//            case "Junho":
//                mesValue=7;
//                break;
//            case "Julho":
//                mesValue=8;
//                break;
//            case "Agosto":
//                mesValue=9;
//                break;
//            case "Setembro":
//                mesValue=10;
//                break;
//            case "Outubro":
//                mesValue=11;
//                break;
//            case "Novembro":
//                mesValue=12;
//                break;
//            case "Dezembro":
//                mesValue=13;
//                break;
//        }
//        browser.findElement(By.cssSelector("#months > option:nth-child("+mesValue+")")).click();
//        int anoAtual = Year.now().getValue();
//        int anoValue = anoAtual - Integer.parseInt(anoNas) + 2;
//        browser.findElement(By.cssSelector("#years > option:nth-child("+anoValue+")")).click();
        //____________________________________________________________________________________________

        //____________________________________________________________________________________________
        //JEITO 2 DE PREENCHER OS CAMPOS DATA/MES/ANO,O MES DEVE ESTAR ESCRITO EM NUMERO NA MASSA DE DADOS
        Select selectDay = new Select(this.browser.findElement(By.id("days")));
        selectDay.selectByValue(diaNas);
        Select selectMeses = new Select(this.browser.findElement(By.id("months")));
        selectMeses.selectByValue(mesNas);
        Select selectAno = new Select(this.browser.findElement(By.id("years")));
        selectAno.selectByValue(anoNas);
        //____________________________________________________________________________________________


        browser.navigate().to("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    public void realizar_cadastro_Json_File() throws IOException, ParseException {

        JSONParser parser = new JSONParser();

        JSONArray  jsonArray = (JSONArray) parser.parse
                (new FileReader("src/test/resources/MassaDeDados.json"));

        esperar();
        for(Object dados : jsonArray){
            JSONObject user = (JSONObject) dados;
            String mail = (String) user.get("Mail");
            browser.findElement(By.cssSelector("#email_create")).sendKeys(mail);
            browser.findElement(By.cssSelector("#SubmitCreate")).click();
            esperar();
            String genero = (String) user.get("Genero");
            //System.out.println(genero);
            if(genero.equals("M")|| genero.equals("m")){
                browser.findElement(By.cssSelector("#id_gender1")).click();
            }
            else {
                browser.findElement(By.cssSelector("#id_gender2")).click();
            }
            String fnome = (String) user.get("Fnome");
            browser.findElement(By.cssSelector("#customer_firstname")).sendKeys(fnome);
            //System.out.println(fnome);
            String pass = (String) user.get("Pass");
            browser.findElement(By.cssSelector("#passwd")).sendKeys(pass);
            //System.out.println(pass);
            browser.navigate().
                    to("http://automationpractice.com/index.php?controller=authentication&back=my-account");

        }
    }

    public String url(){
        return browser.getCurrentUrl();
    }

    public void voltar(){
        browser.navigate().back();
    }
}
