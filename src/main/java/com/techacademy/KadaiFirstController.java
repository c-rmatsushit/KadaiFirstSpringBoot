package com.techacademy;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Calendar;

@RestController
public class KadaiFirstController {

	@GetMapping("/")
	public String index() {
		return "Hello SpringBoot!";
	}

	@GetMapping("dayofweek/{yyyymmdd}")
	public String dispDayOfWeek(@PathVariable String yyyymmdd) {
		try {
			// 曜日
			String yobi[] = { "日曜", "月曜", "火曜", "水曜", "木曜", "金曜", "土曜" };

			// 日付チェック
			SimpleDateFormat sdf = new SimpleDateFormat("yyyymmdd");
			sdf.setLenient(false);
			sdf.parse(yyyymmdd);

			// 年・月を取得する
			int y = Integer.parseInt(yyyymmdd.substring(0, 4));
			int m = Integer.parseInt(yyyymmdd.substring(4, 6)) - 1;
			int d = Integer.parseInt(yyyymmdd.substring(6, 8));

			// 取得した年月の最終年月日を取得する
			Calendar cal = Calendar.getInstance();
			cal.set(y, m, d);

			// YYYYMMDD形式にして変換して返す
			return yobi[cal.get(Calendar.DAY_OF_WEEK) - 1];

		} catch (Exception ex) {
			return null;
		}
	}

	@GetMapping("/plus/{val1}/{val2}")
	public String calcPlus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 + val2;
		return "計算結果：" + res;
	}

	@GetMapping("/minus/{val1}/{val2}")
	public String calcMinus(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 - val2;
		return "計算結果：" + res;
	}

	@GetMapping("/times/{val1}/{val2}")
	public String calcTimes(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 * val2;
		return "計算結果：" + res;
	}

	@GetMapping("/divide/{val1}/{val2}")
	public String calcDivide(@PathVariable int val1, @PathVariable int val2) {
		int res = 0;
		res = val1 / val2;
		return "計算結果：" + res;
	}
}

