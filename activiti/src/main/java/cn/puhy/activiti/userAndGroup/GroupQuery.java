package cn.puhy.activiti.userAndGroup;

import java.util.List;
import java.util.UUID;

import org.activiti.engine.IdentityService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.identity.Group;

/**
 * GroupQuery的方法
 * groupMember方法为根据用户ID查询用户所在的用户组
 * potentialStarter方法为根据流程定义ID查询有权限启动该流程定义的用户组
 */
public class GroupQuery {

	public static void main(String[] args) {
		// 创建流程引擎
		ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
		// 得到身份服务组件实例
		IdentityService identityService = engine.getIdentityService();
		// 写入5条用户组数据
		String aId = UUID.randomUUID().toString();
		createGroup(identityService, aId, "GroupA", "typeA");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupB", "typeB");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupC", "typeC");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupD", "typeD");
		createGroup(identityService, UUID.randomUUID().toString(), "GroupE", "typeE");
		// groupId方法，根据用户组ID查询
		Group groupA = identityService.createGroupQuery().groupId(aId).singleResult();
		System.out.println("groupId method: " + groupA.getId());
		// groupName方法，根据用户组名称查询
		Group groupB = identityService.createGroupQuery().groupName("GroupB").singleResult();
		System.out.println("groupName method: " + groupB.getName());
		// groupType方法，根据用户组类型查询
		Group groupC = identityService.createGroupQuery().groupType("typeC").singleResult();
		System.out.println("groupType method: " + groupC.getName());
		// groupNameLike方法
		List<Group> groups = identityService.createGroupQuery().groupNameLike("%group%").list();
		System.out.println("groupNameLike method: " + groups.size());
	}

	// 将用户组数据保存到数据库中
	private static void createGroup(IdentityService identityService, String id,
			String name, String type) {
		// 调用newGroup方法创建Group实例
		Group group = identityService.newGroup(id);
		group.setName(name);
		group.setType(type);
		identityService.saveGroup(group);
	}
}
