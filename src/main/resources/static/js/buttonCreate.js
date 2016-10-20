/**
 *
 */

function buttonCreate(data){
	//alert(data.length);
	var count = data.length;
	//alert(count);
	for(var i=0 ; i<count ; i++){
	    var btn = document.createElement("input");
	    btn.id = "button" + i;
	    btn.type = "button";
	    //alert(btn.value)
	    btn.value = data[i][0];
	    document.getElementById("buttonAria").appendChild(btn);
	}
}