package com.demirturk.cmscommons.exception;

import com.demirturk.cmscommons.enums.ErrorCodeEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CmsException extends Exception {
    @Getter
    private final ErrorCodeEnum errorCodeEnum;
}
