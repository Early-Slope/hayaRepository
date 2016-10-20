package hello.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import hello.logic.FormCheckBusinessLogic;

@Component
public class WorkTypeDao {

	@Autowired
	FormCheckBusinessLogic fcbl;

	//業務を取得する処理。
	public List<String> getWorkType(String userId, String userPass){

		//①基本データ取得処理
		List<String> list = new ArrayList<>();
		//会社コード
		String companyCode = "ATP";
		//社員ナンバー
		String userNum = "123456";
		//社員名
		String userName = "hayasaka";
		//業務リストを含め、基本データをリストに纏めて返す。
		//returnの都合上、基本データ(不可変)の後ろに業務リスト(可変)を追加する。
		list.add(companyCode);
		list.add(userNum);
		list.add(userName);
		list.add("1Solution");
		list.add("2Solution");
		list.add("3Solution");
		list.add("4Solution");
		list.add("CLSG");

		/*
		if(userId.equals("1111111111")&& userPass.equals("aaaaaaaa")){
			list.add(companyCode);
			list.add(userNum);
			list.add(userName);
			list.add("1Solution");
			list.add("2Solution");
			list.add("3Solution");
			list.add("CLSG");
		}else if(userId.equals("2222222222")&& userPass.equals("bbbbbbbb")){
			list.add(companyCode);
			list.add(userNum);
			list.add(userName);
			list.add("1Solution");
			list.add("2Solution");
			list.add("3Solution");
			list.add("4Solution");
			list.add("5Solution");
			list.add("CLSG");
		}else{
			list.add(companyCode);
			list.add(userNum);
			list.add(userName);
			list.add("-");
		}
		 */

		return list;

	}

}
