package pl.wk.tests.spring.services.model.base.builder;

/**
 * Created by Fumik on 9/12/2017.
 */
public interface SpecificObjectBuilder<T, K> {

    T build(Class<? extends T> clazz, K base);
}
