package cn.puhy.mybatis.provider;

import org.apache.ibatis.jdbc.SQL;

public class SysRoleProvider {

	public String selectByIdProvider(final Integer id) {

		return new SQL() {
			{
				SELECT("id, role_name");
				FROM("sys_role");
				WHERE("id=#{id}");
			}
		}.toString();
	}
}
