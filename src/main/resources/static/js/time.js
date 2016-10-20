/**
 *	サーバーから時刻を取得する。
 *  利用時は、以下を記述すること
 *  ・HTML に <div id="DateArea"></div>	//  09/15 追加するので、下記処理にも処理内容を追記すること。
 *	・HTML に <div id="ClockArea"></div>
 *
 *  ※9/26現在：年月日の修正作業停滞中(サーバから取得した年月日に対して、うるう年等を考慮した修正のこと)
 */
		var dateTime;	//サーバーから取得した時点での時刻
		var year;
		var month;
		var date;
		var day;	//曜日の値(0～6)の値を取得
		var weekdays = ["日", "月", "火", "水", "木", "金", "土"];
		var nowHour;
		var nowMin;
		var nowSec;
		var timeId;

		//時刻取得処理
		function updateTime(){
			window.clearTimeout(timeId);
			getTime();
			year = dateTime.getFullYear();
			month = dateTime.getMonth() + 1;
			date = dateTime.getDate();
			day = weekdays[dateTime.getDay()];
			nowHour = dateTime.getHours();
			nowMin = dateTime.getMinutes();
			nowSec = dateTime.getSeconds();
			msg = convertTime(nowHour,2) + ":" + convertTime(nowMin,2);
			countTime();

		}
		function countTime(){
			nowSec++;

			//時間の繰り上がり
			if(nowSec >= 60){
				nowMin++;
				nowSec = 0;
			}
			if(nowMin >= 60){
				nowHour++;
				nowMin = 0;
			}
			if(nowHour >= 24){
				nowHour = 0;
			}

			//桁揃え処理
			var hour = convertTime(nowHour,2);
			var min = convertTime(nowMin,2);
			var sec = convertTime(nowSec,2);

			msg = hour + ":" + min;
			msg2 = year + "/" + month + "/" + date + "(" + day + ")";
			document.getElementById("ClockArea").innerHTML = msg;
			document.getElementById("DateArea").innerHTML = msg2;

			timeId = window.setTimeout(countTime,1000);
		}

		 function convertTime(num, figures) {
		 	var str = String(num);
		 	while (str.length < figures) {
		 		str = "0"+str;
		 	}
		 	return str;
		 }

		//時刻をサーバーから取得
		function getTime(){
			$.ajax({
				async:false,
				type : "GET",
				url : "getTime",
				dataType : "text",
				cache : false,
			}).done(function(data, status, jqXHR){
				console.log(data);
				dateTime = new Date(data);
			}).fail(function(data, status, jqXHR){
				alert("error");
			})
		};
