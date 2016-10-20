package hello.logic;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class DateTimeSetting {

	public String rtnDate(){

		//フォーマットの作成
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        //現在時刻の取得
        Date nowTime = new Date();

        //Calenderクラスのインスタンス取得
        Calendar cal = Calendar.getInstance();

        //カレンダーに日付をセット
        cal.setTime(nowTime);

        //必要に応じて時刻の調整
        //cal.add(Calendar.HOUR, 9);

        String  rtnDateTime = df.format(cal.getTime());

        return rtnDateTime;

	}

}
