package pl.wk.tests.spring.services.model.base;

import java.util.List;

/**
 * Created by Fumik on 9/12/2017.
 */
public interface RootBase {

    int getRootField1();

    void setRootField1(int value);

    SingleChildBase getSingleChild();

    void setSingleChild(SingleChildBase value);

    List<? extends MultiChildBase> getMultiChild();

    void setMultiChild(List<? extends MultiChildBase> value);

}
