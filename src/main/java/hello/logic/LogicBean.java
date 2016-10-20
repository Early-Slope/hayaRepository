package hello.logic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import constant.Message;


@Component
public class LogicBean {

	public Message msg = new Message();

	private final int FIRSTNAME_CHAR_LENGTH = 10;
	private final int NUM_LENGTH = 8;


	private String[] errorMessage = {
									"userName is not valid.<br/>password is not valid."
								};

	private String[] successMessage = {
									"procces succeed."
								};

	//バリデーションのチェック
	public Boolean checkValid(String name, String string){

		int validNum = 0;

		if(name.length() > FIRSTNAME_CHAR_LENGTH){
			validNum++;
		}
		if(string.length() > NUM_LENGTH){
			validNum++;
		}

		//判定
		if(validNum == 0){
			return true;
		}else{
			return false;
		}

	}


	public List<String> selectReturnMessage(String name, String string){

		List<String> rtnMessage = new ArrayList<String>();


		//ここから、入力された文字列長によって、返すメッセージを選択/////////
		if(name.length() > FIRSTNAME_CHAR_LENGTH){
			rtnMessage.add(errorMessage[0]);
		}
		else if(string.length() > NUM_LENGTH){
			rtnMessage.add(errorMessage[0]);
		}
		if(rtnMessage.isEmpty()){
			rtnMessage.add(successMessage[0]);
		}

		//ここまで//////////////////////////////////////////////////////////

		System.out.println("rtnMessage : "+ rtnMessage);
		System.out.println(msg.E100000)	;
		return rtnMessage;
	}

	public String[] getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String[] errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String[] getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String[] successMessage) {
		this.successMessage = successMessage;
	}

	/*
	public String rtnStr(){
		return "hayasaka";
	}

	public int add(int a, int b){
		int s = a + b;
		return s;
	}
	*/

}
