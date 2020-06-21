package org.globallogic.parisara.ui.api.rest.services;

import java.util.List;

public class CommandParameters {

	private String envFilePath;
	private List<KeyValuePair> envVars;
	
	public String getEnvFilePath() {
		return envFilePath;
	}
	public void setEnvFilePath(String envFilePath) {
		this.envFilePath = envFilePath;
	}
	public List<KeyValuePair> getEnvVars() {
		return envVars;
	}
	public void setEnvVars(List<KeyValuePair> envVars) {
		this.envVars = envVars;
	}
}
