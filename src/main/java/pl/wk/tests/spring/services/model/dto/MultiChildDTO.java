package pl.wk.tests.spring.services.model.dto;

import pl.wk.tests.spring.services.model.base.InnerMultiChildBase;
import pl.wk.tests.spring.services.model.base.MultiChildBase;
import pl.wk.tests.spring.services.model.dto.InnerMultiChildDTO;

/**
 * Created by Fumik on 9/12/2017.
 */
public class MultiChildDTO implements MultiChildBase {

    @Override
    public int getMultiChildField1() {
        return multiChildField1;
    }

    @Override
    public void setMultiChildField1(int MultiChildField1) {
        this.multiChildField1 = MultiChildField1;
    }

    @Override
    public InnerMultiChildDTO getInnerChild() {
        return innerChild;
    }

    @Override
    public void setInnerChild(InnerMultiChildBase innerChild) {
        this.innerChild = (InnerMultiChildDTO) innerChild;
    }

    int multiChildField1;
    InnerMultiChildDTO innerChild;

    @Override
    public String toString() {
        return "MultiChildDTO{" +
                "multiChildField1=" + multiChildField1 +
                ", innerChild=" + innerChild +
                '}';
    }
}
