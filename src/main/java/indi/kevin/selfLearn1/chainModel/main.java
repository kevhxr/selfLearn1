package indi.kevin.selfLearn1.chainModel;

import indi.kevin.selfLearn1.chainModel.Approvers.CustomerInterceptor;

public class main {

    public static void main(String[] args){
        Request request = new Request.Builder().setName("Kevin").setDays(8).setReason("urgent leave").build();
        ChainOfResponsibilityClient chainOfResponsibilityClient = new ChainOfResponsibilityClient();
        chainOfResponsibilityClient.addRatify(new CustomerInterceptor());
        Result result = chainOfResponsibilityClient.execute(request);
        System.out.println(result.toString());
    }
}
