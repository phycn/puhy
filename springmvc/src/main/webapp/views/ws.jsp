<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>websocket测试</title>
    <script type="text/javascript">
        var url = 'ws://' + window.location.host + '<%=request.getContextPath()%>/websocket';
        var sock = new WebSocket(url);

        //对应WebSocketHandler的afterConnectionEstablished
        sock.onopen = function () {
            console.log('开启WebSocket连接！');
            sayHello();
        }

        //对应WebSocketHandler的handleTextMessage
        sock.onmessage = function (e) {
            console.log('接受消息： ', e.data);
            setTimeout(function () {
                sayHello()
            }, 2000);
        }

        //对应WebSocketHandler的afterConnectionClosed
        sock.onclose = function () {
            console.log('关闭WebSocket连接！');
        }

        function sayHello() {
            console.log('发送消息： hello world！')
            sock.send('hello world!');
        }
    </script>
</head>
<body>
hello world!
</body>
</html>