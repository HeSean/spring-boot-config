package io.seanhed.springbootconfig.data;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

@Repository
// default is @Profile("default")
@Profile("test")
public class DataSourceBean {
	
	public int num = 5;

}
