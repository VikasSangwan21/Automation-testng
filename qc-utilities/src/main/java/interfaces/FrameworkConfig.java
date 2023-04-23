package interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
"file:C:\\Users\\User\\Desktop\\Automation\\Automation-testng\\qc-utilities\\src\\test\\resources\\configuration\\frameworkConfig.properties"})
public interface FrameworkConfig extends Config {
	
	String environment();
}
