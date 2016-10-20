function createCalendar(array){
	var len = array.length;


	if(len=="12"){
		var tbody = document.getElementById("calendar");
		var data = array[6];
		var tr = document.createElement("tr");

		document.getElementById("now").innerHTML = data[0] +"月";



		for(var i=1; i<data.length; i++){
			var td = document.createElement("td");
			td.className = "dateCell";
			var a = document.createElement("a");
			a.id = "day" + i;
			if(i==7 || i==14 || i==21 || i==28 || i==35){
				a.className = "day holiday2";
				a.appendChild(document.createTextNode(data[i]));
				td.appendChild(a);
				tr.appendChild(td);
				tbody.appendChild(tr);
				var tr = document.createElement("tr");
			}else if(i==0 || i==8 || i==15 || i==22 || i==29){
				a.className = "day holiday1";
				a.appendChild(document.createTextNode(data[i]));
				td.appendChild(a);
				tr.appendChild(td);
			}else{
				a.className = "day";
				a.appendChild(document.createTextNode(data[i]));
				td.appendChild(a);
				tr.appendChild(td);
			}
		}
		tbody.appendChild(tr);

	}else{
		//error message
		alert("error");
	}
}
