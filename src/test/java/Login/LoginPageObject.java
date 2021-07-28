package Login;

import Cadastro.CadastroPageObject;
import com.desafioseleniumV2.desafioseleniumV2.PageObject;

import org.openqa.selenium.By;

import java.util.concurrent.TimeUnit;

public class LoginPageObject extends PageObject {

    private static final String URL_LOGIN = "http://automationpractice.com/index.php";

    public LoginPageObject() {
        super(null);
        this.browser.navigate().to(URL_LOGIN);
    }

    public void esperar() {
        browser.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    public void entrarSingIn() {

        browser.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();

    }

    public boolean verificarPaginaSingIn() {

        String url = browser.getCurrentUrl();

        return url.equals("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        //return browser.getCurrentUrl().
                //contains("http://automationpractice.com/index.php?controller=authentication&back=my-account");

    }

    public CadastroPageObject entrarPaginaCadastro(String mail) {

        browser.findElement(By.cssSelector("#email_create")).sendKeys(mail);
        browser.findElement(By.cssSelector("#SubmitCreate")).click();
        return new CadastroPageObject(browser);
    }

    public CadastroPageObject entrarSingIn_For_Json_Files() {

        browser.findElement(By.cssSelector("#header > div.nav > div > div > nav > div.header_user_info > a")).click();
        return new CadastroPageObject(browser);
    }
}
