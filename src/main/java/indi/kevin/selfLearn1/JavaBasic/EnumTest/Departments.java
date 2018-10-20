package indi.kevin.selfLearn1.JavaBasic.EnumTest;

public enum Departments implements Company {

    SALES{
        @Override
        public String getDepartName() {
            return "Sales depart";
        }
    }, SUPPORT{
        @Override
        public String getDepartName() {
            return "Support depart";
        }
    };


    public abstract String getDepartName();

    @Override
    public String getComponentName() {
        return("this is company A");
    }

}
