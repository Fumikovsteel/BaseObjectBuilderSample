package pl.wk.tests.spring.services.model.base;

/**
 * Created by Fumik on 9/12/2017.
 */
public interface MultiChildBase {

    int getMultiChildField1();

    void setMultiChildField1(int value);

    InnerMultiChildBase getInnerChild();

    void setInnerChild(InnerMultiChildBase value);
}
