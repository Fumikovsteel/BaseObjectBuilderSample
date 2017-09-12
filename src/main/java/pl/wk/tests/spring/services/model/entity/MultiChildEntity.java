package pl.wk.tests.spring.services.model.entity;

import pl.wk.tests.spring.services.model.base.InnerMultiChildBase;
import pl.wk.tests.spring.services.model.base.MultiChildBase;

/**
 * Created by Fumik on 9/12/2017.
 */

public class MultiChildEntity implements MultiChildBase {

    @Override
    public int getMultiChildField1() {
        return multiChildField1;
    }

    @Override
    public void setMultiChildField1(int MultiChildField1) {
        this.multiChildField1 = MultiChildField1;
    }

    @Override
    public InnerMultiChildEntity getInnerChild() {
        return innerChild;
    }

    @Override
    public void setInnerChild(InnerMultiChildBase innerChild) {
        this.innerChild = (InnerMultiChildEntity) innerChild;
    }

    int multiChildField1;
    InnerMultiChildEntity innerChild;

    @Override
    public String toString() {
        return "MultiChildEntity{" +
                "multiChildField1=" + multiChildField1 +
                ", innerChild=" + innerChild +
                '}';
    }
}

