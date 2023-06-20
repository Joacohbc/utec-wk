<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ultimo Incidente</title>
</head>
<body>
			<table>
		<tr>
			<td>
				Nombre y apellido:
			</td>
			<td>
				${requestScope.nombres}
			</td>
		</tr>
		<tr>
			<td>
				Descripcion de la Solicitud:
			</td>
			<td>
				${requestScope.descripcion}
			</td>
		</tr>
		<tr>
			<td>
				Tipo de Solicitud
			</td>
			<td>
				${requestScope.tipo}
			</td>
		</tr>
		<tr>
			<td>
				Duracion:
			</td>
			<td>
				${requestScope.duracion}
			</td>
		</tr>
		<tr>
			<td>
				Estado del Llamado:
			</td>
			<td>
				${requestScope.estado}
			</td>
		</tr>
	</table>
	<a href="registroAtencion.html">Ingresar otro incidente</a>
</body>
</html>