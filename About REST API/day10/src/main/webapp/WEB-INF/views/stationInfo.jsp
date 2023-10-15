<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<button id="test">테스트 버튼</button>
	<span id="spantag"></span>
	<script>
		const testTag = document.getElementById('test');
		console.log(testTag)
	
	const url='https://apis.data.go.kr/B551232/OAMS_STATN_01/GET_OAMS_STATN_01?serviceKey=v8z2gnVvlHgshJSRT3ay2Cjw5w83oxS2ZzFlrQfkUSuboKQPdA6hUY5hfeOMzwPzYAk3H301kUPWwtWUKclmhA%3D%3D&pageNo=1&numOfRows=10&apiType=json&STATION_NAME=%EC%86%8C%ED%83%9C';
		
		testTag.onclick = async function(){
			await fetch(url)
			.then(resp => resp.text())
			.then(text =>{
				console.log(text)
			const spantag = document.getElementById('spantag');
			spantag.innerText = text
				
			})
			
			
		}
	</script>
</body>
</html>