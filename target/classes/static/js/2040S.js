/**
 *
 */


function approvalStatusInputSelect(selectId, array){
	var select = document.getElementById(selectId);
	var len = array.length;
	var option = document.createElement('option'); //セレクトボックスの要素を作成
	option.setAttribute('value', "default"); //value属性の値を設定する。
	option.innerHTML = "指定しない"; //セレクトボックスの要素の表示名を設定
	select.appendChild(option); //セレクトボックスに要素を追加

	var len = array.length;
	for(var i=0; i<len; i++ ){
		var option = document.createElement('option'); //セレクトボックスの要素を作成
		option.setAttribute('value', i); //value属性の値を設定する
		option.innerHTML = array[i]; //セレクトボックスの要素の表示名を設定
		select.appendChild(option); //セレクトボックスに要素を追加
	}
}

function departmentInputSelect(selectId, array){
	var select = document.getElementById(selectId);
	var len = array.length;
	var option = document.createElement('option'); //セレクトボックスの要素を作成
	option.setAttribute('value', "default"); //value属性の値を設定する。
	option.innerHTML = "指定しない"; //セレクトボックスの要素の表示名を設定
	select.appendChild(option); //セレクトボックスに要素を追加

	for(var i=0; i<len; i++ ){
		var option = document.createElement('option'); //セレクトボックスの要素を作成
		option.setAttribute('value', i); //value属性の値を設定する
		option.innerHTML = array[i][0]; //セレクトボックスの要素の表示名を設定
		select.appendChild(option); //セレクトボックスに要素を追加
	}
}

function firstSelect(){
	var select =document.createElement("select");
	var option = document.createElement('option'); //セレクトボックスの要素を作成
	option.setAttribute('value', "default"); //value属性の値を設定する。
	option.innerHTML = "指定しない"; //セレクトボックスの要素の表示名を設定
	select.appendChild(option); //セレクトボックスに要素を追加
	document.getElementById("work").appendChild(select);
}


function changeWorkList(obj){
	document.getElementById("work").innerHTML = "";

	var select =document.createElement("select");

	if(obj.value!="default"){
		var option = document.createElement('option'); //セレクトボックスの要素を作成
		option.setAttribute('value', "default"); //value属性の値を設定する。
		option.innerHTML = "指定しない"; //セレクトボックスの要素の表示名を設定
		select.appendChild(option); //セレクトボックスに要素を追加
		var num = document.getElementById("department").value;
		var len = department[num].length;
		for(var i=1; i<len; i++ ){
			var option = document.createElement('option'); //セレクトボックスの要素を作成
			option.setAttribute('value', i); //value属性の値を設定する
			option.innerHTML = department[num][i]; //セレクトボックスの要素の表示名を設定
			select.appendChild(option); //セレクトボックスに要素を追加
		}
	}else{
		var option = document.createElement('option'); //セレクトボックスの要素を作成
		option.setAttribute('value', "default"); //value属性の値を設定する。
		option.innerHTML = "指定しない"; //セレクトボックスの要素の表示名を設定
		select.appendChild(option); //セレクトボックスに要素を追加
	}
	document.getElementById("work").appendChild(select);
}

function startMonthInputSelect(selectId){
	var select = document.getElementById(selectId);
	var y = year;
	var m = month;
	for(var i=0; i<12; i++ ){
		var option = document.createElement('option'); //セレクトボックスの要素を作成
		option.setAttribute('value', i); //value属性の値を設定する
		option.innerHTML = y + "/" + m; //セレクトボックスの要素の表示名を設定
		select.appendChild(option); //セレクトボックスに要素を追加
		if(m < 12){
			m++;
		}
		else{
			m = 1;
		}
	}
}

function endMonthInputSelect(selectId, array){
	var select = document.getElementById(selectId);
	var len = array.length;
	for(var i=0; i<len; i++ ){
		var option = document.createElement('option'); //セレクトボックスの要素を作成
		option.setAttribute('value', i); //value属性の値を設定する
		option.innerHTML = array[i]; //セレクトボックスの要素の表示名を設定
		select.appendChild(option); //セレクトボックスに要素を追加
	}
}


//tbody内部(ヘッダ部を除く、承認リストの作成)
//tempSearchData と requestList を渡す。
function createApprovalTableList(tempSearchData,requestList){

	//メモ
	//alert(requestList.length);		//全リスト
	//alert(requestList[x].length)		//1行分のリスト
	//alert(requestList[x][0].length);	//画面表示(振替日除く)のリスト

	var apTable = document.getElementById("approvalList");
	apTable.innerHTML = "";

	//行の処理...取得件数だけ回す
	for(var i=0; i<requestList.length;i++){
		var mainTr = document.createElement("tr");
		mainTr.id = i;	//再申請モーダルにデータを送信する際に、どの行の配列を送るかを指定するために振る

		//チェックボックスの生成
		var checkbox = document.createElement("input");
		checkbox.type  = "checkbox";
		checkbox.id = "chk" + i ;
		checkbox.className = "cell0";
		mainTr.appendChild(checkbox);

		//列の処理①...セルに値を格納する処理
		for(var j=0;j<requestList[i][0].length;j++){
				var td = document.createElement("td");
				td.className = "cell"+ (j+1);			//j+1してるのは、直前にチェックボックスを追加しているため。
				td.innerHTML = requestList[i][0][j];
				mainTr.appendChild(td);
		}
		//列の処理②...振替日に関しての処理

		//詳細画面へ(本来は画像を予定しているが、ひとまず◎で代替)
		var detail = document.createElement("a");
		td.innerHTML = "<a onclick='detailModal("+ i +")'>◎</a>";	//動的に引数を挿入している。これでモーダルに配列を渡せるはず。
		mainTr.appendChild(detail);

		//テーブルに行を追加
		apTable.appendChild(mainTr);
	}
}


//詳細ボタンが押された時の挙動
function detailModal(num){
	alert(num);
}


//検索ボタンが押された時の処理
function searchButton(list){

	//RestControllerの承認リストデータ取得処理に投げる。
	//一旦、以下のリストが返ってきたことにする。
	requestList = [
		[["0","組織B1","業務B","山田太郎","11/01","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","さのまるくん"]],
		[["0","組織B2","業務B","山田太郎","11/01","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","せんとくん"]],
		[["0","組織B3","業務B","山田太郎","11/01","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織B4","業務B","山田太郎","11/01","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織B5","業務B","山田太郎","11/01","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織B6","業務BBB","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]]
	];//以上30件仮データ

	//approvalListの要素を初期化して、検索結果を再挿入している。
	var apTable = document.getElementById("approvalList");
	apTable.innerHTML = "";
	createApprovalTableList(tempSearchData,requestList);
}

//ページを読み込んだ際に、RestControllerの承認リストデータ取得処理に投げる。
//表示件数を考慮すること。
function initApprovalList(){

	//表示リストデータ(仮)
	//[[承認状態,組織名,業務名,氏名,対象日,勤務区分,開始時間,終了時間,備考],[振替日,0],[状態,申請日,承認日,承認者]]
	requestList = [
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織A","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]],
		[["0","組織ABCDE","業務A","山田太郎","10/31","通常","22:22","22:22","備考欄ですよ"],[],["0","10/01(土)","10/05(水)","ぐんまちゃん"]]
	];//以上15件仮データ

	createApprovalTableList(tempSearchData,requestList);

}

//再申請要求ボタンを押した時の挙動。
//チェックボックスのチェック個数をカウントし、出すモーダルを選択する。
function reapprovalRequest(list){

	//チェックの付いたリストの番号(value)を取得する処理を行う。
	var checkList = [];
	var len = list.length;
	for(var i=0; i<len; i++){
		var id="chk" + i;
		if($("#"+id).prop('checked')) {
			checkList.push(document.getElementById(id).id);
		}
	}

	//チェックの入ったデータを格納するリスト
	var detailList;		//モーダルダイアログへ送信するために利用する。


	//チェックが1つだけなら詳細画面を開く
	//チェックが2つ以上なら複数送信用画面を開く
	//チェックがついて無いなら何もしない(エラーメッセージを返す)
	var chkListLength = checkList.length;
	if(chkListLength == 1){
		//詳細画面を開く
		alert("ひとつだけ選択されました");
		alert(checkList);

	}else if(chkListLength >= 2){
		//複数送信用画面を開く
		alert("複数選択されました");
		alert(checkList);
	}else{
		//エラーメッセージを返す。
		alert("ひとつも選択されていません。");
	}


}




