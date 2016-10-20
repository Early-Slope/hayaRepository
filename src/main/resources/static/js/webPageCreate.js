/**
 *
 */

function webPageCreate(buttinList){
	//ヘッダー差替
	document.getElementById("headerImage").innerHTML = '<img src="img/header.jpg">'

	//beanに移行
	buttonCreate(buttonList);

	//フッター差替
	document.getElementById("footerImage").innerHTML = '<img src="img/footer.jpg">'

}




function buttonCreate(buttonList){
	var len = buttonList.length
	var test = document.getElementById("contents");
	var mainUl  =document.createElement('ul');
	mainUl.id = "nav";

	if(len!=0){
		for(var i=0; i<len; i++){
			btnLen = buttonList[i][0].length

			if(btnLen!=1){
				var id = "btn" + i;
				var mainLi  =document.createElement('li');
				var mainA   =document.createElement('a');
				mainA.text = buttonList[i][0][0];
				mainA.name = buttonList[i][1][0];
				mainA.onclick = new Function("movePage(this);");
				mainA.id   = id + "0";
				mainLi.appendChild(mainA);
				mainUl.appendChild(mainLi);

				var ul  =document.createElement('ul');
				for(var j=1; j<btnLen; j++){
					var li  =document.createElement('li');
					var a   =document.createElement('a');
					a.text = buttonList[i][0][j];
					a.name = buttonList[i][1][j];
					a.onclick = new Function("movePage(this);");
					a.id   = id + j
					li.appendChild(a);
					ul.appendChild(li);
				}
				mainLi.appendChild(ul);
				mainUl.appendChild(mainLi);
				test.appendChild(mainUl);
			}else{
				var mainLi  =document.createElement('li');
				var mainA   =document.createElement('a');
				mainA.text = buttonList[i][0][0];
				mainA.onclick = new Function("movePage(this);");
				mainLi.appendChild(mainA);
				mainUl.appendChild(mainLi);
				test.appendChild(mainUl);
			}
		}
	}else{
		//error message
		alert("error");
	}

}


