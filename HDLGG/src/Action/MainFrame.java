package Action;

import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import Entity.FloatPoint;
import Entity.GameStartBackgroundSoundThread;
import Entity.GrassLand;
import Entity.Hero;
import Entity.Imgs;
import sun.audio.AudioPlayer;

public class MainFrame extends Frame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GrassLand[] grassLands = new GrassLand[41];
	GameStartBackgroundSoundThread gameStartBgSoundThread;
	Toolkit toolkit = Toolkit.getDefaultToolkit();
	Dimension screenSize = this.toolkit.getScreenSize();
	boolean addEnemy1 = true;
	boolean addEnemy2 = true;
	private int backgroundSizeOfWidth = 900;
	private int backgroundSizeOfHeight = 672;
	int simpleEnemyNum = 0;
	boolean bossBattle = false;
	int timeCont = 0;
	private FloatPoint scenePosition = new FloatPoint(0.0F, 0.0F);
	boolean playPreBossStoneSound = true;
	boolean playGameOverSound = false;
	public float mapPosition = 0.0F;
	int delta = 0;
	boolean preBossBattle = false;
	private Graphics2D big;
	boolean stopBossBgSound = true;
	 private Hero hero;
	public MainFrame() {
		this.gameStartBgSoundThread = new GameStartBackgroundSoundThread();
		new Thread(this.gameStartBgSoundThread).start();// 出场动画
		big.drawImage(Imgs.BACKGROUND01,(int)this.scenePosition.x, (int)this.scenePosition.y, this.backgroundSizeOfWidth, (int)this.scenePosition.y + 672, (int)this.mapPosition, 0, (int)this.mapPosition + this.backgroundSizeOfWidth / 3, 224,this);
		setSize(this.backgroundSizeOfWidth, this.backgroundSizeOfHeight);// 设置背景的宽高
		setLocation((this.screenSize.width - getWidth()) / 2, 20);// 设置人物的活动区域
		initGrassLands();// 初始化陆地
		setVisible(true);
	}

	public static void main(String[] args) {
		new Thread(new MainFrame()).start();
	}

	@SuppressWarnings("unused")
	private void drawNPC(Graphics2D g) {
		this.grassLands[(this.grassLands.length - 2)].drawMovingGrassLand(this.hero, 23.4F, 25.799999F,
				(int) this.mapPosition, this.backgroundSizeOfWidth, this, g);
		this.grassLands[(this.grassLands.length - 1)].drawMovingGrassLand(this.hero, 32.400002F, 34.799999F,
				(int) this.mapPosition, this.backgroundSizeOfWidth, this, g);
	}

	private void initGrassLands()// 初始化陸地
	{
		FloatPoint[] points = { new FloatPoint(1.0F, 110.0F), new FloatPoint(5.0F, 142.0F),
				new FloatPoint(8.0F, 174.0F), new FloatPoint(9.0F, 206.0F), new FloatPoint(11.0F, 174.0F),
				new FloatPoint(13.0F, 142.0F), new FloatPoint(18.0F, 206.0F), new FloatPoint(19.0F, 158.0F),
				new FloatPoint(27.0F, 110.0F), new FloatPoint(36.0F, 110.0F), new FloatPoint(42.0F, 78.0F),
				new FloatPoint(43.0F, 206.0F), new FloatPoint(46.0F, 160.0F), new FloatPoint(49.0F, 142.0F),
				new FloatPoint(53.0F, 206.0F), new FloatPoint(57.0F, 110.0F), new FloatPoint(59.0F, 174.0F),
				new FloatPoint(62.0F, 174.0F), new FloatPoint(63.0F, 78.0F), new FloatPoint(65.0F, 158.0F),
				new FloatPoint(67.0F, 142.0F), new FloatPoint(69.0F, 110.0F), new FloatPoint(72.0F, 142.0F),
				new FloatPoint(72.0F, 206.0F), new FloatPoint(73.0F, 174.0F), new FloatPoint(76.0F, 110.0F),
				new FloatPoint(77.0F, 78.0F), new FloatPoint(77.0F, 206.0F), new FloatPoint(78.0F, 158.0F),
				new FloatPoint(80.0F, 110.0F), new FloatPoint(81.0F, 142.0F), new FloatPoint(84.0F, 206.0F),
				new FloatPoint(88.0F, 174.0F), new FloatPoint(91.0F, 142.0F), new FloatPoint(93.0F, 110.0F),
				new FloatPoint(93.0F, 206.0F), new FloatPoint(94.0F, 158.0F), new FloatPoint(98.0F, 142.0F),
				new FloatPoint(99.0F, 174.0F), new FloatPoint(24.0F, 110.0F), new FloatPoint(33.0F, 110.0F) };
		int[] lengths = { 22, 3, 1, 2, 1, 2, 2, 3, 5, 8, 16, 3, 2, 7, 6, 7, 2, 2, 5, 1, 3, 2, 2, 1, 3, 2, 2, 1, 1, 2, 5,
				3, 2, 2, 5, 22, 4, 1, 1, 1, 1 };
		for (int i = 0; i < points.length - 2; i++) {
			GrassLand gl = new GrassLand(points[i], lengths[i]);
			this.grassLands[i] = gl;
		}
		GrassLand movingGrassLand1 = new GrassLand(new FloatPoint(24.0F, 110.0F), 1);
		GrassLand movingGrassLand2 = new GrassLand(new FloatPoint(33.0F, 110.0F), 1);
		movingGrassLand1.movingDirection = 3;
		movingGrassLand2.movingDirection = 3;
		this.grassLands[(this.grassLands.length - 2)] = movingGrassLand1;
		this.grassLands[(this.grassLands.length - 1)] = movingGrassLand2;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(2000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		setVisible(true);

	}
}
