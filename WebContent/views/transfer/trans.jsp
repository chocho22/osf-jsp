<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OSF번역</title>
</head>
<body>
	<!-- 
code
('한국어','ko')
('영어','en')
('일본어','ja')
('중국어 간체','zh-CN')
('중국어 번체','zh-TW')
('스페인어','es')
('프랑스어','fr')
('러시아어','ru')
('베트남어','vi')
('태국어','th')
('인도네시아어','id')
('독일어','de')
('이탈리아어','it')
 
 이대로 쿼리박스에 insert
 -->
	<script>
		function check() {
			var selectObj1 = document.querySelector('#source');
			var selectObj2 = document.querySelector('#target');
			if (selectObj1.value == selectObj2.value) {
				alert('번역할 언어와 번역될 언어가 같습니다.\n다시 선택해주세요.');
				return false;
			}
			var textObj = document.querySelector('#text');
			if (textObj.value.length >= 100) {
				alert('번역 할 내용은 100글자 이상일 수 없습니다.');
				return false;
			}
			return true;
		}
		
	</script>
<c:if test="${rMap.isError=='true'}">
<script>
	alert("${rMap.msg}");
</script>
</c:if>
	<form method="post" action="/trans" onsubmit="return check()">
		<table border="1">
			<tr>
				<th>번역할 언어</th>
				<td><select name="source" id="source">
						<c:forEach items="${ccList}" var="cc">
							<option value="${cc.ccCode}"
								<c:if test="${cc.ccCode==param.source}">
			selected
			</c:if>>${cc.ccName}</option>
						</c:forEach>
				</select></td>
				<td rowspan="2"><button>번역</button></td>
				<th>번역될 언어</th>
				<td><select name="target" id="target">
						<c:forEach items="${ccList}" var="cc">
							<option value="${cc.ccCode}"
								<c:if test="${cc.ccCode==param.target}">
				selected
				</c:if>>${cc.ccName}</option>
						</c:forEach>
				</select></td>
			</tr>

			<tr>
				<td colspan="2"><textarea name="text" id="text">${param.text}</textarea>
				</td>
				<td colspan="2"><textarea>
					<c:if test="${rMap.isError!='true'}">
					${rMap.msg}
					</c:if>
				</textarea></td>
			</tr>
		</table>
	</form>
</body>
</html>