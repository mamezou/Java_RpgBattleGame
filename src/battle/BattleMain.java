package battle;


/**--------------------メインクラス（実行する）--------------------**/
public class BattleMain {

	public static void main(String[] args) {
		//勇者と魔王のインスタンスを作成
		Battlable hero = new Hero("勇者", 600 , 400 );
		Battlable boss = new Boss("魔王" , 999 , 999 );
		BattleArea battleArea = new BattleArea(hero, boss);
		battleArea.toBattle();
	}

}
