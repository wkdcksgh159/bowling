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
		
		// homeTeam 선수를 불러오는 함수
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
		
		// 심판의 목록을 불러오는 함수
		$.ajax({
			url:"/getReferee",
			method:"POST",
			success:function(json){
				$("#getReferee").empty();
				$("#getReferee").append("<option value=0>심판 선택</option>");
				$(json).each(function(index, item){
					// console.log("setGame function referee list : ", json);
					temp = "<option value='";
					temp += item.refereeNo;
					temp += "'>";
					temp += item.refereeName;
					temp += "</option>";
					$("#getReferee").append(temp);
				});
			}
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
		
// ### 경기 입력 END ###########################################################################################
	
// ### 핀 입력 버튼 클릭시 체크된 핀 배열 값 저장 START ####################################################################
	
	// 체크한 핀을 pin 배열의 값 저장하는 함수
	let setPinArray = function(pin){
		// console.log("setPinArray function 도착 !");
		
		/* 볼링핀을 체크박스로 설정하여 체크한 핀의 배열 인덱스 값을 1로 설정
		 * 인덱스 값이 1은  쓰러트린 핀, 인덱스 값이 0 은 쓰러트리지 않은 핀
		 * pinCheck 클래스명을 가진 체크박스에서 체크된 value 값에만 value 값을 1로 설정
		 */
		$(".pinCheck:checked").each(function() {
			pin[$(this).val()] = 1;
			$(this).attr("disabled", true);
		});
		
		// console.log("setPinArray function pin : ", pin);
		return pin;
	}
	
// ### 핀 입력 버튼 클릭시 체크된 핀 배열 값 저장 END ####################################################################	
	
	
// ### 경기 데이터 입력 START ############################################################################################################
	
	// 선수의 데이터를 기록하는 함수
	let addReport = function(game){
		// console.log("addReport function 도착 !");
		
		// 객체 받아온 값 변수 저장
		let pin = [0,0,0,0,0,0,0,0,0,0];
		pin = game.pin;
		let pinSum = game.pinSum;
		let turn = game.turn;
		let frame = game.frame;
		let player = game.player;
		let gameNo = game.gameNo;
		
		// 체크한 pin의 개수의 합을 구하는 반복문
		for(let i =0;i<pin.length;i++){
			pinSum += pin[i];
		}
		
		console.log(frame, "프레임", turn, "회차", player, "플레이어"); // 확인
		console.log("pin : ", pin);
		// console.log("frame : ", frame);
		// console.log("turn : ", turn);
		// console.log("player : ", player);
		console.log("pinSum : ", pinSum);
		console.log(""); // 확인
		
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
			
			if(turn == 1 && pinSum == 10 && frame != 10) {
				$.ajax({
					url:"/addGamePlayer",
					method:"POST",
					data:{"gameNo": gameNo,
						  "playerNo":$("#getHomeTeamPlayer").val(),
						  "frame":frame,
						  "turn":2,
						  "pin1":0,
						  "pin2":0,
						  "pin3":0,
						  "pin4":0,
						  "pin5":0,
						  "pin6":0,
						  "pin7":0,
						  "pin8":0,
						  "pin9":0,
						  "pin10":0
						 },
					success:function(){
						// console.log("addGamePlayer 요청 확인!");
						console.log("1회차 스트라이크, 2회차 0 데이터 전송");
					}
				});
			}
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
					 // console.log("addGamePlayer 요청 확인!");
				 }
			});
			
			if(turn == 1 && pinSum == 10 && frame != 10) {
				$.ajax({
					url:"/addGamePlayer",
					method:"POST",
					data:{"gameNo": gameNo,
						  "playerNo":$("#getAwayTeamPlayer").val(),
						  "frame":frame,
						  "turn":2,
						  "pin1":0,
						  "pin2":0,
						  "pin3":0,
						  "pin4":0,
						  "pin5":0,
						  "pin6":0,
						  "pin7":0,
						  "pin8":0,
						  "pin9":0,
						  "pin10":0
						 },
					success:function(){
						// console.log("addGamePlayer 요청 확인!");
						console.log("1회차 스트라이크, 2회차 0 데이터 전송");
					}
				});
			}
		}
		
		
		
		// ### 1~9 프레임 ##############################################################################################
		if(frame != 10){
			// 1회차에 스트라이크를 하지 못한경우
			if(turn == 1 && pinSum < 10){
				// 스트라이크가 아닌 경우

				// 전광판 출력
				board(pinSum, player, frame, turn);
				
				// 순서의 변경없이 2회차 준비
				turn += 1;
				$(".pinCheck").prop("checked", false);
				pin = [0,0,0,0,0,0,0,0,0,0];
				pinSum = 0;
			} else {
				// 1회차에 스트라이크를 하거나, 2회차 투구가 종료된 시점

				// 전광판 출력
				board(pinSum, player, frame, turn);
				
				// 순서 변경
				player += 1;
				pinSum = 0;
				turn = 1;
				pin = [0,0,0,0,0,0,0,0,0,0];
				$(".pinCheck").attr("disabled", false);
				$(".pinCheck").prop("checked", false);
			}
			
		// ### 10 프레임 ########################################################################################################
		} else {
			
			// 10 프레임 1회차에 핀을 10개 쓰러트린 경우 (스트라이크)
			if(turn == 1 && pinSum == 10){
				
				// 전광판 출력
				board(pinSum, player, frame, turn);
				
				// 10 프레임이라 순서를 변경 하지 않는다
				turn += 1;
				// pinSum = 0; 초기화 x
				
				// 체크박스 초기화 및 배열 초기화
				pin = [0,0,0,0,0,0,0,0,0,0];
				$(".pinCheck").attr("disabled", false);
				$(".pinCheck").prop("checked", false);
				
			} else if(turn == 2 && pinSum >= 10){
				// 3회차 자격 획득
				
				if(pinSum > 10 && pinSum < 20){
					// 1회차에 스트라이크를, 2회차에 스트라이크를 하지 못한경우
					
					$(".pinCheck").prop("checked", false);
					
				} else {
					// 스페어 or 1회차, 2회차 스트라이크를 친경우
					
					// 체크박스 초기화 및 배열 초기화
					$(".pinCheck").attr("disabled", false);
					$(".pinCheck").prop("checked", false);
				}

				pinSum -= 10;

				// 전광판 출력
				board(pinSum, player, frame, turn);
				
				// 3회차 기회 자격 획득
				turn += 1;
				pin = [0,0,0,0,0,0,0,0,0,0];
				pinSum = 0;
			} else {
				// turn 1에 10개를 치지못했거나 turn 2에 스페어를 못했거나

				// 전광판 출력
				board(pinSum, player, frame, turn);
				
				if(turn == 1){
					turn += 1;
					
				} else {
					
					player += 1;
					turn = 1;
					pinSum = 0;
					
					// 체크박스 초기화 및 배열 초기화
					$(".pinCheck").attr("disabled", false);
				}

				$(".pinCheck").prop("checked", false);
				pin = [0,0,0,0,0,0,0,0,0,0];
				
			}
			
		}	
		
		// 플레이어 순서 초기화
		if(player > 2){
			// 10 프레임 2 플레이어의 차례 종료시 게임 종료
			if(frame == 10) {
				// 작업 종료 후 경고메세지 출력
				setTimeout(function(){
					alert("게임종료!");
				}, 0);
				
				$.ajax({
					url : "/addGameResult",
					method : "POST",
					data : {"gameNo" : gameNo},
					success : function(){
						console.log("게임종료");
					}
				});
				
			} else {
				player = 1;
				frame += 1;	
			}
		}
		
		// 2회차 or 3회차
		if(turn != 1){
			// 1~9 프레임
			if(frame != 10){
				// 2회차의 경우 스페어
				if(turn == 2 && pinSum < 10){
					$("#strikeBtn").text("스페어");
				} else {
					// 스페어가 아닌 경우 전부 스트라이크
					$("#strikeBtn").text("스트라이크");
				}
			// 10 프레임
			} else {
				// 2회차의 경우 스페어
				if(turn == 2 && pinSum < 10){
					$("#strikeBtn").text("스페어");
				} else {
					// 스페어가 아닌 경우 전부 스트라이크
					$("#strikeBtn").text("스트라이크");
				}
			}
		// 1회차
		} else {
			// 스트라이크
			$("#strikeBtn").text("스트라이크");
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
	
	
	// 전광판에 출력하는 함수
	let board = function(pinSum, player, frame, turn){
		
		// 해당 프레임과 회차에 맞는 전광판에 출력하기 위함
		let homeFrame = "#hf"+frame+"t"+turn; // home팀 전광판 frame
		let awayFrame = "#af"+frame+"t"+turn; // away팀 전광판 frame
		let homeScore = "#hf"+frame+"s";
		let awayScore = "#af"+frame+"s";
		let homeFrameScore = pinSum;
		let awayFrameScore = pinSum;
		
		/*// 턴별로 쓰러트린 핀의 갯수 저장
		let t1Pin = 0;
		let t2Pin = 0;*/
		
		// 플레이어에 따라 맞는 곳에 출력
		if(player == 1){
			$(homeFrame).text(pinSum);
			if(turn != 1){
				homeFrameScore = parseInt($(homeScore).text())+pinSum;
			}
			$(homeScore).text(homeFrameScore);
		} else {
			$(awayFrame).text(pinSum);
			if(turn != 1){
				awayFrameScore = parseInt($(awayScore).text())+pinSum;
			}
			$(awayScore).text(awayFrameScore);
		}
		// 디버깅
		console.log(homeFrame, awayFrame, homeScore, awayScore, homeFrameScore, pinSum, player);
		
		// 이전 프레임과 비교해서 점수 계산
		
		// 현재 프레임
		// 현재 홈팀의 첫번째 턴
		let homeFTurn = "#hf"+frame+"t1";
		// 현재 홈팀의 두번째 턴
		let homeSTurn = "#hf"+frame+"t2";
		// 현재 어웨이팀의 첫번째 턴
		let awayFTurn = "#af"+frame+"t1";
		// 현재 어웨이팀의 두번째 턴
		let awaySTurn = "#af"+frame+"t2";
		
		// 이전 프레임
		let prevFrame = frame - 1
		// 이전 홈팀의 첫번째 턴
		let prevHomeFTurn = "#hf"+prevFrame+"t1";
		// 이전 홈팀의 두번째 턴
		let prevHomeSTurn = "#hf"+prevFrame+"t2";
		// 이전 홈팀의 점수
		let prevHomeScore = "#hf"+prevFrame+"s";
		// 이전 어웨이팀의 첫번째 턴
		let prevAwayFTurn = "#af"+prevFrame+"t1";
		// 이전 어웨이팀의 두번째 턴
		let prevAwaySTurn = "#af"+prevFrame+"t2";
		// 이전 어웨이팀의 점수
		let prevAwayScore = "#af"+prevFrame+"s";
		
		// 이이전 프레임
		let previousFrame = frame - 2
		// 이이전 홈팀의 첫번째 턴
		let previousHomeFTurn = "#hf"+previousFrame+"t1";
		// 이이전 홈팀의 두번째 턴
		let previousHomeSTurn = "#hf"+previousFrame+"t2";
		// 이이전 홈팀의 점수
		let previousHomeScore = "#hf"+previousFrame+"s";
		// 이이전 어웨이팀의 첫번째 턴
		let previousAwayFTurn = "#af"+previousFrame+"t1";
		// 이이전 어웨이팀의 두번째 턴
		let previousAwaySTurn = "#af"+previousFrame+"t2";
		// 이이전 어웨이팀의 점수
		let previousAwayScore = "#af"+previousFrame+"s";
		
		// 점수 계산 후 재 출력
		if(player == 1){
			// 이전 프레임의 점수가 10 일 경우
			if($(prevHomeScore).text() == 10) {
				// 플레이 정보 확인
				console.log("player, frame, turn, pinSum", player, frame, turn, pinSum);
				// 스트라이크 분기
				if($(prevHomeFTurn).text() == 10) {
					// 연속 스트라이크 (연속 스트라이크를 쳤을시 바로 전 프레임 점수에 현재 프레임의 첫번째 턴의 값을 더함)
					if($(homeFTurn).text() == 10){
						$(prevHomeScore).text(parseInt($(prevHomeScore).text())+parseInt($(homeFTurn).text()));
						console.log("연속 스트라이크를 쳤을 경우 : ");
					}
					// 그냥 스트라이크 (그냥 스트라이크를 쳤을시 바로 전 프레임 점수에 현재 프레임의 총 점수를 더함)
					if($(homeFTurn).text() != 10 && turn == 2){
						$(prevHomeScore).text(parseInt($(prevHomeScore).text())+parseInt($(homeScore).text()));
						console.log("그냥 스트라이크를 쳤을 경우 : ");
					}
					// 터키 (이이전 프레임의 점수가 10 일 경우 이이전 프레임의 점수에 이전 프레임의 점수와 현재 프레임의 첫번째턴의 값을 더함)
					if($(previousHomeFTurn).text() == 10) {
						$(previousHomeScore).text(parseInt($(prevHomeScore).text())+parseInt($(homeFTurn).text()));
						console.log("터키");
					}
				}
				
				// 스페어 (이전 프레임의 첫번째턴의 값이 10이 아닌경우 이전 프레임의 점수에 현재 프레임의 첫번째 턴의 값을 더함)
				if($(prevHomeFTurn).text() != 10) {
					console.log("스페어");
					$(prevHomeScore).text(parseInt($(prevHomeScore).text())+parseInt($(homeFTurn).text()));
				}
			}
			// 10 프레임 터키 (9 프레임 점수가 20이고 10 프레임 두번째턴이 시작될때 9 프레임 점수에 10 프레임 두번째턴의 값을 더함)
			if($(prevHomeScore).text() == 20 && turn == 2 && frame == 10) {
				console.log("10프레임 터키 확인");
				$(prevHomeScore).text(parseInt($(prevHomeScore).text())+parseInt($(homeSTurn).text()));
			}
		}
		if(player == 2) {
			// 이전 프레임의 점수가 10 일 경우
			if($(prevAwayScore).text() == 10) {
				// 플레이 정보 확인
				console.log("player, frame, turn, pinSum", player, frame, turn, pinSum);
				// 스트라이크 분기
				if($(prevAwayFTurn).text() == 10) {
					// 연속 스트라이크 (연속 스트라이크를 쳤을시 바로 전 프레임 점수에 현재 프레임의 첫번째 턴의 값을 더함)
					if($(awayFTurn).text() == 10){
						$(prevAwayScore).text(parseInt($(prevAwayScore).text())+parseInt($(awayFTurn).text()));
						console.log("연속 스트라이크를 쳤을 경우 : ");
					}
					// 그냥 스트라이크 (그냥 스트라이크를 쳤을시 바로 전 프레임 점수에 현재 프레임의 총 점수를 더함)
					if($(awayFTurn).text() != 10 && turn == 2){
						$(prevAwayScore).text(parseInt($(prevAwayScore).text())+parseInt($(awayScore).text()));
						console.log("그냥 스트라이크를 쳤을 경우 : ");
					}
					// 터키 (이이전 프레임의 점수가 10 일 경우 이이전 프레임의 점수에 이전 프레임의 점수와 현재 프레임의 첫번째턴의 값을 더함)
					if($(previousAwayFTurn).text() == 10) {
						$(previousAwayScore).text(parseInt($(prevAwayScore).text())+parseInt($(awayFTurn).text()));
						console.log("터키");
					}
				}
				
				// 스페어 (이전 프레임의 첫번째턴의 값이 10이 아닌경우 이전 프레임의 점수에 현재 프레임의 첫번째 턴의 값을 더함)
				if($(prevAwayFTurn).text() != 10) {
					console.log("스페어");
					$(prevAwayScore).text(parseInt($(prevAwayScore).text())+parseInt($(awayFTurn).text()));
				}
			}
			// 10 프레임 터키 (9 프레임 점수가 20이고 10 프레임 두번째턴이 시작될때 9 프레임 점수에 10 프레임 두번째턴의 값을 더함)
			if($(prevAwayScore).text() == 20 && turn == 2 && frame == 10) {
				console.log("10프레임 터키 확인");
				$(prevAwayScore).text(parseInt($(prevAwayScore).text())+parseInt($(awaySTurn).text()));
			}
		}
		// 홈과 어웨이 스코어 합을 받을 변수
		let homeScoreSum = 0;
		let awayScoreSum = 0;
		
		// 홈과 어웨이 각각의 총 점수 적용
		$(".hfs").each(function(){
			if($(this).text().length != 0) {
				homeScoreSum += parseInt($(this).text());
				console.log("each homeScoreSum : ", homeScoreSum);
			}
		});
		
		$(".afs").each(function(){
			if($(this).text().length != 0) {
				awayScoreSum += parseInt($(this).text());
				console.log("each awayScoreSum : ", awayScoreSum);
			}
		});
		
		$("#homeScoreSum").text(parseInt(homeScoreSum));
		$("#awayScoreSum").text(parseInt(awayScoreSum));
		
	}
// ### 경기 데이터 입력 END ############################################################################################################	
	