package security.authentication;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
//import org.springframework.security.core.GrantedAuthority;

//アプリケーション独自のユーザ情報を持たせるために
//UserDetailsインターフェイスの実装クラスであるUserクラスを継承する
//このクラスはSpringSecurityに用意されている
public class SampleUser extends User {
	private String fullName;
    private String deptName;

    public SampleUser(String username, String password) {
        super.setName(username);
        super.setPassword(password);
    }
/*
    public SampleUser(String username, String password,
            Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }
*/
    public String getFullName() {
        return fullName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    //private static final long serialVersionUID = 5869301720811314860L;
}
