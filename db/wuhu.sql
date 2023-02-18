DROP
DATABASE IF EXISTS wuhu;
CREATE
DATABASE wuhu;
USE
wuhu;

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role
(
    id          BIGINT(20) PRIMARY KEY auto_increment COMMENT '角色id',
    role_name   VARCHAR(30)  NOT NULL COMMENT '角色名称',
    role_key    VARCHAR(100) NOT NULL COMMENT '角色权限字符串',
    data_scope  TINYINT(1) unsigned NOT NULL DEFAULT 1 COMMENT '数据范围(1:全部数据权限,2:自定义数据权限,3:本部门数据权限,4:本部门及以下数据权限)',
    `status`    TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '状态(0启用,1禁用)',
    order_num   INT(4) DEFAULT 0 COMMENT '排序序号',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    del_flag    TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
    create_by   VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by   VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time DATETIME COMMENT '修改时间'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '角色表';

insert into sys_role(role_name, role_key)
values ('管理员', 'admin'),
       ('董事长', 'leader'),
       ('普通员工', 'employee');


DROP TABLE IF EXISTS sys_dept;
CREATE TABLE sys_dept
(
    id           BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '部门id',
    parent_id    BIGINT(20) DEFAULT 0 COMMENT '部门父id',
    ancestors    VARCHAR(50)  DEFAULT '' COMMENT '部门祖级列表',
    dept_name    VARCHAR(50) NOT NULL COMMENT '部门名称',
    phone        VARCHAR(30)  DEFAULT NULL COMMENT '部门联系电话',
    email        VARCHAR(50)  DEFAULT NULL COMMENT '部门联系邮箱',
    leader       VARCHAR(30)  DEFAULT NULL COMMENT '负责人(多个元素用,号分割)',
    leader_phone VARCHAR(50)  DEFAULT NULL COMMENT '负责人联系电话',
    `status`     TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '状态(0启用,1禁用)',
    order_num    INT(4) DEFAULT 0 COMMENT '排序序号',
    remark       VARCHAR(500) DEFAULT NULL COMMENT '备注',
    del_flag     TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
    create_by    VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time  DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by    VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time  DATETIME COMMENT '修改时间'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '部门表';

INSERT INTO sys_dept(parent_id, dept_name)
VALUES (0, '总经办'),
       (1, '财务部'),
       (1, '研发部'),
       (1, '人力资源部'),
       (1, '生产部'),
       (1, '运营部'),
       (1, '市场部'),
       (1, '销售部'),
       (3, '研发一部'),
       (3, '研发二部'),
       (3, '研发三部');


DROP TABLE IF EXISTS sys_post;
CREATE TABLE sys_post
(
    id          BIGINT(20) PRIMARY KEY AUTO_INCREMENT COMMENT '岗位id',
    post_code   VARCHAR(50) NOT NULL COMMENT '岗位编码',
    post_name   VARCHAR(50) NOT NULL COMMENT '岗位名称',
    `status`    TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '状态(0启用,1禁用)',
    order_num   INT(4) DEFAULT 0 COMMENT '排序序号',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    create_by   VARCHAR(64)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by   VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time DATETIME COMMENT '修改时间'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '岗位表';

INSERT INTO sys_post(post_code, post_name)
VALUES ('00001', 'CEO'),
       ('00002', 'CTO'),
       ('00003', 'CFO'),
       ('00004', 'COO'),
       ('00005', '经理'),
       ('00006', '小组长'),
       ('00007', 'Java架构师'),
       ('00008', 'Web前端架构师');


DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user
(
    id          BIGINT(20) PRIMARY KEY auto_increment COMMENT '用户id',
    dept_id     BIGINT(30) DEFAULT NULL COMMENT '部门id',
    account     VARCHAR(30) NOT NULL COMMENT '账号',
    `password`  VARCHAR(50) NOT NULL COMMENT '密码',
    nickname    VARCHAR(30) NOT NULL COMMENT '昵称',
    user_type   TINYINT(1) UNSIGNED NOT NULL COMMENT '用户类型(0:系统用户,1:注册用户)',
    sex         TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别(0:男,1:女,2:未知)',
    age         TINYINT(1) UNSIGNED COMMENT '年龄',
    phone       CHAR(11)     DEFAULT '' COMMENT '电话',
    email       VARCHAR(50)  DEFAULT '' COMMENT '邮箱',
    id_card     CHAR(18)     DEFAULT '' COMMENT '身份证',
    address     VARCHAR(100) DEFAULT '' COMMENT '地址',
    avatar      VARCHAR(100) DEFAULT '' COMMENT '头像',
    `status`    TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '状态(0启用,1禁用)',
    order_num   INT(4) DEFAULT 0 COMMENT '排序序号',
    del_flag    TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
    create_by   VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by   VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time DATETIME COMMENT '修改时间',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '用户表';

INSERT INTO sys_user(account, `password`, nickname, user_type, sex, age)
VALUES ('2684837849', '123456', 'zchengfeng', 2, 0, 18),
       ('17620587787', '123123', '我叫大黄狗', 2, 0, 22),
       ('222222', '123456', '洗脚妹丽丽', 2, 1, 18),
       ('1111111111', '123123', '风骚的小御姐', 2, 1, 25);


DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu
(
    id                   BIGINT(20) PRIMARY KEY auto_increment COMMENT '菜单id',
    parent_id            BIGINT(20) DEFAULT 0 COMMENT '菜单父id',
    menu_name            VARCHAR(30) NOT NULL COMMENT '菜单名称',
    menu_type            TINYINT(1) UNSIGNED NOT NULL COMMENT '菜单类型(0:目录,1:菜单,2:按钮)',
    parent_path          VARCHAR(200) DEFAULT '' COMMENT '父菜单id路径(以逗号分隔,父子id)',
    path                 VARCHAR(50)  DEFAULT '' COMMENT '菜单跳转路径',
    permissionKey        VARCHAR(100) DEFAULT NULL COMMIT '权限标识',
    icon                 VARCHAR(30)  DEFAULT '' COMMENT '菜单icon',
    noPermissionBehavior TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '无权限行为(0:隐藏,1:禁用,2:消息提示)',
    closable             TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '菜单是否可关闭(0:隐藏,1:开启)',
    isNew                TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '是否是新菜单(0:否,1:是)',
    create_by            VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time          DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by            VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time          DATETIME COMMENT '修改时间',
    remark               VARCHAR(500) DEFAULT NULL COMMENT '备注'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '系统菜单表';

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role
(
    user_id   BIGINT(20) PRIMARY KEY NOT NULL COMMENT '用户id',
    role_id   BIGINT(20) PRIMARY KEY NOT NULL COMMENT '角色id',
    isDefault TINYINT(1) NOT NULL DEFAULT 0 COMMENT '是否为默认角色'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '用户角色关联表';

DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu
(
    role_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '角色id',
    menu_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '菜单id'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '角色菜单关联表';

DROP TABLE IF EXISTS sys_user_post;
CREATE TABLE sys_user_post
(
    user_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '用户id',
    post_id BIGINT(20) PRIMARY KEY NOT NULL COMMENT '岗位id',
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '用户岗位关联表';

DROP TABLE IF EXISTS sys_user_login_record(
    id BIGINT(20) PRIMARY KEY auto_increment COMMENT 'id',
    user_id BIGINT(20) DEFAULT NOT COMMENT '用户id',
    login_time DATETIME NOT NULL DEFAULT NOW() COMMENT '登录时间',
    ipaddr int NOT NULL COMMENT 'ip',
    ipaddress VARCHAR (50) DEFAULT '' COMMENT 'ip地址',
    login_mode TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '登录方式(0:账号密码,1.手机号登录,2.邮箱登录,3.二维码登录,4.第三方登录)',
    login_entry TINYINT(1) UNSIGNED NOT NULL DEFAULT 0 COMMENT '登录入口(0:PC,1:APP,2:小程序)',
    login_device VARCHAR (50) DEFAULT NULL COMMENT '登录设备',
    login_os VARCHAR (50) DEFAULT '' COMMENT '登录系统',
    login_browser VARCHAR (50) DEFAULT '' COMMENT '登录浏览器',
    `status` TINYINT DEFAULT 0 COMMENT '登录状态(0:登录成功,1登录失败)',
    onlineStatus TINYINT DEFAULT 0 COMMENT '在线状态(0:在线,1离线)',
    last_login_time DATETIME COMMENT '最后一次登录时间',
    create_by VARCHAR (50) DEFAULT '' COMMENT '创建者',
    create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
    update_by VARCHAR (50) DEFAULT '' COMMENT '修改者',
    update_time DATETIME COMMENT '修改时间',
    remark VARCHAR (500) DEFAULT NULL COMMENT '备注',
    FOREIGN KEY (user_id) references sys_user(id)
    ) engine=INNODB character set =utf8mb4 collate =utf8mb4_general_ci row_format= dynamic comment '用户登录记录表';


DROP TABLE IF EXISTS sys_dict_field;
CREATE TABLE sys_dict_field
(
    id          BIGINT(20) PRIMARY KEY auto_increment COMMENT '字典字段id',
    dict_name   VARCHAR(100) NOT NULL COMMENT '字典字段名称',
    dict_type   VARCHAR(100) DEFAULT '' COMMENT '字典字段类型',
    create_by   VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by   VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time DATETIME COMMENT '修改时间',
    remark      VARCHAR(500) DEFAULT NULL COMMENT '备注',
    UNIQUE (dict_type)
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '字典字段表';

DROP TABLE IF EXISTS sys_dict_value;
CREATE TABLE sys_dict_value
(
    id           BIGINT(20) PRIMARY KEY auto_increment COMMENT '字典字段值id',
    field_id     BIGINT(20) NOT NULL COMMENT '字典字段id',
    dict_value   VARCHAR(100) NOT NULL COMMENT '字典字段值',
    dict_label   VARCHAR(100) DEFAULT '' COMMENT '字典字段标签',
    is_default   TINYINT(1) NOT NULL DEFAULT 1 COMMENT '是否默认(0:是,1否)',
    `status`     TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '状态(0启用,1禁用)',
    order_num    INT(4) DEFAULT 0 COMMENT '排序序号',
    extraContent JSON COMMENT '额外内容,用于扩展',
    create_by    VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time  DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by    VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time  DATETIME COMMENT '修改时间',
    remark       VARCHAR(500) DEFAULT NULL COMMENT '备注',
    FOREIGN KEY (field_id) references sys_dict_field (id)
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '字典字段值表';


DROP TABLE IF EXISTS sys_config;
CREATE TABLE sys_config
(
    id           BIGINT(20) PRIMARY KEY auto_increment COMMENT '配置id',
    config_name  VARCHAR(100) NOT NULL COMMENT '参数名称',
    config_key   VARCHAR(100) DEFAULT '' COMMENT '参数key',
    config_value VARCHAR(100) DEFAULT '' COMMENT '参数value',
    config_type  TINYINT      DEFAULT 1 COMMENT '是否是系统内置配置(0是,1否)',
    create_by    VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time  DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by    VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time  DATETIME COMMENT '修改时间',
    remark       VARCHAR(500) DEFAULT NULL COMMENT '备注'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '系统参数配置表';

/**
 {
  // 处理器
  handle: {
    class: "",
    method: "",
    threadGroupName: "",
    threadName: "",
  },
  // 请求参数
  params: {
    type: "",
    body: "",
  },
  // 响应内容
  return: {
    type: "",
    body: "",
  },
  // 异常
  exception: {
    // 异常类型
    type: "",
    // 异常原因
    cause: "",
    // 异常堆栈
    stack: "",
  },
  // 分析
  analysis: {
    // 请求时间
    requestTime: "",
    // 请求参数字节
    requestParamsSize: 10,
    // 响应时间
    responseTime: "",
    // 响应内容字节
    responseContentSize: 10,
    // 执行时间
    executeTime: 1000,
    // 是否是慢请求
    slowRequest: false,
  },
};
*/
DROP TABLE IF EXISTS sys_op_log;
CREATE TABLE sys_op_log
(
    id           BIGINT(20) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '日志id',
    u_id         BIGINT COMMENT '操作用户id',
    m_id         INT COMMENT '操作菜单',
    content      JSON NOT NULL COMMENT '数据操作内容(包含处理器、请求参数、响应、异常、分析五部分组成)',
    operate_type TINYINT(1) NOT NULL COMMENT '操作类型(0增加、1删除、2改、3查)',
    del_flag     TINYINT(1) unsigned NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
    create_by    VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time  DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by    VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time  DATETIME COMMENT '修改时间',
    remark       VARCHAR(500) DEFAULT NULL COMMENT '备注'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '操作日志表';


DROP TABLE IF EXISTS sys_job_group;
CREATE TABLE sys_job_group
(
    id             BIGINT(20) PRIMARY KEY auto_increment COMMENT '任务组id',
    job_group_name VARCHAR(100) NOT NULL COMMENT '任务组名称'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '定时任务调度组表';


DROP TABLE IF EXISTS sys_job;
CREATE TABLE sys_job
(
    id             BIGINT(20) PRIMARY KEY auto_increment COMMENT '任务id',
    job_name       VARCHAR(100) NOT NULL COMMENT '任务名称',
    job_group      BIGINT(20) NOT NULL COMMENT '任务组id',
    invoke_targer  TEXT(1000) NOT NULL COMMENT '调度目标字符串',
    corn           VARCHAR(200) NOT NULL COMMENT ''
        job_log TEXT(1000) COMMENT '日志信息',
    `status`       TINYINT      NOT NULL COMMENT '执行状态(0:正常,1:失败)',
    exceotion_info TEXT(2000) DEFAULT '' COMMENT '执行异常信息',
    create_by      VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time    DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by      VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time    DATETIME COMMENT '修改时间',
    remark         VARCHAR(500) DEFAULT NULL COMMENT '备注',
    FOREIGN KEY (job_group) references sys_job_group (id)
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '定时任务调度表';


DROP TABLE IF EXISTS sys_notice;
CREATE TABLE sys_notice
(
    id             BIGINT(20) PRIMARY KEY auto_increment COMMENT '公告id',
    notice_title   VARCHAR(50) NOT NULL COMMENT '公告标题',
    notice_type    TINYINT     NOT NULL COMMENT '公告类型(0:通知,1:公告)',
    notice_level   TINYINT      DEFAULT 0 COMMENT '公告级别(0普通的,1紧急的)',
    notice_content TEXT(2000) DEFAULT '' COMMENT '公告内容',
    `status`       TINYINT      DEFAULT 0 COMMENT '公告状态(0开启,1关闭)',
    create_by      VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time    DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by      VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time    DATETIME COMMENT '修改时间',
    remark         VARCHAR(500) DEFAULT NULL COMMENT '备注'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '系统通知公告表';



DROP TABLE IF EXISTS gen_table;
CREATE TABLE gen_table
(
    id                BIGINT(20) PRIMARY KEY auto_increment COMMENT '表id',
    table_name        VARCHAR(50) NOT NULL COMMENT '表名称',
    table_comment     VARCHAR(100) DEFAULT '' COMMENT '表描述',
    sub_table_name    VARCHAR(64)  DEFAULT NULL COMMENT '关联子表名称',
    sub_table_fk_name VARCHAR(64)  DEFAULT NULL COMMENT '关联子表的外键名',
    class_name        VARCHAR(100) DEFAULT '' COMMIT '表对应实体类名',
    package_name      VARCHAR(100) COMMENT '生成包路径',
    module_name       VARCHAR(100) COMMENT '生成模块名',
    business_name     VARCHAR(100) COMMENT '生成业务名',
    function_name     VARCHAR(100) COMMENT '生成功能名',
    function_author   VARCHAR(100) COMMENT '生成功能作者',
    gen_type          TINYINT      DEFAULT 0 COMMENT '生成代码方式(0:zip压缩包,1自定义路径)',
    gen_path          VARCHAR(200) DEFAULT '/' COMMENT '生成代码路径',
    template_categry  VARCHAR(200) DEFAULT 'curd' COMMENT '使用的模板(crud:表单操作,tree:树表操作,sub:子表操作)',
    `options`         JSON COMMENT '配置项',
    create_by         VARCHAR(50)  DEFAULT '' COMMENT '创建者',
    create_time       DATETIME     DEFAULT NOW() COMMENT '创建时间',
    update_by         VARCHAR(50)  DEFAULT '' COMMENT '修改者',
    update_time       DATETIME COMMENT '修改时间',
    remark            VARCHAR(500) DEFAULT NULL COMMENT '备注'
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '代码生成表';


DROP TABLE IF EXISTS gen_table_column;
CREATE TABLE gen_table_column
(
    id             BIGINT(20) PRIMARY KEY auto_increment COMMENT '表字段id',
    table_id       BIGINT(20) NOT NULL COMMENT '所属表的id',
    column_name    VARCHAR(100) NOT NULL COMMENT '列字段名',
    column_comment VARCHAR(200) COMMENT '列字段描述',
    column_type    VARCHAR(100) NOT NULL COMMENT '列类型',
    java_field     VARCHAR(200) NOT NULL COMMENT 'java字段名',
    java_type      VARCHAR(100) NOT NULL COMMENT 'java字段类型',
    is_pk          TINYINT      NOT NULL DEFAULT 1 COMMENT '是否是主键(0是,1否)',
    is_increment   TINYINT      NOT NULL DEFAULT 1 COMMENT '是否是自增列(0是,1否)',
    is_required    TINYINT      NOT NULL DEFAULT 1 COMMENT '是否必填(0是,1否)',
    is_insert      TINYINT      NOT NULL DEFAULT 1 COMMENT '是否为插入字段(0是,1否)',
    is_edit        TINYINT      NOT NULL DEFAULT 1 COMMENT '是否为编辑(0是,1否)',
    is_list        TINYINT      NOT NULL DEFAULT 1 COMMENT '是否为列表字段(0是,1否)',
    is_query       TINYINT      NOT NULL DEFAULT 1 COMMENT '是否为查询字段(0是,1否)',
    query_type     VARCHAR(200)          DEFAULT 'EQ' COMMENT '查询方式(等于、不等于、大于、小于、范围)',
    component_type TINYINT COMMENT '列显示组件类型(0:文本框,1:密码框,2:数字输入框,3:文本域,4:下拉框,5:复选框,6:单选框,7.日期空间,8.日期时间控件)',
    dict_type      VARCHAR(200)          DEFAULT '' COMMENT '字典类型',
    extraContent   JSON COMMENT '额外内容,用于扩展',
    order_num      INT(4) DEFAULT 0 COMMENT '排序序号',
    create_by      VARCHAR(50)           DEFAULT '' COMMENT '创建者',
    create_time    DATETIME              DEFAULT NOW() COMMENT '创建时间',
    update_by      VARCHAR(50)           DEFAULT '' COMMENT '修改者',
    update_time    DATETIME COMMENT '修改时间',
    remark         VARCHAR(500)          DEFAULT NULL COMMENT '备注',
    FOREIGN KEY (table_id) references gen_table (id)
) engine=INNODB character set=utf8mb4 collate=utf8mb4_general_ci row_format=dynamic comment '代码生成表字段';



DROP TABLE IF EXISTS t1;
CREATE TABLE t1
(
    jdoc JSON COMMENT 'JSON对象',
    jarr JSON COMMENT 'JSON数组',
    jstr JSON COMMENT 'JSON字符串'
);

desc sys_dept;

INSERT INTO T1(jdoc, jarr, jstr)
values ('{
  "name": "zchengfeng",
  "age": 20,
  "user": {
    "uname": "hehe",
    "uage": 100
  }
}', '[
  "zhangsan",
  "haha"
]', '"hello"');
SELECT JSON_TYPE(jarr)
from t1;
SELECT JSON_TYPE(jstr)
from t1;
ARRAR
STRING

SELECT JSON_ARRAY(0, '哈哈哈', now())
SELECT JSON_OBJECT('name', 'zchengfeng', 'age', 20, 'birthday', now())

SELECT JSON_LENGTH(jdoc)
FROM T1

SELECT JSON_MERGE_PRESERVE('["a", 1]', '{"key": "value"}');

SELECT JSON_VALID('["hehe","haha"]')