package pl.wk.tests.spring.services.model.entity.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wk.tests.spring.services.model.base.MultiChildBase;
import pl.wk.tests.spring.services.model.base.RootBase;
import pl.wk.tests.spring.services.model.base.SingleChildBase;
import pl.wk.tests.spring.services.model.base.builder.*;
import pl.wk.tests.spring.services.model.entity.InnerMultiChildEntity;
import pl.wk.tests.spring.services.model.entity.MultiChildEntity;
import pl.wk.tests.spring.services.model.entity.RootEntity;
import pl.wk.tests.spring.services.model.entity.SingleChildEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fumik on 9/12/2017.
 */
@Component
public class RootEntityBuilder implements SpecificObjectBuilder<RootEntity, RootBase> {

    @Autowired
    InnerMultiChildBaseBuilder innerMultiChildBaseBuilder;
    @Autowired
    MultiChildBaseBuilder multiChildBaseBuilder;
    @Autowired
    SingleChildBaseBuilder singleChildBaseBuilder;
    @Autowired
    RootBaseBuilder rootBaseBuilder;

    @Override
    public RootEntity build(Class<? extends RootEntity> clazz, RootBase base) {

        RootEntity rootEntity = (RootEntity) rootBaseBuilder.build(RootEntity.class, base);
        SingleChildEntity singleChildEntity = (SingleChildEntity) singleChildBaseBuilder.build(SingleChildEntity.class, base.getSingleChild());
        rootEntity.setSingleChild(singleChildEntity);

        List<MultiChildEntity> multiChildEntities = new ArrayList<>();
        for(MultiChildBase multiChildBase : base.getMultiChild()) {
            MultiChildEntity multiChildEntity = (MultiChildEntity) multiChildBaseBuilder.build(MultiChildEntity.class, multiChildBase);
            multiChildEntity.setInnerChild((InnerMultiChildEntity) innerMultiChildBaseBuilder.build(InnerMultiChildEntity.class, multiChildBase.getInnerChild()));
            multiChildEntities.add(multiChildEntity);
        }
        rootEntity.setMultiChild(multiChildEntities);

        return rootEntity;
    }
}
