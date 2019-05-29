package security.service.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import security.domain.RegistedUser;

@Mapper
public interface UserDaoMapper {
	@Select("SELECT id, loginId, password, fullName, deptName FROM t_user WHERE id = #{id}")
	RegistedUser findById(@Param("id") int id);

	@Select("SELECT id, loginId, password, fullName, deptName FROM t_user")
	List<RegistedUser> findAll();


	//@Select("SELECT * FROM t_user WHERE id = #{id}")
	//SampleUser findById(@Param("id") int id);

	//@Select("SELECT * FROM t_user")
	//List<SampleUser> findAll();
}
