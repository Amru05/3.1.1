package com.Amrudin.app.config;

import com.Amrudin.app.Application;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Application.class);
	}
	/*
        добавление фильтра для работы с PATCH, DELETE запросами
         */

	@Override
	public void onStartup(ServletContext context) throws ServletException {
		super.onStartup(context);
		registerHiddenFieldFilter(context);
	}

	private void registerHiddenFieldFilter(ServletContext aContext) {
		aContext.addFilter("hiddenHttpMethodFilter",
				new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
	}
}
