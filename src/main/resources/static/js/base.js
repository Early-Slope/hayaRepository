/**
 *共通処理
 */


function pageChange(link) {
	$('#main_menu').load('/'+link, null, function() {});
}


function accordion() {
    $(this).next().slideToggle(300);
}

function rightClickBan(){
	$(document).bind("contextmenu",function(e){
	    return false;
	});
}


function keyBan(){
	$(function(){
		$(document).keydown(function(event){
			// クリックされたキーのコード
			var keyCode = event.keyCode;

		    // ファンクションキーを制御する
			if(keyCode == 112 // F1キーの制御
				|| keyCode == 113 // F2キーの制御
				|| keyCode == 114 // F3キーの制御
				|| keyCode == 115 // F4キーの制御
				|| keyCode == 116 // F5キーの制御
				|| keyCode == 117 // F6キーの制御
				|| keyCode == 118 // F7キーの制御
				|| keyCode == 119 // F8キーの制御
				|| keyCode == 120 // F9キーの制御
				|| keyCode == 121 // F10キーの制御
				|| keyCode == 122 // F11キーの制御
				|| keyCode == 123 // F12キーの制御
			)
			{
				return false;
			}
		});
	});
}


function convertToJson(valueList) {
	var array = [];
	var strList = {};

	for(i=0; i<valueList.length; i++){
		array.push(valueList[i]);
	}
	strList = {userNumber: string,strList : array};

	return JSON.stringify(strList);
}

//値を送信して受け取るまでの処理
function sendJson(test,jsonStr){
	$.ajax({
		async:false,
		type : "POST",
		url : test,
		dataType : "json",
		data: jsonStr,
		contentType: 'application/json',
		cache : false,
	}).done(function(data, status, jqXHR){
		message = jqXHR.responseJSON.rtnList;
		messageStr = message[0];	//取得したメッセージの0番目を取得([true,msg]の形式) 削除検討
		work = jqXHR.responseJSON.workTypeList;
	}).fail(function(data, status, jqXHR){
		valid = false;
	})
};

function getButtonParameter(link,Authority){
	$.ajax({
		async:false,
		type : "POST",
		url : link,
		dataType : "json",
		data: Authority,
		contentType: 'application/json',
		cache : false,
	}).done(function(data, status, jqXHR){
		buttonList = jqXHR.responseJSON.btnList;
	}).fail(function(data, status, jqXHR){
		valid = false;
	})
};



function messageInit(){
	document.getElementById("messageAria").innerHTML = "";
}


function workInputSelect(selectId, array){
	var select = document.getElementById(selectId);
	var len = array.length;
	for(var i=0; i<len; i++ ){
		var option = document.createElement('option');
		option.setAttribute('value', array[i]);
		option.innerHTML = array[i];
		select.appendChild(option);
	}
}


function createMessage(message){
	var errorCount = 0;
	var successList = [];
	var errorList   = [];
	var resultList  = [];

	for(var i=0; i<message.length; i++){
		if(message[i][0]=="true"){
			successList.push(message[i][1]);
		}else if(message[i][0]=="false"){
			errorList.push(message[i][1]);
			errorCount = 1;
		}else{
			errorList.push('undefined.');
			errorCount = 1;
		}
	}

	if(errorCount==0){
		resultList.push("true");
		resultList.push(successList[0]);
	}else if(errorCount==1){
		var errorMessage = errorList[0];
		if(1<errorList.length){
			for(var j=1; j<errorList.length; j++){
				errorMessage = errorMessage + "<br/>" + errorList[j];
			}
		}
		resultList.push("false");
		resultList.push(errorMessage);
	}
	return resultList;
}


/**
 * ボタンのパラメータを取得する。
 * 権限コードを渡し、ボタンパラメータをリストで受け取る。
 * @param Authority
 * @returns buttonList
 */
function setButtonParam(Authority){
	Authority.toString(Authority);
    var array ={"authority": Authority};
	$.ajax({
		async:false,
		type : "POST",
		url : "getButtonParam",
		dataType : "json",
		data: JSON.stringify(array),
		contentType: 'application/json',
		cache : false,
	}).done(function(data, status, jqXHR){
		buttonList = jqXHR.responseJSON.btnList;
	}).fail(function(data, status, jqXHR){
		valid = false;
	})
}





