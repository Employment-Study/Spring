# [Spring] 12. REST API

작성일시: 2023년 10월 16일 오전 1:15
복습: No

# REST란?

HTTP URI + HTTP Method

HTTP URI를 통해 제어할 자원(Resource)을 명시하고, HTTP Method(GET,POST,PUT,DELETE)를 통해 해당 자원을 제어하는 명령을 내리는 방식의 아키텍처

## REST 3대 요소

1. 자원(URI) : 요청할때 보낼 자원
2. 조작 : HTTP Method
3. 표현 : xml,json 서버에대한 적절한 응답

## 4개의 메서드

[https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FrPv02%2FbtqVug9k6bg%2FY6uC9tVZPCpG5pj33Cax2k%2Fimg.png](https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2FrPv02%2FbtqVug9k6bg%2FY6uC9tVZPCpG5pj33Cax2k%2Fimg.png)

## REST의 기본 원칙 6가지

1. 클라이언트-서버 모델
    - 서버와 클라이언트 역할이 분리되어 독립적으로 교체 및 개발될 수 있다.
    - 사용자 인터페이스와 데이터 처리 영역이 분리될 수 있어 유지 보수가 매우 쉬워진다.
2. 무상태
    - 세션 상태가 서버에 젖아되어 있지 않은 상태, 필요에 따라 외부 DB에 저장하기도 한다.
    - server는 단순히 요청이 오면 응답을 보내는 역할만 수행하며, 세션 관리는 client에게 책임이 있다.
        - 장점 : scaling이 자유롭다.
3. 캐시 가능
    - 웹 표준인 HTTP를 그대로 사용하기 때문에, 웹에서 사용하는 기존 인프라를 그대로 사용할 수 있다. 따라서 HTTP가 가진 캐싱 기능을 적용할 수 있다.
    - 캐싱 처리 : GET요청에서 주로 처리된다.
    - 관련 헤더들- if-Match
        - client가 함께 보낸 Etag식별자와 같은 값이 있으면 200
        - 다른 값이 있으면 412 http code로 응답, 덮어쓰기 용도로 사용된다.
    - 관련 헤더들 - if-Modified-Since
        - Last-Modified의 값을 표기하여 전달해주고, 동일한 컨텐츠라면 (최종 수정 시간이 같다면 ) 304 http code로 응답
        - 만약 다른 컨텐츠라면 (If-Modified-Since 에 들어간 last-modified 값보다 이후에 데이터가 수정되었다면) 200 으로 응답If-**None**match : ETag 식별자와 같은 값이라면 304를 전달하고, **다른 값**이라면 200을 응답한다. 신규 값을 생성하고, 덮어쓰기를 금지하는 용도로 사용된다.
    - 캐싱 관련 검증 헤더
        - ETag
        - last-modified
    - 참고
        - 412 : Precondition Failed , 클라이언트 오류 응답 코드는 대상 리소스에 대한 액세스가 거부되었음을 나타냅니다.
        - ETag : ETag HTTP 응답 헤더는 특정 버전의 리소스를 식별하는 식별자입니다. (like 주민등록번호)
4. 자체 표현구조
    - REST API만 보고도 이를 쉽게 이해할 수 있다.
5. 계층화(Layered System)
    - 클라이언트 입장에서는 REST API 서버만 호출한다.
    - 하지만, REST 서버는 다중 계층으로 구성될 수 있으며, 로드 밸런싱, 암호화 계층을 추가해 구조상의 유연성을 둘 수 있고 PROXY, 게이트웨이 같은 네트워크 기반의 중간매체를 사용할 수 있음
    - 내부 레이어를 숨기고, 인접한 레이어에만 공개함으로써 레이어간의 결합을 줄인다
6. Uniform Interface
    - HTTP 표준만 따른다면 어떤 언어 혹은 어떤 플랫폼에서 사용하여도 사용이 가능한 인터페이스 스타일이다.
    - 안드로이드 플랫폼, IOS 플랫폼 등 특정 언어나 플랫폼에 종속되지 않고 사용이 가능하다.
    

### 응답 메세지 처리하기

`잘 설계된 API 는 리소스에 대한 응답까지도 잘 해줘야 한다.`

1) 200대

- 200 : 클라이언트의 요청을 정상적으로 수행
- 201 : POST 를 통한 리소스 생성 작업 시, 해당 리소스가 성공적으로 생성됨을 알려줌

2) 400대

- 400 : 클라이언트의 요청이 부적절한 경우 사용
- 401 : 인증되지 않은 클라이언트의 요청에 대한 응답
- 403 : 인가되지 않은, 응답하고 싶지 않은 리소스에 접근하려 할 때 이에 대한 응답
- 405 : 요청 리소스에 대해 사용 불가능한 method 를 이용했을 때 사용하는 응답

3) 500대

- 500 : 서버에 문제가 있을 경우 사용하는 응답 코드

4) 300대

- 301 : 요청한 리소스에 대한 URI 가 변경되었을 때 사용하는 응답 코드

## 의존성 추가 코드

```xml
<!-- https://mvnrepository.com/artifact/com.fasterxml.jackson.core/jackson-databind -->
		<dependency>
			<groupId>com.fasterxml.jackson.core</groupId>
			<artifactId>jackson-databind</artifactId>
			<version>2.15.2</version>
		</dependency>
```

## Servlet-context.xml코드

```xml
<annotation-driven>
	<message-converters>
		<beans:bean
			class="org.springframework.http.converter.StringHttpMessageConverter">
			<beans:property name="supportedMediaTypes">
				<beans:list>
						<beans:value>plain/text;charset=utf-8</beans:value>
						<beans:value>application/json;charset=utf-8</beans:value>
					</beans:list>
				</beans:property>
			</beans:bean>
		</message-converters>
	</annotation-driven>
```

## Controller에서 처리하는 Ajax

## Ajax를 이용한 GET요청 - VIEW

```html
<div class="content">
	<h3> 백엔드(컨트롤러)에 데이터를 요청하여 응답받고, 그 값을 문서에 반영하기</h3>
	<button id="btn2"> 버튼2 </button>
	<span id="span2"></span>
	
	<script>
		const btn2 = document.getElementById('btn2')
		btn2.onclick =function() {
			const url = '${cpath}/ajax2'		//요청할 주소를 지정
			
			fetch(url)							// 지정한 주소로 요청을 전송한다(이후 컨트롤러 코드 실행)
			.then(resp => resp.text())			// 서버가 응답을 반환하면 텍스트 형식으로 변환한다.
			.then(text =>{						// 해당 텍스트를 이용하여 아래 코드를 수행한다.
				const span2 = document.getElementById('span2')	// 문서의 span2를 불러와서
				span2.innerText = '서버에서 보낸 값: '+ text			// 글자를 넣는다.
			})
		}
	</script>
</div>
```

## Ajax를 이용한 Get요청 처리 -Controller

```java
@GetMapping("/ajax2")
	@ResponseBody	// 이 함수가 반환하는 값 그 자체가 응답이다(포워딩 하지마라)
	public String ajax2() {
		int num =  ran.nextInt(1000);
		String value = String.format("%04d", num);
		return value;
	}
```

## AJax를 이용한 Get요청 처리2-VIEW

```html
<div class="content">
	<p><input type="text" name="name" placeholder="이름" ></p>
	<p><input type="number" name="age" placeholder="나이" ></p>
	<p><input id="btn3" type="button" value="GET"></p>
	<p><input id="btn4" type="button" value="POST"></p>
	<p><span id="span3"></span></p>
	<p><span id="span4"></span></p>
	<script>
		const btn3 = document.getElementById('btn3')
		btn3.onclick= function(){
			const name =document.querySelector('input[name="name"]')
			const age =document.querySelector('input[name="age"]')
			
			
			//GET 요청이면 일반 요청과 동일하게 쿼리스트링 형식을 이용하여 파라미터를 전달할 수 있다.
			//GET은 body 
			const url = '${cpath}/ajax3?name='+name.value+'&age='+age.value
			fetch(url)
			.then(response=> response.text())
			.then(text => {
				const span3 = document.getElementById('span3')
				span3.innerText = text
			} )
		}
	</script>
```

## Ajax를 이용한 GET요청 처리 - RestController

```java
@RequestMapping(value="/ajax3", method = RequestMethod.GET, produces = "plain/text;charset=utf-8")
	@ResponseBody
	public String ajax3(String name, int age) {
		System.out.println("name :" + name);
		System.out.println("age : "+ age);
		boolean isAdult = age>=20;
		
		String value = String.format("%s님은 %d살이고 %s입니다.", name,age,isAdult?"성인":"미성년자");
	
		return value;
	}
```

## RestController에서 처리하는 Ajax

## View코드

```java
<div class="content">
	<h3>현재 가입된 목록</h3>
	<table id="table" border="1" cellpadding="10" cellspacing="0">
		<thead>
			<tr>
				<th>userid</th>
				<th>userpw</th>
				<th>username</th>
				<th>gender</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
	
	<script>
	window.addEventListener('DOMContentLoaded', async function(){
		const tbody = document.querySelector('#table tbody');
		const url = '${cpath}/memberList';
		const memberList = await fetch(url).then(resp => resp.json());

		console.log(memberList);

			let tag = '';
		memberList.forEach(e => {
			tag += '<tr>';
			tag += '<td>'+e.userid+'</td>';
			tag += '<td>'+e.userpw+'</td>';
			tag += '<td>'+e.username+'</td>';
			tag += '<td>'+e.gender+'</td>';
			tag += '</tr>';
		});
		tbody.innerHTML = tag
	});
	</script>
</div>
```

## @RestController를 사용한 Controller 코드

```java
@RestController 
//내부의 모든 함수는 @ResponseBody를 자동으로 적용받는다.
//jsp 포워딩 할 수 없다.

//@CrossOrigin // localhost의 jsp에서 localhost의 서버로 ajax요청을 보내는 것은 항상 허용된다.
//			 // localost의 jsp에서 다른 서버로 ajax요청을 받는 것은 허용되지 않는다.
//			 // same=origin(동일 출처 자원 공유 원칙)에 의해, 서버에 허용해야 다른 도메인에서 자원을 요청할 수 있다.)
//			//CORS(Cross Origin Resource Sharing)를 제어하기 위해 다른 서버에 요청을 해서 자원을 받아올 수 있다.
//// 로컬호스트가 타 서버에 요청을 보내는 것이 아니라, 로컬호스트의 서버가 타 서버에 요청을 보내야 값을 가져올 수 있는 경우가 있다.
public class AjaxController {
	
	// servlet-context.xml 에서 annotation-driven 내부에 message-converter를 작성하면
	// produces와 consumes에 대한 미디어 타입을 생략할 수 있다

@GetMapping("/memberList")
	public List<MemberDTO> memberList(){
		return memberDAO.selectList();
	}
```

## 비동기로 회원가입(아이디 중복 여부 체크)

## VIEW 코드

```html

<div class="content">
	<h3>회원 테이블 계정 중복 여부 확인하기</h3>
	<form id="joinform">
	<p>
		<input type="text" name="userid" placeholder="ID" autocomplete="off" required>
		<input id ="btn5" type="button" value="중복 확인"> <!-- button 태그면 제출이되지만 input type=button은 되지 않음 -->
	</p>
	<p>
		<span id="span5"></span>
	</p>
		<p><input type="password" name="userpw" placeholder="Password"></p>
		<p><input type="text" name="username" placeholder="Name" autocomplete="off" required></p>
		<p>
			<select name="gender" required>
				<option value="">=== 성별 선택 ===</option>
				<option value="남성">남성</option>
				<option value="여성">여성</option>
				</select>
		</p>
		<p><input type="submit" value="가입"></p>
	</form>
<script>
		// 1) 입력된 아이디가 사용중인 아이디인지 체크하기
		const btn5 = document.getElementById('btn5');
		console.log(btn5)
		btn5.onclick = async function(){
			console.log('클릭')
			const userid = document.querySelector('input[name="userid"]');
			console.log(userid)
			if(userid.value == ''){
				alert('사용할 ID를 먼저 입력하세요')
				userid.focus()
				return
			}
			const url = '${cpath}/ajax5?userid='+userid.value;
			
			
			// 지정한 주소로 요청한 후 , 응답이 오면 응답을 json형태로 변환하여 result에 저장한다.
			// await을 쓰지 않으면 promise 타입이 반환된다.
			const result = await (fetch(url).then(resp=> resp.json()));
			const span5 = document.getElementById('span5')
			span5.innerText =  result.msg
			span5.style.color = result.color
		}
		
			//2) 회원 가입
				const joinForm = document.getElementById('joinform')
				console.log(joinForm)
				joinForm.onsubmit = async function(event){
				
				event.preventDefault();	// 기본작동 막기. form이 제출되지 않는다.
				
				const formData = new FormData(joinForm) // form안에 있는 input을 다 불러온다
				const ob = {}							// 빈 JS객체를 준비한다.
				for (let element of formData.entries()) {
				    ob[element[0]] = element[1];
				}
				console.log(ob);
				
				const url = '${cpath}/join'
				const opt = {
						method : 'POST',
						body : JSON.stringify(ob),
						headers:{
							'Content-Type' : 'application/json;charset=utf-8'
						}
				}
				const result = await fetch(url,opt).then(resp => resp.json())
				alert(result.status)
				if(result.status == '가입성공'){
					joinForm.reset()
					document.getElementById('span5').innerText = '';
				}
			
				
			}
		
		</script>
	
</div>
```

## RestController 코드

```java
@GetMapping("/ajax5")
	public HashMap<String, String> ajax5(String userid) throws JsonProcessingException {
		MemberDTO dto = memberDAO.selectOneByUserId(userid);
		String msg = dto == null? "사용가능한 ID입니다." : " 이미 사용중인 ID입니다.";
		String color = dto == null? "blue" : "red";
		
		//1)직접 JSON 형식의 문자열 구성하기
//		String result= "{\"msg\" : \"%s\", \"color\" : \"%s\"}";
//		result = String.format(result, msg, color);
		
		//2) dto 혹은 hashmap에 값을 넣은 후 objectMapper를 활용하여 문자열로 변환하기
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("msg",msg);
//		map.put("color",color);
		
//		String result= mapper.writeValueAsString(map); 
//		//예외는 throws,  DTO,HashMap,List(자바스크립트의 배열타입으로 바뀜)도 가능
//		System.out.println(result);
//		return result;
	
		
		//3) 자바 객체를 그냥 반환하기
		//하지만 직접 사용하지 않아도 선언만 해주면 알아서 변환해준다.
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("msg",msg);
		map.put("color",color);
		
		return map;
	}
```

## 비동기로  회원가입 완료하기

## VIEW 코드

✅formData 메서드에대한 자료

[FormData 객체](https://ko.javascript.info/formdata)

```java
<div class="content">
	<h3>회원 테이블 계정 중복 여부 확인하기</h3>
	<form id="joinform">
	<p>
		<input type="text" name="userid" placeholder="ID" autocomplete="off" required>
		<input id ="btn5" type="button" value="중복 확인"> <!-- button 태그면 제출이되지만 input type=button은 되지 않음 -->
	</p>
	<p>
		<span id="span5"></span>
	</p>
		<p><input type="password" name="userpw" placeholder="Password"></p>
		<p><input type="text" name="username" placeholder="Name" autocomplete="off" required></p>
		<p>
			<select name="gender" required>
				<option value="">=== 성별 선택 ===</option>
				<option value="남성">남성</option>
				<option value="여성">여성</option>
				</select>
		</p>
		<p><input type="submit" value="가입"></p>
	</form>
	
	<script>
			//2) 회원 가입
				const joinForm = document.getElementById('joinform')
				console.log(joinForm)
				joinForm.onsubmit = async function(event){
				
				event.preventDefault();	// 기본작동 막기. form이 제출되지 않는다.
				
				const formData = new FormData(joinForm) // form안에 있는 input을 다 불러온다
				const ob = {}							// 빈 JS객체를 준비한다.
				for (let element of formData.entries()) {
				    ob[element[0]] = element[1];
				}
				console.log(ob);
				
				const url = '${cpath}/join'
				const opt = {
						method : 'POST',
						body : JSON.stringify(ob),
						headers:{
							'Content-Type' : 'application/json;charset=utf-8'
						}
				}
				const result = await fetch(url,opt).then(resp => resp.json())
				alert(result.status)
				if(result.status == '가입성공'){
					joinForm.reset()
					document.getElementById('span5').innerText = '';
				}
			
				
			}
		
		</script>
	
</div>
```

## RestController로 요청 처리하기

```java
@PostMapping("/join")		//@RequestBody : JSON 데이터를 받기 위해 선언
	public HashMap<String, String> join(@RequestBody MemberDTO dto) { 
		int row = memberDAO.insert(dto);
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("status",row != 0 ? "가입성공" : "가입 실패");
		map.put("color", row!= 0? "blue " : "red");
		
		return map;
	}
```