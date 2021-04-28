<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>monster generate</h1>
	<form action="/admin/monster/generate" method="post">
		<strong>레벨</strong><input type="text" name="level" value="1"><br>
		<strong>이름</strong><input type="text" name="name" value=""><br>
		<strong>근력</strong><input type="text" name="strength" value=""><br>
		<strong>민첩</strong><input type="text" name="dexterity" value=""><br>
		<strong>지능</strong><input type="text" name="intelligence" value=""><br>
		<strong>체력</strong><input type="text" name="health" value=""><br>
		<strong>마나</strong><input type="text" name="mana" value=""><br>
		<strong>타입</strong><select name="type" id="">
			<option value="A">A</option>
			<option value="B">B</option>
			<option value="C">C</option>
			<option value="D">D</option>
		</select>
		<strong>경험치</strong><input type="text" name="exp" value=""><br>
		<strong>설명</strong><textarea name="info" id="" cols="30" rows="10"></textarea><br>
		<input type="submit" value="등록">
	</form>
</body>
</html>