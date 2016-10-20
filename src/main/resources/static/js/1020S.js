function createDispTable(){
	var tbody = document.getElementById("dispTableArea");
	var dispTr = document.createElement("tr");
	var dispTd = document.createElement("td");
	dispTd.setAttribute("rowlspan", "2");
	dispTd.className = "tCell1";
	dispTd.appendChild(document.createTextNode("業務No"));
	dispTr.appendChild(dispTd);

	var dispTd = document.createElement("td");
	dispTd.setAttribute("colspan", "7");
	dispTd.className = "tCell2";
	dispTd.appendChild(document.createTextNode("勤務時間"));
	dispTr.appendChild(dispTd);

	createBlankCell(dispTr,3,7)

	//途中まで



	dispTr.appendChild(dispTd);

	tbody.innerHTML = "";
	tbody.appendChild(dispTr);

}

function createBlankCell(dispTr,startNumber,lastNumber){
	for(var i=0; startNumber<=lastNumber; startNumber++){
		var dispTd = document.createElement("td");
		dispTd.className = "tCell" + startNumber;
		dispTr.appendChild(dispTd);
	}
}












function createTable(tableList){
	var len = tableList.length;
	var t = tableList;
	var x=0;
	var count = 0;
	var taskList = [];
	var timeList = [];
	var totalList= [];

	var tbody = document.getElementById("graphAria");

	var mainTr = document.createElement("tr");

	var mainTd = document.createElement("td");
	mainTd.className = "cell0";
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell1";
	var text_node = document.createTextNode("日付");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell2";
	var text_node = document.createTextNode("申請");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell3";
	var text_node = document.createTextNode("出社");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell4";
	var text_node = document.createTextNode("退社");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell5";
	var text_node = document.createTextNode("業務名");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell6";
	var text_node = document.createTextNode("計画");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell7";
	var text_node = document.createTextNode("勤務時間");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell8";
	var text_node = document.createTextNode("申請状態");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell9";
	var text_node = document.createTextNode("備考");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	var mainTd = document.createElement("td");
	mainTd.className = "cell10";
	var text_node = document.createTextNode("確認・訂正");
	mainTd.appendChild(text_node);
	mainTr.appendChild(mainTd);

	tbody.appendChild(mainTr);













	for(var i=0; i<len; i++){
		var spaceValue = 0;
		var cls = "";






		//var year = t[i][0][0];
		var month = t[i][0][1];
		var day   = t[i][0][2];
		var week  = t[i][0][3];
		var cls   = t[i][0][4];

		switch(week){
			case "sun":
				week = "(日)";
				break;
			case "mon":
				week = "(月)";
				break;
			case "tue":
				week = "(火)";
				break;
			case "wed":
				week = "(水)";
				break;
			case "thu":
				week = "(木)";
				break;
			case "fri":
				week = "(金)";
				break;
			case "sat":
				week = "(土)";
				break;
		}
		if(i==0){
			var date = month + "/" + ("0"+day).slice(-2) + week;
		}else{
			var date = "&nbsp;&nbsp;&nbsp;" + ("0"+day).slice(-2) + week;
		}


		for(var k=2; k<t[i].length; k++){
			var item = t[i][k];
			var tr  = document.createElement("tr");

			//チェックボックス
			var checkbox = document.createElement("input");
			checkbox.type  = "checkbox";
			checkbox.value = day +","+ (k);
			checkbox.className = "cell0";
			if(item.length!=0){
				checkbox.id = "chk" + x;

				tr.appendChild(checkbox);
				var td0 = document.createElement("td");
				td0.className = "cell1";
				switch(cls){
					case "1":
						td0.className = "holiday1";
						break;
					case "2":
						td0.className = "holiday2";
						break;
					case "3":
						td0.className = "holiday3";
						break;
				}
				td0.innerHTML = date;
				tr.appendChild(td0);

				//ボタン作成
				var td = document.createElement("td");
				td.className = "cell2";

				var button = document.createElement("input");
				button.type="button";
				button.id = "button" + x;
				button.value="+";
				button.onclick = new Function("popUpSubMenu(this)");

				td.appendChild(button);
				tr.appendChild(td);

				//出勤時間
				var td = document.createElement("td");
				td.className = "cell3";
				td.innerHTML = item[0];
				tr.appendChild(td);

				//退勤時間
				var td = document.createElement("td");
				td.className = "cell4";
				td.innerHTML = item[1];
				tr.appendChild(td);

				//業務名
				var td = document.createElement("td");
				td.className = "cell5";
				td.innerHTML = item[4];
				tr.appendChild(td);
				taskList.push(item[4]);

				//グラフ
				//計画時間
				var td = document.createElement("td");
				td.className = "cell6";
				td.innerHTML = item[2];
				tr.appendChild(td);
				taskList.push(item[2]);
				tr.appendChild(td);

				var plan = ((Number(item[2])*60)/(12*60))*100;
				var td = document.createElement("td");
				td.className = "cell7"

				var graphParameter = 0;
				var overParameter  = 0;
				var spaceParameter = 0;

				//実稼働時間計算
				var timeValue = (Number(item[3])*60)/(12*60)*100;

				//グラフ使用値計算
				//実績
				if(timeValue==99){
					graphParameter = 99
				}
				else if(timeValue>99){
					graphParameter = 99;
				}else if(timeValue<99){
					graphParameter = timeValue;
				}else{
					graphParameter = 0;
				}

				//計画ー実績
				if(graphParameter==99){
					overParameter = 0;
				}else if(graphParameter<plan){
					overParameter = 0;
				}else if(graphParameter>plan){
					overParameter  = graphParameter - plan;
					graphParameter = graphParameter - overParameter;
				}else{
					overParameter = 0;
				}

				if(plan>99){
					plan = 99;
				}

				//空白
				spaceParameter = 99 - (graphParameter + overParameter);


				//グラフ上実績値テキスト表示処理
				var graphDiv = document.createElement("div");
				graphDiv.className = "actualValue";
				var graphA = document.createElement("a");
				if(item[2]<item[3]){
					graphA.className = "actualValueOverColor";
				}else{
					graphA.className = "actualValueNormalColor";
				}
				var text = document.createTextNode(item[3]);
				graphA.appendChild(text);
				graphDiv.appendChild(graphA);
				td.appendChild(graphDiv);

				//実績グラフ作成
				var graphDiv = document.createElement("a");
				graphDiv.id = "graph0";
				graphDiv.classList = "meter";
				graphDiv.style.width = graphParameter + "%";
				td.appendChild(graphDiv);

				var graphDiv = document.createElement("a");
				graphDiv.id = "overTime";
				graphDiv.classList = "meter";
				graphDiv.style.width = overParameter + "%";
				td.appendChild(graphDiv);

				var graphDiv = document.createElement("a");
				graphDiv.id = "space";
				graphDiv.classList = "meter";
				graphDiv.style.width = spaceParameter + "%";
				td.appendChild(graphDiv);

				if(item[2].length>0){
					//時間外計画時間グラフ作成
					var graphDiv = document.createElement("div");
					graphDiv.id = "planningTime";
					graphDiv.classList = "meter";
					graphDiv.style.width = plan + "%";
					td.appendChild(graphDiv);
				}




				tr.appendChild(td);



				//申請状態
				var td = document.createElement("td");
				var status;
				switch(item[5]){
					case "":
						status = "";
						break;
					case "0":
						status = "";
						break;
					case "1":
						status = "申請中";
						break;
					case "2":
						status = "承認済";
						break;
					case "3":
						status = "要訂正";
						break;
				}
				td.className = "cell8";
				td.innerHTML = status;
				tr.appendChild(td);

				var td = document.createElement("td");
				td.className = "cell9";
				td.innerHTML = item[6];
				tr.appendChild(td);

				var td = document.createElement("td");
				td.className = "cell10";
				td.innerHTML = "<a>●</a>"
				tr.appendChild(td);
			}else{
				checkbox.id = "chk" + x;
				tr.appendChild(checkbox);
				var td0 = document.createElement("td");
				td0.className = "cell1";
				switch(cls){
					case "1":
						td0.className = "holiday1";
						break;
					case "2":
						td0.className = "holiday2";
						break;
					case "3":
						td0.className = "holiday3";
						break;
				}
				td0.innerHTML = date;
				tr.appendChild(td0);

				var idNum=2;
				for(var j=0; j<9; j++){
					if(j!="0"){
						var td = document.createElement("td");
						td.className = "cell" + idNum;
					}else{
						var td = document.createElement("td");
						var button = document.createElement("input");
						button.type="button";
						button.id = "button" + x;
						button.value="+";
						button.onclick = new Function("popUpSubMenu(this)");
						td.appendChild(button);
						td.className = "cell" + idNum;
					}
					idNum++;
					tr.appendChild(td);
				}
			}
			tbody.appendChild(tr);
			x++;
			count++;
		}

	}
	return count;
}



function createTotalGraph(array){
	var len = array.length;
	if(len!=0){
		var item = array[0];
		for(var i=1; i<len; i++){
			item = item[i]
		}
	}
}



function deleteItems(count,tableList){
	var deleteList = [];
	for(var i=0; i<count; i++){
		var id="chk" + i;
		if($("#"+id).prop('checked')) {
			deleteList.push(document.getElementById(id).value);
		}
	}

	for(var j=0; j<tableList.length; j++){
		var date = tableList[j][0][2];
		var pullValue = [];

		for(var k=0; k<deleteList.length; k++){
			var DesignatedDate   = deleteList[k].split(",")[0];
			var Number = deleteList[k].split(",")[1];

			if(date==DesignatedDate){
				delete tableList[j][Number];
				pullValue.push(Number);
			}
		}

		if(pullValue.length!=0){
			pullValue.sort(
				function(a,b){
					if( a > b ) return -1;
					if( a < b ) return 1;
					return 0;
				}
			);
			for(var m=0; m<pullValue.length; m++){
				tableList[j].splice(pullValue[m],1);
			}
			if(tableList[j].length==2){
				tableList[j].push("");
			}
		}
	}
	document.getElementById("graphAria").innerHTML = "";
	count = createTable(tableList);
}


//勤怠一覧情報取得テストの為に暫定で作成_20161012 (早坂)
//「企業コード」「社員番号」「社員名」「日付(YYYY)」「日付(MM)」を送信すること

function getAttendanceList(){
	//仮データ
	var provisionalArray = {
		"companyCode" : "atp0000",
		"userNumber" : "employee0001",
		"userName" : "hayasaka",
		"year" : "2016" ,
		"month" : "10" ,
	}
	$.ajax({
		async:false,
		type : "POST",
		url : "attendanceList",
		dataType : "json",
		data: JSON.stringify(provisionalArray),
		contentType: 'application/json',
		cache : false,
	}).done(function(data, status, jqXHR){
		console.log(jqXHR);
		tableList = jqXHR.responseJSON.attendanceList;	<!--[何日(+1)の][どのデータの][何番目の要素]を指定する。-->
	}).fail(function(data, status, jqXHR){
		alert("error");
		valid = false;
	})
};



/*
function timeCalc(array){
	var hourList   = [];
	var miniteList = [];

	for(var i=0; i< 2; i++){

		var timeValue = array[i].split(":");

		if(timeValue[0]=="00"){
			var hour = 24*60;
		}else{
			if(timeValue[0].charAt(0)=="0"){
				var hour = Number(timeValue[0].substr( 1 )*60);
			}else{
				var hour = Number(timeValue[0]*60);
			}
		}


		if(timeValue[1].charAt(0)=="0"){
			var minite = Number(timeValue[1].substr( 1 ));
		}else{
			var minite = Number(timeValue[1]);
		}

		hourList.push(hour);
		miniteList.push(minite);
	}

	if(hourList[0]<hourList[1]){
		var attendance = hourList[1]-hourList[0]
		if(miniteList[0]<miniteList[1]){
			var leave = miniteList[1]-miniteList[0];
		}else if(miniteList[0]>miniteList[1]){
			var leave = miniteList[0]-miniteList[1];
		}else if(miniteList[0]==miniteList[1]){
			var leave = 0;
		}
	}

	var time = attendance + leave;

	return time;
}
*/




