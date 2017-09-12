package pl.wk.tests.spring.services.model.base.builder;

import org.springframework.stereotype.Component;
import pl.wk.tests.spring.services.model.base.InnerMultiChildBase;
import pl.wk.tests.spring.services.model.base.MultiChildBase;

/**
 * Created by Fumik on 9/12/2017.
 */
@Component
public class MultiChildBaseBuilder implements GenericObjectBuilder<MultiChildBase> {
    @Override
    public MultiChildBase build(Class<? extends MultiChildBase> clazz, MultiChildBase base) {
        try {
            MultiChildBase copy = clazz.newInstance();
            copy.setMultiChildField1(base.getMultiChildField1());
            return copy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
