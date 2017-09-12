package pl.wk.tests.spring.services.model.entity;

import pl.wk.tests.spring.services.model.base.InnerMultiChildBase;

/**
 * Created by Fumik on 9/12/2017.
 */
public class InnerMultiChildEntity implements InnerMultiChildBase {

    @Override
    public int getInnerMultiChildField1() {
        return innerMultiChildField1;
    }

    @Override
    public void setInnerMultiChildField1(int innerMultiChildField1) {
        this.innerMultiChildField1 = innerMultiChildField1;
    }

    int innerMultiChildField1;

    @Override
    public String toString() {
        return "InnerMultiChildEntity{" +
                "innerMultiChildField1=" + innerMultiChildField1 +
                '}';
    }
}
