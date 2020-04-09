define({ "api": [
  {
    "type": "GET",
    "url": "/api1",
    "title": "api1",
    "version": "1.0.0",
    "group": "Api1Controller",
    "name": "api1",
    "description": "<p>接口1</p>",
    "parameter": {
      "fields": {
        "请求参数": [
          {
            "group": "请求参数",
            "type": "int",
            "optional": false,
            "field": "id",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "请求参数示例",
          "content": "{\"id\": 2533}",
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
            "field": "name",
            "description": ""
          },
          {
            "group": "响应结果",
            "type": "String",
            "optional": false,
            "field": "address",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"address\":\"b\",\"name\":\"5U\"}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/cn/puhy/apidoc/controller/Api1Controller.java",
    "groupTitle": "Api1Controller"
  }
] });
