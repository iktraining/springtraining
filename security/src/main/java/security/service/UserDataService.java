package security.service;

import java.math.BigInteger;
import java.util.List;

import security.domain.RegistedUser;

public interface UserDataService {

	public RegistedUser findById(BigInteger id);

	public List<RegistedUser> findAll();
}
