package com.consultas.main;

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

	@SuppressWarnings("resource")
	public static void main(String[] args){
		
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-batch-context.xml");
		
		JobLauncher jobLauncher = (JobLauncher) context.getBean("jobLauncher");
		
		Job job = (Job) context.getBean("jobResult");
		
		try {
			JobExecution jobExecution = jobLauncher.run(job, new JobParameters());
			System.out.println("Job Exit Status: " + jobExecution.getStatus());
			
		} catch (JobExecutionAlreadyRunningException e) {
			System.out.println("Job Already Execution.********************\n Message: " + e.getMessage() + "\n LocalizeMessage: " + e.getLocalizedMessage());
		} catch (JobRestartException e) {
			System.out.println("Job Restart.********************\n Message: " + e.getMessage() + "\n LocalizeMessage: " + e.getLocalizedMessage());
		} catch (JobInstanceAlreadyCompleteException e) {
			System.out.println("Job Instance Already Compolete.********************\n Message: " + e.getMessage() + "\n LocalizeMessage: " + e.getLocalizedMessage());
		} catch (JobParametersInvalidException e) {
			System.out.println("Job Parameters Invalid.********************\n Message: " + e.getMessage() + "\n LocalizeMessage: " + e.getLocalizedMessage());
		}
	}
}
