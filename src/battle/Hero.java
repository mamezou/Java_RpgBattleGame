package battle;

import java.util.Random;

/**--------------------勇者クラス--------------------**/
public class Hero extends Character {

	final private Random random;

	public Hero(String name, int hp , int mp) {
		super(name , hp , mp);
	    this.random = new Random();
	}

	@Override
	public String Action(int num) {
		String skill;
		switch (num) {//入力された数字によって異なるActionを行う
        case 1:
            skill = "たたかう";
            return skill;
        case 2:
        	skill = "まほう";
            return skill;
        case 3:
        	skill = "かいふく";
            return skill;
        case 4:
            skill = "こうさん";
            return skill;
        default:
            return null;//[1]~[4]以外の数字が入力された時に「null」を返す。
        }
	}

	@Override
	public int Attack(int number) {
		int dmg = 0;
		switch (number) {
		case 1:
			if (random.nextInt(10) > 7) {//一定確率で会心の一撃
				System.out.println(this.getName() + "は「会心の一撃」を与えた！");
				dmg = 150 + random.nextInt(80);
			} else {
				dmg = 50 + random.nextInt(30);//ノーマルダメージ
			}
			break;
		case 2://必殺技
			System.out.println(this.getName() + "は究極魔法 ホーリーを唱えた！");
			System.out.println("聖なる光が邪悪を浄化する！！");
			dmg = 250 + random.nextInt(100);;
			this.mp -= 70;
			break;
		}
		return dmg;
	}

	@Override
	public boolean MpCheck(int num) {//必要なMpが残っているかチェックするメソッド
		boolean check = true;
		switch (num) {
		case 1:
			check = true;
			break;
		case 2:
			if(this.mp < 70) {
				check = false;
			}
			break;
		case 3:
			if(this.mp < 40) {
				check = false;
			}
			break;
		}
		return check;
	}

	@Override
	public int Heal() {//回復メソッド
		int healHp = 300 + random.nextInt(200);
		this.hp += healHp;
		this.mp -= 40;
		return healHp;
	}
}
