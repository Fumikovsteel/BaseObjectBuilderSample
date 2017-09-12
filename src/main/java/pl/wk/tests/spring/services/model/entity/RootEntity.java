package pl.wk.tests.spring.services.model.entity;

import pl.wk.tests.spring.services.model.base.MultiChildBase;
import pl.wk.tests.spring.services.model.base.RootBase;
import pl.wk.tests.spring.services.model.base.SingleChildBase;

import java.util.List;

/**
 * Created by Fumik on 9/12/2017.
 */
public class RootEntity implements RootBase {

    int rootField1;
    SingleChildEntity singleChild;
    List<MultiChildEntity> multiChild;

    @Override
    public SingleChildEntity getSingleChild() {
        return singleChild;
    }

    @Override
    public void setSingleChild(SingleChildBase singleChild) {
        this.singleChild = (SingleChildEntity) singleChild;
    }

    @Override
    public List<MultiChildEntity> getMultiChild() {
        return multiChild;
    }

    @Override
    public void setMultiChild(List<? extends MultiChildBase> multiChild) {
        this.multiChild = (List<MultiChildEntity>) multiChild;
    }

    @Override
    public int getRootField1() {
        return rootField1;
    }

    @Override
    public void setRootField1(int rootField1) {
        this.rootField1 = rootField1;
    }

    @Override
    public String toString() {
        return "RootEntity{" +
                "rootField1=" + rootField1 +
                ", singleChild=" + singleChild +
                ", multiChild=" + multiChild +
                '}';
    }
}
