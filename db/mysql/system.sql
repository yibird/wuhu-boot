DROP DATABASE
    IF
        EXISTS `wuhu-boot`;
CREATE DATABASE `wuhu-boot` CHARACTER
    SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE `wuhu-boot`;

############################## system 模块	###############################
DROP TABLE
    IF
        EXISTS sys_tenant;
# sys_tenant
CREATE TABLE sys_tenant (
                            id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '租户id',
                            tenant_code VARCHAR ( 100 ) NOT NULL COMMENT '租户编码',
                            tenant_name VARCHAR ( 100 ) NOT NULL COMMENT '租户名称',
                            super_tenant BIT( 1 ) NOT NULL DEFAULT 0 COMMENT '是否是超级租户(0否,1是)',
                            address VARCHAR ( 255 ) COMMENT '地址',
                            phone VARCHAR ( 20 ) COMMENT '电话',
                            email VARCHAR ( 100 ) COMMENT '邮箱',
                            emergency_contact VARCHAR ( 100 ) DEFAULT NULL COMMENT '紧急联系人',
                            `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                            remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                            version INT COMMENT '版本号',
                            sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                            deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                            creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                            create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                            updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                            update_time DATETIME COMMENT '修改时间'
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '租户表';
INSERT INTO sys_tenant ( tenant_code,tenant_name, super_tenant)
VALUES ('t00001','飞鸟科技', 1),('t00002','测试租户',0);

# sys_role
DROP TABLE
    IF
        EXISTS sys_role;
CREATE TABLE sys_role (
                          id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '角色id',
                          role_code VARCHAR ( 30 ) NOT NULL COMMENT '角色编码',
                          role_name VARCHAR ( 30 ) NOT NULL COMMENT '角色名称',
                          role_key VARCHAR ( 100 ) NOT NULL COMMENT '角色权限字符串',
                          data_scope TINYINT ( 1 ) UNSIGNED NOT NULL DEFAULT 1 COMMENT '数据范围(0:全部数据权限,1:本部门数据权限,2:本部门及子机构数据权限,3:自定义数据权限)',
                          `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                          remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                          version INT COMMENT '版本号',
                          sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                          deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                          creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                          create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                          updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                          update_time DATETIME COMMENT '修改时间',
                          tenant_id BIGINT NOT NULL COMMENT '租户id',
                          FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id ),
                          UNIQUE INDEX `uq_role_code` ( `role_code` ASC ) USING BTREE
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '角色表';
INSERT INTO sys_role ( role_code,role_name, role_key, data_scope, `status`,tenant_id)
VALUES
    ( 'r00001','管理员', 'admin', 0, 1,1 ),
    ( 'r00002', '董事长', 'boss', 0, 1,1),
    (
        'r00003','经理',
        'leader',
        1,
        0,
        1
    );


# sys_org
DROP TABLE
    IF
        EXISTS sys_org;
CREATE TABLE sys_org (
                         id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '机构id',
                         p_id BIGINT ( 20 ) DEFAULT 0 COMMENT '机构父id,0表示无上级机构',
                         org_code VARCHAR ( 50 ) NOT NULL COMMENT '机构编码(唯一)',
                         org_name VARCHAR ( 50 ) NOT NULL COMMENT '机构名称',
                         level_path VARCHAR ( 200 ) DEFAULT '' COMMENT '机构层级路径(以,号分割机构id,用于优化查找机构)',
                         phone VARCHAR ( 30 ) DEFAULT NULL COMMENT '机构联系电话',
                         email VARCHAR ( 50 ) DEFAULT NULL COMMENT '机构联系邮箱',
                         leader VARCHAR ( 30 ) DEFAULT NULL COMMENT '机构负责人(多个元素用,号分割)',
                         `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                         remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                         version INT COMMENT '版本号',
                         sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                         deleted BIT ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                         creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                         create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                         updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                         update_time DATETIME COMMENT '修改时间',
                         tenant_id BIGINT NOT NULL COMMENT '租户id',
                         UNIQUE INDEX `uq_org_code` ( `org_code` ASC ) USING BTREE,
                         FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '机构部门表';
INSERT INTO sys_org ( p_id, org_code, org_name, level_path, tenant_id )
VALUES
    ( 0, 'org00001', '飞鸟集团', '', 1 ),
    ( 1, 'org00002', '总经办', '1', 1 ),
    ( 1, 'org00003', '财务部', '1', 1 ),
    ( 1, 'org00004', '市场部', '1', 1 ),
    ( 1, 'org00005', '研发部', '1', 1 ),
    ( 1, 'org00006', '人力资源部', '1', 1 ),
    ( 3, 'org00007', '财务一部', '1-3', 1 ),
    ( 3, 'org00008', '财务一部', '1-3', 1 ),
    ( 4, 'org00009', '市场一部', '1-4', 1 ),
    ( 4, 'org00010', '市场一部', '1-4', 1 ),
    ( 5, 'org00011', '研发一部', '1-5', 1 ),
    ( 5, 'org00012', '研发二部', '1-5', 1 );

# sys_post
DROP TABLE
    IF
        EXISTS sys_post;
CREATE TABLE sys_post (
                          id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '岗位id',
                          post_code VARCHAR ( 50 ) NOT NULL COMMENT '岗位编码',
                          post_name VARCHAR ( 50 ) NOT NULL COMMENT '岗位名称',
                          post_type TINYINT ( 1 ) NOT NULL DEFAULT 0 COMMENT '岗位类型(0全职岗位、1试用岗位、2实习岗位、3临时岗位)',
                          post_level TINYINT ( 1 ) NOT NULL COMMENT '岗位等级(0实习、1初级、2中级、3高级、4资深、5专家、6首席官)',
                          `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                          remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                          version INT COMMENT '版本号',
                          sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                          deleted BIT ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                          creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                          create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                          updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                          update_time DATETIME COMMENT '修改时间',
                          tenant_id BIGINT NOT NULL COMMENT '租户id',
                          UNIQUE INDEX `uq_post_code` ( `post_code` ASC ) USING BTREE,
                          FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '岗位表';
INSERT INTO sys_post ( post_code, post_name, post_level, tenant_id )
VALUES
    ( '00001', 'CEO', 6, 1 ),
    ( '00002', 'CTO', 6, 1 ),
    ( '00003', 'CFO', 6, 1 ),
    ( '00004', 'COO', 6, 1 ),
    ( '00005', '经理', 4, 1 ),
    ( '00006', 'Java架构师', 4, 1 ),
    ( '00007', 'Web前端架构师', 4, 1 ),
    ( '00008', 'Web前端实习生', 0, 1 ),
    ( '00009', '初级Web前端工程师', 1, 1 ),
    ( '00010', '中级Web前端工程师', 2, 1 ),
    ( '00011', '高级Web前端工程师', 3, 1 ),
    ( '00012', '资深Web前端工程师', 4, 1 );

# sys_menu
DROP TABLE
    IF
        EXISTS sys_menu;
CREATE TABLE sys_menu (
                          id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '菜单id',
                          p_id BIGINT ( 20 ) DEFAULT 0 COMMENT '菜单父id,0表示无上级菜单',
                          menu_code VARCHAR ( 30 ) NOT NULL COMMENT '菜单编码',
                          menu_name VARCHAR ( 30 ) NOT NULL COMMENT '菜单名称',
                          menu_type TINYINT ( 1 ) UNSIGNED NOT NULL COMMENT '菜单类型(0:目录,1:菜单,2:按钮)',
                          menu_path VARCHAR ( 50 ) DEFAULT '' COMMENT '菜单跳转路径(以/为前缀的表示内部路由,以http开头的表示内嵌网页)',
                          menu_icon VARCHAR ( 30 ) DEFAULT '' COMMENT '菜单icon',
                          level_path VARCHAR ( 200 ) DEFAULT '' COMMENT '层级路径(以逗号分隔,父子id),用于优化查找菜单',
                          permission_key VARCHAR ( 100 ) DEFAULT NULL COMMENT '权限标识',
                          external_link BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '是否是外部链接(0否,1是)',
                          no_permission_action TINYINT ( 1 ) UNSIGNED NOT NULL DEFAULT 0 COMMENT '无权限行为(0:隐藏,1:禁用,2:消息提示)',
                          closable BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '菜单是否可关闭(0:否,1:是)',
                          isNew BIT ( 1 ) NOT NULL DEFAULT 0 COMMENT '是否是新菜单(0:否,1:是)',
                          `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                          remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                          version INT COMMENT '版本号',
                          sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                          deleted BIT ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                          creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                          create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                          updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                          update_time DATETIME COMMENT '修改时间',
                          tenant_id BIGINT NOT NULL COMMENT '租户id',
                          FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '系统菜单表';
INSERT INTO sys_menu ( p_id, menu_code, menu_name, menu_type, menu_path, menu_icon, level_path, permission_key, no_permission_action, closable, isNew, tenant_id )
VALUES
    ( 0, 'm00001', '系统设置', 0, '', '', '', '', 0, 0, 0, 1 ),
    ( 1, 'm00002', '用户管理', 1, '/user', '', '1', '', 0, 0, 0, 1 ),
    ( 2, 'm00003', '用户管理-新增', 2, '', '', '1-2', 'sys:user:add', 0, 0, 0, 1 ),
    ( 2, 'm00004', '用户管理-删除', 2, '', '', '1-2', 'sys:user:del', 0, 0, 0, 1 ),
    ( 2, 'm00005', '用户管理-修改', 2, '', '', '1-2', 'sys:user:update', 0, 0, 0, 1 ),
    ( 2, 'm00006', '用户管理-列表', 2, '', '', '1-2', 'sys:user:list', 0, 0, 0, 1 ),
    ( 2, 'm00007', '用户管理-详情', 2, '', '', '1-2', 'sys:user:info', 0, 0, 0, 1 );

# sys_user
DROP TABLE
    IF
        EXISTS sys_user;
CREATE TABLE sys_user (
                          id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '用户id',
                          account VARCHAR ( 30 ) NOT NULL COMMENT '账号',
                          `password` VARCHAR ( 200 ) NOT NULL COMMENT '密码',
                          nickname VARCHAR ( 50 ) NOT NULL COMMENT '昵称',
                          sex TINYINT ( 1 ) UNSIGNED NOT NULL DEFAULT 0 COMMENT '性别(0:男,1:女,2:未知)',
                          age TINYINT ( 1 ) UNSIGNED COMMENT '年龄',
                          phone CHAR ( 11 ) DEFAULT '' COMMENT '电话',
                          id_card CHAR ( 18 ) DEFAULT '' COMMENT '身份证',
                          email VARCHAR ( 50 ) DEFAULT '' COMMENT '邮箱',
                          weChat VARCHAR ( 50 ) DEFAULT '' COMMENT '微信号',
                          address VARCHAR ( 100 ) DEFAULT '' COMMENT '地址',
                          avatar VARCHAR ( 100 ) DEFAULT '' COMMENT '头像',
                          birthday DATETIME COMMENT '生日',
                          `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                          remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                          version INT COMMENT '版本号',
                          sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                          deleted BIT ( 1 ) NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                          creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                          create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                          updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                          update_time DATETIME COMMENT '修改时间',
                          tenant_id BIGINT NOT NULL COMMENT '租户id',
                          role_id BIGINT NOT NULL COMMENT '角色id',
                          org_id BIGINT COMMENT '机构id',
                          post_id BIGINT COMMENT '岗位id',
                          UNIQUE INDEX `uq_account` ( `account` ASC ) USING BTREE,
                          UNIQUE INDEX `uq_phone` ( `phone` ASC ) USING BTREE,
                          UNIQUE INDEX `uq_id_card` ( `id_card` ASC ) USING BTREE
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '用户表';
INSERT INTO sys_user ( account, `password`, nickname, sex, age, phone, id_card, tenant_id, role_id )
VALUES
    ( '2684837849', '{noop}123456', 'zchengfeng', 0, 18, '17620001787', '330326199211027412', 1, 1 ),
    ( '17620587787', '{noop}123456', '大黄', 0, 22, '17620001781', '410222199107242031', 1, 1 ),
    ( '222222', '{noop}123456', '阿梅', 1, 18, '17620001782', '410222199107242032', 1, 2 ),
    ( '1111111111', '{noop}123456', '上官菲菲', 1, 24, '17620001783', '410222199107242033', 1, 2 );

# sys_role_menu
DROP TABLE
    IF
        EXISTS sys_role_menu;
CREATE TABLE sys_role_menu (
                               id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
                               role_id BIGINT ( 20 ) NOT NULL COMMENT '角色id',
                               menu_id BIGINT ( 20 ) NOT NULL COMMENT '菜单id',
                               FOREIGN KEY ( role_id ) REFERENCES sys_role ( id ),
                               FOREIGN KEY ( menu_id ) REFERENCES sys_menu ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '角色菜单关联表';
INSERT INTO sys_role_menu(role_id,menu_id) VALUES (1,1),(1,2),(1,3),(1,4),(1,5);

# sys_user_token
DROP TABLE IF EXISTS sys_user_token;
CREATE TABLE sys_user_token(
                               id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
                               user_id BIGINT ( 20 ) NOT NULL COMMENT '用户id',
                               access_token  VARCHAR(50) COMMENT 'accessToken',
                               access_token_expire   datetime COMMENT 'accessToken 过期时间',
                               refresh_token         varchar(32) COMMENT 'refreshToken',
                               refresh_token_expire  datetime COMMENT 'refreshToken 过期时间',
                               create_time           datetime COMMENT '创建时间'
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '用户令牌表';

# sys_dict_type
DROP TABLE
    IF
        EXISTS sys_dict_type;
CREATE TABLE sys_dict_type (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
                               dict_code VARCHAR ( 100 ) DEFAULT '' COMMENT '字典编码',
                               dict_name VARCHAR ( 100 ) NOT NULL COMMENT '字典名称',
                               dict_source TINYINT(1) NOT NULL  DEFAULT 0 COMMENT '数据来源(0字典数据,1动态SQL)',
                               dict_sql    varchar(500) COMMENT '动态SQL',
                               `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                               remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                               version INT COMMENT '版本号',
                               sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                               deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                               creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                               create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                               updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                               update_time DATETIME COMMENT '修改时间',
                               tenant_id BIGINT NOT NULL COMMENT '租户id',
                               UNIQUE INDEX `uq_dict_code` ( `dict_code` ASC ) USING BTREE,
                               FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '字典类型表';

INSERT INTO sys_dict_type(dict_code,dict_name,remark,tenant_id) VALUES('user_sex','性别','用户性别',1);


# sys_dict_data
DROP TABLE
    IF
        EXISTS sys_dict_data;
CREATE TABLE sys_dict_data (
                               id BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
                               dict_type BIGINT NOT NULL COMMENT '字典类型id',
                               dict_label VARCHAR ( 100 ) NOT NULL COMMENT '字典标签',
                               dict_value VARCHAR ( 100 ) DEFAULT '' COMMENT '字典值',
                               `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                               remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                               version INT COMMENT '版本号',
                               sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                               deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                               creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                               create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                               updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                               update_time DATETIME COMMENT '修改时间',
                               FOREIGN KEY ( dict_type ) REFERENCES sys_dict_type ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '字典数据表';

INSERT INTO sys_dict_data(dict_type,dict_label,dict_value) VALUES(1,'男','0'),(1,'女','1'),(1,'未知','2');


# sys_log_login
DROP TABLE
    IF
        EXISTS sys_log_login;
CREATE TABLE sys_log_login (
                               id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT 'id',
                               login_type TINYINT ( 1 ) UNSIGNED NOT NULL DEFAULT 0 COMMENT '登录/登出类型(0:PC,1:APP,2:小程序)',
                               login_mode TINYINT ( 1 ) UNSIGNED NOT NULL DEFAULT 0 COMMENT '登录/登出方式(0:账号密码,1.手机号登录,2.邮箱登录,3.二维码登录,4.第三方登录)',
                               operation TINYINT ( 1 ) UNSIGNED NOT NULL COMMENT '登录操作信息(0:登录,1:登出)',
                               ip_addr INT NOT NULL COMMENT 'ip',
                               ip_address VARCHAR ( 50 ) DEFAULT '' COMMENT 'ip地址',
                               use_device VARCHAR ( 50 ) DEFAULT NULL COMMENT '登录设备',
                               use_os VARCHAR ( 50 ) DEFAULT '' COMMENT '登录系统',
                               use_browser VARCHAR ( 50 ) DEFAULT '' COMMENT '登录浏览器',
                               user_agent   VARCHAR(500) COMMENT 'User Agent',
                               login_status BIT(1) DEFAULT 1 COMMENT '登录/登出状态(0失败,1成功)',
                               online_status TINYINT(1) DEFAULT 1 COMMENT '在线状态(0:离线,1在线)',
                               last_login_time DATETIME COMMENT '最后一次登录时间',
                               `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                               remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                               version INT COMMENT '版本号',
                               sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                               deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                               creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                               create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                               updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                               update_time DATETIME COMMENT '修改时间',
                               user_id BIGINT ( 20 ) NOT NULL COMMENT '用户id',
                               FOREIGN KEY ( user_id ) REFERENCES sys_user ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '用户登录日志表';


# sys_log_operate
DROP TABLE
    IF
        EXISTS sys_log_operate;
CREATE TABLE sys_log_operate (
                                 id BIGINT ( 20 ) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT '日志id',
                                 user_id BIGINT COMMENT '操作用户id',
                                 operate_name VARCHAR(100) COMMENT '操作名称',
                                 operate_type tinyint(1) UNSIGNED NOT NULL COMMENT '操作类型(0查询、1添加、2删除、3修改、4调用)',
                                 `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '日志状态(0失败,1成功)',
                                 module VARCHAR(50) COMMENT '操作模块',
                                 req_url varchar(200) DEFAULT NULL COMMENT '请求URI',
                                 req_params text COMMENT '请求参数',
                                 res_result text COMMENT '响应结果',
                                 timer INT COMMENT '执行耗时(单位毫秒)',
                                 slow_log BIT ( 1 ) NOT NULL DEFAULT 0 COMMENT '是否是慢日志(0否,1是)',
                                 remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                                 creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                                 create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                                 FOREIGN KEY ( user_id ) REFERENCES sys_user ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '操作日志表';



# sys_message
DROP TABLE
    IF
        EXISTS sys_message;
CREATE TABLE sys_message (
                             id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '消息id',
                             tenant_id BIGINT NOT NULL COMMENT '租户id',
                             type TINYINT UNSIGNED NOT NULL COMMENT '消息类型(1:通知公告,2:系统消息)',
                             title VARCHAR ( 100 ) NOT NULL COMMENT '消息标题',
                             expiration datetime NOT NULL COMMENT '过期时间',
                             receiver_type TINYINT NOT NULL COMMENT '接收者类型(1:指定用户,2:全体用户)',
                             receivers VARCHAR ( 1000 ) COMMENT '接收者id集合,以逗号分割,仅在接收者类型为1时生效',
                             priority TINYINT ( 1 ) NOT NULL COMMENT '优先级(0:高,1:中,2:低)',
                             content TEXT ( 1000 ) COMMENT '内容',
                             cancel_time DATETIME COMMENT '撤销时间',
                             message_status TINYINT ( 1 ) NOT NULL COMMENT '消息状态(0:草稿,1:已发送,2:已接收,3:已查阅)',
                             `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                             remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                             version INT COMMENT '版本号',
                             sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                             deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                             creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                             create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                             updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                             update_time DATETIME COMMENT '修改时间',
                             FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '系统消息表';

# sys_params
DROP TABLE IF EXISTS sys_params;
CREATE TABLE sys_params (
                            id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '组id',
                            tenant_id BIGINT NOT NULL COMMENT '租户id',
                            param_name VARCHAR(50) NOT NULL COMMENT '参数名称',
                            param_type TINYINT UNSIGNED NOT NULL DEFAULT 0 COMMENT '参数类型(0系统参数,1自定义参数)',
                            param_key VARCHAR(50) NOT NULL COMMENT '参数key',
                            param_value VARCHAR(50) NOT NULL COMMENT '参数value',
                            `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                            remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                            version INT COMMENT '版本号',
                            sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                            deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                            creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                            create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                            updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                            update_time DATETIME COMMENT '修改时间',
                            FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '参数管理';

INSERT INTO sys_params(tenant_id,param_name,param_type,param_key,param_value) VALUES (1,'应用名称',0,'APP_NAME','wuhu-boot');

# sys_task_group
DROP TABLE IF EXISTS sys_job_group;
CREATE TABLE sys_job_group (
                               id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '任务组id',
                               tenant_id BIGINT NOT NULL COMMENT '租户id',
                               group_name VARCHAR(50) NOT NULL COMMENT '任务组名称',
                               `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                               remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                               version INT COMMENT '版本号',
                               sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                               deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                               creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                               create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                               updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                               update_time DATETIME COMMENT '修改时间',
                               FOREIGN KEY ( tenant_id ) REFERENCES sys_tenant ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '定时任务组';
INSERT INTO sys_job_group(tenant_id,group_name) VALUES (1,'系统');

# sys_job
DROP TABLE IF EXISTS sys_job;
CREATE TABLE sys_job (
                         id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '任务id',
                         group_id BIGINT(20) NOT NULL COMMENT '任务组id',
                         job_name VARCHAR(50) NOT NULL COMMENT '任务名称',
                         job_status TINYINT UNSIGNED NOT NULL COMMENT '任务状态(0暂停、1正常)',
                         bean_name VARCHAR(200) NOT NULL COMMENT 'bean名称',
                         method_name  VARCHAR(50) NOT NULL COMMENT '方法名',
                         method_params TEXT(1000) COMMENT '方法参数',
                         cron_expression VARCHAR(200) NOT NULL COMMENT 'cron表达式',
                         concurrent_execute BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '是否并发执行(0是,1否)',
                         immediate BIT ( 1 ) NOT NULL DEFAULT 0 COMMENT '是否立即执行(0是,1否)',
                         `status` BIT ( 1 ) NOT NULL DEFAULT 1 COMMENT '数据状态(0禁用,1启用)',
                         remark VARCHAR ( 500 ) DEFAULT NULL COMMENT '备注',
                         version INT COMMENT '版本号',
                         sort INT ( 4 ) DEFAULT 0 COMMENT '排序序号',
                         deleted BIT( 1 )  NOT NULL DEFAULT 0 COMMENT '删除标志(0未删除,1已删除)',
                         creator VARCHAR ( 64 ) DEFAULT '' COMMENT '创建者',
                         create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                         updater VARCHAR ( 50 ) DEFAULT '' COMMENT '修改者',
                         update_time DATETIME COMMENT '修改时间',
                         FOREIGN KEY ( group_id ) REFERENCES sys_job_group ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '定时任务';

# sys_job_log
DROP TABLE IF EXISTS sys_job_log;
CREATE TABLE sys_job_log (
                             id BIGINT ( 20 ) PRIMARY KEY AUTO_INCREMENT COMMENT '任务id',
                             job_id        BIGINT(20) NOT NULL COMMENT '任务id',
                             `status`        TINYINT UNSIGNED NOT NULL COMMENT '任务状态(0失败,1成功)',
                             timer INT NOT NULL COMMENT '执行耗时(单位毫秒)',
                             exception TEXT COMMENT '异常信息',
                             create_time DATETIME DEFAULT NOW() COMMENT '创建时间',
                             FOREIGN KEY ( job_id ) REFERENCES sys_job ( id )
) ENGINE = INNODB CHARACTER
    SET = utf8mb4 COLLATE = utf8mb4_general_ci row_format = dynamic COMMENT '定时任务日志';
