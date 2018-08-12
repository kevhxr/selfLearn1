package indi.kevin.selfLearn1.chainModel.Approvers;

import indi.kevin.selfLearn1.chainModel.Request;
import indi.kevin.selfLearn1.chainModel.Result;

public class GroupLeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("GroupLeader:             request:" + request.toString());

        if(request.days() > 1){
            Request newRequest = new Request.Builder().newRequest(request)
                    .setGroupLeader(request.name()+" works well").build();
            System.out.println("=========================================================");
            return chain.proceed(newRequest);
        }
        return new Result(true,"GroupLeader: fare well");
    }
}
