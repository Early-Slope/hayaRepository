package hello.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import constant.ButtonParam;

@Component
public class ButtonParamBussinessLogic {

	ButtonParam bParam = new ButtonParam();

	public List<List<String[]>> getButtonParam(String Authority){
		String auth = checkAuthority(Authority);
		List<List<String[]>> rtnBtnList = makeButtonList(auth);
		return rtnBtnList;
	}

	/**
	 * 権限コード(文字列の数値)を渡し、権限レベルの確認を行う。返り値は文字列。
	 * @param Authority
	 * @return authority
	 */
	public String checkAuthority(String Authority){
		String authority;
		int auth = Integer.parseInt(Authority);

		if(auth>=0 && auth<10){
			authority = "Supervisor";
		}else if(auth>=10 && auth<20){
			authority = "General";
		}else if(auth>=20 && auth<30){
			authority = "Authorizer";
		}else if(auth>=30 && auth<40){
			authority = "SystemAdmin";
		}else{
			authority = "Nothing";
		}
		return authority;
	}

	/**
	 * ボタン生成に必要なパラメータリストを作成する。
	 * @param authority 権限レベル
	 * @return rtnList
	 */
	public List<List<String[]>> makeButtonList(String authority){

		List<List<String[]>> rtnList = new ArrayList<>();
		List<String[]> element;

		switch(authority){
			case "Supervisor" : break;


			case "General" :
				element = Arrays.asList(bParam.applyName,bParam.applyLink);
				rtnList.add(element);
				break;

			case "Authorizer" :
				element = Arrays.asList(bParam.applyName,bParam.applyLink);
				rtnList.add(element);
				element = Arrays.asList(bParam.registName,bParam.registLink);
				rtnList.add(element);
				element = Arrays.asList(bParam.reportName,bParam.reportLink);
				rtnList.add(element);
				break;

			case "SystemAdmin" : break;

			//見つからない場合
			case "Nothing":
			default : break;
		}

		return rtnList;

	}

}
