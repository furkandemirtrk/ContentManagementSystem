package com.demirturk.cms.exception;

import com.demirturk.cms.enums.ErrorCodeEnum;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CmsException extends Exception {
    @Getter
    private final ErrorCodeEnum errorCodeEnum;
}
