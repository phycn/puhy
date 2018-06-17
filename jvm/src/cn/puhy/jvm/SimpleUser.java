package cn.puhy.jvm;

/**
 * @author puhongyu
 * 2018/6/13 20:50
 */
public class SimpleUser {
    public static final int TYPE = 1;

    private int id;
    private String name;


    public int getId() {
        return id;
    }

    public void setId(int id) throws IllegalStateException {
        try {
            this.id = id;
        } catch (IllegalStateException e) {
            System.out.println(e.toString());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
