package indi.kevin.selfLearn1.chainModel.Approvers;

import indi.kevin.selfLearn1.chainModel.Request;
import indi.kevin.selfLearn1.chainModel.Result;

public class CustomerInterceptor implements Ratify {


    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("CustomerInterceptor:     "+request.toString());
        String reason = request.reason();
        if(reason != null && reason.equals("urgent leave")){
            Request newRequset = new Request.Builder()
                    .newRequest(request)
                    .setCustomInfo(request.name()+":this is urget, pls help approve soon").build();
            System.out.println("CustomerInterceptor:     redirect");
            System.out.println("=========================================================");
            return chain.proceed(newRequset);
        }else{
            return chain.proceed(request);
        }
    }
}
