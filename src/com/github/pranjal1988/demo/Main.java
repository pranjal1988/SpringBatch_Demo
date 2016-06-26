package com.github.pranjal1988.demo;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
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
		Job job =  (Job) context.getBean("ioSampleJob");
		JobLauncher launcher = (JobLauncher) context.getBean("syncExecJobLauncher");
		try {
			JobExecution exec = launcher.run(job, new JobParameters());
		} catch (JobExecutionAlreadyRunningException | JobRestartException | JobInstanceAlreadyCompleteException
				| JobParametersInvalidException e) {
			System.out.println("Handle exception ");
			e.printStackTrace();
		}
	}

}
