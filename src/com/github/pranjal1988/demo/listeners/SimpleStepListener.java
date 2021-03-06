package com.github.pranjal1988.demo.listeners;

import java.util.List;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.ItemProcessListener;
import org.springframework.batch.core.ItemReadListener;
import org.springframework.batch.core.ItemWriteListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ExecutionContext;

import com.github.pranjal1988.demo.Model.Stock;

public class SimpleStepListener implements StepExecutionListener , ItemReadListener<String> , ItemWriteListener<Stock> , ItemProcessListener<String, Stock> {

	private int readCounter = 0;
	private ExecutionContext context;
	private StepExecution exec;
	
	@Override
	public void beforeStep(StepExecution stepExecution) {
		exec = stepExecution;
		context = stepExecution.getExecutionContext();
		System.out.println("In Before Step callback !");
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println("In After Step callback !");
		return ExitStatus.COMPLETED;
	}

	@Override
	public void beforeProcess(String item) {
		System.out.println("Going to process the input item : " + item);
	}

	@Override
	public void afterProcess(String item, Stock result) {
		System.out.println("processed the input item : " + item + " and transformed it to Stock : " + result);
	}

	@Override
	public void onProcessError(String item, Exception e) {
		System.out.println("Error while processing the item : " + item + " \n Exception being : \n " + e.toString());
	}

	@Override
	public void beforeWrite(List<? extends Stock> items) {
		System.out.println("Going to write [ " + items.size() + " ] Stock details" );
	}

	@Override
	public void afterWrite(List<? extends Stock> items) {
		System.out.println("Written [ " + items.size() + " ] Stock details");
	}

	@Override
	public void onWriteError(Exception exception, List<? extends Stock> items) {
		System.out.println("Error occured in write step");
	}

	@Override
	public void beforeRead() {
		System.out.println("going to read item");
	}

	@Override
	public void afterRead(String item) {
		readCounter++;
		if(readCounter % 500 == 0){
			System.out.println("Read item : " + readCounter);
		}
		if(readCounter == 1059){
			this.exec.setExitStatus(ExitStatus.FAILED);
			exec.setStatus(BatchStatus.FAILED);
			exec.setTerminateOnly();
		}
	}

	@Override
	public void onReadError(Exception ex) {
		System.out.println("Error occured while reading item, exception is : " + ex.toString());
	} 

}
