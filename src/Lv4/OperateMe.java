package Lv4;

public class OperateMe {
    public String modifyPrivacy = "修改前的属性值";
    private String value1 = "value1";

    public OperateMe() {

    }

    public OperateMe(String value1) {
        this.value1 = value1;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getModifyPrivacy() {
        return modifyPrivacy;
    }

    public void showValue() {
        System.out.println("展示值为：" + value1);
    }
}
