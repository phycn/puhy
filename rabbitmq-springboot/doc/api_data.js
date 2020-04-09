define({ "api": [
  {
    "type": "GET",
    "url": "/send",
    "title": "send",
    "version": "1.0.1",
    "group": "TestController",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": true,
            "field": "id",
            "defaultValue": "1",
            "description": "<p>用户id</p>"
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": true,
            "field": "address[street]",
            "description": ""
          },
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "country",
            "defaultValue": "DE",
            "description": ""
          }
        ]
      }
    },
    "name": "send",
    "description": "<p>测试</p>",
    "success": {
      "fields": {
        "响应结果111": [
          {
            "group": "响应结果111",
            "type": "String",
            "optional": false,
            "field": "name",
            "description": ""
          },
          {
            "group": "响应结果111",
            "type": "String",
            "optional": false,
            "field": "age",
            "description": ""
          }
        ]
      },
      "examples": [
        {
          "title": "响应结果示例",
          "content": "{\"name\": \"phy\", \"id\": 1}",
          "type": "json"
        }
      ]
    },
    "filename": "src/main/java/cn/puhy/study/rabbitmqspringboot/controller/TestController.java",
    "groupTitle": "TestController"
  }
] });
