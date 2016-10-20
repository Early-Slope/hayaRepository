package hello.form;

import java.util.List;


public class FormBean {

	public FormBean(){}

	/**
	 * 基本的にAjax通信時、この配列に値を格納する
	 */
	private List<String> strList;

	/**
	 * エラー(成功)メッセージの返却値を格納。
	 * [[true,sMsg].[false,eMsg],...]
	 */
	private List<List<String>> rtnList;

	/**
	 * 画面遷移の判断で使用する。	※消去予定
	 */
	private Boolean valid;

	/**
	 * 画面コード
	 */
	private String displayCode;


	/**
	 * 操作に必要な日付情報を格納。
	 */
	private String year;	//年
	private String month;	//月
	private String date;	//日
	//private String weekday;	//曜日


	//ユーザ基本情報-ここから////////////////////////////////////////////////////////////////////

	/**
	 * 会社コード
	 */
	private String companyCode;

	/**
	 * 社員番号
	 */
	private String employeeNumber;

	/**
	 * 画面から送られた社員名(UserName)
	 */
	private String userName;

	/**
	 * 画面から送られたUserID
	 */
	private String userNumber;

	/**
	 * 画面に返す業務リスト
	 */
	private List<String> workTypeList;

	/**
	 * 場所コード
	 */
	private String placeCode;

	/**
	 * 出勤ステータス
	 */
	private String attendWorkStatus;

	/**
	 * 退勤ステータス
	 */
	private String leaveWorkStatus;


	//ユーザ基本情報-ここまで////////////////////////////////////////////////////////////////////

	/**
	 * エラーが起きた時にメッセージを格納する為のリスト
	 */
	private List<List<String>> messageList;


	//勤怠一覧画面に表示する情報
	/**
	 * 勤怠一覧画面に表示するデータリスト。
	 * 形式については、AttendanceListDao参照
	 */
	private List<List<List<String>>> attendanceList;


	//以下 getter 及び setter ///////////////////////////////////////////////////////////////////

	public List<String> getStrList() {
		return strList;
	}
	public void setStrList(List<String> strList) {
		this.strList = strList;
	}
	public Boolean isValid() {
		return valid;
	}
	public void setValid(Boolean boolean1) {
		this.valid = boolean1;
	}
	public List<List<String>> getRtnList() {
		return rtnList;
	}
	public void setRtnList(List<List<String>> rtnList) {
		this.rtnList = rtnList;
	}
	public String getDisplayCode() {
		return displayCode;
	}
	public void setDisplayCode(String displayCode) {
		this.displayCode = displayCode;
	}
	public String getUserNumber() {
		return userNumber;
	}
	public void setUserNumber(String userNumber) {
		this.userNumber = userNumber;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<String> getWorkTypeList() {
		return workTypeList;
	}
	public void setWorkTypeList(List<String> workTypeList) {
		this.workTypeList = workTypeList;
	}
	public List<List<String>> getMessageList() {
		return messageList;
	}
	public void setMessageList(List<List<String>> messageList) {
		this.messageList = messageList;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getEmployeeNumber() {
		return employeeNumber;
	}
	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
	public String getAttendWorkStatus() {
		return attendWorkStatus;
	}
	public void setAttendWorkStatus(String attendWorkStatus) {
		this.attendWorkStatus = attendWorkStatus;
	}
	public String getLeaveWorkStatus() {
		return leaveWorkStatus;
	}
	public void setLeaveWorkStatus(String leaveWorkStatus) {
		this.leaveWorkStatus = leaveWorkStatus;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public List<List<List<String>>> getAttendanceList() {
		return attendanceList;
	}
	public void setAttendanceList(List<List<List<String>>> attendanceList) {
		this.attendanceList = attendanceList;
	}

}

