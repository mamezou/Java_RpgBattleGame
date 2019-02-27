package battle;

/**--------------------キャラクターのインターフェース--------------------**/
public interface Battlable {


	public String getName();//名前
	public int getHP();//HP
	public int getMP();//MP

	public boolean Dead();//死亡判定

	public String Action(int num);//勇者のアクション
	public String Action();//ボスのアクション
	public int Attack(int num);//こうげきメソッド、ダメージを返す。
	public void Damage(int damage);//ダメージ計算メソッド、受けた側のHP減らす
	public int Heal();//回復メソッド
	public boolean MpCheck(int i);//MPの残量チェックメソッド



}