package pl.wk.tests.spring.services.model.base.builder;

import org.springframework.stereotype.Component;
import pl.wk.tests.spring.services.model.base.SingleChildBase;

/**
 * Created by Fumik on 9/12/2017.
 */
@Component
public class SingleChildBaseBuilder implements GenericObjectBuilder<SingleChildBase> {
    @Override
    public SingleChildBase build(Class<? extends SingleChildBase> clazz, SingleChildBase base) {
        try {
            SingleChildBase copy = clazz.newInstance();
            copy.setSingleChildField1(base.getSingleChildField1());
            return copy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}