<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
    <h3>Server Status</h3>
    

    <table border="1">
        <tr>
            <th>
                Localization
            </th>
        </tr>
        <tr>
            <td>
                <fmt:message key="username" />
            </td>
            <td>
                <input type="text">
            </td>
        </tr>
        <tr>
            <td>
                <fmt:message key="password" />
            </td>
            <td>
                <input type="password">
            </td>
        </tr>
    </table>
    <hr>

    <a href="success">Simple GoTo -> Success</a>
    <hr>

    <a href="apis/goToCustomView">
        GoTo -> Custom View
    </a>
    <hr>
    <a href="apis/chicco">Get Chicco SysPropVal - GET</a>
    <hr>

    <a href="apis/serverStatus">Go Success - GET</a>
    <hr>

    <form action="apis/serverStatusPost" method="post">
        <input type="submit" value="Go Success - POST">
    </form>
    <hr>

    <a href="apis/serverSampleHeader">Go Test Header RequestMapping - GET</a>
    <hr>
    <form action="apis/serverSampleHeader" method="post">
        <input type="submit" value="Go Test Header RequestMapping - POST">
    </form>
    <hr>

    <a href="apis/serverSampleParams">Go Test Params RequestMapping - GET</a>
    <hr>
    <form action="apis/serverSampleParams" method="post">
        <input type="submit" value="Go Test Params RequestMapping - POST">
    </form>
    <hr>

    <a href="apis/serverSampleWildCheng/12345" >PathVariable - GET</a>

    <h3>Sample Rest API</h3>


    <form action="apis/sampleRest/api/" method="post">
        <input type="submit" value="Rest API - POST">
    </form>
    <hr>

    <a href="apis/sampleRest/api/12345" >PathVariable - GET</a>
    <hr>

    <form action="apis/sampleRest/api/12345" method="post">
        <input type="hidden" name="_method" value="PUT"/>
        <input type="submit" value="Rest API - PUT">
    </form>
    <hr>

    <form action="apis/sampleRest/api/12345" method="post">
        <input type="hidden" name="_method" value="DELETE"/>
        <input type="submit" value="Rest API - DELETE" />
    </form>
    <hr>

    <a href="apis/serverSampleRequestParams?name=Cheng">Test RequestParam - GET</a>
    <hr>
    <a href="apis/serverSampleHeaderParams">Test RequestHeader - GET</a>
    <hr>
    <a href="apis/serverSampleCookieValue">Test CookieValue - GET</a>
    <hr>

    <form action="apis/formToObject" METHOD="post">
        <table>
            <tr>
                <td>
                    Username:
                </td>
                <td>
                    <input type="text" name="username">
                </td>
            </tr>
            <tr>
                <td>
                    Password:
                </td>
                <td>
                    <input type="password" name="password">
                </td>
            </tr>

            <tr>
                <td>
                    City:
                </td>
                <td>
                    <input type="text" name="address.city">
                </td>
            </tr>
            <tr>
                <td>
                    State:
                </td>
                <td>
                    <input type="text" name="address.state">
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Go From to POJO">
                </td>
            </tr>
        </table>
    </form>
    <hr>

    <a href="apis/doServletAPI">Servlet API - GET</a>
    <hr>
    
    <a href="apis/doSpringModelAndView">ModelAndView - GET</a>
    <hr>

    <a href="apis/doSpringMap">Map - GET</a>
    <hr>

    <a href="apis/doSpringSessionAttr">SessionAttributes - GET</a>
    <hr>

    <a href="apis/doHttpSessionRequiredException">Do HttpSessionRequiredException - GET</a>
</body>
</html>