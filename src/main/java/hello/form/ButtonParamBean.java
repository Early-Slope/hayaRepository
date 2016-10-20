package hello.form;

import java.util.List;

/**
 * ボタン生成処理に使用するクラス
 *
 * @author haya510
 */
public class ButtonParamBean {

	ButtonParamBean(){}

	/**
	 * 権限情報
	 * 	 スーパーバイザ：0-9 /
	 *   一般:10-19 /
	 *   承認者:20-29 /
	 *   システム管理者：30-39 /
	 */
	private String Authority;

	/**
	 * 	フロントに返すためのボタン情報
	 *  [ List<String> id ,List<String> 画面項目 , List<String> リンク ] の形を取る。
	 *  idは単一の要素を持たせ、画面項目要素とリンク要素は1:1で対応している。
	 */
	private List<List<String[]>> btnList;

	public String getAuthority() {
		return Authority;
	}
	public void setAuthority(String authority) {
		Authority = authority;
	}
	public List<List<String[]>> getBtnList() {
		return btnList;
	}
	public void setBtnList(List<List<String[]>> btnList) {
		this.btnList = btnList;
	}

}
