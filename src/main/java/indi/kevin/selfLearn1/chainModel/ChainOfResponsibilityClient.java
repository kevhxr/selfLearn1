package indi.kevin.selfLearn1.chainModel;

import indi.kevin.selfLearn1.chainModel.Approvers.DepartmentHeader;
import indi.kevin.selfLearn1.chainModel.Approvers.GroupLeader;
import indi.kevin.selfLearn1.chainModel.Approvers.Manager;
import indi.kevin.selfLearn1.chainModel.Approvers.Ratify;

import java.util.ArrayList;

public class ChainOfResponsibilityClient {
    private ArrayList<Ratify> ratifies;

    public ChainOfResponsibilityClient(){
        ratifies = new ArrayList<>();
    }

    public void addRatify(Ratify ratify){
        ratifies.add(ratify);
    }

    public Result execute(Request request){
        ArrayList<Ratify> ratifyList = new ArrayList<>();
        ratifyList.addAll(ratifies);
        ratifyList.add(new GroupLeader());
        ratifyList.add(new Manager());
        ratifyList.add(new DepartmentHeader());
        RealChain realChain = new RealChain(ratifyList,request,0);
        return realChain.proceed(request);
    }
}
