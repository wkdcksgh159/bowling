// ### 경기 입력 START #############################################################################################
	
	// game 테이블에  경기 데이터를 입력하기 위해 데이터 출력하는 함수
	let setGame = function(){
		// homeTeam 팀 명단을 불러오는 함수
		$.ajax({
			url:"/getHomeTeam",
			method:"POST",
			success:function(json){
				$(json).each(function(index, item){
					// console.log("setGame function homeTeam list : ", json);
					temp = "<option value='";
					temp += item.teamName;
					temp += "'>";
					temp += item.teamName;
					temp += "</option>";
					$("#getHomeTeam").append(temp);
				});
			}
		});
		
		// hometeam 선수를 불러오는 함수
		$("#getHomeTeam").change(function(){
			$.ajax({
				url:"/getHomeTeamPlayer",
				method:"POST",
				data:{"teamName":$("#getHomeTeam").val()},
				success:function(json){
					$("#getHomeTeamPlayer").empty();
					$("#getHomeTeamPlayer").append("<option value=0>선수 선택</option>");
					$(json).each(function(index, item){
						// console.log("setGame function homeTeamPlayer list : ", json);
						temp = "<option value='";
						temp += item.playerNo;
						temp += "'>";
						temp += item.playerName;
						temp += "</option>";
						$("#getHomeTeamPlayer").append(temp);
					});
				} 
			});
			
			// addReport 에서 경기 입력폼에서 경기장 출력
			$.ajax({
				url:"/getStadium",
				method:"POST",
				data:{"teamName":$("#getHomeTeam").val()},
				success:function(json){
					// console.log("setGame function gameNo : ", json);
					$("#getStadium").text(json.stadiumName);
				}
			});
			
			// away team을 불러오는 함수
			$.ajax({
				url:"/getAwayTeam",
				method:"POST",
				data:{"teamName":$("#getHomeTeam").val()},
				success:function(json){
					$("#getAwayTeam").empty();
					$("#getAwayTeam").append("<option value=0>팀 선택</option>");
					$(json).each(function(index, item){
						// console.log("setGame function awayTeam list : ", json);
						temp = "<option value='";
						temp += item.teamName;
						temp += "'>";
						temp += item.teamName;
						temp += "</option>";
						$("#getAwayTeam").append(temp);
					});
				}
			});
		});
		
		// away team 선수를 불러오는 함수
		$("#getAwayTeam").change(function(){
			$.ajax({
				url:"/getHomeTeamPlayer",
				method:"POST",
				data:{"teamName":$("#getAwayTeam").val()},
				success:function(json){
					$("#getAwayTeamPlayer").empty();
					$("#getAwayTeamPlayer").append("<option value=0>선수 선택</option>");
					$(json).each(function(index, item){
						// console.log("setGame function awayTeamPlayer list : ", json);
						temp = "<option value='";
						temp += item.playerNo;
						temp += "'>";
						temp += item.playerName;
						temp += "</option>";
						$("#getAwayTeamPlayer").append(temp);
					});
				}
			});
		});
		
		// 전광판에 선수의 이름을 입력시키는 함수
		$("#getHomeTeamPlayer").change(function(){
			$("#homeTeamPlayer").empty();
			$("#homeTeamPlayer").text($("#getHomeTeamPlayer option:checked").text());	
		})
		
		$("#getAwayTeamPlayer").change(function(){
			$("#awayTeamPlayer").empty();
			$("#awayTeamPlayer").text($("#getAwayTeamPlayer option:checked").text());
		})
	}
		
// ### 경기 입력 END #############################################################################################
	
// ### 핀 입력 버튼 클릭시 체크된 핀 배열 값 저장 START ####################################################################
	
	// 체크한 핀을 pin 배열의 값 저장하는 함수
	let setPinArray = function(pin){
		// console.log("setPinArray function 도착 !");
		
		// 볼링핀을 체크박스로 설정하여 체크한 핀의 배열 인덱스 값을 1로 설정
		// 인덱스 값이 1은  쓰러트린 핀, 인덱스 값이 0 은 쓰러트리지 않은 핀
		if($("input:checkbox[id='pin1']").is(":checked") == true){
			$("#pin1").attr("disabled",true);
			pin[0]=1;
		}
		
		if($("input:checkbox[id='pin2']").is(":checked") == true){
			$("#pin2").attr("disabled",true);
			pin[1]=1;
		}
		
		if($("input:checkbox[id='pin3']").is(":checked") == true){
			$("#pin3").attr("disabled",true);
			pin[2]=1;
		}
		
		if($("input:checkbox[id='pin4']").is(":checked") == true){
			$("#pin4").attr("disabled",true);
			pin[3]=1;
		}
		
		if($("input:checkbox[id='pin5']").is(":checked") == true){
			$("#pin5").attr("disabled",true);
			pin[4]=1;
		}
		
		if($("input:checkbox[id='pin6']").is(":checked") == true){
			$("#pin6").attr("disabled",true);
			pin[5]=1;
		}
		
		if($("input:checkbox[id='pin7']").is(":checked") == true){
			$("#pin7").attr("disabled",true);
			pin[6]=1;
		}
		
		if($("input:checkbox[id='pin8']").is(":checked") == true){
			$("#pin8").attr("disabled",true);
			pin[7]=1;
		}
		
		if($("input:checkbox[id='pin9']").is(":checked") == true){
			$("#pin9").attr("disabled",true);
			pin[8]=1;
		}
		
		if($("input:checkbox[id='pin10']").is(":checked") == true){
			$("#pin10").attr("disabled",true);
			pin[9]=1;
		}

		// console.log("setPinArray function pin : ", pin);
		
		return pin;
	}
	
// ### 핀 입력 버튼 클릭시 체크된 핀 배열 값 저장 END ####################################################################
		
	
	
// ### 경기 데이터 입력 START ############################################################################################################
	
	// 선수의 데이터를 기록하는 함수
	let addReport = function(game){
		// console.log("addReport function 도착 !");
		
		let pin = [0,0,0,0,0,0,0,0,0,0];
		pin = game.pin;
		let pinSum = game.pinSum;
		let turn = game.turn;
		let frame = game.frame;
		let player = game.player;
		let gameNo = game.gameNo;
	
		// 변수
		// home팀 전광판 frame
		let homeFrame = "#h"+frame;
		// away팀 전광판 frame
		let awayFrame = "#a"+frame;
		
		//체크한 pin의 개수의 합을 구하는 반복문
		for(let i =0;i<pin.length;i++){
			pinSum += pin[i];
		}
		
		console.log("frame : ", frame);
		console.log("turn : ", turn);
		console.log("player : ", player);
		console.log("pinSum : ", pinSum);
		
		// 선수의 회차마다의 기록을 저장하기 위한 함수
		if(game.player == 1){
			$.ajax({
				url:"/addGamePlayer",
				method:"POST",
				data:{"gameNo": gameNo,
					  "playerNo":$("#getHomeTeamPlayer").val(),
					  "frame":frame,
					  "turn":turn,
					  "pin1":pin[0],
					  "pin2":pin[1],
					  "pin3":pin[2],
					  "pin4":pin[3],
					  "pin5":pin[4],
					  "pin6":pin[5],
					  "pin7":pin[6],
					  "pin8":pin[7],
					  "pin9":pin[8],
					  "pin10":pin[9]
					 },
				success:function(){
					// console.log("addGamePlayer 요청 확인!");
				}
			});
		}else{
			$.ajax({
				url:"/addGamePlayer",
				method:"POST",
				data:{"gameNo": gameNo,
					  "playerNo":$("#getAwayTeamPlayer").val(),
					  "frame":frame,
					  "turn":turn,
					  "pin1":pin[0],
					  "pin2":pin[1],
					  "pin3":pin[2],
					  "pin4":pin[3],
					  "pin5":pin[4],
					  "pin6":pin[5],
					  "pin7":pin[6],
					  "pin8":pin[7],
					  "pin9":pin[8],
					  "pin10":pin[9]
					 },
				success:function(){
					console.log("addGamePlayer 요청 확인!");
				}
			});
		}
		
		// 1회차에 핀을 10개 쓰러트린 경우 (스트라이크)
		if(turn == 1 && pinSum == 10){
			// console.log("strike !");
			
			// 전광판에 스트라이크 출력
			if(player == 1){
				$(homeFrame).text(pinSum);
			} else {
				$(awayFrame).text(pinSum);
			}
			
			// 10프레임이 아닐때 턴을 초기화하고 플레이어를 넘긴다
			if(frame != 10){
				turn = 1;
				player += 1;
				pinSum = 0;
			}else{
				turn += 1;
			}
			
			$(".pinCheck").attr("disabled", false);
			$(".pinCheck").prop("checked", false);
			pin = [0,0,0,0,0,0,0,0,0,0];
		} else {
			
			// 전광판에 쓰러트린 핀 출력
			if(player == 1){
				$(homeFrame).text(pinSum);
			} else {
				$(awayFrame).text(pinSum);
			}
			
			// 버튼 클릭 할 때마다 선수의 회차가 +1된다
			turn += 1;
			$(".pinCheck").prop("checked", false);
			pin = [0,0,0,0,0,0,0,0,0,0];
			
			// 프레임 체크
			if(frame != 10){
				// turn이 2보다 클때 turn을 초기화시키고 다음플레이어로 넘긴다
				if(turn > 2){
					$(".pinCheck").attr("disabled", false);
					$(".pinCheck").prop("checked", false);
					player += 1;
					pinSum = 0;
					turn = 1;
					pin = [0,0,0,0,0,0,0,0,0,0];
				}
			} else {
				// 10프레임 2회차에 스페어 했을 경우
				if(pinSum == 10){
					// 3회차 조건 충족
					$(".pinCheck").attr("disabled", false);
					$(".pinCheck").prop("checked", false);
					pin = [0,0,0,0,0,0,0,0,0,0];
				} else if(turn > 3){
					// 플레이어 순서 변경
					$(".pinCheck").attr("disabled", false);
					$(".pinCheck").prop("checked", false);
					pinSum = 0;
					turn = 1;
					player += 1;
					pin = [0,0,0,0,0,0,0,0,0,0];
				}
			}
		} 
		// 어웨이팀으로 변경
		if(player > 2){
			// 경기종료 버튼, 핀입력 버튼이 비활성화
			if(frame == 10 ) {
				// 작업 종료 후 경고메세지 출력
				setTimeout(function(){
					alert("게임종료!");
				}, 0);
				$("#addPinBtn").attr("disabled", true);
			}
			player = 1;
			frame += 1;
		}
		
		//1회차일때 스트라이크버튼이 있다.
		
		if(frame != 10 && turn != 1){
			$("#strikeBtn").hide();
		} else {
			$("#strikeBtn").show();
		}
		
		game.pin = [0,0,0,0,0,0,0,0,0,0]
		game.pinSum = pinSum;
		game.turn = turn;
		game.frame = frame;
		game.player = player;
		game.gameNo = gameNo;
		
		// console.log("addReport function Game : ", game);
		
		return game;
	}
// ### 경기 데이터 입력 END ############################################################################################################	
	
	// 경기 종료 데이터 입력
	
	