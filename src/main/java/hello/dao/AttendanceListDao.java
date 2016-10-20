package hello.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class AttendanceListDao {

	/*
	1日のデータを一つの多次元配列に纏める必要がある。
	[
		[年,月,日,曜日,休日区分],[振替休日],[開始時間,終了時間,予定値,実績値,業務名,申請状況,備考][②][③]...,
		[年,月,日,曜日,休日区分],[振替休日],[開始時間,終了時間,予定値,実績値,業務名,申請状況,備考][②][③],
		[年,月,日,曜日,休日区分],[振替休日],[開始時間,終了時間,予定値,実績値,業務名,申請状況,備考][②][③]
	]
	 */

	//勤怠一覧画面に必要な情報を取得する処理。
	//20161014現在、ひとまずデータ群を作成する必要があるので、作り方に問題はあるが、データを定義した。
	public List<List<List<String>>> selectAttendanceList(String companyCode, String userNumber, String userName, String year, String month){
		List<List<List<String>>> monthlyWorkList = new ArrayList<>();	//画面に戻す全データ(以下の配列)を格納する

		//10/1～5日のデータを空欄で埋める
		for(int i=1; i<=5;i++){
				List<List<String>> onedayWorkList0 = new ArrayList<>();
				List<String> dateList0 = new ArrayList<>();
				List<String> compensatoryLeaveList0 = new ArrayList<>();
				List<String> detailList0 = new ArrayList<>();
				dateList0 = Arrays.asList("2016","10","0"+Integer.toString(i),"mon","0");
				compensatoryLeaveList0 = Arrays.asList();
				onedayWorkList0.add(dateList0);
				onedayWorkList0.add(compensatoryLeaveList0);
				//detailList0 = Arrays.asList("","","","","","","");
				detailList0 = Arrays.asList();
				onedayWorkList0.add(detailList0);
				monthlyWorkList.add(onedayWorkList0);
		}


		List<List<String>> onedayWorkList1 = new ArrayList<>();		//一日分のデータを格納していく
		List<String> dateList1 = new ArrayList<>();					//日付系の情報(年,月,日,曜日,休日区分)
		List<String> compensatoryLeaveList1 = new ArrayList<>();	//振り替え休日
		List<String> detailList1 = new ArrayList<>();					//業務詳細情報(開始・終了時間,予定・実績値,業務名,申請状況,備考)
		dateList1 = Arrays.asList("2016","10","06","thu","0");
		compensatoryLeaveList1 = Arrays.asList();
		onedayWorkList1.add(dateList1);
		onedayWorkList1.add(compensatoryLeaveList1);
		detailList1 = Arrays.asList("09:00","12:00","3","3","プログラム作成業","0","難易度上昇中");
		onedayWorkList1.add(detailList1);
		detailList1 = Arrays.asList("13:00","19:00","5","6","環境調査業務","1","Bluemix懐かしい");
		onedayWorkList1.add(detailList1);
		monthlyWorkList.add(onedayWorkList1);


		List<List<String>> onedayWorkList2 = new ArrayList<>();		//一日分のデータを格納していく
		List<String> dateList2 = new ArrayList<>();					//日付系の情報(年,月,日,曜日,休日区分)
		List<String> compensatoryLeaveList2 = new ArrayList<>();	//振り替え休日
		List<String> detailList2 = new ArrayList<>();					//業務詳細情報(開始・終了時間,予定・実績値,業務名,申請状況,備考)
		dateList2 = Arrays.asList("2016","10","07","fri","0");
		compensatoryLeaveList2 = Arrays.asList();
		onedayWorkList2.add(dateList2);
		onedayWorkList2.add(compensatoryLeaveList2);
		detailList2 = Arrays.asList("09:00","20:00","8","10","プログラム生成業","1","がんばってる。");
		onedayWorkList2.add(detailList2);
		monthlyWorkList.add(onedayWorkList2);


		List<List<String>> onedayWorkList3 = new ArrayList<>();		//一日分のデータを格納していく
		List<String> dateList3 = new ArrayList<>();					//日付系の情報(年,月,日,曜日,休日区分)
		List<String> compensatoryLeaveList3 = new ArrayList<>();	//振り替え休日
		List<String> detailList3 = new ArrayList<>();					//業務詳細情報(開始・終了時間,予定・実績値,業務名,申請状況,備考)
		dateList3 = Arrays.asList("2016","10","08","sat","2");
		compensatoryLeaveList3 = Arrays.asList();
		onedayWorkList3.add(dateList3);
		onedayWorkList3.add(compensatoryLeaveList3);
		detailList3 = Arrays.asList("09:00","12:00","3","3","環境調査業務","1","休日出勤バージョン");
		onedayWorkList3.add(detailList3);
		monthlyWorkList.add(onedayWorkList3);


		List<List<String>> onedayWorkList4 = new ArrayList<>();		//一日分のデータを格納していく
		List<String> dateList4 = new ArrayList<>();					//日付系の情報(年,月,日,曜日,休日区分)
		List<String> compensatoryLeaveList4 = new ArrayList<>();	//振り替え休日
		List<String> detailList4 = new ArrayList<>();					//業務詳細情報(開始・終了時間,予定・実績値,業務名,申請状況,備考)
		dateList4 = Arrays.asList("2016","10","09","sun","1");
		compensatoryLeaveList4 = Arrays.asList();
		onedayWorkList4.add(dateList4);
		onedayWorkList4.add(compensatoryLeaveList4);
		//detailList4 = Arrays.asList("","","","","","","");
		detailList4 = Arrays.asList();
		onedayWorkList4.add(detailList4);
		monthlyWorkList.add(onedayWorkList4);


		List<List<String>> onedayWorkList5 = new ArrayList<>();		//一日分のデータを格納していく
		List<String> dateList5 = new ArrayList<>();					//日付系の情報(年,月,日,曜日,休日区分)
		List<String> compensatoryLeaveList5 = new ArrayList<>();	//振り替え休日
		List<String> detailList5 = new ArrayList<>();					//業務詳細情報(開始・終了時間,予定・実績値,業務名,申請状況,備考)
		dateList5 = Arrays.asList("2016","10","10","mon","0");
		compensatoryLeaveList5 = Arrays.asList();
		onedayWorkList5.add(dateList5);
		onedayWorkList5.add(compensatoryLeaveList5);
		detailList5 = Arrays.asList("09:00","12:00","3","3","環境調査業務1","1","テストコメント");
		onedayWorkList5.add(detailList5);
		detailList5 = Arrays.asList("13:00","18:00","5","5","コーディング業務","1","午後の業務もガンバる");
		onedayWorkList5.add(detailList5);
		detailList5 = Arrays.asList("18:00","21:00","3","3","環境調査業務2","1","午後の業務もガンバる");
		onedayWorkList5.add(detailList5);
		monthlyWorkList.add(onedayWorkList5);


		List<List<String>> onedayWorkList6 = new ArrayList<>();		//一日分のデータを格納していく
		List<String> dateList6 = new ArrayList<>();					//日付系の情報(年,月,日,曜日,休日区分)
		List<String> compensatoryLeaveList6 = new ArrayList<>();	//振り替え休日
		List<String> detailList6 = new ArrayList<>();					//業務詳細情報(開始・終了時間,予定・実績値,業務名,申請状況,備考)
		dateList6 = Arrays.asList("2016","10","11","tue","0");
		compensatoryLeaveList6 = Arrays.asList();
		onedayWorkList6.add(dateList6);
		onedayWorkList6.add(compensatoryLeaveList6);
		detailList6 = Arrays.asList("","","","","","","");
		onedayWorkList6.add(detailList6);
		monthlyWorkList.add(onedayWorkList6);


		//10/12～31日のデータを空欄で埋める
		for(int i=12; i<=31;i++){
				List<List<String>> onedayWorkList0 = new ArrayList<>();
				List<String> dateList0 = new ArrayList<>();
				List<String> compensatoryLeaveList0 = new ArrayList<>();
				List<String> detailList0 = new ArrayList<>();
				dateList0 = Arrays.asList("2016","10",Integer.toString(i),"mon","0");
				compensatoryLeaveList0 = Arrays.asList();
				onedayWorkList0.add(dateList0);
				onedayWorkList0.add(compensatoryLeaveList0);
				//detailList0 = Arrays.asList("","","","","","","");
				detailList0 = Arrays.asList();
				onedayWorkList0.add(detailList0);
				monthlyWorkList.add(onedayWorkList0);
		}
		return monthlyWorkList;
	}

}
