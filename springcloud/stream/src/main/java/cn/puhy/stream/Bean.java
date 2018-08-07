package cn.puhy.stream;

/**
 * @author PUHY
 * 2018-08-07 23:05
 */
public class Bean {

    private String field1;
    private String field2;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    @Override
    public String toString() {
        return "Bean{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                '}';
    }
}
