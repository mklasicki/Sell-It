package com.marcin.converters;

import java.io.IOException;
import java.util.List;

public interface Converter<DTO, DOMAIN> {

    DOMAIN to(DTO dto);

    DTO from(DOMAIN domain) throws IOException;

    List<DTO> listConverter(List<DOMAIN> domains) throws IOException;


}
