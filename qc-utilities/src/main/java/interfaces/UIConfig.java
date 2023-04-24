package interfaces;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
	"system:properties",
	"file:${user.dir}/src/test/resources/configuration/configsettings.properties"
	})
public interface UIConfig extends Config {
	
	String environment();
	
	@Key("${environment}.URL")
	String URL();
}
