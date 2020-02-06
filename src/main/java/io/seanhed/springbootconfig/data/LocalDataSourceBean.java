package io.seanhed.springbootconfig.data;

import org.springframework.context.annotation.Profile;

import org.springframework.stereotype.Repository;

@Repository
@Profile("dev")
public class LocalDataSourceBean {

	public int num = 10;

}
