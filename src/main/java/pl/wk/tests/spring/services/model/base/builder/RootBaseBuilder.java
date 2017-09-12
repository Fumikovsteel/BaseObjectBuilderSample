package pl.wk.tests.spring.services.model.base.builder;

import org.springframework.stereotype.Component;
import pl.wk.tests.spring.services.model.base.RootBase;

/**
 * Created by Fumik on 9/12/2017.
 */
@Component
public class RootBaseBuilder implements GenericObjectBuilder<RootBase> {
    @Override
    public RootBase build(Class<? extends RootBase> clazz, RootBase base) {
        try {
            RootBase copy = clazz.newInstance();
            copy.setRootField1(base.getRootField1());
            return copy;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
