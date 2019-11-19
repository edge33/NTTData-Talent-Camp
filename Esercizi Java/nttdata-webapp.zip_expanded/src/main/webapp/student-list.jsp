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
        	<a href="new">Add Student</a>
        	&nbsp;&nbsp;&nbsp;
        	<a href="list">List All Student</a>
        	
        </h2>
	</center>
	
    <div align="center">
        <table border="1" cellpadding="5">
            
            <caption><h2>List of Student</h2></caption>
            
            <tr>
             	<th>MATRICOLA</th>
                <th>COGNOME</th>
                <th>NOME</th>
                <th>CODICE FISCALE</th>
                <th>SESSO</th>
                <th>LOCALITA'</th>
                <th>PROVINCIA</th>
                <th>TELEFONO</th>
                <th>EMAIL</th>
                <th>DATA IMMATR.</th>
                <th>DATA NASCITA</th>
            </tr>
             
            <c:forEach var="studente" items="${listStudent}">
                <tr>
                 	<td><c:out value="${studente.matricola}" /></td>
                    <td><c:out value="${studente.cognome}" /></td>
                    <td><c:out value="${studente.nome}" /></td>
                    <td><c:out value="${studente.codiceFiscale}" /></td>
                    <td><c:out value="${studente.sesso}" /></td>
                    <td><c:out value="${studente.localita}" /></td>
                    <td><c:out value="${studente.provincia}" /></td>
                    <td><c:out value="${studente.telefono}" /></td>
                    <td><c:out value="${studente.email}" /></td>
                    <td><c:out value="${studente.dataNascita}" /></td>
                    <td><c:out value="${studente.dataImmatricolazione}" /></td>
                    
                    <td>
                    	<a href="edit?id=<c:out value='${studente.matricola}' />">Edit</a>
                    	
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	
                    	<a href="delete?id=<c:out value='${studente.matricola}' />">Delete</a>   
                    	
                    	&nbsp;&nbsp;&nbsp;&nbsp;
                    	
                    	<a href="exam?id=<c:out value='${studente.matricola}' />">Exam</a>                   	
                    	                 	
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</body>
</html>
