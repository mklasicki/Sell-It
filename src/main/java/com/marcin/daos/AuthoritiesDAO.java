package com.marcin.daos;


import com.marcin.domain.Authorities;

import java.util.List;

public interface AuthoritiesDAO {

   List<Authorities> getAuthorities();

   void saveAuthorities(Authorities authorities);

   Authorities findAuthorities(long id);


}
