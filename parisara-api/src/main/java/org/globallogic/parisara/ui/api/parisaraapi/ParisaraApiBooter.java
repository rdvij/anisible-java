package org.globallogic.parisara.ui.api.parisaraapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"org.globallogic.parisara.ui.api.*"})
public class ParisaraApiBooter {

	public static void main(String[] args) {
		SpringApplication.run(ParisaraApiBooter.class, args);
	}

}
