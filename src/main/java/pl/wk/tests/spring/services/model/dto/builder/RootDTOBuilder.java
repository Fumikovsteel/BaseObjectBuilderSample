package pl.wk.tests.spring.services.model.dto.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.wk.tests.spring.services.model.base.MultiChildBase;
import pl.wk.tests.spring.services.model.base.RootBase;
import pl.wk.tests.spring.services.model.base.SingleChildBase;
import pl.wk.tests.spring.services.model.base.builder.*;
import pl.wk.tests.spring.services.model.dto.InnerMultiChildDTO;
import pl.wk.tests.spring.services.model.dto.MultiChildDTO;
import pl.wk.tests.spring.services.model.dto.RootDTO;
import pl.wk.tests.spring.services.model.dto.SingleChildDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Fumik on 9/12/2017.
 */
@Component
public class RootDTOBuilder implements SpecificObjectBuilder<RootDTO, RootBase> {

    @Autowired
    InnerMultiChildBaseBuilder innerMultiChildBaseBuilder;
    @Autowired
    MultiChildBaseBuilder multiChildBaseBuilder;
    @Autowired
    SingleChildBaseBuilder singleChildBaseBuilder;
    @Autowired
    RootBaseBuilder rootBaseBuilder;

    @Override
    public RootDTO build(Class<? extends RootDTO> clazz, RootBase base) {

        RootDTO rootDTO = (RootDTO) rootBaseBuilder.build(RootDTO.class, base);
        SingleChildDTO singleChildDTO = (SingleChildDTO) singleChildBaseBuilder.build(SingleChildDTO.class, base.getSingleChild());
        rootDTO.setSingleChild(singleChildDTO);

        List<MultiChildDTO> multiChildDTOs = new ArrayList<>();
        for(MultiChildBase multiChildBase : base.getMultiChild()) {
            MultiChildDTO multiChildDTO = (MultiChildDTO) multiChildBaseBuilder.build(MultiChildDTO.class, multiChildBase);
            multiChildDTO.setInnerChild((InnerMultiChildDTO) innerMultiChildBaseBuilder.build(InnerMultiChildDTO.class, multiChildBase.getInnerChild()));
            multiChildDTOs.add(multiChildDTO);
        }
        rootDTO.setMultiChild(multiChildDTOs);

        return rootDTO;
    }
}
