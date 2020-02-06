package io.seanhed.springbootconfig;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.seanhed.springbootconfig.data.DataSourceBean;
import io.seanhed.springbootconfig.data.LocalDataSourceBean;

@RestController
@RefreshScope
public class GreetingsController {

	@Value("${my.greeting: deafultValue}")
	private String greetingMessage;

	@Value("${my.list.values}")
	private List<String> listValues;

	@Autowired
	private DbSettings dbSettings;

	// @Autowired
	// private LocalDataSourceBean localDataSourceBean;
	
	// if we are not on the profile specified in the class, it will not instantiate
	// and could not be autowired (spring will fail to start)
	// @Autowired
	// private DataSourceBean dataSourceBean;

	@Autowired
	private Environment env;

	@GetMapping("/greeting")
	public String greeting() {
		// return greetingMessage + appDesc + listValues + dbValues;
		return greetingMessage + dbSettings.getConnection() + dbSettings.getPort();
	}

	// @GetMapping("/bean")
	// public String whatBeanAmI() {
	// return String.valueOf(localDataSourceBean.num);
	// }

	@GetMapping("/envDetails")
	public String envDetails() {
		return env.toString();
	}

}