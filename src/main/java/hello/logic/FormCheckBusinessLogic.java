package hello.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import constant.Message;

@Component
public class FormCheckBusinessLogic {

	Message msgData = new Message();

	@Autowired
	private ValidationBussinessLogic vbl;

	//list[0]に格納された画面コードを使い、エラーメッセージを引っ張る引数を決定する
	//返り値は [msg, msg, ... , true/false] の形式を取ること。

	/**
	 * リストのチェックを行い、true-false及びエラーコードを返す。rtnListの中身は『要素毎に固めて』addすること。
	 * @param list		[画面コード, 値1, 値2, ... , ]
	 * @param min		checkLengthで使用する。文字列長の下限
	 * @param max		checkLengthで使用する。文字列長の上限
	 */
	public List<List<String>> checkPattern(List<String> list, int min, int max){

		List<List<String>> rtnList = new ArrayList<>();
		String dispCode = list.get(0);//画面コードを保存
		list.remove(0);//リストから画面コードを除外
		switch(dispCode){
			//ログイン画面
			case "1000S" :
				rtnList.add(vbl.checkNull(list.get(0),msgData.S100000, msgData.E100000));	//list[0]:UserID, list[1]:PW
				rtnList.add(vbl.checkLength(list.get(0),msgData.S100000, msgData.E100002,8,10));
				rtnList.add(vbl.checkNull(list.get(1),msgData.S100000, msgData.E100001));
				rtnList.add(vbl.checkLength(list.get(1),msgData.S100000, msgData.E100003,8,10));
				break;

			case "1010S" :
				break;

			case "1020S" :
				rtnList.add(vbl.checkNull(list.get(0), msgData.S100000, msgData.E102000));	//CompanyCode
				rtnList.add(vbl.checkNull(list.get(1), msgData.S100000, msgData.E102001));	//userNumber
				rtnList.add(vbl.checkNull(list.get(2), msgData.S100000, msgData.E102002));	//userName
				rtnList.add(vbl.checkNull(list.get(3), msgData.S100000, msgData.E102003));	//year
				rtnList.add(vbl.checkNull(list.get(4), msgData.S100000, msgData.E102003));	//month
				break;

			default :
				System.out.println("画面が存在しません。");
		}
		return rtnList;
	}

}
