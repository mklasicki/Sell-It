package com.marcin.converters;

import java.util.List;

public interface Converter<DTO, DOMAIN> {

    DOMAIN to(DTO dto);

    DTO from(DOMAIN domain);

    List<DTO> listConverter(List<DOMAIN> domains);


}
