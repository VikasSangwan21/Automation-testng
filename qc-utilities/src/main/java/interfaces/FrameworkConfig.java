package interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
    "system:properties",
"file:${project.path}/qc-utilities/src/test/resources/configuration/frameworkConfig.properties"})
public interface FrameworkConfig extends Config {
	
	String environment();
}
