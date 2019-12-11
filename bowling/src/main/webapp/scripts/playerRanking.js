// 개인 랭킹을 불러오는 ajax
/*$.ajax({
	url:"/playerRecord",
	method:"POST",
	data:{playerNo:"playerName",
			playerName:gender,
	},
	success:function(json){
		$("#selectPlayerRanking").append("<option value=0>선택</option>");
		$(json).each(function(index, item){
				console.log("json",json);
				temp = "<tr><td>"+item.rank+"</td>";
				temp += "<td>"+item.playerName+"</td> <td>"+item.gender+"</td> <td>"+item.totalGame+"</td>";
				temp += "<td>"+item.win+"</td> <td>"+item.draw+"</td> <td>"+item.lose+"</td>";
				temp += "<td>"+item.winRate+"</td> <td>"+item.scoreAvg+"</td> <td>"+item.strikeAvg+"</td>";
				temp += "<td>"+item.spareAvg+"</td></tr>";
				$("#selectPlayerRanking").append(temp);
		});
			
	}
	
});*/