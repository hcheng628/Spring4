<%--
  Created by IntelliJ IDEA.
  User: supercheng
  Date: 10/1/17
  Time: 9:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Model</title>
</head>
<body>
    <div>
        <span>
            Chicco WebLogic Value: ${ requestScope.chicco }
        </span>
    </div>
    <div>
        <span>
            ModelAndView name: ${ requestScope.name }
        </span>
    </div>
    <hr>
    <div>
        <span>
            Map Current Time: ${ requestScope.current_time }
        </span>
    </div>
    <div>
        <span>
            RequestScope: ${ requestScope.coffee }
        </span>
    </div>

    <div>
        <span>
            SessionScope: ${ sessionScope.coffee }
        </span>
    </div>

    <div>
        <span>
            SessionScope pet: ${ sessionScope.pet }
        </span>
    </div>


    <div>
        <span>
            SessionScope java: ${ sessionScope.java }
        </span>
    </div>
</body>
</html>
