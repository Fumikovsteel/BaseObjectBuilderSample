package pl.wk.tests.spring.services.model.dto;

import pl.wk.tests.spring.services.model.base.MultiChildBase;
import pl.wk.tests.spring.services.model.base.RootBase;
import pl.wk.tests.spring.services.model.base.SingleChildBase;
import pl.wk.tests.spring.services.model.dto.MultiChildDTO;
import pl.wk.tests.spring.services.model.dto.SingleChildDTO;
import pl.wk.tests.spring.services.model.entity.MultiChildEntity;

import java.util.List;

/**
 * Created by Fumik on 9/12/2017.
 */
public class RootDTO implements RootBase {

    int rootField1;
    SingleChildDTO singleChild;
    List<MultiChildDTO> multiChild;

    @Override
    public SingleChildDTO getSingleChild() {
        return singleChild;
    }

    @Override
    public void setSingleChild(SingleChildBase singleChild) {
        this.singleChild = (SingleChildDTO) singleChild;
    }

    @Override
    public List<MultiChildDTO> getMultiChild() {
        return multiChild;
    }

    @Override
    public void setMultiChild(List<? extends MultiChildBase> multiChild) {
        this.multiChild = (List<MultiChildDTO>) multiChild;
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
        return "RootDTO{" +
                "rootField1=" + rootField1 +
                ", singleChild=" + singleChild +
                ", multiChild=" + multiChild +
                '}';
    }
}
