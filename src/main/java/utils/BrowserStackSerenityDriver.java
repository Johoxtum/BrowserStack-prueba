package utils;


import java.io.FileReader;
import java.net.URL;
import java.util.Iterator;

import org.json.JSONTokener;
import lombok.SneakyThrows;
import org.json.JSONArray;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import net.thucydides.core.webdriver.DriverSource;

public class BrowserStackSerenityDriver implements DriverSource {

    @SneakyThrows
    public WebDriver newDriver() {
        EnvironmentVariables environmentVariables = SystemEnvironmentVariables.createEnvironmentVariables();

        String username = System.getenv("BROWSERSTACK_USERNAME");
        if (username == null) {
            username = (String) environmentVariables.getProperty("browserstack.user");
        }

        String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
        if (accessKey == null) {
            accessKey = (String) environmentVariables.getProperty("browserstack.key");
        }

        String environment = System.getProperty("environment");
        environment = environmentVariables.getProperty("environment.parallel_2.name");
        DesiredCapabilities capabilities = new DesiredCapabilities();

        try {

            FileReader reader = new FileReader("src/test/resources/conf/parallel.conf.json");


            JSONTokener tokener = new JSONTokener(reader);

            JSONObject jsnobject = new JSONObject(tokener);
            JSONArray jsonArray = jsnobject.getJSONArray("environments");

            for (int i = 0; i < jsonArray.length(); i++) {

                JSONObject jsonObject = new JSONObject();
                jsonObject = (JSONObject) jsonArray.get(i);
                System.out.println(jsonObject.get("os_version"));

                capabilities.setCapability("os_version" ,jsonObject.get("os_version").toString());
                capabilities.setCapability("device",jsonObject.get("device").toString() );
                capabilities.setCapability("real_mobile",jsonObject.get("real_mobile").toString());
                capabilities.setCapability("browserstack.local", jsonObject.get("browserstack.local").toString());
                this.initialProperties(environmentVariables, capabilities, environment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
            return new RemoteWebDriver(new URL("https://" + username + ":" + accessKey + "@"
                    + environmentVariables.getProperty("browserstack.server") + "/wd/hub"), capabilities);
    }

    public boolean takesScreenshots() {
        return true;
    }


    private void initialProperties(EnvironmentVariables environmentVariables, DesiredCapabilities capabilities, String environment) {

        Iterator it = environmentVariables.getKeys().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();

            if (key.equals("browserstack.user") || key.equals("browserstack.key")
                    || key.equals("browserstack.server")) {
                continue;
            } else if (key.startsWith("bstack_")) {
                capabilities.setCapability(key.replace("bstack_", ""), environmentVariables.getProperty(key));
                if (key.equals("bstack_browserstack.local")
                        && environmentVariables.getProperty(key).equalsIgnoreCase("true")) {
                    System.setProperty("browserstack.local", "true");
                }
            } else if (environment != null && key.startsWith("environment." + environment)) {
                capabilities.setCapability(key.replace("environment." + environment + ".", ""),
                        environmentVariables.getProperty(key));
                if (key.equals("environment." + environment + ".browserstack.local")
                        && environmentVariables.getProperty(key).equalsIgnoreCase("true")) {
                    System.setProperty("browserstack.local", "true");
                }
            }
        }

    }
}
