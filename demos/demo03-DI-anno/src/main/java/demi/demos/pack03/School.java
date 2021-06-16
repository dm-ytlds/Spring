package demi.demos.pack03;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// 为引用数据类型的自动注入做铺垫
@Component("mySchool")
public class School {

    @Value("Xihua")
    private String sname;
    @Value("Chengdu")
    private String addr;

    public void setSname(String sname) {
        this.sname = sname;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        return "School{" +
                "sname='" + sname + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
