package hello.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.dao.AttendanceListDao;
import hello.form.FormBean;

@Component
public class AttendanceListBussinessLogic {

	@Autowired
	AttendanceListDao ald;


	//勤怠一覧画面の情報取得処理に対応する形に整形するだけの処理
	public List<String> dataShaping(FormBean fb){
		List<String> list = new ArrayList<>();
		list.add("1020S");
		list.add(fb.getCompanyCode());
		list.add(fb.getUserNumber());
		list.add(fb.getUserName());
		list.add(fb.getYear());
		list.add(fb.getMonth());
		return list;
	}


	//データベースへアクセスし、取得した値を、画面の整形に利用できる形に整形する(予定)
	//データベースから取得する形式が現在不明瞭なので、ひとまずdaoで作成した配列をそのまま渡す。
	public List<List<List<String>>> databaseAccessing(String companyCode, String userNumber, String userName, String year, String month){
		List<List<List<String>>> list = new ArrayList<>();

		//daoにアクセスしてデータを受け取る。
		list = ald.selectAttendanceList(companyCode,userNumber,userName,year,month);

		return list;
	}

}
