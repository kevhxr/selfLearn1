package indi.kevin.selfLearn1.chainModel.Approvers;

import indi.kevin.selfLearn1.chainModel.Request;
import indi.kevin.selfLearn1.chainModel.Result;

public class DepartmentHeader implements Ratify {
    @Override
    public Result deal(Chain chain) {
        Request request = chain.request();
        System.out.println("DepartmentHeader:        request:" + request.toString());
        System.out.println("=========================================================");

        if(request.customInfo() != null && request.customInfo() != ""){
            return new Result(true,"ok again urgent amm....");
        }

        if(request.days() > 7){
            return new Result(false,"DepartmentHeader: man don't be stupid I wont approve getta away!!");
        }
        return new Result(true,"DepartmentHeader: no worry get it nailed!");
    }
}
