<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Locale" %>
<%@ page import="java.text.DateFormat" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>CreditFlow 6.0 Proxy Service</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<script>
    $(document).ready(function () {
            $('select').change(function () {
                $("select option:selected").each(function (el) {
                    var locale = $(this).val();
                    console.log("Locale Country: " + locale);
                    $.get("api/rest/test/changeLocale?newLocale=" + locale,
                        function (data) {
                         if(data == locale){
                             location.reload();
                         }
                        }
                    );
                });
            });
        }
    );
</script>

<div class="row" style="margin-top: 100px">
        <div class="container">
            <div class="col-md-9">
                <a href="api/rest/getEmps" class="btn btn-success">Employee Services</a>
                <br><br>
                <a href="api/rest/test/customEmpConverter?employee=1-first-last-email-1-1" class="btn btn-success">Custom Emp Converter Test</a>
                <br><br>
                <a href="api/rest/test/ObjectToJson" class="btn btn-success">Object -> JSON</a>
            </div>

            <div class="col-md-9" style="margin-top: 30px">
                <form action="api/rest/test/getFileInfo" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <div>
                            <label for="uploadFile" class="btn btn-primary">
                                <span>Upload</span>
                                <input id="uploadFile" type="file" name="file" class="form-control" style="display: none">
                            </label>
                        </div>
                        <div>
                            <label for="uploadFileDesc">File Desc: </label>
                            <input id="uploadFileDesc" type="text" name="desc" class="form-control">
                        </div>
                        <div>
                            <input type="submit" value="Go Submit" class="form-control">
                        </div>
                    </div>
                </form>
            </div>
            
            <div class="col-md-9" style="margin-top: 30px">
                <a href="api/rest/test/doDownloadFile" class="btn btn-success">Test Download File</a>
            </div>

            <div class="col-md-9" style="margin-top: 30px;">
                <select name="localeCountry" id="local">
                    <option value="en_US">English</option>
                    <option value="zh_CN">Chinese</option>
                </select>
                <br><br>
                <div>
                    <span><fmt:message key="app.current.dateTime" />: </span>
                </div>
                <fmt:setLocale value="${sessionScope.currentLocale}" scope="session"/>
                <%
                    Date currrentDateTime = new Date();
                    Locale locale = null;
                    if(session.getAttribute("currentLocale") == null) {
                        locale = new Locale("en");
                    }else {
                        locale = new Locale(session.getAttribute("currentLocale").toString().substring(2));
                    }
                    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
                    session.setAttribute("currrentDateTime", df.format(currrentDateTime).toString());
                %>
                ${sessionScope.currrentDateTime}
            </div>

            <div class="col-md-9" style="margin-top: 30px;">
                <form action="api/rest/test/doUploadFile" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <div>
                            <label for="fileUpload" class="btn btn-primary">
                                <span>Upload Me</span>
                                <input id="fileUpload" type="file" name="file" class="form-control" style="display: none">
                            </label>
                        </div>
                        <div>
                            <label for="fileDesc">File Desc: </label>
                            <input id="fileDesc" type="text" name="desc" class="form-control">
                        </div>
                        <div>
                            <input type="submit" value="Do Upload" class="form-control">
                        </div>
                    </div>
                </form>

            </div>
        </div>
    </div>
</body>
</html>