package cn.puhy.springmvc.domain;

import java.beans.PropertyEditorSupport;

/**
 * @author puhongyu
 * 2018/1/30 21:31
 */
public class UserEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        System.out.println("PropertyEditorSupport转换：" + text);
        User user = new User();
        if (text != null) {
            String[] items = text.split(":");
            user.setName(items[0] + "by propertyeEditor");
            user.setAddress(items[1]);
            user.setPassword(items[2]);
        }
        setValue(user);
    }
}
