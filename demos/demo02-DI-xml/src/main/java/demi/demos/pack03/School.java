package demi.demos.pack03;

public class School {
    private String sname;
    private String addr;

    public School() {

    }

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
