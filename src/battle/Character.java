package battle;

/**--------------------キャラクターの抽象クラス。これを継承し個性を持たせたクラスを作成する--------------------**/
public abstract class Character implements Battlable{
	private final String name;
	protected int hp;
	protected int mp;

	protected Character(String name, int hp, int mp) {
		this.name = name;
	    this.hp = hp;
	    this.mp = mp;
	}

	public String getName() {
		return this.name;
	}

	public int getHP() {
		return this.hp;
	}

	public int getMP() {
		return this.mp;
	}

	public String Action() {//ボスよう。行動はランダムで決めてもらう。
		String trick = "";//オーバーライドするのでここは適当に書いてます。
		return trick;
	}

	public String Action(int num) {//勇者よう。選択した行動を実行する。
		String skill = "";//オーバーライドするのでここは適当に書いてます。
		return skill;
	}

	public boolean MpCheck(int num) {//MPのチェックメソッド、オーバーライドします。
		return true;
	}

	public int Attack(int number) {//アクションによって与えるダメージを計算するメソッド
		int dmg = number;
		return dmg;
	}

	public void Damage(int dg) {//ダメージ処理。
		this.hp -= dg;
	}

	public int Heal() {//回復メソッド
		return 0;
	}

	public boolean Dead() {//死亡判定。もしHPが0以下なら「true」を返す。
		return this.getHP() <= 0;
	}

}

