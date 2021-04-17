package com.globant.PomDrpDwnWilAngel.test;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {System.out.println("El test inicio: " + result.getName());	}

	public void onTestSuccess(ITestResult result) {System.out.println("El test paso");}

	public void onTestFailure(ITestResult result) {System.out.println("El test fallo");	}

	public void onTestSkipped(ITestResult result) {System.out.println("El test fue skypeado");	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {}

	public void onStart(ITestContext context) {System.out.println("Aqui empezo La suite: " + context.getName());	}

	public void onFinish(ITestContext context) {System.out.println("Aqui finalizo La Suite: " + context.getName());}

}
