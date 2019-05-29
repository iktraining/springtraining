package security.service;

import java.math.BigInteger;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import security.domain.RegistedUser;

@Transactional
@
public class UserDataServiceImpl implements UserDataService{

	public RegistedUser findById(BigInteger id);

	public List<RegistedUser> findAll();
}
