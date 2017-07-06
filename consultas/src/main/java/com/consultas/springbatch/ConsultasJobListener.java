package com.consultas.springbatch;

import java.util.List;

import org.joda.time.DateTime;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class ConsultasJobListener implements JobExecutionListener {
	
	private DateTime startTime, stopTime;
	
	public void beforeJob(JobExecution JobExecution) {
		startTime = new DateTime();
		System.out.println("Job starts at : " + startTime);
	}

	public void afterJob(JobExecution jobExecution) {
		stopTime = new DateTime();
		System.out.println("Job stops at : " + stopTime + " \n Total time take in millis: " + getTimeInMillis(startTime, stopTime));
		
		if(jobExecution.getStatus() == BatchStatus.COMPLETED){
			System.out.println("Job completed successfully...");
		}else{
			System.out.println("Job failed with following exceptions: ");
			List<Throwable> excetionList = jobExecution.getAllFailureExceptions();
			for (Throwable throwable : excetionList) {
				System.err.println("Exception: " + throwable.getLocalizedMessage());
			}
		}
		
	}
	
	private long getTimeInMillis(DateTime start, DateTime stop){
		return stop.getMillis() - start.getMillis();
	}

}
