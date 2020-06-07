package com.marcin.converters;

public interface Converter<DTO, DOMAIN> {

    DOMAIN to(DTO dto);
    DTO from(DOMAIN domain);
}
