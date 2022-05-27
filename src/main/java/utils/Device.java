package utils;

import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Device {

    private EnvironmentVariables environmentVariables;
    private DesiredCapabilities capabilities;

    public Device(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    @Override
    public String toString() {
        return "XiaomiRedminote9{" +
                "environmentVariables=" + environmentVariables +
                ", capabilities=" + capabilities +
                '}';
    }

    public Device() {
        super();
    }

    public EnvironmentVariables getEnvironmentVariables() {
        return environmentVariables;
    }

    public void setEnvironmentVariables(EnvironmentVariables environmentVariables) {
        this.environmentVariables = environmentVariables;
    }

    public DesiredCapabilities getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(DesiredCapabilities capabilities) {
        this.capabilities = capabilities;
    }


    public Device newproductXiaomi(String parametro1,
                                             String parametro2,
                                             String parametro3,
                                             String parametro4,
                                             String parametro5,
                                             String parametro6,
                                             String parametro7,
                                             String parametro8, String environmentDevice) {

        Device xiaomiRedminote9 = new Device();
        xiaomiRedminote9.setEnvironmentVariables(SystemEnvironmentVariables.createEnvironmentVariables());

        String environment1 = xiaomiRedminote9.getEnvironmentVariables().getProperty(environmentDevice);
        if (environment1 != null) {

            DesiredCapabilities capabilities = new DesiredCapabilities();

            capabilities.setCapability(parametro1, parametro2);
            capabilities.setCapability(parametro3, parametro4);
            capabilities.setCapability(parametro5, parametro6);
            capabilities.setCapability(parametro7, parametro8);
            xiaomiRedminote9.setCapabilities(capabilities);
        }
        return xiaomiRedminote9;

    }

 public Device capabilities1 (String parametro1, String parametro2, String parametro3, String parametro4, String parametro5, String parametro6, String parametro7, String parametro8, String environmentDevice){

     DesiredCapabilities capabilities = new DesiredCapabilities();
     Device xiaomiRedminote9 = new Device();
     xiaomiRedminote9.setEnvironmentVariables(SystemEnvironmentVariables.createEnvironmentVariables());

     for (int i=0;i<=8;i++){

            capabilities.setCapability(parametro1, parametro2);
            capabilities.setCapability(parametro3, parametro4);
            capabilities.setCapability(parametro5, parametro6);
            capabilities.setCapability(parametro7, parametro8);
            xiaomiRedminote9.setCapabilities(capabilities);
     }
        return xiaomiRedminote9;
 }

}
