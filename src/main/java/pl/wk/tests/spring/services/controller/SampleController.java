package pl.wk.tests.spring.services.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.wk.tests.spring.services.config.TestConfiguration;
import pl.wk.tests.spring.services.model.base.RootBase;
import pl.wk.tests.spring.services.model.base.builder.RootBaseBuilder;
import pl.wk.tests.spring.services.model.dto.InnerMultiChildDTO;
import pl.wk.tests.spring.services.model.dto.MultiChildDTO;
import pl.wk.tests.spring.services.model.dto.RootDTO;
import pl.wk.tests.spring.services.model.dto.SingleChildDTO;
import pl.wk.tests.spring.services.model.dto.builder.RootDTOBuilder;
import pl.wk.tests.spring.services.model.entity.InnerMultiChildEntity;
import pl.wk.tests.spring.services.model.entity.MultiChildEntity;
import pl.wk.tests.spring.services.model.entity.RootEntity;
import pl.wk.tests.spring.services.model.entity.SingleChildEntity;
import pl.wk.tests.spring.services.model.entity.builder.RootEntityBuilder;

import java.util.Arrays;

/**
 * Created by Fumik on 5/26/2017.
 */
@RestController
public class SampleController {

    @Autowired
    private TestConfiguration testConfiguration;

    @Autowired
    private RootEntityBuilder rootEntityBuilder;
    @Autowired
    private RootDTOBuilder rootDTOBuilder;

    @RequestMapping(path="/sample", method= RequestMethod.GET)
    public String sampleGet() {
        return testConfiguration.getSampleValue();
    }

    @RequestMapping(path = "/root", method = RequestMethod.GET)
    public RootBase root() {
        return generateRootEntity();
    }

    @RequestMapping(path = "/root/copy", method = RequestMethod.GET)
    public RootBase rootCopy() {
        RootDTO rootDTO = generateRootDTO();
        return rootEntityBuilder.build(RootEntity.class, rootDTO);
    }

    @RequestMapping(path = "/root/dto", method = RequestMethod.GET)
    public RootBase rootDTO() {
        RootEntity rootEntity = generateRootEntity();
        return rootDTOBuilder.build(RootDTO.class, rootEntity);
    }

    private RootEntity generateRootEntity() {
        RootEntity rootEntity = new RootEntity();
        rootEntity.setRootField1(100);
        SingleChildEntity singleChildEntity = new SingleChildEntity();
        singleChildEntity.setSingleChildField1(200);
        rootEntity.setSingleChild(singleChildEntity);

        InnerMultiChildEntity innerMultiChildEntity = new InnerMultiChildEntity();
        innerMultiChildEntity.setInnerMultiChildField1(400);
        MultiChildEntity multiChildEntity = new MultiChildEntity();
        multiChildEntity.setMultiChildField1(300);
        multiChildEntity.setInnerChild(innerMultiChildEntity);
        MultiChildEntity multiChildEntity2 = new MultiChildEntity();
        multiChildEntity2.setMultiChildField1(300);
        multiChildEntity2.setInnerChild(innerMultiChildEntity);
        rootEntity.setMultiChild(Arrays.asList(multiChildEntity, multiChildEntity2));

        return rootEntity;
    }

    private RootDTO generateRootDTO() {
        RootDTO rootDTO = new RootDTO();
        rootDTO.setRootField1(1000);
        SingleChildDTO singleChildDTO = new SingleChildDTO();
        singleChildDTO.setSingleChildField1(2000);
        rootDTO.setSingleChild(singleChildDTO);

        InnerMultiChildDTO innerMultiChildDTO = new InnerMultiChildDTO();
        innerMultiChildDTO.setInnerMultiChildField1(4000);
        MultiChildDTO multiChildDTO = new MultiChildDTO();
        multiChildDTO.setMultiChildField1(3000);
        multiChildDTO.setInnerChild(innerMultiChildDTO);
        rootDTO.setMultiChild(Arrays.asList(multiChildDTO));

        return rootDTO;
    }
}
