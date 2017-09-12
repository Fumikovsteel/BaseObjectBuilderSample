package pl.wk.tests.spring.services.model.base.builder;

import org.springframework.stereotype.Component;
import pl.wk.tests.spring.services.model.base.InnerMultiChildBase;

/**
 * Created by Fumik on 9/12/2017.
 */
@Component
public class InnerMultiChildBaseBuilder implements GenericObjectBuilder<InnerMultiChildBase> {
    @Override
    public InnerMultiChildBase build(Class<? extends InnerMultiChildBase> clazz, InnerMultiChildBase base) {
        try {
            InnerMultiChildBase copy = clazz.newInstance();
            copy.setInnerMultiChildField1(base.getInnerMultiChildField1());
            return copy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
