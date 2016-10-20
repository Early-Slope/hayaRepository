package hello.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;


@Component
public class ValidationBussinessLogic {

	/**
	 * nullチェック処理。
	 * 入力値がnullでないかを確認する。
	 * @param value
	 * @param sMsg
	 * @param eMsg
	 * @return	list
	 */
	public List<String> checkNull(String value, String sMsg, String eMsg){

		List<String> list = new ArrayList<>();

		if(value != null){
			list.add("true");
			list.add(sMsg);
		}else{
			list.add("false");
			list.add(eMsg);
		}

		return list;
	}

	/**
	 * 文字列長のチェック処理。
	 * minLength <= value <= maxLength を満たす時、[true, sMsg]を返す
	 * @param value
	 * @param sMsg
	 * @param eMsg
	 * @param minLength
	 * @param maxLength
	 * @return list
	 */
	public List<String> checkLength(String value, String sMsg, String eMsg, int minLength, int maxLength){

		List<String> list = new ArrayList<>();

		if(value.length() >= minLength && value.length() <= maxLength){
			list.add("true");
			list.add(sMsg);
		}else{
			list.add("false");
			list.add(eMsg);
		}
		return list;

	}

	//制作途中
	/**
	 * 禁則文字チェック処理。(制作中)
	 * 文字が格納された配列を渡し、禁則文字が含まれていないかどうかを確認する
	 * @param valueList
	 * @return
	 */
	public boolean checkInterdiction(List<String> valueList){

		boolean flag = true;

		//入力フォームによってパターンを変える必要があるため、定義箇所を変更する可能性あり。
		String regex = "[^a-zA-Z0-9]";	//許容しない文字列を渡す

		Pattern p = Pattern.compile(regex);

		for(String value : valueList){
			Matcher m = p.matcher(value);
			if(m.find()){	//指定外の文字列が見つかった場合
				flag = false;
				break;
			}else{	//見つからなかった場合
			}
		}
		return flag;
	}

	/**
	 * [[boolean,param1],[boolean,param2],...]の形式を渡し、falseが含まれていた場合はfalseを返す。
	 * falseが一つも無ければ、tureを返す。
	 * @param list
	 * @return checkFlag
	 */
	public boolean isAllTrue(List<List<String>> list){

		String result;
		result = list.toString();
		boolean checkFlag = result.contains("false");	//falseがあればtrueを返す。

		if(checkFlag == false){	//falseが1つも含まれていなかったら
			checkFlag = true;
		}else{						//falseが1つでも含まれていたら
			checkFlag = false;
		}

		return checkFlag;
	}

}
