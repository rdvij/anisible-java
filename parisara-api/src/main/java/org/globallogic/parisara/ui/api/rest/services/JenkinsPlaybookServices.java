package org.globallogic.parisara.ui.api.rest.services;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.springframework.stereotype.Service;

@Service("jenkinsServices")
public class JenkinsPlaybookServices implements PlaybookExecutions {

	Logger logger = Logger.getLogger(JenkinsPlaybookServices.class.getName());
	
	@Override
	public boolean executePlayBook(CommandParameters commandParameters) {

		ProcessBuilder jenkinsInstanceCreateProcess = new ProcessBuilder();

		/**
		 * Use CommandParameters object here to seek if Environment variables 
		 * have been set of the file to use. And create the complete Ansible command to execute.
		 * 
		 * As an example : String[] ansible_run = {"ansible-playbook", "/root/playbooks/script-ilo.yml", "-e", "'@/tmp/vars.yml'"};
		 */
		
		String[] ansible_run = {"ansible-playbook", "--version"};

		jenkinsInstanceCreateProcess.command(ansible_run);

		/**
		 * Change the behavior here to monitor the execution of deployment and
		 * finally send a message asynchronously to browser about completion.
		 */
		
		try {
			Process process = jenkinsInstanceCreateProcess.start();
			InputStream stderr = process.getErrorStream ();

			BufferedReader reader = new BufferedReader (new InputStreamReader(stderr));

			if(reader.lines().count() == 0) {
				logger.info("Jenkins Script executed succesfully");
				return true;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

		return false;
	}

}
