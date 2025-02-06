package com.ui.listners;

import com.constants.Env;
import com.utility.EnvUtility;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retryAnalyzer implements IRetryAnalyzer {

    public static final int MAX_ATTEMPTS = EnvUtility.getMaxRetries(Env.QA);
    public static int currentAttempt = 1;

    @Override
    public boolean retry(ITestResult result) {
        if(currentAttempt<=MAX_ATTEMPTS){
            currentAttempt++;
            return true;
        }
        return false;
    }
}
