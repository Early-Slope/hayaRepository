/**
 buttonData
 */

function getButtonData(authority,pageId){
	var b1 = ['ログイン','0001WN.html'];
	var b2 = ['時間外申請','0002WN.html'];

	var buttonData = [];

	if(authority=="sys"){
		switch(pageId){
			case '0001WN':
				buttonData.push(b1);
				//buttonData.push(b2);
				break;
			case '0002WN':
				buttonData.push(b2);
				break;
		}
	}
	return buttonData;
}