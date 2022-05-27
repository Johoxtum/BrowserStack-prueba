package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Mapeo {

    public static final Target USERNAME = Target.the("Usuario")
            .located(By.id("user-name"));
    public static final Target PASSWORD = Target.the("Usuario")
            .located(By.id("password"));
    public static final Target BTN = Target.the("Usuario")
            .located(By.id("login-button"));
    public static final Target validation = Target.the("Usuario")
            .located(By.xpath("//*[@id=\"header_container\"]/div[2]/span"));

}
