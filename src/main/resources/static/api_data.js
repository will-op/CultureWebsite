define({
    "api": [
        {
            "type": "DELETE",
            "url": "/admin/categorydelete/:categoryid/",
            "title": "删除分类",
            "version": "0.0.1",
            "group": "AdminController",
            "name": "____",
            "description": "<p>删除分类</p>",
            "parameter": {
                "fields": {
                    "Parameter": [
                        {
                            "group": "Parameter",
                            "type": "Number",
                            "optional": false,
                            "field": "categoryid",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "拼接URL",
                        "content": "127.0.0.1/admin/categorydelete/7",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "examples": [
                    {
                        "title": "Success-Response:",
                        "content": "{\n    \"errorMsg\": \"删除课程失败\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/AdminController.java",
            "groupTitle": "AdminController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/admin/categorydelete/:categoryid/"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/admin/categoryadd",
            "title": "增加分类",
            "version": "0.0.1",
            "group": "AdminController",
            "name": "categoryadd",
            "description": "<p>增加分类</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n      \"sortname\":\"测试\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"errorMsg\": \"添加类别成功\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/AdminController.java",
            "groupTitle": "AdminController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/admin/categoryadd"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/admin/courseadd",
            "title": "增加课程",
            "version": "0.0.1",
            "group": "AdminController",
            "name": "courseadd",
            "description": "<p>增加课程</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n    \"title\": \"油画课6\",\n    \"keyword\": \"油画\",\n    \"totalnum\": 120,\n    \"joined\": 50,\n    \"price\": 1500,\n    \"categoryid\": 2,\n    \"teacherid\": 2,\n    \"courseintro\": \"好课\",\n    \"abstracts\": \"haoaoahaohao\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "Success-Response:",
                        "content": "{\n    \"errMsg\": \"添加课程失败\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/AdminController.java",
            "groupTitle": "AdminController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/admin/courseadd"
                }
            ]
        },
        {
            "type": "DELETE",
            "url": "/admin/coursedelete/:courseid",
            "title": "删除课程",
            "version": "0.0.1",
            "group": "AdminController",
            "name": "coursedelete",
            "description": "<p>删除课程</p>",
            "parameter": {
                "examples": [
                    {
                        "title": "拼接字符串",
                        "content": "{admin/coursedelete/9}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"errMsg\": \"删除课程失败\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/AdminController.java",
            "groupTitle": "AdminController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/admin/coursedelete/:courseid"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/admin/courseupdate",
            "title": "更新课程",
            "version": "0.0.1",
            "group": "AdminController",
            "name": "courseupdate",
            "description": "<p>更新课程</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n    \"courseid\": 12,\n    \"title\": \"油画课233\",\n    \"keyword\": \"油画\",\n    \"totalnum\": 120,\n    \"joined\": 50,\n    \"price\": 1500,\n    \"categoryid\": 2,\n    \"teacherid\": 2,\n    \"courseintro\": \"好课\",\n    \"abstracts\": \"haoaoahaohao\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"errMsg\": \"更新课程成功\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/AdminController.java",
            "groupTitle": "AdminController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/admin/courseupdate"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/admin/categoryupdate",
            "title": "更新分类",
            "version": "0.0.1",
            "group": "AdminController",
            "name": "update",
            "description": "<p>更新分类</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n    \"categories\": [\n        {\n            \"categoryid\":1,\n            \"sortname\": \"国画\"\n        },\n        {\n            \"categoryid\": 2,\n            \"sortname\": \"油画\"\n        },\n        {\n            \"categoryid\": 3,\n            \"sortname\": \"水彩\"\n        },\n        {\n            \"categoryid\": 4,\n            \"sortname\": \"素描画\"\n        }\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"errorMsg\": \"更新类别成功\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/AdminController.java",
            "groupTitle": "AdminController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/admin/categoryupdate"
                }
            ]
        },
        {
            "success": {
                "fields": {
                    "Success 200": [
                        {
                            "group": "Success 200",
                            "optional": false,
                            "field": "varname1",
                            "description": "<p>No type.</p>"
                        },
                        {
                            "group": "Success 200",
                            "type": "String",
                            "optional": false,
                            "field": "varname2",
                            "description": "<p>With type.</p>"
                        }
                    ]
                }
            },
            "type": "",
            "url": "",
            "version": "0.0.0",
            "filename": "CultureWebsite/target/classes/static/main.js",
            "group": "C__Users_Administrator_Desktop_CultureWebsite_target_classes_static_main_js",
            "groupTitle": "C__Users_Administrator_Desktop_CultureWebsite_target_classes_static_main_js",
            "name": ""
        },
        {
            "type": "GET",
            "url": "/category/main",
            "title": "分类信息",
            "version": "0.0.1",
            "group": "CategoryController",
            "name": "main",
            "description": "<p>分类信息</p>",
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"categories\": [\n        {\n            \"categoryid\": 1,\n            \"sortname\": \"国画\",\n            \"courses\": null\n        },\n        {\n            \"categoryid\": 2,\n            \"sortname\": \"油画\",\n            \"courses\": null\n        },\n        {\n            \"categoryid\": 3,\n            \"sortname\": \"水彩\",\n            \"courses\": null\n        },\n        {\n            \"categoryid\": 4,\n            \"sortname\": \"素描\",\n            \"courses\": null\n        },\n        {\n            \"categoryid\": 8,\n            \"sortname\": \"测试\",\n            \"courses\": null\n        }\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CategoryController.java",
            "groupTitle": "CategoryController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/category/main"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/category/coursecoming",
            "title": "即将开始",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "____",
            "description": "<p>即将开始</p>",
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"coursecoming\": [\n        {\n            \"id\": null,\n            \"ctitle\": \"国画课2\",\n            \"cperiod\": \"第二课时\",\n            \"cid\": 2,\n            \"timegap\": \"61小时后开始\"\n        },\n        {\n            \"id\": null,\n            \"ctitle\": \"油画课\",\n            \"cperiod\": \"第三课时\",\n            \"cid\": 3,\n            \"timegap\": \"68小时后开始\"\n        },\n        {\n            \"id\": null,\n            \"ctitle\": \"国画课\",\n            \"cperiod\": \"第一课时\",\n            \"cid\": 1,\n            \"timegap\": \"109小时后开始\"\n        }\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CategoryController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/category/coursecoming"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/course/addcollect",
            "title": "用户添加收藏",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "addcollect",
            "description": "<p>用户添加收藏</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n      \"courseid\":1\n      \"userid\":1\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"errorMsg\": \"收藏课程失败\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/addcollect"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/course/query/:categoryid",
            "title": "查看该类别下课程（categoryid）",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "categoryquerybyid",
            "description": "<p>查看该类别下课程</p>",
            "parameter": {
                "fields": {
                    "请求参数": [
                        {
                            "group": "请求参数",
                            "type": "Number",
                            "optional": false,
                            "field": "categoryid",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "Number",
                            "optional": false,
                            "field": "currentPage",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "Number",
                            "optional": false,
                            "field": "pageSize",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "Object",
                            "optional": false,
                            "field": "session",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "拼接URL",
                        "content": "{/course/query/1/}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"courseForCategory\": {\n        \"total\": -1,\n        \"list\": [\n            {\n                \"courseid\": 1,\n                \"title\": \"国画课\",\n                \"keyword\": \"国画\",\n                \"totalnum\": 120,\n                \"joined\": 50,\n                \"price\": 1500,\n                \"categoryid\": 1,\n                \"teacherid\": 1,\n                \"courseintro\": null,\n                \"category\": null\n            }\n        ],\n        \"pageNum\": 1,\n        \"pageSize\": 1,\n        \"size\": 1,\n        \"startRow\": 1,\n        \"endRow\": 1,\n        \"pages\": 1,\n        \"prePage\": 0,\n        \"nextPage\": 0,\n        \"isFirstPage\": true,\n        \"isLastPage\": true,\n        \"hasPreviousPage\": false,\n        \"hasNextPage\": false,\n        \"navigatePages\": 8,\n        \"navigatepageNums\": [\n            1\n        ],\n        \"navigateFirstPage\": 1,\n        \"navigateLastPage\": 1\n    }\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/query/:categoryid"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/course/collectkeyword/:categoryid",
            "title": "类别下关键词",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "collectkeyword",
            "description": "<p>类别下关键词</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Number",
                            "optional": false,
                            "field": "categoryid",
                            "description": ""
                        }
                    ]
                }
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/collectkeyword/:categoryid"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/course/ifcollect",
            "title": "判断已收藏",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "ifcollect",
            "description": "<p>判断已收藏</p>",
            "parameter": {
                "fields": {
                    "请求参数": [
                        {
                            "group": "请求参数",
                            "type": "Object",
                            "optional": false,
                            "field": "session",
                            "description": ""
                        }
                    ],
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求参数示例",
                        "content": "session=null",
                        "type": "json"
                    },
                    {
                        "title": "请求体示例",
                        "content": "{\"object\":{}}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/ifcollect"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/period/periodOfCourse/:courseid/",
            "title": "购买时课时列表",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "periodOfCourse",
            "description": "<p>购买时课时列表</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Number",
                            "optional": false,
                            "field": "courseid",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{/period/periodOfCourse/1}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"courseperiod\": [\n        {\n            \"courseperiodid\": null,\n            \"courseperiodname\": \"第一课时\",\n            \"courseid\": 1,\n            \"begintime\": null\n        }\n    ],\n    \"courseid\": 1\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseperiodController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/period/periodOfCourse/:courseid/"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/course/querybycourseid",
            "title": "查看课程详情",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "querybycourseid",
            "description": "<p>查看课程详情</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n      \"courseid\":1\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"course\": {\n        \"courseid\": null,\n        \"title\": \"国画课\",\n        \"keyword\": null,\n        \"totalnum\": 120,\n        \"joined\": 50,\n        \"price\": null,\n        \"categoryid\": 1,\n        \"teacherid\": 1,\n        \"courseintro\": \"好课\",\n        \"category\": null\n    },\n    \"comments\": []\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/querybycourseid"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/course/querybykeyword",
            "title": "点击关键词搜索（categoryid+keyword）",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "querybykeyword",
            "description": "<p>点击关键词搜索</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "Object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n      \"categoryid\":1,\n      \"keyword\":\"国画\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"courseForKeyword\": [\n        {\n            \"courseid\": null,\n            \"title\": null,\n            \"keyword\": \"国画\",\n            \"totalnum\": null,\n            \"joined\": null,\n            \"price\": null,\n            \"categoryid\": null,\n            \"teacherid\": null,\n            \"courseintro\": null,\n            \"category\": null\n        }\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/querybykeyword"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/course/query/title",
            "title": "模糊查询",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "searchbytitle",
            "description": "<p>模糊查询（教师、关键词、描述、标题）</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n    \"title\": \"国画\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"title\": \"国画\",\n    \"detail\": [\n        {\n            \"courseid\": null,\n            \"title\": \"国画课\",\n            \"keyword\": null,\n            \"totalnum\": 120,\n            \"joined\": 50,\n            \"price\": 1500,\n            \"categoryid\": null,\n            \"teacherid\": 1,\n            \"courseintro\": null,\n            \"category\": null\n        },\n        {\n            \"courseid\": null,\n            \"title\": \"国画课2\",\n            \"keyword\": null,\n            \"totalnum\": 120,\n            \"joined\": 50,\n            \"price\": 1500,\n            \"categoryid\": null,\n            \"teacherid\": 2,\n            \"courseintro\": null,\n            \"category\": null\n        }\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/query/title"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/course/topteachers",
            "title": "热门导师热搜词",
            "version": "0.0.1",
            "group": "CourseController",
            "name": "topteachers",
            "description": "<p>热门老师</p>",
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"popteachers\": [\n        \"陈老师\"\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/topteachers"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/course/topworks",
            "title": "热门作品热搜词",
            "version": "1.0.0",
            "group": "CourseController",
            "name": "topworks",
            "description": "<p>热门作品</p>",
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"popteachers\": [\n        \"国画\"\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseController.java",
            "groupTitle": "CourseController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/course/topworks"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/usercourse/test",
            "title": "测试",
            "version": "0.0.1",
            "group": "CourseOfUserController",
            "name": "test",
            "description": "<p>测试</p>",
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "String",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "\"DSB8F5\"",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseOfUserController.java",
            "groupTitle": "CourseOfUserController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/usercourse/test"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/login/adminlogin",
            "title": "管理员登录（测试用，获取session）",
            "version": "0.0.1",
            "group": "LoginController",
            "name": "adminlogin",
            "description": "<p>管理员登录（测试用，获取session）</p>",
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "String",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "管理员接口sessionid='39dd68e6-ebb4-4507-8dab-215bdefd2682',测试管理员信息='Admin{adminid='10001', pwd='123456'}'",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/LoginController.java",
            "groupTitle": "LoginController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/login/adminlogin"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/login/adminregister",
            "title": "管理员注册",
            "version": "0.0.1",
            "group": "LoginController",
            "name": "adminregister",
            "description": "<p>管理员注册</p>",
            "parameter": {
                "fields": {
                    "请求参数": [
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "adminid",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "pwd",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求参数示例",
                        "content": "adminid=10002&pwd=123456",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "String",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "\"dqabUCM\"",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/LoginController.java",
            "groupTitle": "LoginController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/login/adminregister"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/login/usrlogin",
            "title": "用户登录（测试用，获取session）",
            "version": "0.0.1",
            "group": "LoginController",
            "name": "usrlogin",
            "description": "<p>用户登录（测试用，获取session）</p>",
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "String",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "用户接口sessionid='39dd68e6-ebb4-4507-8dab-215bdefd2682',测试用户信息='User{userid=1666666, wxid='oJp8353u2kg8rhPWb32b800LQG4Y', wxnickname='去创', sex='男', userscore=72}'",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/LoginController.java",
            "groupTitle": "LoginController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/login/usrlogin"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/user/signin",
            "title": "用户签到",
            "version": "0.0.1",
            "group": "UserController",
            "name": "____",
            "description": "<p>用户签到</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n    \"awardtype\":\"签到\",\n    \"userid\": 1\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"signFlag\": true,\n    \"addFlag\": true\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/UserController.java",
            "groupTitle": "UserController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/user/signin"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/comment/addcomment",
            "title": "用户评论",
            "version": "0.0.1",
            "group": "UserController",
            "name": "addcomment",
            "description": "<p>用户评论</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n      \"courseid\":1\n      \"ccomment\":\"好帅\"\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"addFlag\": \"评论成功\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CommentController.java",
            "groupTitle": "UserController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/comment/addcomment"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/usercourse/viewpurchased",
            "title": "查看已购买课程",
            "version": "0.0.1",
            "group": "UserController",
            "name": "courseofuser",
            "description": "<p>查看已购买课程</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n    \"userid\": 1\n}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"courseOfUsers\": [\n        {\n            \"courseofuserid\": null,\n            \"userid\": 1,\n            \"coursename\": null,\n            \"courseid\": 2,\n            \"buydate\": \"2019-06-02 11:05:32\",\n            \"courses\": [\n                {\n                    \"courseid\": null,\n                    \"title\": \"国画课2\",\n                    \"keyword\": null,\n                    \"totalnum\": null,\n                    \"joined\": null,\n                    \"price\": null,\n                    \"categoryid\": null,\n                    \"teacherid\": null,\n                    \"courseintro\": null,\n                    \"category\": null,\n                    \"comments\": null,\n                    \"teacher\": null\n                }\n            ]\n        },\n        {\n            \"courseofuserid\": null,\n            \"userid\": 1,\n            \"coursename\": null,\n            \"courseid\": 1,\n            \"buydate\": \"2019-06-02 11:49:31\",\n            \"courses\": [\n                {\n                    \"courseid\": null,\n                    \"title\": \"国画课\",\n                    \"keyword\": null,\n                    \"totalnum\": null,\n                    \"joined\": null,\n                    \"price\": null,\n                    \"categoryid\": null,\n                    \"teacherid\": null,\n                    \"courseintro\": null,\n                    \"category\": null,\n                    \"comments\": null,\n                    \"teacher\": null\n                }\n            ]\n        }\n    ]\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseOfUserController.java",
            "groupTitle": "UserController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/usercourse/viewpurchased"
                }
            ]
        },
        {
            "type": "POST",
            "url": "/usercourse/coursepurchase",
            "title": "购买课程",
            "version": "0.0.1",
            "group": "UserController",
            "name": "coursepurchase",
            "description": "<p>购买课程</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Object",
                            "optional": false,
                            "field": "object",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{\n    \"courseid\": 1,\n    \"userid\": 1,\n    \"period\": [\n        \"测试1\",\n        \"测试二\",\n        \"测试三\"\n    ]\n }",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{\n    \"errorMsg\": \"购买课程成功\"\n}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/CourseOfUserController.java",
            "groupTitle": "UserController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/usercourse/coursepurchase"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/user/showcollect/:userid/",
            "title": "查看收藏",
            "version": "0.0.1",
            "group": "UserController",
            "name": "showcollect",
            "description": "<p>查看收藏</p>",
            "parameter": {
                "fields": {
                    "请求体": [
                        {
                            "group": "请求体",
                            "type": "Number",
                            "optional": false,
                            "field": "userid",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求体示例",
                        "content": "{/user/showcollect/1}",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "Object",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "{}",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/UserController.java",
            "groupTitle": "UserController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/user/showcollect/:userid/"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/weixin/getAccess_Token",
            "title": "获取微信token",
            "version": "1.0.0",
            "group": "WechatTestController",
            "name": "getWechatToken",
            "description": "<p>获取微信token（需要上下文勿操作）</p>",
            "parameter": {
                "fields": {
                    "请求参数": [
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "code",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "state",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "Object",
                            "optional": false,
                            "field": "attributes",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "Object",
                            "optional": false,
                            "field": "session",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求参数示例",
                        "content": "code=wK282iqt&session=null&attributes=null&state=hry9Nsc1",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "String",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "\"KeSEG\"",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/WechatTestController.java",
            "groupTitle": "WechatTestController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/weixin/getAccess_Token"
                }
            ]
        },
        {
            "type": "GET",
            "url": "/youare/beautiful",
            "title": "公众号对接",
            "version": "0.0.1",
            "group": "WxPubController",
            "name": "wechatDocking",
            "description": "<p>公众号对接（需要上下文勿操作）</p>",
            "parameter": {
                "fields": {
                    "请求参数": [
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "TOKEN",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "signature",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "timestamp",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "nonce",
                            "description": ""
                        },
                        {
                            "group": "请求参数",
                            "type": "String",
                            "optional": false,
                            "field": "echostr",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "请求参数示例",
                        "content": "TOKEN=good&signature=n6M3m&nonce=lITV2Lb7&echostr=ODf09N&timestamp=Rnzg",
                        "type": "json"
                    }
                ]
            },
            "success": {
                "fields": {
                    "响应结果": [
                        {
                            "group": "响应结果",
                            "type": "String",
                            "optional": false,
                            "field": "response",
                            "description": ""
                        }
                    ]
                },
                "examples": [
                    {
                        "title": "响应结果示例",
                        "content": "\"fMv\"",
                        "type": "json"
                    }
                ]
            },
            "filename": "CultureWebsite/src/main/java/com/xm/sbdemo1/controller/WxPubController.java",
            "groupTitle": "WxPubController",
            "sampleRequest": [
                {
                    "url": "http://www.ueof.top/youare/beautiful"
                }
            ]
        }
    ]
});
