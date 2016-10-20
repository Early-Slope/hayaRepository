/**
 *チェック処理
 */

function blankCheck(array){
	var length = array.length;
	var flg = 0;
	if(length!=-1){
		for(var i=0; i<length; i++){
			if(document.getElementById(array[i]).value.length==0){
				flg=1;
				break;
			}
		}
		if(flg==0){
			return true;
		}else{
			document.getElementById(array[i]).focus();
			return false;
		}
	}else{
		document.getElementById(array[0]).focus();
		return false;
	}
}


function digitsCheck(tmpList){
	var length = tmpList.length;
	var flg = 0;
	for(i=0; i<length; i++){
		var item = document.getElementById(tmpList[i][0]);
		var itemLength = tmpList[i][1];
		if(item.value.length>itemLength){
			flg = 1;
			item.focus();
			break;
		}
	}
	if(flg==0){
		return true;
	}else if(flg==1){
		return false;
	}
}

