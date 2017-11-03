<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
	<title>Spring MVC Internationalization i18n 2</title>
</head>
<body>

<h1>Spring MVC Internationalization i18n 2</h1>
Language : <a href="changeLocale?lang=en_US">English</a> | <a href="changeLocale?lang=zh_CN">Chinese</a>
<p>${message}</p>
<p><spring:message code="app.current.dateTime"/></p>
Current Locale : ${pageContext.response.locale} / ${locale}

</body>
</html>