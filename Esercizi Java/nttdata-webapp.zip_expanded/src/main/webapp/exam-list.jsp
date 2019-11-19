<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>UNIWEX 1.0.0</title>
</head>
<body>
	<center>
		<h1>UNIWEX JAVA</h1>
        <h2>
        	<a href="list">List All Student</a>
        	
        </h2>
	</center>
	
    <div align="center">
        <table border="1" cellpadding="5">
        
            <caption><h2>List of Exam</h2></caption>
                
            <tr>
             	<th>COD CORSO LAUREA</th>
                <th>MATRICOLA</th>
                <th>DESCRIZIONE ESAME</th>
                <th>CFU</th>
                <th>ANNO</th>
                <th>SEMESTRE</th>
            </tr>
            
            <c:forEach var="exam" items="${listExam}">
                <tr>
                 	<td><c:out value="${exam.codCorsoLaurea}" /></td>
                    <td><c:out value="${exam.matricola}" /></td>
                    <td><c:out value="${exam.esameDesc}" /></td>
                    <td><c:out value="${exam.cfu}" /></td>
                    <td><c:out value="${exam.anno}" /></td>
                    <td><c:out value="${exam.semestre}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
