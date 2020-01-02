<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body> <!--  content.jsp -->
   <table>
    <tr> 
      <td> 이름 </td>
      <td> ${dto.name} </td>
    </tr>
    <tr> 
      <td> 나이 </td>
      <td> ${dto.age}</td>
    </tr>
    <tr> 
      <td> 전화번호 </td>
      <td> ${dto.phone} </td>
    </tr>
    <tr> 
      <td> 작성일 </td>
      <td> ${dto.writeday} </td>
    </tr>
   </table>
   <a href="update?id=${dto.id}"> 수정 </a>
   <a href="delete?id=${dto.id}"> 삭제 </a>
   <a href="list"> 목록 </a>
</body>
</html>










