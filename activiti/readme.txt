cn.puhy.activiti.first          第一个activiti

cn.puhy.activiti.userAndGroup   用户和用户组

    AddGroup                    增加和修改用户组
    DeleteGroup                 删除用户组
    ListData                    Query的list方法
    ListPage                    Query的listPage方法,常用于分页查询
    Count                       Query的Count方法
    Sort                        Query的排序
    SortMix                     Query的多字段排序
    SingleResult                Query的singleResult方法，查询一条记录，多条会报错
    GroupQuery                  用户组数据查询
    NativeQuery                 原生SQL查询，直接使用SQL查询

    OperateUser                 增加，修改，删除用户
    CheckPasswd                 验证用户密码
    UserQuery                   用户数据查询
    AuthenticatedUserId         设置认证用户
    MemberShip                  用户组与用户的关系

cn.puhy.activiti.repository     流程存储

    DeployResource              部署资源
    ProcessDefControl           中止与激活流程定义
    MyCacheBean                 自定义缓存
    MyCacheTest                 测试自定义缓存
    Candidate                   流程定义权限
    RepositoryServiceTest       RepositoryService数据查询与删除

cn.puhy.activiti.task           流程任务管理
    NewTask                     保存和删除任务
    TaskPermission              任务权限，设置候选用户组，候选用户，权限数据查询，添加删除用户组(用户)权限
    TaskVariable                任务参数
    DataObjectTest              从BPMN文件中获取流程参数

