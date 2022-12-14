<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ==" crossorigin="anonymous">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link
        href="https://fonts.googleapis.com/css2?family=Do+Hyeon&display=swap"
        rel="stylesheet">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
        <title>Document</title>
    <style>
        body {
            background-image: url('asset/img/bg.jpg');
            padding-left: 200px;
            padding-right: 200px;
            font-family: 'Do Hyeon', sans-serif;
        }
        .card-body {
            background-color: whitesmoke;
        }
        p {
            padding-top: 5px;
            padding-left: 20px;
            font-size: 30px;
        }
        img, #map-wrap, .list-group>li{
            padding-left: 20px;
            padding-top: 5px;
        }
        p>button{
            border: 0px;
        }
        span+button{
            margin-left: 10px;
        }
    </style>
</head>
<body>
    <div class="card-body" style="margin-top: 100px; margin-bottom: 10px; height: 50px">
		<p>${board.title } / ${board.boardwriter }
            <button class="like"><span class="material-symbols-outlined">heart_plus</span></button>
            <button class="dislike"><span class="material-symbols-outlined">heart_minus</span></button>
            <span id="likenum">${board.likenum }</span>
        </p>
	</div>
	<div class="card mb-2">
		<div class="card-body">
            <img alt="게시물사진" src="./asset/img/pg1.gif">
			<p>게시물내용</p>
            <div id="map-wrap">
                <div id="map" style="width:100%;height:350px;"></div>
            </div>
			<ul class="list-group list-group-flush">
                <li>댓글(<span class="com-cnt">${comNum }</span>)</li>
				<li class="list-group-item">
					<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
					<button type="button" class="btn btn-dark mt-3"onclick="addReply()">post reply</button>
				</li>
			</ul>
			<ul class="list-group list-group-flush" id="reply">
				<c:forEach var="com" items="${comList }" >
				<li class="list-group-item"><span>${com.content }/${com.comwriter }</span><button class="deleteBtn">삭제</button></li>
				</c:forEach>
			</ul>
		</div>
	</div>	
	<script>
		let likeSp = document.querySelector(".dislike+span");
	
	    document.getElementsByClassName("dislike")[0].style.display = "none";//배열형태로 반환되기 때문에 인덱스 번호 필요
	
	    //좋아요 버튼 눌렀을 때
	    document.querySelector(".like").addEventListener("click", function () {
	        //좋아요 버튼 안 보이게
	        document.querySelector(".like").style.display = "none";
	        //싫어요 버튼 보이게
	        document.querySelector(".dislike").style.display = "inline";
	        
	        const URL="http://localhost:8089/boot/board/like/plus/${board.boardnum}";
	      	setLikeNum(URL);
	    });
	    
	    //싫어요 기능
	    document.querySelector(".dislike").addEventListener("click", function () {
	        //싫어요 버튼 안 보이게
	        document.querySelector(".dislike").style.display = "none";
	        //좋아요 버튼 보이게
	        document.querySelector(".like").style.display = "inline";
	
	        
	        const URL="http://localhost:8089/boot/board/like/minus/${board.boardnum}";
	        setLikeNum(URL);
	    });
	    
	    //비동기 통신 함수
	        async function setLikeNum(url){
            	await fetch(url).then((data)=>data.json()).then((res)=>{
            		console.log(res);
            		
            		//DB에서 가져온 res값으로 좋아요 개수 변경하기
            		likeSp.innerText=res;
            	})
        	}
	    
	    //댓글 작성
	        function addReply() {
	            // 배열형태
	            let com = document.getElementsByTagName("textarea")[0];
				
	            //post방식으로 전송할 거라서 url은 여기까지만 작성!
	            const url="http://localhost:8089/boot/com/add";
	            
	            setCom(url, com.value);
	            
	        }
	    //댓글 작성 비동기 함수
	    	async function setCom(url, com){
	 
	    		const data={
	    			boardnum:${board.boardnum},
	    			content:com,
	    			comwriter:'까꿍밤'
	    		}
	    		
	    		//post방식으로 받아 주기 위해
	    			//데이터 속성도 지정해줘야 함
	    			//데이터를 body에 담아서 보냄
	    				//JSON.stringify(data): json형태의 객체를 문자열로 변환하는 작업
	    		const data1={
	    			method:'POST',
	    			headers:{
	    				'Content-Type':'application/json'
	    			},
	    			body:JSON.stringify(data)
	    		}
	    		
	    		//기본 값이 get방식이기 때문에 post방식으로 받을 수 있도록 지정해준 data1을 넣어주기
	    		await fetch(url, data1).then((data)=>data.json()).then((res)=>{
	    			 let comLi = document.createElement("li");//댓글 형식을 구성하는 li태그 생성<li></li>
	
	    			 if(res.result=="success"){
	 	            // li태그에 클래스 이름 넣기!
	 	            comLi.className = "list-group-item";

	 	            let comSp = document.createElement("span");//li태그 내에 추가해야 하는 span태그
	 	            comSp.appendChild(document.createTextNode(com + "/작성자"));//span태그 안에 텍스트 추가, textarea이기 때문에 value로 값을 가져올 수 있음
	 	            comLi.appendChild(comSp);//li태그에 span태그 자식 요소로 추가하는 거

	 	            let comBtn = document.createElement("button");//li태그 내에 추가해야 하는 button태그 생성
	 	            comBtn.className = "deleteBtn";
	 	            comBtn.appendChild(document.createTextNode("삭제"));//삭제 하는 버튼
	 	            comLi.appendChild(comBtn);//li태그에 button태그 자식 요소로 추가

	 	            //append: 뒤에 추가, prepend: 앞에 추가
	 	            document.getElementById("reply").prepend(comLi);//댓글 추가할 곳 : getElementById("reply"), 추가할 내용: prepend(comLi)

	 	            //댓글 창 비우기 -> 댓글 쓴 후 댓글 쓰는 창에 내용 비운다는 뜻
	 	            com.value = "";

	    			}
            
            	})
	    		
	    	}
	    
	</script>
	
</body>
</html>