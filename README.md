## 项目技术栈
| 依赖名称 | 描述  | 版本 |
|------|-----|----|
| JDK  | JDK | 21 |

## 项目目录
- wuhu-boot-server:应用启动服务,负责项目的配置、启动。
- wuhu-boot-auth:认证服务,提供用户名密码、手机号验证码、扫码、SSO等认证。
- wuhu-boot-system:系统模块,包含用户、角色、部门、菜单、数据字典、操作日志等系统功能。
- wuhu-boot-im:即时通讯服务,提供简单的单聊、群聊等常见im功能。
- wuhu-boot-components:组件服务。提供短信、OSS、定时任务存储等服务。
  - wuhu-component-generator:代码生成器服务。
  - wuhu-component-ssm:SSM短信服务。
  - wuhu-component-oss:提供OSS服务。

## git 提交规范
- build:对构建系统或者外部依赖项进行了修改。
- ci:对CI配置文件或脚本进行了修改。
- docs:对文档进行了修改。
- feat:增加新的特征。
- fix:修复bug。
- pref:提高性能的代码更改。
- refactor:既不是修复bug也不是添加特征的代码重构。
- style:不影响代码含义的修改，比如空格、格式化、缺失的分号等。
- config:修改了项目中配置文件。
- test:增加确实的测试或者矫正已存在的测试。
- sql:修改sql脚本。