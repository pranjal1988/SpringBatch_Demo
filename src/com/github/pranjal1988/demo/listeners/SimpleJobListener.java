package com.github.pranjal1988.demo.listeners;

import javax.batch.api.listener.JobListener;

public class SimpleJobListener implements JobListener{

	@Override
	public void beforeJob() throws Exception {
		System.out.println("In before Job callback.\n Going to start Job.");
	}

	@Override
	public void afterJob() throws Exception {
		System.out.println("In after Job callback. \n Irrespective of the success/failure of the job, after job callback will be received");
	}

}
