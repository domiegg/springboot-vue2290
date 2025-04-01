const menu = {
    list() {
        return [{
            "backMenu": [{
                "child": [{
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "用户",
                    "menuJump": "列表",
                    "tableName": "yonghu"
                }],
                "menu": "用户管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "游戏分类",
                    "menuJump": "列表",
                    "tableName": "youxifenlei"
                }],
                "menu": "游戏分类管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除", "查看评论"],
                    "menu": "游戏攻略",
                    "menuJump": "列表",
                    "tableName": "youxigonglue"
                }],
                "menu": "游戏攻略管理"
            }, {
                "child": [{
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "轮播图管理",
                    "tableName": "config"
                }, {
                    "buttons": ["新增", "查看", "修改", "删除"],
                    "menu": "游戏资讯",
                    "tableName": "news"
                }, {
                    "buttons": ["查看", "修改", "删除"],
                    "menu": "收藏管理",
                    "tableName": "storeup"
                }],
                "menu": "系统管理"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["查看"],
                    "menu": "游戏攻略列表",
                    "menuJump": "列表",
                    "tableName": "youxigonglue"
                }],
                "menu": "游戏攻略"
            }],
            "hasBackLogin": "是",
            "hasBackRegister": "否",
            "hasFrontLogin": "否",
            "hasFrontRegister": "否",
            "roleName": "管理员",
            "tableName": "users"
        }, {
            "backMenu": [{
                "child": [{
                    "buttons": ["查看", "删除"],
                    "menu": "收藏信息",
                    "tableName": "storeup"
                }],
                "menu": "收藏管理"
            }],
            "frontMenu": [{
                "child": [{
                    "buttons": ["查看", "新增" ,"修改" ,"删除"],
                    "menu": "游戏攻略列表",
                    "menuJump": "列表",
                    "tableName": "youxigonglue"
                }],
                "menu": "游戏攻略"
            }],
            "hasBackLogin": "否",
            "hasBackRegister": "否",
            "hasFrontLogin": "是",
            "hasFrontRegister": "是",
            "roleName": "用户",
            "tableName": "yonghu"
        }]
    }
}
export default menu;