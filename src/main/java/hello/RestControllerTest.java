package hello;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import constant.Message;
import hello.dao.WorkTypeDao;
import hello.form.ButtonParamBean;
import hello.form.FormBean;
import hello.logic.AttendanceListBussinessLogic;
import hello.logic.ButtonParamBussinessLogic;
import hello.logic.DateTimeSetting;
import hello.logic.FormCheckBusinessLogic;
import hello.logic.ValidationBussinessLogic;

@RestController
public class RestControllerTest {

	@Autowired
	private DateTimeSetting dts;

	@Autowired
	private FormCheckBusinessLogic fcbl;

	@Autowired
	private ButtonParamBussinessLogic bpbl;

	@Autowired
	private WorkTypeDao wtd;

	@Autowired
	private ValidationBussinessLogic vbl;

	@Autowired
	private AttendanceListBussinessLogic albl;

	Message msgData = new Message();

	//メッセージ取得処理
	@RequestMapping(value = "/message", method = RequestMethod.POST)
	public String formCheck(@RequestBody String json) {
		String rtnJson = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			FormBean obj = mapper.readValue(json, FormBean.class);
			List<String> daoGetList = new ArrayList<>();

			//① : id,passのvalidationチェックを行い、処理結果を受け取る
			List<List<String>> rList =  fcbl.checkPattern(obj.getStrList(),8,10);

			//② : ①の結果に対して、入力値に問題があるかどうかを確認する処理を行う。
			boolean flag = vbl.isAllTrue(rList);

			//③ : DB接続処理を行う
			if(flag){
				//③-1 : ②の結果に問題が無ければ、DAOにアクセスして「会社コード、社員No、社員名」を取得する
				daoGetList = wtd.getWorkType(obj.getStrList().get(0), obj.getStrList().get(1));	//userId,userPw
			}else{
				//③-2 : ②の結果に問題があれば、DAOにアクセスせずに、エラー処理を行う
				Collections.addAll(daoGetList, "-","-","-");
				List<String> eList = new ArrayList<>(Arrays.asList("false",msgData.E101003));
				rList.add(eList);
			}

			//④画面に取得データを返す為に、Jacksonで整形する
			obj.setRtnList(rList);
			obj.setCompanyCode(daoGetList.get(0));
			obj.setUserNumber(daoGetList.get(1));
			obj.setUserName(daoGetList.get(2));
			List<String> tempList = new ArrayList<>();
			for(int i=3;i<daoGetList.size();i++){	//返ってきた配列の、業務リスト部分を抜き出して格納する。
				tempList.add(daoGetList.get(i));
			}
			obj.setWorkTypeList(tempList);

			rtnJson = mapper.writeValueAsString(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
        return rtnJson;
    }

	//出勤退勤ボタン処理
	@RequestMapping(value = "/workStatus", method = RequestMethod.POST)
	public String workStatus(@RequestBody String json) {
		String rtnJson = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			FormBean obj = mapper.readValue(json, FormBean.class);

			//① :「企業コード」「社員番号」「社員名」「場所コード」「出勤ステータス」「退勤ステータス」の
			//     チェック処理を行い、処理結果を受け取る。
			// List<String> daoGetList = new ArrayList<>();

			//② : ①の処理結果を受け取り、問題が無かったかどうか確認する処理を行う。

			//③-1 : ②の処理結果を受け取り、問題が無い場合はデータベースへアクセスする処理を行う。

			//③-2 : ②の処理結果を受け取り、問題が有る場合はデータベースへアクセスせずにエラー処理を行う。

			//④ : ③の処理結果を使用して、画面にデータを返す処理を行う。

			rtnJson = mapper.writeValueAsString(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
        return rtnJson;
    }

	//時刻取得処理
	@RequestMapping(value = "/getTime", method = RequestMethod.GET)
	public String dateTime() {
		String time = dts.rtnDate();
        return time;
    }

	/**
	 * ボタン情報取得処理に投げる
	 * @param json
	 * @return rtnJson
	 */
	@RequestMapping(value = "/getButtonParam", method = RequestMethod.POST)
	public String buttonParam(@RequestBody String json) {
		String rtnJson = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			ButtonParamBean obj = mapper.readValue(json, ButtonParamBean.class);
			List<List<String[]>> rList = bpbl.getButtonParam(obj.getAuthority());
			obj.setBtnList(rList);

			rtnJson = mapper.writeValueAsString(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
        return rtnJson;
    }

	/**
	 * ブラウザ側から、strListに「企業コード」「社員番号」「社員名」「日付(YYYY)」「日付(MM)」を受け取り、ユーザーの勤怠を取得する。
	 * @param json
	 * @return
	 */
	@RequestMapping(value = "/attendanceList", method = RequestMethod.POST)
	public String AttendanceList(@RequestBody String json){
		String rtnJson = null;
		try{
			ObjectMapper mapper = new ObjectMapper();
			FormBean obj = mapper.readValue(json, FormBean.class);
			List<List<List<String>>> daoGetList = new ArrayList<>();
			//① : 「企業コード」「社員番号」「社員名」「日付(YYYY/MM)」のチェック処理を行い、処理結果を受け取る。
			obj.setStrList(albl.dataShaping(obj));//nullチェックを行う為に、対応する形に整形
			List<List<String>> rList =  fcbl.checkPattern(obj.getStrList(),8,10);

			//② : ①の処理結果を受け取り、問題が無かったかどうか確認する処理を行う。
			boolean flag = vbl.isAllTrue(rList);

			//③ : DB接続処理を行う
			if(flag){
				//③-1 : ②の処理結果を受け取り、問題が無い場合、データベースにアクセスをする処理を行う。
				daoGetList = albl.databaseAccessing(obj.getCompanyCode(), obj.getUserNumber(), obj.getUserName(), obj.getYear(), obj.getMonth());
				List<String> sList = new ArrayList<>(Arrays.asList("true",msgData.S100000));
				rList.add(sList);
			}else{
				//③-2 : ②の処理結果を受け取り、問題がある場合、データベースにアクセスせずにエラー処理を行う。
				//Collections.addAll(daoGetList, "-","-","-");
				List<String> eList = new ArrayList<>(Arrays.asList("false",msgData.E102005));
				rList.add(eList);
			}

			//④ : ③の処理結果を使用して、画面にデータを返す。
			obj.setRtnList(rList);
			obj.setAttendanceList(daoGetList);

			rtnJson = mapper.writeValueAsString(obj);
		}catch(IOException e){
			e.printStackTrace();
		}
		return rtnJson;
	}


}

