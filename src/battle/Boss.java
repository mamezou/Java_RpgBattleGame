package battle;

import java.util.Random;

/**--------------------ボスクラス--------------------**/
public class Boss extends Character {

	final private Random random;
	private int atk;

	public Boss(String name, int hp , int mp) {
		super(name , hp , mp);
		this.random = new Random();
	}

	@Override
	public String Action() {
		String trick;
		atk = 0;//発動する技（trick）の番号を代入 -> Attackメソッドで使用する。
		int ran = random.nextInt(100);

		if(ran < 65) {
			trick = "こうげき";//70%の確率でこうげき
			atk = 1;
			return trick;
		}else if(ran < 80) {
			trick = "メテオ";//15%の確率で必殺技
			atk = 2;
			return trick;
		}else if(ran < 85) {
			trick = "死の呪文";//5%の確率で即死技
			atk = 3;
			return trick;
		}else {
			return null;//15%の確率で「null」を返す
		}
	}

	public boolean MpCheck(int num) {
		boolean check = true;
		num = atk;
		switch (num) {
		case 1:
			check = true;
			break;
		case 2:
			if(this.mp < 250) {
				check = false;
			}
			break;
		case 3:
			if(this.mp < 500) {
				check = false;
			}
			break;
		}
		return check;
	}

	@Override
	public int Attack(int number) {
		int dmg = 0;
		number = atk;//Actionで指定したtrick の番号を代入
		switch (number) {
		case 1:
			if (random.nextInt(9) > 7) {
				System.out.println(this.getName() + "は「痛恨の一撃」を与えた！");
				dmg = 150 + random.nextInt(50);//一定確率で痛恨の一撃
			} else {
				dmg = 50 + random.nextInt(20);//ノーマルダメージ
			}
			break;
		case 2:
			System.out.println(this.getName() + "は究極魔法 メテオを唱えた！");
			System.out.println("大量の隕石が襲いかかる！！");
			this.mp -= 250;
			dmg = 250 + random.nextInt(50);//必殺技
			break;
		case 3:
			System.out.println(this.getName() + "は禁断の呪文　を唱えた！！！");
			System.out.println("冥界の使者が命を奪いに来た！！！");
			this.mp -= 500;
			dmg = 99999;
			break;
		}
		return dmg;
	}

}
