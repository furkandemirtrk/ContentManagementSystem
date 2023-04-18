package com.demirturk.cmscommons.util;

import lombok.Getter;
import org.modelmapper.ModelMapper;

public class CommonsModelMapper extends ModelMapper {

    public CommonsModelMapper() {
        super();
    }

    @Getter
    private static final CommonsModelMapper mapper = new CommonsModelMapper();

}
