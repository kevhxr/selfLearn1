package indi.kevin.selfLearn1.chainModel.Approvers;

import indi.kevin.selfLearn1.chainModel.Request;
import indi.kevin.selfLearn1.chainModel.Result;

public class Manager implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("Manager:                 request:" + request.toString());

        if(request.days() > 3){
            Request newRequest = new Request.Builder().newRequest(request)
                    .setManagerInfo(request.name()+" I like your work, ask above for completion").build();
            System.out.println("=========================================================");
            return chain.proceed(newRequest);
        }
        return new Result(true,"Manager: finish ur biz soon");
    }
}
