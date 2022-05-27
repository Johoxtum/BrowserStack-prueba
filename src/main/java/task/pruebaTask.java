package task;


import lombok.SneakyThrows;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import static net.serenitybdd.screenplay.Tasks.instrumented;
import static userinterfaces.Mapeo.*;

public class pruebaTask implements Task {


    @SneakyThrows
    @Override
    public <T extends Actor> void performAs(T actor) {



        actor.attemptsTo(
                Enter.keyValues("standard_user").into(USERNAME),
                Enter.keyValues("secret_sauce").into(PASSWORD),
                Click.on(BTN)

        );



    }

    public static pruebaTask informacion() {
        return instrumented(pruebaTask.class);

    }
}
