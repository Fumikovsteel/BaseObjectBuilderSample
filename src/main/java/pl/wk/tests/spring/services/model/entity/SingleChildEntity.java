package pl.wk.tests.spring.services.model.entity;

import pl.wk.tests.spring.services.model.base.SingleChildBase;

/**
 * Created by Fumik on 9/12/2017.
 */
public class SingleChildEntity implements SingleChildBase {

    @Override
    public int getSingleChildField1() {
        return SingleChildField1;
    }

    @Override
    public void setSingleChildField1(int SingleChildField1) {
        this.SingleChildField1 = SingleChildField1;
    }

    int SingleChildField1;

    @Override
    public String toString() {
        return "SingleChildEntity{" +
                "SingleChildField1=" + SingleChildField1 +
                '}';
    }
}
