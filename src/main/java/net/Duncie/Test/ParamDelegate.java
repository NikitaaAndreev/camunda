package net.Duncie.Test;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

@Component("delegate")
public class ParamDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {

        String gender = (String) delegateExecution.getVariable("gender");
        String email = (String) delegateExecution.getVariable("email");
        Integer countMan = 0;
        Integer countWoman = 0;
        Boolean isMan= false;

        if(gender.equals("man")) {
            isMan = true;
            countMan++;
        } else {
            countWoman++;
        }

        delegateExecution.setVariable("countMan", countMan);
        delegateExecution.setVariable("countWoman", countWoman);
        delegateExecution.setVariable("isMan", isMan);
    }
}
