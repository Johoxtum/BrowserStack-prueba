package interactions;


import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import task.pruebaTask;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Json implements Interaction {

    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {

        JSONParser parser = new JSONParser();

        Object obj = parser.parse(String.valueOf(new File("parallel.config.json")));
        JSONObject jsonObject = (JSONObject) obj;
        System.out.println("Aqui hay un json" + jsonObject);


    }
    public static Json data() {
        return instrumented(Json.class);

    }
}
