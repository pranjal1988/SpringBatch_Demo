package com.github.pranjal1988.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("com\\github\\pranjal1988\\demo\\config\\simpleJobConfig.xml");
		Job job =  (Job) context.getBean("dbRepoSampleJob");
		JobLauncher launcher = (JobLauncher) context.getBean("syncExecJobLauncher");
		try {
			Map<String, JobParameter> params = new HashMap<String, JobParameter>();
			params.put("Long", new JobParameter("longTest"));
			JobParameters jp = new JobParameters(params);
			
			JobExecution exec = launcher.run(job, jp);
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			System.out.println("Handle exception ");
			e.printStackTrace();
		}
	}

}
