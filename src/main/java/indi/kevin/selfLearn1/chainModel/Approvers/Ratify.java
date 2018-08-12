package indi.kevin.selfLearn1.chainModel.Approvers;

import indi.kevin.selfLearn1.chainModel.Request;
import indi.kevin.selfLearn1.chainModel.Result;

public interface Ratify {
    public Result deal(Chain chain);

    interface Chain{
        Request request();

        Result proceed(Request request);
    }
}
