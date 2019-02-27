package battle;

import inout.EnterOnConsole;

public class BattleArea {

	private final Battlable first;
	private final Battlable second;

	public BattleArea(Battlable first, Battlable second) {
		this.first = first;//主人公
		this.second = second;//ボス
		}

	/**--------------------バトルここから（終了するまでループする）--------------------**/
	public void toBattle(){

		EnterOnConsole.println("");
		EnterOnConsole.println(second.getName() + "が現れた！");
		EnterOnConsole.sleep(500);

		//ターン設定、この間を繰り返す。200ターン以内には決着はつくはず・・・
		int maxTurn = 200;
	    for (int i = 0; i < maxTurn; i++) {

	    	guide();//ステータスを表示するメソッド

	    	EnterOnConsole.println("1:たたかう 2:まほう 3:かいふく 4:こうさん");
			String line = EnterOnConsole.readLine();//入力の読み取り
			int num = Integer.parseInt(line);//回答を数字に変換しnumに代入

			/**--------------------勇者の行動--------------------**/
			String skill = first.Action(num);

			if(skill == null) {
				EnterOnConsole.println(first.getName() + "は" + second.getName() + "に恐れおののいている。");//候補以外を入力した場合
			}else if(skill == "こうさん"){
				toLose();//降参メソッド
				toGameOver();//ゲームオーバーメソッド
				break;//for文抜けます。
			}else if(skill == "かいふく"){
				if(first.MpCheck(num)) {//MP残量チェックメソッド
					EnterOnConsole.println(first.getName() + "は 回復呪文 を唱えた！");
					EnterOnConsole.sleep(1000);
					int healHp = first.Heal();//HP回復メソッド
					EnterOnConsole.println(first.getName() + "の HP が " + healHp + "回復した！");
				}else {
					EnterOnConsole.sleep(500);
					EnterOnConsole.println("MPが足りない！");
				}
			}else {
				EnterOnConsole.println(first.getName() + ": " + skill);//それぞれの行動名を表示
				EnterOnConsole.sleep(1500);
				if(first.MpCheck(num)) {//MP残量チェックメソッド
					int damage = first.Attack(num);//アタックメソッド、ダメージ計算する。
					EnterOnConsole.sleep(500);
					EnterOnConsole.println(second.getName() + "に"+ damage + "のダメージ！");
					second.Damage(damage);//ダメージ計算処理
					if(second.Dead()) {//死亡判定
						toClear();
						break;
					}
				}else {
					EnterOnConsole.sleep(500);
					EnterOnConsole.println("MPが足りない！");
				}

			}

			/**----------------勇者の行動ここまで------------------**/

			EnterOnConsole.sleep(1500);//少し待機
			EnterOnConsole.println("");

			/**--------------------魔王の行動--------------------**/
			String trick = second.Action();//引数なし
			if(trick == null) {
				EnterOnConsole.println(second.getName() + "は不気味にほほえんでいる");//15%の確率で何もしない
			}else {
				EnterOnConsole.println(second.getName() + ": " + trick);//それぞれの行動名を表示
				EnterOnConsole.sleep(1500);
				if(second.MpCheck(num)) {//MP残量チェックメソッド
					int damage = second.Attack(num);//アタックメソッド、ダメージ計算する
					EnterOnConsole.sleep(500);
					EnterOnConsole.println(first.getName() + "に"+ damage + "のダメージ！");
					first.Damage(damage);//ダメージ計算処理
					if(first.Dead()) {//死亡判定
						toGameOver();
						break;
					}
				}else {
					EnterOnConsole.sleep(500);
					EnterOnConsole.println(second.getName() + "は MP が足りず、発動できなかった！");
				}
			}
			/**-----------------魔王の行動ここまで-----------------**/

			EnterOnConsole.sleep(1500);//少し待機
			EnterOnConsole.println("");

	    }
	}
	/**--------------------バトルここまで--------------------**/

	private void guide() { //ステータスを表示するメソッド
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("------------------------");
		EnterOnConsole.println("|" +first.getName() + "\t\t" + "|" + second.getName());
		EnterOnConsole.println("|" + "HP: " +first.getHP() + "\t" + "|" + "HP: " +second.getHP());
		EnterOnConsole.println("|" + "MP: " +first.getMP() + "\t" + "|" + "MP: " +second.getMP());
		EnterOnConsole.println("------------------------");
		EnterOnConsole.println(first.getName() + "はどうする？");
	}

	private void toClear() { //ゲームクリア時のイベントメソッド
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("");
		EnterOnConsole.println(second.getName() + ":  ぐぐぐっ..");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println(second.getName() + ":  この..");
		EnterOnConsole.sleep(1500);
		EnterOnConsole.println(second.getName() + ":  わたしが...");
		EnterOnConsole.sleep(2500);
		EnterOnConsole.println(second.getName() + ":  やられる...とは....");
		EnterOnConsole.sleep(1000);
		EnterOnConsole.println("");
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println(second.getName() + " を倒した！！\n\n");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("こうして..");
		EnterOnConsole.sleep(1500);
		EnterOnConsole.println("世界は \"" + first.getName() + "\" によって");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("平和がもたらされました...");
		EnterOnConsole.sleep(1000);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(3000);
		EnterOnConsole.println("");
		EnterOnConsole.println("GAME Clear!!!");
	}

	private void toLose() { //降参した時のイベントメソッド

		EnterOnConsole.println(first.getName() + "：まいりました。ゆるしてください。");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println(second.getName() + "：ふんっ！降参とはそれでも主人公か！");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println(second.getName() + "：そんな情けない" + first.getName() + "などみてられぬわっ！");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println(second.getName() + "：消えてしまえっ！！");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println(second.getName() + "は死の呪文を唱えた！!");
		EnterOnConsole.sleep(3000);
		EnterOnConsole.println("");
		EnterOnConsole.println(first.getName() + "に 99999 のダメージ！!!!");
		EnterOnConsole.sleep(500);
	}

	private void toGameOver() { //ゲームオーバー時のイベントメソッド
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("");
		EnterOnConsole.println(first.getName() + " は倒れた...");
		EnterOnConsole.println("");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("その後...");
		EnterOnConsole.sleep(1500);
		EnterOnConsole.println("世界は \"" + second.getName() + "\" によって");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("滅ぼされてしまいました...");
		EnterOnConsole.sleep(2000);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(500);
		EnterOnConsole.println("・");
		EnterOnConsole.sleep(3000);
		EnterOnConsole.println("");
		EnterOnConsole.println("GAME OVER");
	}
}

