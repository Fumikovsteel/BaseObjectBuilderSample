package pl.wk.tests.spring.services.model.base.builder;

/**
 * Created by Fumik on 9/12/2017.
 */
public interface GenericObjectBuilder<T> {

    T build(Class<? extends T> clazz, T base);
}
