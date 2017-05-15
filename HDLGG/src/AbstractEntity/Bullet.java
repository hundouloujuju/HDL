 package AbstractEntity;
 
 import java.awt.Graphics2D;

import Entity.FloatPoint;
 
 public abstract class Bullet//×Óµ¯
 {
   public FloatPoint position;
   public boolean isAlive = true;
   public float size;
   public int energy;
 
   public Bullet(FloatPoint position, boolean isAlive, int energy)
   {
     this.position = position;
     this.isAlive = isAlive;
     this.energy = energy;
   }
 
   public abstract void drawBubblet(Graphics2D paramGraphics2D, float paramFloat);
 }

