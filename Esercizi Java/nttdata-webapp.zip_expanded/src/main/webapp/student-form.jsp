<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>UNIWEX 1.0.0</title>
</head>
<body>
	<center>
		<h1>UNIWEX JAVA</h1>
		<h2>
			<a href="new">Add New student</a> 
			&nbsp;&nbsp;&nbsp; 
			<a href="list">List All Student</a>
		</h2>
	</center>

	<div align="center">

		<c:if test="${studente != null}">
			<form action="update" method="post">
		</c:if>

		<c:if test="${studente == null}">
			<form action="insert" method="post">
		</c:if>

		<table border="1" cellpadding="5">
			<caption>
				<h2>
					<c:if test="${studente != null}">
		            			Edit Student
		            </c:if>
		            		
					<c:if test="${studente == null}">
		            			Add New Student
		            </c:if>
				</h2>
			</caption>

			<c:if test="${studente != null}">
				<input type="hidden" name="id" value="<c:out value='${studente.matricola}' />" />
			</c:if>
			
			<tr>
				<th>Matricola: </th>

				<td>
					<c:if test="${studente != null}">
						<input type="text" name="matricola" size="45" value="<c:out value='${studente.matricola}' />" readonly="false" />
					</c:if>
					
					<c:if test="${studente == null}">
						<input type="text" name="matricola" size="45" value="<c:out value='${studente.matricola}' />" />
					</c:if>
					
					
				</td>
			</tr>
			
			
			<tr>
				<th>Cognome: </th>

				<td>
					<input type="text" name="cognome" size="45" value="<c:out value='${studente.cognome}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Nome: </th>

				<td>
					<input type="text" name="nome" size="45" value="<c:out value='${studente.nome}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Codice Fiscale: </th>

				<td>
					<input type="text" name="codiceFiscale" size="45" value="<c:out value='${studente.codiceFiscale}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Sesso: </th>

				<td>
					<input type="text" name="sesso" size="45" value="<c:out value='${studente.sesso}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Localita: </th>

				<td>
					<input type="text" name="localita" size="45" value="<c:out value='${studente.localita}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Provincia: </th>

				<td>
					<input type="text" name="provincia" size="45" value="<c:out value='${studente.provincia}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Telefono: </th>

				<td>
					<input type="text" name="telefono" size="45" value="<c:out value='${studente.telefono}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Email: </th>

				<td>
					<input type="text" name="email" size="45" value="<c:out value='${studente.email}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Data di Nasciata: </th>

				<td>
					<input type="text" name="dataNascita" size="45" value="<c:out value='${studente.dataNascita}' />" />
				</td>
			</tr>
			
			<tr>
				<th>Data Immatricolazione: </th>

				<td>
					<input type="text" name="dataImma" size="45" value="<c:out value='${studente.dataImmatricolazione}' />" />
				</td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Save" /></td>
			</tr>
			
		</table>
		</form>
	</div>
</body>
</html>
