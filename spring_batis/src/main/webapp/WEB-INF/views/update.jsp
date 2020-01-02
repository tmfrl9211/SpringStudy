<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <!--  update.jsp -->
  <form method=post action=update_ok>
   <input type=hidden name=id value="${dto.id}">
    이름 <input type=text name=name value="${dto.name}"> <p>
    나이 <input type=text name=age value="${dto.age}"> <p>
    전화번호 <input type=text name=phone value="${dto.phone}"> <p>
    <input type=submit value=수정>
  </form>
</body>
</html>